package de.signWritingEditor.server.communication.gateway.specific;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.communication.gateway.shared.SymbolImageServlet;
import de.signWritingEditor.server.service.pdfService.ErrorImage;

public class ErrorImageServlet extends HttpServlet {
	private static final long serialVersionUID = 5895661057993267970L;
	private static final Logger LOG = Logger.getLogger(SymbolImageServlet.class);

	private static final String ERROR_ATTRIBUTE_KEY = "error-message";

	@Override
	public void init() throws ServletException {

	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage;

		try {
			errorMessage = request.getParameter(ERROR_ATTRIBUTE_KEY);
		} catch (ClassCastException e) {
			LOG.error("could not cast " + request.getAttribute(ERROR_ATTRIBUTE_KEY) + " to string");
			errorMessage = "ClassCastException";
		}

		ErrorImage errorImageWrapper = new ErrorImage();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(errorImageWrapper.drawImage(errorMessage), "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();

		response.setContentType("image/png");
		response.getOutputStream().write(imageInByte, 0, imageInByte.length);
	}

	protected Logger getLog() {
		return LOG;
	}
}
