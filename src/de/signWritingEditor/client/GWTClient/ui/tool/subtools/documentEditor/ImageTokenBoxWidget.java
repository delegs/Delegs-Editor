package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.TokenBox;

public class ImageTokenBoxWidget extends AbstractTextbasedTokenBoxWidget {

	private static final String URL_BOX_STYLE_NAME = "urlBoxWidget";
	private ImageTokenBox imageTokenBox;
	private FlowPanel contentPanel;
	private ExtendedRichTextArea urlTextBox;
	private Image image;
	private FlowPanel imagePanel;
	private ImageTokenBoxWidgetListener imageTokenBoxWidgetListener;

	private FontMetricSpecifier fontMetricSpecifier;
	private Id tokenId;
	private FlowPanel buttonPanel;

	public ImageTokenBoxWidget(ImageTokenBox imageTokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService, ImageTokenBoxWidgetListener listener) {
		this.imageTokenBox = imageTokenBox;
		this.imageTokenBoxWidgetListener = listener;
		this.tokenId = imageTokenBox.getId();

		contentPanel = new FlowPanel();
		contentPanel.addStyleName("imageTokenBoxPanel");

		int contentWidth = (int) (imageTokenBox.getWidth_PX() - imageTokenBox.getMarginRight());

		fontMetricSpecifier = new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL, FontSize.SIZE_13,
				FontWeight.NORMAL);

		urlTextBox = new ExtendedRichTextArea(eventTranslator, fontSizeService);
		urlTextBox.getElement().setId(DocumentPanel.ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR);
		urlTextBox.getElement().getStyle().setHeight(imageTokenBox.getURLBoxHeight_PX(), Unit.PX);
		urlTextBox.getElement().getStyle().setWidth(100, Unit.PCT);
		urlTextBox.setStyleName(URL_BOX_STYLE_NAME);
		urlTextBox.setReadOnly(true);
		urlTextBox.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				handleKeyDownEvent(event);
			}
		});
		urlTextBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				handleUrlChanged();
			}
		});

		urlTextBox.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				ImageTokenBoxWidget.this.imageTokenBoxWidgetListener.onSelectToken(getId(), event.isShiftKeyDown());
			}
		});

		urlTextBox.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ImageTokenBoxWidget.this.imageTokenBoxWidgetListener.onSelectToken(getId(), false);
				ImageTokenBoxWidget.this.imageTokenBoxWidgetListener.onSelectToken(getId(), true, true);
			}
		});

		urlTextBox.addPasteHandler(new PasteHandler() {
			@Override
			public void onPaste(PasteEvent event) {
				handlePaste();
			}
		});

		image = new Image(imageTokenBox.getUrl());
		image.getElement().getStyle().setProperty("margin", "auto");
		image.getElement().getStyle().setDisplay(Display.BLOCK);
		if (imageTokenBox.getUrl().equals("")) {
			String imageString = generateErrorImageURL(I18NAccess.I18N.getImageNotFound());
			image.setUrl(imageString);
		}

		image.addLoadHandler(new LoadHandler() {

			@Override
			public void onLoad(LoadEvent event) {
				image.getElement().getStyle().clearWidth();
				image.getElement().getStyle().clearHeight();
				scaleImageToFitToken();
			}
		});
		image.addErrorHandler(new ErrorHandler() {

			@Override
			public void onError(ErrorEvent event) {
				String imageString = generateErrorImageURL(I18NAccess.I18N.getImageNotFound());
				image.setUrl(imageString);
			}
		});
		scaleImageToFitToken();

		imagePanel = new FlowPanel();
		imagePanel.setPixelSize((int) contentWidth, imageTokenBox.getHeight_PX() - imageTokenBox.getURLBoxHeight_PX()
				- imageTokenBox.getButtonPanelHeight());
		imagePanel.add(image);

		if (!imageTokenBox.isContentLocked()) {
			imagePanel.addStyleName("basicTokenBorder");
		}
		imagePanel.addStyleName("imagePanel");

		contentPanel.setPixelSize((int) contentWidth, imageTokenBox.getHeightWithMargin_PX());
		contentPanel.getElement().getStyle().setMarginRight(imageTokenBox.getMarginRight(), Unit.PX);
		contentPanel.add(imagePanel);

		buttonPanel = new FlowPanel();
		buttonPanel.getElement().getStyle().setWidth(100, Unit.PCT);
		buttonPanel.getElement().getStyle().setHeight(imageTokenBox.getButtonPanelHeight(), Unit.PX);
		buttonPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		buttonPanel.addStyleName("buttonPanel");

		contentPanel.add(buttonPanel);

		if (imageTokenBox.isContentLocked()) {
			buttonPanel.getElement().getStyle().setDisplay(Display.NONE);
			urlTextBox.getElement().getStyle().setDisplay(Display.NONE);
		}

		contentPanel.add(urlTextBox);
		initWidget(contentPanel);

		addResizeButtonToPanel(buttonPanel);
	}

	public ImageTokenBoxWidgetListener getImageListener() {
		return imageTokenBoxWidgetListener;
	}

	public String getUrl() {
		return imageTokenBox.getUrl();
	}

	protected void handlePaste() {
		handleUrlChanged();
	}

	protected void handleKeyDownEvent(KeyDownEvent event) {
		switch (event.getNativeKeyCode()) {
		case KeyCodes.KEY_BACKSPACE:
			handleBackspace(event);
			break;
		case KeyCodes.KEY_DELETE:
			handleDelete(event);
			break;
		case KeyCodes.KEY_TAB:
			handleKeyTabEvent(event.isControlKeyDown(), event.isShiftKeyDown());
			event.preventDefault();
			break;
		case KeyCodes.KEY_LEFT:
			handleKeyLeft(event.isControlKeyDown(), event.isShiftKeyDown());
			break;
		case KeyCodes.KEY_RIGHT:
			handleKeyRight(event.isControlKeyDown(), event.isShiftKeyDown());
			break;
		case KeyCodes.KEY_UP:
			handleKeyUp(event.isControlKeyDown(), event.isShiftKeyDown());
			break;
		case KeyCodes.KEY_DOWN:
			handleKeyDown(event.isControlKeyDown(), event.isShiftKeyDown());
			break;
		case KeyCodes.KEY_HOME:
			handleKeyHome(event.isControlKeyDown(), event.isShiftKeyDown());
			break;
		case KeyCodes.KEY_END:
			handleKeyEndEvent(event.isControlKeyDown(), event.isShiftKeyDown());
			break;
		default:
			switch (urlTextBox.getInteractionFromEvent(event)) {
			case COPY:
				handleCopy();
				break;
			case CUT:
				handleCut();
				break;
			default:
				int keyCode = event.getNativeKeyCode();
				if (keyCode == (int) 'S') {
					if (event.isControlKeyDown() || event.isMetaKeyDown()) {
						event.preventDefault();
					}
				}
				break;
			}
			break;
		}
	}

	private void handleCopy() {
		imageTokenBoxWidgetListener.onCopy();
	}

	private void handleCut() {
		imageTokenBoxWidgetListener.onCut();
	}

	private void handleDelete(KeyDownEvent event) {
		boolean performDefault = firePreTextChange(tokenId);
		if (performDefault) {
			boolean notAtLastPosition = getCursorPosition() < urlTextBox.getTextLength();

			if (notAtLastPosition || urlTextBox.hasTextSelection()) {
				// TextBox handles event on its own and notifies listeners
				fireTextChangedDeferred();
			} else {
				event.preventDefault();
				fireDeleteNext();
			}
		}
	}

	private void fireDeleteNext() {
		if (imageTokenBoxWidgetListener != null) {
			imageTokenBoxWidgetListener.onDeleteNext(tokenId);
		}

	}

	private void fireTextChangedDeferred() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				fireTextChanged();
			}
		});
	}

	private void fireTextChanged() {
		fireTextChanged(imageTokenBox.getUrl());
	}

	private void fireTextChanged(String newText) {
		assert newText != null : "Precondition failed: newText != null";

		if (imageTokenBoxWidgetListener != null) {
			imageTokenBoxWidgetListener.onImageUrlChanged(tokenId, newText);
		}
	}

	private boolean firePreTextChange(Id firingTokenId) {
		return imageTokenBoxWidgetListener != null
				&& imageTokenBoxWidgetListener.handleForTokenSelection(firingTokenId, false);
	}

	private void handleBackspace(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE";

		boolean performDefault = firePreTextChange(tokenId);
		if (performDefault) {

			if ((getCursorPosition() == 0) && urlTextBox.getSelectionLength() == 0) {
				fireDeletePrevious();
				event.preventDefault();
			} else if (getCursorPosition() == urlTextBox.getTextLength()) {
				event.preventDefault();
				event.stopPropagation();
				fireTextChangedDeferred();

			} else {
				fireTextChangedDeferred();
			}
		}

	}

	private void fireDeletePrevious() {
		if (imageTokenBoxWidgetListener != null) {
			imageTokenBoxWidgetListener.onDeletePrevious(tokenId);
		}

	}

	private void handleUrlChanged() {
		imageTokenBoxWidgetListener.onImageUrlChanged(imageTokenBox.getId(), imageTokenBox.getUrl());
	}

	private void handleKeyEndEvent(boolean controlKeyDown, boolean shiftKeyDown) {
		if (controlKeyDown) {
			imageTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), shiftKeyDown);
		} else {
			imageTokenBoxWidgetListener.onMoveCursorToLineEnd(getId(), shiftKeyDown);
		}
	}

	private void handleKeyHome(boolean controlKeyDown, boolean shiftKeyDown) {
		if (controlKeyDown) {
			imageTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), shiftKeyDown);
		} else {
			imageTokenBoxWidgetListener.onMoveCursorToLineStart(getId(), shiftKeyDown);
		}
	}

	private void handleKeyTabEvent(boolean controlKeyDown, boolean shiftKeyDown) {
		if (!shiftKeyDown) {
			imageTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), false);
		} else {
			imageTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), false, false);
		}
	}

	private void handleKeyDown(boolean controlKeyDown, boolean shiftKeyDown) {
		if (controlKeyDown) {
			imageTokenBoxWidgetListener.onMoveCursorToNextParagraph(getId(), shiftKeyDown);
		} else {
			imageTokenBoxWidgetListener.onMoveCursorLineDown(getId(), shiftKeyDown);
		}
	}

	private void handleKeyUp(boolean controlKeyDown, boolean shiftKeyDown) {
		if (controlKeyDown) {
			imageTokenBoxWidgetListener.onMoveCursorToPreviousParagraph(getId(), shiftKeyDown);
		} else {
			imageTokenBoxWidgetListener.onMoveCursorLineUp(getId(), shiftKeyDown);
		}
	}

	private void handleKeyRight(final boolean controlKeyDown, final boolean shiftKeyDown) {
		final int cursorPos = urlTextBox.getCursorPosition();
		final boolean wasWholeTextSelected = isWholeTextSelected();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {

				if (controlKeyDown || cursorPos >= urlTextBox.getCursorAbsoluteRight()
						|| (wasWholeTextSelected && shiftKeyDown)) {
					imageTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), shiftKeyDown);
				} else if (shiftKeyDown && isWholeTextSelected()) {
					imageTokenBoxWidgetListener.onSelectToken(getId(), true);
				} else if (!shiftKeyDown) {
					imageTokenBoxWidgetListener.onSelectToken(getId(), false);
				}
			}
		});
	}

	private void handleKeyLeft(final boolean controlKeyDown, final boolean shiftKeyDown) {
		// Wait until cursor and selection are changed
		final int cursorPos = urlTextBox.getCursorPosition();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				if (controlKeyDown || cursorPos <= 0) {
					imageTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), false, shiftKeyDown);
				} else if (shiftKeyDown && isWholeTextSelected()) {
					imageTokenBoxWidgetListener.onSelectToken(getId(), true);
				} else if (!shiftKeyDown) {
					imageTokenBoxWidgetListener.onSelectToken(getId(), false);
				}
			}
		});
	}

	private void scaleImageToFitToken() {
		float imageWidth = image.getWidth();
		float imageHeight = image.getHeight();

		float tokenWidth = imageTokenBox.getWidth_PX() - imageTokenBox.getMarginRight();
		float tokenHeight = imageTokenBox.getHeight_PX() - imageTokenBox.getURLBoxHeight_PX()
				- imageTokenBox.getButtonPanelHeight();

		float widthRatio = tokenWidth / imageWidth;
		float heightRatio = tokenHeight / imageHeight;

		if (widthRatio < heightRatio) {
			image.setPixelSize((int) tokenWidth, (int) (imageHeight * widthRatio));
		} else {
			image.setPixelSize((int) (imageWidth * heightRatio), (int) tokenHeight);
		}

		float imagePositionY = ((tokenHeight) / 2) - (image.getHeight() / 2);
		image.getElement().getStyle().setPosition(Position.RELATIVE);

		// Image overlaps with border otherwise
		if (imagePositionY == 0.5f) {
			imagePositionY = 0;
		}

		image.getElement().getStyle().setTop(imagePositionY, Unit.PX);
	}

	@Override
	public int getCursorPosition() {
		return urlTextBox.getCursorPosition();
	}

	@Override
	public int getCursorPositionAt(int left) {
		return 0;
	}

	@Override
	public boolean isValidCursorPosition(int cursorPosition) {
		return urlTextBox.isValidPosition(cursorPosition);
	}

	@Override
	public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
		assert mouseOverHandler != null : "Precondition failed: mouseOverHandler != null";
		assert mouseOutHandler != null : "Precondition failed:  mouseOutHandler != null";

		urlTextBox.addHandler(mouseOverHandler, MouseOverEvent.getType());
		urlTextBox.addHandler(mouseOutHandler, MouseOutEvent.getType());
		urlTextBox.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
	}

	@Override
	public void setCursorPositionAndFocus(int cursorPosition) {
		urlTextBox.setFocus(true);
		urlTextBox.setCursorPos(cursorPosition);
	}

	private int getMaxImageHeight() {
		return imageTokenBox.getMaxHeight() - imageTokenBox.getURLBoxHeight_PX() - imageTokenBox.getButtonPanelHeight();
	}

	private int getImageTokenBoxWidgetMaxWidth() {
		return imageTokenBox.getMaxWidth() - imageTokenBox.getMarginRight();
	}

	private boolean isGreaterMinHeight(int height) {
		return height > imageTokenBox.getMinHeight();
	}

	private boolean isLessThenMinWidth(int width) {
		return width < imageTokenBox.getMinWidth();
	}

	private boolean isLessOrEqlMaxWidth(int width) {
		return width <= getImageTokenBoxWidgetMaxWidth();
	}

	@Override
	public String getText() {
		return urlTextBox.getText();
	}

	public void setUrl(String url) {
		imageTokenBox.setUrl(url);
		image.setUrl(imageTokenBox.getUrl());
	}

	@Override
	public void setDragModeHandler(MouseDragListener listener) {
		urlTextBox.setMouseDragListener(listener);
	}

	@Override
	public void setTextBoxBackgroundColor(Color color) {
		urlTextBox.getElement().getStyle().setBackgroundColor(color.getCssValue());

	}

	@Override
	public Id getId() {
		return imageTokenBox.getId();
	}

	@Override
	public void focus() {
		urlTextBox.setFocus(true);
	}

	@Override
	public void toggleSelection() {
		this.urlTextBox.setSelection(!this.urlTextBox.isSelected());
	}

	@Override
	public TokenBox getTokenBox() {
		return imageTokenBox;
	}

	@Override
	public void setTokenBox(TokenBox tokenBox) {
		assert tokenBox instanceof ImageTokenBox : "Precondition failed: tokenBox instanceof ImageTokenBox";
		this.imageTokenBox = (ImageTokenBox) tokenBox;

		updateImageTokenBoxWidget();
	}

	private void updateImageTokenBoxWidget() {
		updateButtonPanelMargin();
		int contentWidth = (int) (imageTokenBox.getWidth_PX() - imageTokenBox.getMarginRight());
		contentPanel.setPixelSize(contentWidth, imageTokenBox.getHeightWithMargin_PX());
		imagePanel.setPixelSize(contentWidth, imageTokenBox.getHeight_PX() - imageTokenBox.getURLBoxHeight_PX()
				- imageTokenBox.getButtonPanelHeight());
		if (imageTokenBox.getUrl().isEmpty()) {
			String imageString = generateErrorImageURL(I18NAccess.I18N.getImageNotFound());
			image.setUrl(imageString);
		} else {
			image.setUrl(imageTokenBox.getUrl());
		}
	}

	private void updateButtonPanelMargin() {
		buttonPanel.getElement().getStyle().setMarginBottom(imageTokenBox.getMarginBetweenImageAndTextPX(), Unit.PX);
	}

	@Override
	public int getCursorLeft() {
		return urlTextBox.getCursorLeft(fontMetricSpecifier);
	}

	public interface ImageTokenBoxWidgetListener
			extends TokenBoxWidgetListener, TextbasedTokenBoxWidgetListener, ResizableTokenBoxWidgetListener {

		public void onImageUrlChanged(Id id, String newUrl);

		void onReport(String url);
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
		int newWidth = getImageTokenBoxWidgetMaxWidth();
		height += imageTokenBox.getURLBoxHeight_PX();
		if (isLessOrEqlMaxWidth(width)) {
			newWidth = width;
		}

		if (isLessThenMinWidth(newWidth)) {
			newWidth = imageTokenBox.getMinWidth();
		}

		int newHeight = imageTokenBox.getMinHeight();

		if (isGreaterMinHeight(height)) {
			newHeight = height;
		}

		if (newHeight > getMaxImageHeight()) {
			newHeight = getMaxImageHeight();
		}

		imageTokenBox.setWidth(newWidth);
		imageTokenBox.setHeight(newHeight);
		setTokenBox(imageTokenBox);
		imageTokenBoxWidgetListener.onResizeToken(getId());
	}

	@Override
	protected boolean isResizeable() {
		return true;
	}

	@Override
	public boolean isWholeTextSelected() {
		return urlTextBox.getSelectionLength() == urlTextBox.getTextLength();
	}

}
