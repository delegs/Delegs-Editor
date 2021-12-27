package de.signWritingEditor.server.communication.gateway.specific;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import de.signWritingEditor.server.service.ConfigurationService;

public class PdfDeliveryServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(PdfDeliveryServlet.class);
	private static final long serialVersionUID = -54161956189605214L;

	private static final String PDF_PATH = "esf.pdf.path";
	private static final String LEHRMATERIALIEN_PATH = "esf.lehrmaterialien.path";
	private File pdfDirFile;
	private File lehrMaterialienDirFile;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService confService = new ConfigurationService();

			pdfDirFile = new File(confService.getProperty(PDF_PATH));
			lehrMaterialienDirFile = new File(confService.getProperty(LEHRMATERIALIEN_PATH));
			if (!pdfDirFile.exists()) {
				pdfDirFile.mkdir();
			}
		} catch (IOException e) {
			e.printStackTrace();
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

		String fileName = request.getParameter("filename");
		boolean lehrmaterialie = Boolean.parseBoolean(request.getParameter("lehrmaterialie"));
		if (fileName != null) {
			File dir = lehrmaterialie ? lehrMaterialienDirFile : pdfDirFile;
			File file = new File(dir.getAbsoluteFile() + File.separator + fileName);

			if (file.exists()) {
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType(getServletContext().getMimeType(file.getAbsolutePath()));
				response.setContentLength((int) file.length());
				response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
				try (InputStream is = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
					IOUtils.copy(is, os);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				response.getWriter().append("pdf not found");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			response.getWriter().append("pdf not found");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}

	protected Logger getLog() {
		return LOG;
	}
}