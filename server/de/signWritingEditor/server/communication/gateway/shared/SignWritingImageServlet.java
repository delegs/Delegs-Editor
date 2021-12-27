package de.signWritingEditor.server.communication.gateway.shared;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.communication.infrastructure.SignDataDecoder;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.DictionaryServiceImpl;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SignWritingImageServlet extends SignWritingServlet {

	private static final String PARAMETER_NAME_TRANSPARENT = "transparent";
	private static final String PARAMETER_NAME_SCALE = "scale";
	private static final String PARAMETER_NAME_SYMBOLS = "symbols";

	private static final long serialVersionUID = 8118800198624901214L;

	private static final Logger LOG = Logger.getLogger(SignImageServlet.class);

	private SignDataDecoder signDataDecoder;
	private SignImageService signImageService;
	private DbConnector connector;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			connector = new DbConnector(configurationService);
			UserDb userDB = new UserDb(connector);
			SymbolDB symbolDB = new SymbolDB(connector);
			SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
			SignDB signDB = new SignDB(connector, userDB, symbolFactory, configurationService);
			SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDB, configurationService, symbolFactory);
			DictionaryServiceImpl dictionaryService = new DictionaryServiceImpl(signDB, signHistoryDb);
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidParameters(request)) {
			List<PositionedSymbol> decodedPositionedSymbols = signDataDecoder
					.decodePositionedSymbols(request.getParameter(PARAMETER_NAME_SYMBOLS));
			double scaleFactor = Double.parseDouble(request.getParameter(PARAMETER_NAME_SCALE));
			boolean transparent = Boolean.valueOf(request.getParameter(PARAMETER_NAME_TRANSPARENT));

			BufferedImage symbolGroupImage = signImageService.createPositionedSymbolsImage(decodedPositionedSymbols,
					scaleFactor, transparent);

			response.setContentType("image/png");

			ServletOutputStream outputStream = response.getOutputStream();
			ImageIO.write(symbolGroupImage, "PNG", outputStream);
		} else {
			respondToBadRequest(response);
		}
	}

	private boolean hasValidParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		boolean result = false;

		String symbolsParameter = request.getParameter(PARAMETER_NAME_SYMBOLS);
		String scaleParameter = request.getParameter(PARAMETER_NAME_SCALE);
		String transparentParameter = request.getParameter(PARAMETER_NAME_TRANSPARENT);

		if (symbolsParameter != null && scaleParameter != null && transparentParameter != null) {
			try {
				Double scaleFactor = Double.valueOf(scaleParameter);

				result = scaleFactor > 0 && scaleFactor <= signImageService.getMaxScaleFactor()
						&& (transparentParameter.equalsIgnoreCase("true")
								|| transparentParameter.equalsIgnoreCase("false"))
						&& signDataDecoder.isValidSignDataCode(symbolsParameter);
			} catch (NumberFormatException exception) {
				result = false;
			}
		}

		return result;
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}
}
