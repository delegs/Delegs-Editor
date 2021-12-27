package de.signWritingEditor.server.communication.gateway.shared;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.server.communication.infrastructure.SignDataDecoder;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.DictionaryServiceImpl;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class SignImageServlet extends HttpServlet {
	private static final long serialVersionUID = -5729383758666520808L;

	private static final Logger LOG = Logger.getLogger(SignImageServlet.class);

	private DictionaryService dictionaryService;

	private SignImageService signImageService;

	private SignDataDecoder signDataDecoder;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			DbConnector connector = new DbConnector(configurationService);
			UserDb userDB = new UserDb(connector);
			SymbolDB symbolDB = new SymbolDB(connector);
			SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
			SignDB signDB = new SignDB(connector, userDB, symbolFactory, configurationService);
			SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDB, configurationService, symbolFactory);
			dictionaryService = new DictionaryServiceImpl(signDB, signHistoryDb);
			signImageService = new SignImageService(configurationService, dictionaryService);
			signDataDecoder = new SignDataDecoder(symbolFactory);
		} catch (IOException e) {
			LOG.error("Error while creating configuration service: " + e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected long getLastModified(HttpServletRequest request) {
		String lowerIdParameter = request.getParameter("lowerId");
		String upperIdParameter = request.getParameter("upperId");
		String sourceParameter = request.getParameter("source");
		String localeParameter = request.getParameter("signlocale");

		if (localeParameter == null || lowerIdParameter == null || upperIdParameter == null) {
			return -1;
		}

		long upperId = Long.parseLong(upperIdParameter);

		SignLocale signLocale = SignLocale.valueOf(localeParameter);

		SignSource signSource;
		// To support older apps that use this servlet and do not provide
		// the sign source (ie: FindTheSign)
		if (sourceParameter == null) {
			signSource = dictionaryService.resolveLatestSource(upperId, lowerIdParameter, signLocale);
		} else {
			signSource = SignSource.valueOf(sourceParameter);
		}

		SignId signId = new SignId(upperId, lowerIdParameter, signLocale, signSource);

		long accurateToMilliseconds = dictionaryService.getModificationDate(signId);
		long roundedToSeconds = accurateToMilliseconds / 1000 * 1000;
		// The HTTP-Date string apparently does not support milliseconds.
		// If we do not round to seconds ourselves,
		// the next request may find a slightly "newer" (up to 999 ms) version,
		// which would always lead to a 200 instead of a 304.
		return roundedToSeconds;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		String signData = request.getParameter("signdata");
		String lowerIdParameter = request.getParameter("lowerId");
		String upperIdParameter = request.getParameter("upperId");
		String sourceParameter = request.getParameter("source");
		String localeParameter = request.getParameter("signlocale");
		String scaleParameter = request.getParameter("scale");
		String transparencyParameter = request.getParameter("transparent");
		boolean transparent = transparencyParameter != null;
		SimpleSign sign = null;
		SignId signId = null;

		if (signData != null) {
			List<PositionedSymbol> positionedSymbols = signDataDecoder.decodePositionedSymbols(signData);

			// The sign is just a container for the positioned symbols and the
			// width, so the other values are irrelevant
			sign = new SimpleSign(new SignId(1, "x", SignLocale.DGS, SignSource.DELEGS), User.getUnknownUser(),
					SignLocale.DGS, new Date(), "");

			for (PositionedSymbol positionedSymbol : positionedSymbols) {
				sign.addSymbol(positionedSymbol);
			}
		} else if (lowerIdParameter != null && upperIdParameter != null && localeParameter != null) {
			long upperId = Long.parseLong(upperIdParameter);
			SignLocale signLocale = SignLocale.valueOf(localeParameter);
			SignSource signSource;
			// To support older apps that use this servlet and do not provide
			// the sign source (ie: FindTheSign)
			if (sourceParameter == null) {
				signSource = dictionaryService.resolveLatestSource(upperId, lowerIdParameter, signLocale);
			} else {
				signSource = SignSource.valueOf(sourceParameter);
			}

			signId = new SignId(upperId, lowerIdParameter, signLocale, signSource);
		}

		double scaleFactor = 1;
		if (scaleParameter != null) {
			double scaleFactorFromRequest = Double.parseDouble(scaleParameter);
			if (scaleFactorFromRequest > 0 && scaleFactorFromRequest <= signImageService.getMaxScaleFactor()) {
				scaleFactor = scaleFactorFromRequest;
			}
		}

		OutputStream out = null;
		try {
			if (sign != null || signId != null) {
				out = response.getOutputStream();
				response.setContentType("image/png");

				BufferedImage signImage;
				if (sign != null) {
					signImage = signImageService.createSignImage(sign, scaleFactor, transparent);
				} else {
					signImage = signImageService.createSignImage(signId, scaleFactor, transparent);
				}

				ImageIO.write(signImage, "PNG", out);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image for sign not found");
			}
		} catch (IOException e) {
			LOG.debug("Client closed connection");

			StringBuffer stackTraceMessage = new StringBuffer();

			for (StackTraceElement element : e.getStackTrace()) {
				stackTraceMessage.append(element.getFileName() + " " + element.getClassName() + " "
						+ element.getMethodName() + " " + element.getLineNumber() + "<br>");
			}

			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage() + e.getCause()
					+ e.getLocalizedMessage() + "IOException" + stackTraceMessage.toString());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);

			StringBuffer stackTraceMessage = new StringBuffer();

			for (StackTraceElement element : e.getStackTrace()) {
				stackTraceMessage.append(element.getFileName() + " " + element.getClassName() + " "
						+ element.getMethodName() + " " + element.getLineNumber() + "<br>");
			}

			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage() + e.getCause()
					+ e.getLocalizedMessage() + " No IOException" + stackTraceMessage.toString());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
