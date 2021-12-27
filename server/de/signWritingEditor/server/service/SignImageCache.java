package de.signWritingEditor.server.service;

import java.awt.image.BufferedImage;
import java.io.IOException;

import de.signWritingEditor.shared.model.domainValue.SignId;

public interface SignImageCache {
	boolean containsSignImage(SignId signId, double scaleFactor, boolean transparent);

	BufferedImage getSignImage(SignId signId, double scaleFactor, boolean transparent) throws IOException;

	void addSignImage(SignId signId, double scaleFactor, boolean transparent, BufferedImage signImage)
			throws IOException;

	void removeSignImagesFor(SignId signId) throws IOException;

	boolean containsSignImagesFor(SignId signId);
}