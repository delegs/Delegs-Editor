package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

public class SignInfo implements Serializable {

	public static final int MAX_IMAGE_HEIGHT = 200;

	private static final long serialVersionUID = -5484683134182406256L;

	private String contentId;
	private String imageName;
	private int width;
	private int height;

	@Deprecated
	protected SignInfo() {
		super();
	}

	public SignInfo(String contentId, String imageName, int width, int height) {
		assert contentId != null : "Precondition failed: contentId != null";
		assert imageName != null : "Precondition failed: imageName != null";
		assert width >= 0 : "Precondition failed: width >= 0";
		assert height >= 0 : "Precondition failed: height >= 0";

		this.contentId = contentId;

		this.imageName = imageName;

		this.width = width;
		this.height = height;

		this.limitSize();

		assert getContentId().equals(contentId) : "Postcondition failed: getContentId().equals(contentId)";
	}

	public String getContentId() {
		return contentId;
	}

	public boolean isEmpty() {
		return imageName.isEmpty() || width == 0 || height == 0;
	}

	public String getImageName() {
		assert imageName != null : "Postcondition failed: result != null";
		return imageName;
	}

	public int getWidth() {
		assert width >= 0 : "Postcondition failed: result >= 0";
		return width;
	}

	public int getHeight() {
		assert height >= 0 : "Postcondition failed: result >= 0";
		return height;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj.getClass() == getClass()) {
			result = ((SignInfo) obj).contentId.equals(contentId);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return contentId.hashCode();
	}

	// private operations

	private void limitSize() {
		if (this.height > MAX_IMAGE_HEIGHT) {
			this.width = this.width * MAX_IMAGE_HEIGHT / this.height;
			this.height = MAX_IMAGE_HEIGHT;
		}
	}

}
