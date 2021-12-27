package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import de.signWritingEditor.shared.i18n.I18NLocale;

public class Notification implements Serializable {

	private static final long serialVersionUID = -1934897754563145957L;

	private Map<I18NLocale, String> notificationMap;

	public Notification() {
		notificationMap = new HashMap<>();
	}

	public void addNotification(I18NLocale locale, String notification) {
		notificationMap.put(locale, notification);
	}

	public String getNotification(I18NLocale locale) {
		return notificationMap.get(locale);
	}
}
