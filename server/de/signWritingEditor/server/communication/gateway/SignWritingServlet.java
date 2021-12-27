package de.signWritingEditor.server.communication.gateway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public abstract class SignWritingServlet extends HttpServlet {

	private static final long serialVersionUID = 3213220021064672776L;

	protected void sendResponse(HttpServletResponse response, String responseString) {
		PrintWriter writer = null;
		try {
			if (responseString != null) {
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				writer.write(responseString);
				writer.flush();
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			getLog().error(e.getMessage(), e);
			try {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} catch (IOException ioe) {
				getLog().error(ioe);
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	protected boolean hasParameters(HttpServletRequest request, String... parameters) {
		assert request != null : "Precondition failed: request != null";
		assert parameters != null : "Precondition failed: parameters != null";

		boolean result = true;
		for (String parameter : parameters) {
			if (request.getParameter(parameter) == null) {
				result = false;
				break;
			}
		}

		return result;
	}

	protected void respondToBadRequest(HttpServletResponse response) {
		respondToBadRequest(response, "{}");
	}

	protected void respondToBadRequest(HttpServletResponse response, String message) {
		assert response != null : "Precondition failed: response != null";
		assert message != null : "Precondition failed: message != null";

		try {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, message);
		} catch (IOException e) {
			getLog().error(e);
		}
	}

	protected void respondToNotFound(HttpServletResponse response) {
		assert response != null : "Precondition failed: response != null";

		try {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} catch (IOException e) {
			getLog().error(e);
		}
	}

	protected void respondToInternalServerError(HttpServletResponse response) {
		assert response != null : "Precondition failed: response != null";

		try {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			getLog().error(e);
		}
	}

	protected abstract Logger getLog();
}
