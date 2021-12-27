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

public class VideoCacheSupplier extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(VideoCacheSupplier.class);
	private static final long serialVersionUID = -7017416314606036915L;


	private String path;
	private File videoCacheDir;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService confService = new ConfigurationService();
			path = confService.getProperty(ConfigurationService.PROPERTY_VIDEO_CACHE_DIR);

			videoCacheDir = new File(path);
			if (!videoCacheDir.exists()) {
				videoCacheDir.mkdir();
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

		if (fileName != null) {
			File file = new File(videoCacheDir.getAbsoluteFile() + File.separator + fileName);

			if (file.exists()) {
				response.setStatus(HttpServletResponse.SC_OK);
				// Chrome benoetigt die Range fuer den Video-Slider
				response.setHeader("Accept-Ranges", "bytes");
				response.setContentType(getServletContext().getMimeType(file.getAbsolutePath()));
				response.setContentLength((int) file.length());
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
				try (InputStream is = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
					IOUtils.copy(is, os);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				response.getWriter().append("video not found");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			response.getWriter().append("video not found");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}

	protected Logger getLog() {
		return LOG;
	}

}
