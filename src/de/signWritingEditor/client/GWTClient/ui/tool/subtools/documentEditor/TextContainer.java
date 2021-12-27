package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

public interface TextContainer {

	public int getCursorPosition();

	public int getCursorPositionAt(int left);

	public boolean isValidCursorPosition(int cursorPosition);
}
