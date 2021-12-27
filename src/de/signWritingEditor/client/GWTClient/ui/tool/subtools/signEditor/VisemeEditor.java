package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorMacImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ImageAndTextButton;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.i18n.I18NLocale;
import de.signWritingEditor.shared.infrastructure.OperatingSystemChecker;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.OperatingSystem;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedMouthSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;

public class VisemeEditor extends Composite {

	private final VisemeEditorListener visemeEditorListener;

	private final Map<Character, Symbol> keyToVisemeMap;
	private final Map<Symbol, Character> visemeToKeyMap;

	private final TextBox visemeKeyTextBox;
	private EventTranslatorStandardImpl eventTranslator = GWT.create(EventTranslatorStandardImpl.class);

	private final FlowPanel mainPanel;
	private final HeadSymbolKeyboard headSymbolKeyboard;

	private PositionedSymbolFactory positionedSymbolFactory;

	private ImageAndTextButton arrangeVisemesButton;

	private ImageAndTextButton freePositionVisemesButton;

	private boolean isInFreePositionableMode;

	public VisemeEditor(final SymbolImageUrlService symbolImageUrlService, final VisemeEditorListener listener,
			PositionedSymbolFactory positionedSymbolFactory) {
		assert symbolImageUrlService != null : "Precondition failed: symbolImageUrlService != null";
		assert listener != null : "Precondition failed: listener != null";
		assert positionedSymbolFactory != null : "Precondition failed: positionedSymbolFactory != null";

		this.positionedSymbolFactory = positionedSymbolFactory;
		this.visemeEditorListener = listener;

		if (OperatingSystemChecker.getOperatingSystemType().equals(OperatingSystem.MacOS)) {
			eventTranslator = GWT.create(EventTranslatorMacImpl.class);
		}

		// Use LinkedHashMap to preserve insertion-order
		this.keyToVisemeMap = new LinkedHashMap<>();
		this.visemeToKeyMap = new LinkedHashMap<>();

		this.mainPanel = new FlowPanel();
		this.mainPanel.setStyleName("visemeEditor");
		initWidget(mainPanel);

		this.visemeKeyTextBox = new TextBox() {
			@Override
			public void onBrowserEvent(final Event event) {
				// Pasting into key text box is not allowed
				if (event.getTypeInt() == Event.ONPASTE) {
					event.preventDefault();
				}
				super.onBrowserEvent(event);
			}
		};
		this.visemeKeyTextBox.sinkEvents(Event.ONPASTE | Event.ONKEYPRESS);

		final boolean visemeKeyTextBoxEnabled = isVisemeKeyTextBoxEnabled();

		if (visemeKeyTextBoxEnabled) {
			this.visemeKeyTextBox.setStyleName("textBox");
			this.mainPanel.add(visemeKeyTextBox);

			visemeKeyTextBox.addKeyPressHandler(new KeyPressHandler() {

				@Override
				public void onKeyPress(KeyPressEvent event) {

					char charCode = event.getCharCode();

					if (isValidVisemeKey(charCode)) {
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {
							@Override
							public void execute() {
								handleVisemeKeyTextBoxTextChanged();
							}
						});
					} else {
						int keyCode = event.getNativeEvent().getKeyCode();
						if (!isOtherAllowedKey(keyCode) && keyCode != 0) {
							event.preventDefault();
							repairVisemeKeyTextBox();
						}
					}
				}
			});

			visemeKeyTextBox.addKeyDownHandler(new KeyDownHandler() {
				@Override
				public void onKeyDown(final KeyDownEvent event) {
					if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE
							|| event.getNativeKeyCode() == KeyCodes.KEY_DELETE
							|| event.getNativeKeyCode() == KeyCodes.KEY_LEFT) {
						event.stopPropagation();
					}

					switch (eventTranslator.get(event)) {
					case UNDO:
						event.preventDefault();
						break;
					case REDO:
						event.preventDefault();
						break;
					default:
						break;
					}
				}
			});

			visemeKeyTextBox.addKeyUpHandler(new KeyUpHandler() {
				@Override
				public void onKeyUp(final KeyUpEvent event) {

					// Ignore keys used for text selection
					final int nativeKeyCode = event.getNativeKeyCode();
					if (!(KeyCodes.KEY_LEFT == nativeKeyCode || KeyCodes.KEY_RIGHT == nativeKeyCode
							|| KeyCodes.KEY_SHIFT == nativeKeyCode || KeyCodes.KEY_ALT == nativeKeyCode
							|| KeyCodes.KEY_CTRL == nativeKeyCode)) {
						handleVisemeKeyTextBoxTextChanged();
					}
				}
			});

			visemeKeyTextBox.addFocusHandler(new FocusHandler() {
				@Override
				public void onFocus(final FocusEvent event) {
					handleFocusVisemeKeyTextBox();
				}
			});
		}

		ImageAndTextButton deleteAllVisemesButton = new ImageAndTextButton(
				new Image(Resources.RESOURCE.IconDeleteAll()), I18N.getDeleteAllVisemes(), new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						visemeKeyTextBox.setText("");
						handleVisemeKeyTextBoxTextChanged();
						VisemeEditor.this.visemeEditorListener.onDeleteOldHeadSymbols();
					}
				});
		this.mainPanel.add(deleteAllVisemesButton);

		freePositionVisemesButton = new ImageAndTextButton(new Image(Resources.RESOURCE.getIconFreePositionVisemes()),
				I18N.getFreePositionVisemes(), new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						setTextBoxEnabled(false);
						toggleFreePositionAndArrangeButton();
						VisemeEditor.this.visemeEditorListener.onFreePositionHeadSymbols();
					}

				});
		this.mainPanel.add(freePositionVisemesButton);

		arrangeVisemesButton = new ImageAndTextButton(new Image(Resources.RESOURCE.getIconArrangeVisemes()),
				I18N.getArrangeVisemes(), new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						setTextBoxEnabled(true);
						toggleFreePositionAndArrangeButton();
						VisemeEditor.this.visemeEditorListener.onArrangeHeadSymbols();
					}
				});
		this.mainPanel.add(arrangeVisemesButton);

		// when created the SignEditor is in freepositioned Mode
		initializeButtonStatus(true);

		headSymbolKeyboard = new HeadSymbolKeyboard(symbolImageUrlService, visemeKeyTextBoxEnabled);
		headSymbolKeyboard.setStyleDependentName("keyTextBox", visemeKeyTextBoxEnabled);
		mainPanel.add(headSymbolKeyboard);

		initMouthSymbolButtons();
	}

	public void setButtonAndTextBoxStatus(boolean isInFreePositionMode) {
		initializeButtonStatus(isInFreePositionMode);
		setTextBoxEnabled(!isInFreePositionMode);
		setFocus(!isInFreePositionMode);
	}

	// bei Initialize sind Symbols angeorndet
	private void initializeButtonStatus(boolean isInFreePositionMode) {
		setIsInFreePositionableMode(isInFreePositionMode);
		arrangeVisemesButton.setEnabled(isInFreePositionMode);
		freePositionVisemesButton.setEnabled(!isInFreePositionMode);
	}

	private void toggleFreePositionAndArrangeButton() {
		if (isInFreePositionableMode()) {
			setIsInFreePositionableMode(false);
			freePositionVisemesButton.setEnabled(true);
			arrangeVisemesButton.setEnabled(false);
		} else {
			setIsInFreePositionableMode(true);
			freePositionVisemesButton.setEnabled(false);
			arrangeVisemesButton.setEnabled(true);
		}
		visemeEditorListener.onHistoryEvent();
	}

	public boolean isInFreePositionableMode() {
		return isInFreePositionableMode;
	}

	private void setIsInFreePositionableMode(boolean isInFreePositionableMode) {
		this.isInFreePositionableMode = isInFreePositionableMode;
	}

	private void setFocus(final boolean focused) {
		if (isVisemeKeyTextBoxEnabled()) {
			visemeKeyTextBox.setFocus(focused);
		}
	}

	public int getVisemeKeyCount() {
		return visemeKeyTextBox.getText().length();
	}

	public void removeVisemeKeyAt(final int visemeIndex) {
		assert visemeIndex >= 0 : "Precondition failed: visemeIndex >= 0";
		assert visemeIndex < getVisemeKeyCount() : "Precondition failed: visemeIndex < getKeyCount()";

		final String text = visemeKeyTextBox.getText();
		final String newText = text.substring(0, visemeIndex) + text.substring(visemeIndex + 1);
		visemeKeyTextBox.setText(newText);
	}

	public void insertVisemeKeyAt(final int index, final PositionedMouthSymbol mouthSymbol) {
		assert mouthSymbol != null : "Precondition failed: mouthSymbol != null";
		assert hasViseme(mouthSymbol) : "Precondition failed: hasViseme(mouthSymbol)";
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index <= getVisemeKeyCount() : "Precondition failed: index [" + index + "] <= getKeyCount() ["
				+ getVisemeKeyCount() + "]";

		insertVisemeKeyAt(index, visemeToKeyMap.get(mouthSymbol.getSymbol()));
	}

	public void setVisemeKeysFor(final List<HeadSymbol> headSymbols) {
		assert headSymbols != null : "Precondition failed: headSymbols != null";

		int cursorPosition = visemeKeyTextBox.getCursorPos();
		final StringBuilder stringBuilder = new StringBuilder();

		for (final HeadSymbol headSymbol : headSymbols) {
			final Character headSymbolCharacter = visemeToKeyMap.get(headSymbol.getPositionedMouthSymbol().getSymbol());
			if (headSymbolCharacter != null) {
				stringBuilder.append(headSymbolCharacter);
			}
		}

		visemeKeyTextBox.setText(stringBuilder.toString());
		if (visemeKeyTextBox.getText().length() >= cursorPosition) {
			visemeKeyTextBox.setCursorPos(cursorPosition);
		}
	}

	public boolean hasViseme(final PositionedMouthSymbol viseme) {
		assert viseme != null : "Precondition failed: viseme != null";

		return visemeToKeyMap.containsKey(viseme.getSymbol());
	}

	/**
	 * Caluclates the index of the given HeadSymbol inside the given list only considering visemes.
	 */
	public int getVisemeIndex(final List<HeadSymbol> headSymbols, final HeadSymbol viseme) {
		assert headSymbols != null : "Precondition failed: headSymbols != null";
		assert viseme != null : "Precondition failed: viseme != null";
		assert hasViseme(viseme.getPositionedMouthSymbol()) : "Precondition failed: hasViseme(viseme.getMouth())";

		int result = -1;

		for (final HeadSymbol headSymbol : headSymbols) {
			if (hasViseme(headSymbol.getPositionedMouthSymbol())) {
				result++;
			}

			if (headSymbol == viseme) {
				break;
			}
		}

		assert result >= -1 : "Postcondition failed: result >= -1";
		return result;
	}

	public void resetVisemeEditor() {
		visemeKeyTextBox.setText("");
		initializeButtonStatus(true);
	}

	private boolean isValidVisemeKey(final char character) {
		return keyToVisemeMap.containsKey(character);
	}

	private void repairVisemeKeyTextBox() {
		final String oldText = visemeKeyTextBox.getText();
		final int oldCursorPos = visemeKeyTextBox.getCursorPos();
		int newCursorPos = oldCursorPos;

		final StringBuilder repairedText = new StringBuilder();

		for (int keyIndex = 0; keyIndex < oldText.length(); keyIndex++) {
			if (isValidVisemeKey(oldText.charAt(keyIndex))) {
				// only keep valid viseme characters
				repairedText.append(oldText.charAt(keyIndex));
			} else if (keyIndex < oldCursorPos) {
				// modify cursor position to take into account deleted invalid
				// characters
				newCursorPos -= 1;
			}
		}
		visemeKeyTextBox.setText(repairedText.toString());
		visemeKeyTextBox.setCursorPos(newCursorPos);

	}

	private void handleFocusVisemeKeyTextBox() {
		VisemeEditor.this.visemeEditorListener.onFocusKeyTextBox();
	}

	private void initMouthSymbolButtons() {
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_RECTANGLE_YAWN.getIswaSymbol(), new char[] { 'a' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_RECTANGLE.getIswaSymbol(), new char[] { 'ä' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_TENSE.getIswaSymbol(), new char[] { 'b', 'p' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_WRINKLES_DOUBLE.getIswaSymbol(), new char[] { '§' });
		addMouthSymbol(MouthBaseSymbol.TONGUE_INSIDE_MOUTH_RELAXED.getIswaSymbol(), new char[] { 'd', 't', 'n' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_OVAL.getIswaSymbol(), new char[] { 'e' });
		addMouthSymbol(MouthBaseSymbol.TEETH_ON_LIPS.getIswaSymbol(), new char[] { 'f', 'v', 'w' });
		addMouthSymbol(new Symbol(4, 5, 1, 5, 2, 5, 10, 10), new char[] { 'g', 'k', 'r', 'c' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_OVAL_WRINKLED.getIswaSymbol(), new char[] { 'i' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_WRINKLES_SINGLE.getIswaSymbol(), new char[] { 'j' });
		addMouthSymbol(MouthBaseSymbol.TONGUE_TIP_TOUCHES_INSIDE_MOUTH.getIswaSymbol(), new char[] { 'l' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_CLOSED_NEUTRAL.getIswaSymbol(), new char[] { 'm' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_CIRCLE.getIswaSymbol(), new char[] { 'o', 'ö' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_OVAL_YAWN.getIswaSymbol(), new char[] { '&' });
		addMouthSymbol(MouthBaseSymbol.TEETH.getIswaSymbol(), new char[] { 's', 'z', 'ß' });
		addMouthSymbol(MouthBaseSymbol.TEETH_ON_TONGUE.getIswaSymbol(), new char[] { '%' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_FORWARD.getIswaSymbol(), new char[] { '$' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_OPEN_WRINKLED.getIswaSymbol(), new char[] { 'u', 'ü' });
		addMouthSymbol(MouthBaseSymbol.MOUTH_SMILE.getIswaSymbol(), new char[] { ')' });
		//
		addMouthSymbol(MouthBaseSymbol.NONE.getIswaSymbol(), new char[] { '+' });
		addMouthSymbol(MouthBaseSymbol.WHITESPACE.getIswaSymbol(), new char[] { ' ' });
	}

	private boolean containsVisemeKeys(final char[] keys) {
		assert keys != null : "Precondition failed: keys != null";

		boolean result = false;

		for (int i = 0, l = keys.length; i < l && !result; i++) {
			final char key = keys[i];

			result = keyToVisemeMap.containsKey(key);
		}

		return result;
	}

	private void addMouthSymbol(final Symbol mouthSymbol, final char[] keys) {
		assert mouthSymbol != null : "Precondition failed: mouthSymbol != null";
		assert keys != null : "Precondition failed: keys != null";
		assert keys.length > 0 : "Precondition failed: keys.length > 0";
		assert !containsVisemeKeys(keys) : "Precondition failed: !containsKeys(keys)";

		final char defaultKey = keys[0];

		visemeToKeyMap.put(mouthSymbol, defaultKey);

		for (final Character key : keys) {
			keyToVisemeMap.put(Character.toLowerCase(key), mouthSymbol);
			keyToVisemeMap.put(Character.toUpperCase(key), mouthSymbol);
		}

		final StringBuilder keyLabelTextBuilder = new StringBuilder();
		for (int i = 0, l = keys.length; i < l; i++) {
			keyLabelTextBuilder.append(keys[i]);
			if (i < l - 1) {
				keyLabelTextBuilder.append(", ");
			}
		}

		headSymbolKeyboard.addHeadSymbol(createHeadSymbol(mouthSymbol), keyLabelTextBuilder.toString(),
				new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						handleMouthSymbolButtonClicked(mouthSymbol, defaultKey);
					}
				});
	}

	private void handleVisemeKeyTextBoxTextChanged() {
		repairVisemeKeyTextBox();

		final String text = visemeKeyTextBox.getText();

		final List<HeadSymbol> newHeadSymbols = new ArrayList<HeadSymbol>();

		for (int i = 0; i < text.length(); i++) {
			final Symbol mouthSymbol = keyToVisemeMap.get(Character.toLowerCase(text.charAt(i)));
			final HeadSymbol headSymbol = createHeadSymbol(mouthSymbol);
			newHeadSymbols.add(headSymbol);
		}
		// When typing fast more letters appear before the cursor position was
		// requested resulting in an inconsistent value
		// Therefore re-adjust
		int cursorPos = -1;
		if (I18NLocale.DE.equals(I18N.getLocale())) {
			int cursorPositionInTextBox = visemeKeyTextBox.getCursorPos();
			cursorPos = cursorPositionInTextBox <= newHeadSymbols.size() ? cursorPositionInTextBox
					: newHeadSymbols.size();
		} else {
			cursorPos = newHeadSymbols.size();
		}
		visemeEditorListener.onHeadSymbolsChanged(newHeadSymbols, cursorPos);
		visemeEditorListener.onHistoryEvent();
	}

	private HeadSymbol createHeadSymbol(final Symbol mouthSymbol) {
		assert mouthSymbol != null : "Precondition failed: mouthSymbol != null";

		PositionedHeadPostureSymbol headPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol());

		PositionedSymbol positionedMouthSymbol = positionedSymbolFactory.createPositionedSymbol(mouthSymbol);

		if (mouthSymbol.equals(MouthBaseSymbol.NONE.getIswaSymbol())) {
			headPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
					.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol());
		} else if (mouthSymbol.equals(MouthBaseSymbol.WHITESPACE.getIswaSymbol())) {
			headPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
					.createPositionedSymbol(HeadPostureBaseSymbol.NONE_SPACE_WIDTH.getIswaSymbol());
			positionedMouthSymbol = new PositionedMouthSymbol(mouthSymbol);

		}

		PositionedSymbol positionedHeadPostureSymbol = positionedSymbolFactory
				.createPositionedSymbol(headPosture.getSymbol());
		final HeadSymbol result = positionedSymbolFactory.createHeadSymbol(positionedHeadPostureSymbol,
				positionedMouthSymbol);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void insertVisemeKeyAt(final int index, final char key) {
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index <= getVisemeKeyCount() : "Precondition failed: index [" + index + "] <= getKeyCount() ["
				+ getVisemeKeyCount() + "]";

		final String oldText = visemeKeyTextBox.getText();
		final String newText = oldText.substring(0, index) + key
				+ oldText.substring(index + visemeKeyTextBox.getSelectionLength());

		visemeKeyTextBox.setText(newText);
		visemeKeyTextBox.setCursorPos(index + 1);
	}

	private boolean isVisemeKeyTextBoxEnabled() {
		return I18NLocale.DE.equals(I18N.getLocale());
	}

	private boolean isOtherAllowedKey(final int nativeKeyCode) {
		return nativeKeyCode == KeyCodes.KEY_LEFT || nativeKeyCode == KeyCodes.KEY_RIGHT
				|| nativeKeyCode == KeyCodes.KEY_HOME || nativeKeyCode == KeyCodes.KEY_END
				|| nativeKeyCode == KeyCodes.KEY_BACKSPACE || nativeKeyCode == KeyCodes.KEY_DELETE;
	}

	private void handleMouthSymbolButtonClicked(final Symbol mouthSymbol, final char key) {
		assert keyToVisemeMap.containsKey(key) : "Precondition failed: keyToVisemeMap.containsKey(key)";

		insertVisemeKeyAt(getVisemeKeyCount(), key);

		if (!isInFreePositionableMode()) {
			handleVisemeKeyTextBoxTextChanged();
		} else {
			visemeEditorListener.onAddFreePositionedHeadSymbol(createHeadSymbol(mouthSymbol));
		}
	}

	private void setTextBoxEnabled(boolean enabled) {
		visemeKeyTextBox.setEnabled(enabled);
	}

	public interface VisemeEditorListener {
		void onHeadSymbolsChanged(List<HeadSymbol> newHeadSymbols, int cursorPosition);

		void onFreePositionHeadSymbols();

		void onAddFreePositionedHeadSymbol(HeadSymbol headSymbol);

		void onDeleteOldHeadSymbols();

		void onArrangeHeadSymbols();

		void onFocusKeyTextBox();

		void onHistoryEvent();
	}
}
