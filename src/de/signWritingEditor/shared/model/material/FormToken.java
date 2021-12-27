package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public class FormToken extends TextbasedToken {
	private static final long serialVersionUID = 1L;
	private static final String ALLOW_ALL = ".*";

	private String description;
	private String inputContent;
	private int descriptionWidthPx;
	private int inputWidthPx;
	private int widthPx;
	private String pattern;
	private String contentExplanation;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	protected FormToken() {
	}

	public FormToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle, String description) {
		this(id, tokenStyle, description, "", ALLOW_ALL);
	}

	public FormToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle, String description, String inputContent,
			String pattern) {
		super(id, tokenStyle);
		assert description != null : "Precondition failed: description != null";
		assert inputContent != null : "Precondition failed: inputContent != null";
		assert pattern != null : "Precondition failed:  pattern != null";

		this.description = description;
		this.inputContent = inputContent;
		this.inputWidthPx = 334;
		this.descriptionWidthPx = 135;
		this.widthPx = inputWidthPx + descriptionWidthPx;
		this.contentExplanation = "";
		setPattern(pattern);
	}

	public String getDefaultPattern() {
		return ALLOW_ALL;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		if (pattern != null && !pattern.isEmpty()) {
			this.pattern = pattern;
		} else {
			this.pattern = ALLOW_ALL;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInputContent() {
		return this.inputContent;
	}

	public void setInputContent(String newInputContent) {
		this.inputContent = newInputContent;
	}

	public int getDescriptionWidthPx() {
		return descriptionWidthPx;
	}

	public void setDescriptionWidth(int labelWidth) {
		this.descriptionWidthPx = labelWidth;
		this.widthPx = descriptionWidthPx + inputWidthPx;
	}

	public int getInputWidthPx() {
		return inputWidthPx;
	}

	public void setInputWidth(int inputWidth) {
		this.inputWidthPx = inputWidth;
		this.widthPx = descriptionWidthPx + inputWidthPx;
	}

	public int getWidthPx() {
		return widthPx;
	}

	public void setWidthPx(int width) {
		this.widthPx = width;
	}

	@Override
	public void lockLayout(boolean isLockedLayout) {
	}

	@Override
	public boolean isLayoutLocked() {
		return true;
	}

	@Override
	public void lockContent(boolean isLockedContent) {
	}

	@Override
	public boolean isContentLocked() {
		return false;
	}

	@Override
	public long contentHashCode() {
		return Objects.hash(super.contentHashCode(), description, inputContent, pattern);
	}

	@Override
	public Color getBackgroundColor() {
		return super.getTextBackgroundColor();
	}

	@Override
	public void setBackgroundColor(Color backgroundColor) {
		TextbasedTokenStyle style = (TextbasedTokenStyle) super.getStyle();
		style.setTextBackgroundColor(backgroundColor);
	}

	public void setFontColor(Color fontColor) {
		TextbasedTokenStyle style = (TextbasedTokenStyle) super.getStyle();
		style.setFontColor(fontColor);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String getText() {
		return getInputContent();
	}

	@Override
	public void setText(String text) {
		setInputContent(text);
	}

	public TextbasedTokenStyle getTokenStyle() {
		return (TextbasedTokenStyle) super.getStyle();
	}

	public String getContentExplanation() {
		return contentExplanation;
	}

	public void setContentExplanation(String contentExplanation) {
		this.contentExplanation = contentExplanation == null ? "" : contentExplanation;
	}

	public boolean hasValidContent() {
		return "".equals(inputContent) || inputContent.matches(pattern);
	}

}
