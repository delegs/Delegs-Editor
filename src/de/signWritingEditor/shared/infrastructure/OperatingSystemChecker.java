package de.signWritingEditor.shared.infrastructure;

import com.google.gwt.user.client.Window.Navigator;

import de.signWritingEditor.shared.model.domainValue.OperatingSystem;

public final class OperatingSystemChecker {

	protected static OperatingSystem detectedOS = null;

	public static OperatingSystem getOperatingSystemType() {
		if (detectedOS == null) {
			String OS = Navigator.getPlatform().toLowerCase();
			if (OS.contains("mac") || OS.contains("darwin")) {
				detectedOS = OperatingSystem.MacOS;
			} else if (OS.contains("win")) {
				detectedOS = OperatingSystem.Windows;
			} else if (OS.contains("nux")) {
				detectedOS = OperatingSystem.Linux;
			} else {
				detectedOS = OperatingSystem.Other;
			}
		}
		return detectedOS;
	}
}
