package de.signWritingEditor.server.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import de.signWritingEditor.server.service.ConfigurationService.OS;
import de.signWritingEditor.shared.model.domainValue.SignId;

public class SignImageFileSystemCache implements SignImageCache {
	private static final String SEPARATOR = "/";
	private static final String IMAGE_TYPE = "png";
	private static final String TRANSPARENT_STRING = "transparent";

	private final String signImageCacheUrl;
	private OS operatingSystem;

	public SignImageFileSystemCache(ConfigurationService configurationService) {
		assert configurationService != null : "Precondition failed: configurationService != null";

		signImageCacheUrl = configurationService.getProperty(ConfigurationService.PROPERTY_SIGN_IMAGE_CACHE_URL);
		operatingSystem = configurationService.getOS();
	}

	@Override
	public boolean containsSignImage(SignId signId, double scaleFactor, boolean transparent) {
		assert signId != null : "Precondition failed: signId != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";

		String signImageCacheDirectoryPath = getSignImageCacheDirectoryPath(signId);

		File signImageCacheFile = new File(
				getSignImageCacheFilePath(signImageCacheDirectoryPath, scaleFactor, transparent));

		return signImageCacheFile.exists();
	}

	@Override
	public BufferedImage getSignImage(SignId signId, double scaleFactor, boolean transparent) throws IOException {
		assert signId != null : "Precondition failed: signId != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert containsSignImage(signId, scaleFactor,
				transparent) : "Precondition failed containsSignImage(signId, scaleFactor, transparent)";

		String signImageCacheDirectoryPath = getSignImageCacheDirectoryPath(signId);

		File signImageCacheFile = new File(
				getSignImageCacheFilePath(signImageCacheDirectoryPath, scaleFactor, transparent));

		BufferedImage result = ImageIO.read(signImageCacheFile);

		assert result != null : "Postcondition failed: assert result != null";
		return result;
	}

	@Override
	public void addSignImage(SignId signId, double scaleFactor, boolean transparent, BufferedImage signImage)
			throws IOException {
		assert signId != null : "Precondition failed: signId != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert signImage != null : "Precondition failed: signImage != null";

		String signImageCacheDirectoryPath = getSignImageCacheDirectoryPath(signId);

		File signImageCacheDirectory = new File(signImageCacheDirectoryPath);
		if (!signImageCacheDirectory.exists()) {
			signImageCacheDirectory.mkdirs();
		}

		File imageFile = new File(getSignImageCacheFilePath(signImageCacheDirectoryPath, scaleFactor, transparent));

		if (transparent) {
			int imageHeight = signImage.getHeight();
			int imageWidth = signImage.getWidth();

			for (int h = 0; h < imageHeight; h++) {
				for (int w = 0; w < imageWidth; w++) {

					int pixelColor = signImage.getRGB(w, h);

					if (pixelColor == new Color(254, 254, 254, 255).getRGB())
						signImage.setRGB(w, h, Color.TRANSLUCENT);
				}
			}
		}

		ImageIO.write(signImage, IMAGE_TYPE, imageFile);

		assert containsSignImage(signId, scaleFactor,
				transparent) : "Postcondition failed: containsSignImage(signId, scaleFactor, transparent)";
	}

	@Override
	public void removeSignImagesFor(SignId signId) throws IOException {
		assert signId != null : "Precondition failed: signId != null";
		assert containsSignImagesFor(signId) : "Precondition failed: containsSignImagesFor(signId)";

		File signImageCacheDirectory = new File(getSignImageCacheDirectoryPath(signId));
		FileUtils.deleteDirectory(signImageCacheDirectory);

		assert !containsSignImagesFor(signId) : "Postcondition failed: !containsSignImagesFor(signId)";
	}

	@Override
	public boolean containsSignImagesFor(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		File signImageCacheDirectory = new File(getSignImageCacheDirectoryPath(signId));

		return signImageCacheDirectory.exists() && signImageCacheDirectory.list().length > 0;
	}

	private String getSignImageCacheFilePath(String signImageCacheDirectoryPath, double scaleFactor,
			boolean transparent) {
		assert signImageCacheDirectoryPath != null : "Precondition failed: signImageCacheDirectoryPath != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";

		StringBuilder resultBuilder = new StringBuilder();

		resultBuilder.append(signImageCacheDirectoryPath);
		resultBuilder.append(SEPARATOR);
		resultBuilder.append(scaleFactor);

		if (transparent) {
			resultBuilder.append("_");
			resultBuilder.append(TRANSPARENT_STRING);
		}

		resultBuilder.append(".");
		resultBuilder.append(IMAGE_TYPE);

		String result = resultBuilder.toString();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private String getSignImageCacheDirectoryPath(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		String lowerId = signId.getLowerIdPart().replace(SEPARATOR, "_");
		if (operatingSystem == OS.Windows) {
			// Fix for development environment only
			lowerId = lowerId.replace("?", "x01").replace(":", "x02");
		}
		StringBuilder resultBuilder = new StringBuilder();

		resultBuilder.append(signImageCacheUrl);
		resultBuilder.append(signId.getSignLocale().name());
		resultBuilder.append(SEPARATOR);
		resultBuilder.append(Character.toLowerCase(lowerId.charAt(0)));
		resultBuilder.append(SEPARATOR);
		resultBuilder.append(lowerId);
		resultBuilder.append("_");
		resultBuilder.append(signId.getUpperIdPart());

		String result = resultBuilder.toString();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
