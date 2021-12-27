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

public class TutorialDeliveryServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(TutorialDeliveryServlet.class);

	private static final long serialVersionUID = -7624738272143022205L;

	private static final String TUTORIAL_PATH = "esf.tutorial.path";

	private String tutorialPath;
	private File tutorialDir;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			tutorialPath = configurationService.getProperty(TUTORIAL_PATH);
			tutorialDir = new File(tutorialPath);
			if (!tutorialDir.exists()) {
				tutorialDir.mkdir();
			}

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

		String tutorialName = request.getParameter("tutorialname");

		if (tutorialName != null) {
			File tutorialVideo = new File(tutorialDir.getAbsoluteFile() + File.separator + tutorialName);

			if (tutorialVideo.exists()) {
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType(getServletContext().getMimeType(tutorialVideo.getAbsolutePath()));
				response.setContentLength((int) tutorialVideo.length());
				response.setHeader("Content-Disposition", "attachment; filename=\"" + tutorialName + "\"");

				try (InputStream is = new FileInputStream(tutorialVideo);
						OutputStream os = response.getOutputStream()) {
					IOUtils.copy(is, os);
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				response.getWriter().append("tutorial not found");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}

		} else {
			response.getWriter().append("tutorial not found");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}