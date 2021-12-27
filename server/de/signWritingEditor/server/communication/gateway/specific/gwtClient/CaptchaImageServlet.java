package de.signWritingEditor.server.communication.gateway.specific.gwtClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;

public class CaptchaImageServlet extends SignWritingServlet {

	private static final Logger LOG = Logger.getLogger(CaptchaImageServlet.class);

	private static final long serialVersionUID = 8546091791982767380L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Captcha captcha = new Captcha.Builder(150, 50).addText().addBackground(new GradiatedBackgroundProducer()).gimp()
				.addNoise().addBorder().build();

		session.setAttribute(Captcha.NAME, captcha);

		CaptchaServletUtil.writeImage(response, captcha.getImage());
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}
}
