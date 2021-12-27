package de.signWritingEditor.shared.model.material;

public class StandardClipboard implements Clipboard {

	private String text;

	private Object content;

	public StandardClipboard() {
		text = "";
	}

	@Override
	public String getText() {
		assert !isEmpty() : "Precondition failed: !isEmpty()";

		return text;
	}

	@Override
	public void clear() {
		text = "";
	}

	@Override
	public boolean isClipboardText(String pastedText) {
		assert pastedText != null : "Precondition failed: pastedText != null";
		assert !isEmpty() : "Precondition failed: !isEmpty()";

		return getText().equals(pastedText);
	}

	@Override
	public boolean isEmpty() {
		boolean result = text == null || text.equals("");

		return result;
	}

	@Override
	public void setText(String text) {
		assert text != null : "Precondition failed: text != null";
		this.text = text;
	}

	@Override
	public void setContent(Object content) {
		this.content = content;
	}

	@Override
	public Object getContent() {
		return content;
	}
}
