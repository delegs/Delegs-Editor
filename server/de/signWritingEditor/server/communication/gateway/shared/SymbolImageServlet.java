package de.signWritingEditor.server.communication.gateway.shared;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.DictionaryServiceImpl;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SymbolImageServlet extends HttpServlet {
	private static final long serialVersionUID = -5729383758666520808L;

	private static final Logger LOG = Logger.getLogger(SymbolImageServlet.class);

	private SymbolFactory symbolFactory;

	private SignImageService signImageService;

	private DbConnector dbConnector;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			dbConnector = new DbConnector(configurationService);
			UserDb userDb = new UserDb(dbConnector);
			SymbolDB symbolDb = new SymbolDB(dbConnector);
			SignDB signDB = new SignDB(dbConnector, userDb, symbolFactory, configurationService);
			SignHistoryDB signHistoryDb = new SignHistoryDB(dbConnector, userDb, configurationService, symbolFactory);
			DictionaryServiceImpl dictionaryService = new DictionaryServiceImpl(signDB, signHistoryDb);

			this.symbolFactory = new SymbolFactory(symbolDb.getAllSymbols());
			this.signImageService = new SignImageService(configurationService, dictionaryService);
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

		double scaleFactor = 1;

		String scaleParameter = request.getParameter("scale");
		if (scaleParameter != null) {
			double scaleFactorFromRequest = Double.parseDouble(scaleParameter);
			if (scaleFactorFromRequest > 0 && scaleFactorFromRequest <= signImageService.getMaxScaleFactor()) {
				scaleFactor = scaleFactorFromRequest;
			}
		}

		String symbolParameter = request.getParameter("symboldata");
		if (symbolParameter != null && symbolFactory.isValidSymbol(symbolParameter)) {
			Symbol symbol = symbolFactory.createSymbol(symbolParameter);

			OutputStream outputStream = null;
			try {
				outputStream = response.getOutputStream();
				response.setContentType("image/png");

				String cssColorCodeForFormerBlack = request.getParameter("colorFormerBlack");
				Color colorCodeForFormerBlack = null;
				if (cssColorCodeForFormerBlack == null) {
					colorCodeForFormerBlack = Color.BLACK;
				} else {
					colorCodeForFormerBlack = Color.makeFromCssString("#" + cssColorCodeForFormerBlack);
				}

				String cssColorCodeForFormerWhite = request.getParameter("colorFormerWhite");
				Color colorCodeForFormerWhite = null;
				if (cssColorCodeForFormerWhite == null) {
					colorCodeForFormerWhite = Color.WHITE;
				} else {
					colorCodeForFormerWhite = Color.makeFromCssString("#" + cssColorCodeForFormerWhite);
				}
				Image symbolImage = signImageService.loadSymbolImage(symbol, scaleFactor, colorCodeForFormerBlack,
						colorCodeForFormerWhite);
				// Put Image inside a BufferedImage so it can be written to
				// the OutputStream
				BufferedImage outputImage = new BufferedImage(symbolImage.getWidth(null), symbolImage.getHeight(null),
						BufferedImage.TYPE_INT_ARGB);
				Graphics graphics = outputImage.getGraphics();
				graphics.drawImage(symbolImage, 0, 0, null);
				graphics.dispose();

				ImageIO.write(outputImage, "PNG", outputStream);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} finally {
				if (outputStream != null) {
					outputStream.close();
				}
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
