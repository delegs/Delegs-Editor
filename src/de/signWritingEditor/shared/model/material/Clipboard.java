package de.signWritingEditor.shared.model.material;

public interface Clipboard {
	public abstract String getText();

	public abstract void setText(String text);

	public void setContent(Object content);

	public <T> T getContent();

	public abstract void clear();

	public abstract boolean isClipboardText(String pastedText);

	public abstract boolean isEmpty();

}