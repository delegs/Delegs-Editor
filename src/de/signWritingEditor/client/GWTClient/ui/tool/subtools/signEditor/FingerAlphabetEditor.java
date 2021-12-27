package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

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
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.FingerAlphabetKeyboard.FingerAlphabetKeyboardListener;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.infrastructure.OperatingSystemChecker;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.domainValue.OperatingSystem;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;

public class FingerAlphabetEditor extends Composite {

	Map<Character, FingerAlphabet> characterToFingerAlphabetMap;
	Map<FingerAlphabet, Character> fingerAlphabetToCharacterMap;
	private FlowPanel mainPanel;
	private final FingerAlphabetKeyboard fingerAlphabetKeyboard;
	private ImageAndTextButton arrangeFingerAlphabetButton;
	private ImageAndTextButton spellSearchWordButton;
	private FingerAlphabetEditorListener fingerAlphabetListener;
	private EventTranslatorStandardImpl eventTranslator;
	private TextBox fingerAlphabetTextBox;

	public FingerAlphabetEditor(SymbolImageUrlService symbolImageUrlService,
			final FingerAlphabetEditorListener fingerAlphabetListener) {

		this.fingerAlphabetListener = fingerAlphabetListener;
		characterToFingerAlphabetMap = new LinkedHashMap<Character, FingerAlphabet>();
		fingerAlphabetToCharacterMap = new LinkedHashMap<FingerAlphabet, Character>();
		fingerAlphabetKeyboard = new FingerAlphabetKeyboard(symbolImageUrlService);
		initFingerAlphabetMap();

		if (OperatingSystemChecker.getOperatingSystemType().equals(OperatingSystem.MacOS)) {
			eventTranslator = GWT.create(EventTranslatorMacImpl.class);
		} else {
			eventTranslator = GWT.create(EventTranslatorStandardImpl.class);
		}

		this.mainPanel = new FlowPanel();
		initWidget(mainPanel);

		this.fingerAlphabetTextBox = new TextBox() {
			@Override
			public void onBrowserEvent(final Event event) {
				// Pasting into key text box is not allowed
				if (event.getTypeInt() == Event.ONPASTE) {
					event.preventDefault();
				}
				super.onBrowserEvent(event);
			}
		};
		this.fingerAlphabetTextBox.sinkEvents(Event.ONPASTE | Event.ONKEYPRESS);

		fingerAlphabetTextBox.addStyleName("fingerAlphabetTextBox");

		fingerAlphabetTextBox.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {

				char charCode = event.getCharCode();

				if (isValidFingerAlphabetKey(charCode)) {
					Scheduler.get().scheduleDeferred(new ScheduledCommand() {
						@Override
						public void execute() {
							handleFingerAlphabetTextBoxChanged();
						}
					});
				} else {
					int keyCode = event.getNativeEvent().getKeyCode();
					if (!isOtherAllowedKey(keyCode) && keyCode != 0) {
						event.preventDefault();
						repairFingerAlphabetTextBox();
					}
				}
			}
		});

		fingerAlphabetTextBox.addKeyDownHandler(new KeyDownHandler() {
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

		fingerAlphabetTextBox.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(final KeyUpEvent event) {

				// Ignore keys used for text selection
				final int nativeKeyCode = event.getNativeKeyCode();
				if (!(KeyCodes.KEY_LEFT == nativeKeyCode || KeyCodes.KEY_RIGHT == nativeKeyCode
						|| KeyCodes.KEY_SHIFT == nativeKeyCode || KeyCodes.KEY_ALT == nativeKeyCode
						|| KeyCodes.KEY_CTRL == nativeKeyCode)) {
					handleFingerAlphabetTextBoxChanged();
				}
			}
		});

		fingerAlphabetTextBox.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(final FocusEvent event) {
				handleFocusFingerAlphabetTextBox();
			}
		});

		mainPanel.add(fingerAlphabetTextBox);

		spellSearchWordButton = new ImageAndTextButton(
				new Image(Resources.RESOURCE.getIconSearchwordToFingeralphabet()),
				I18N.getSpellSearchwordToFingerAlphabet(), new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						handleSpellSearchWordClicked();
					}
				});
		this.mainPanel.add(spellSearchWordButton);

		arrangeFingerAlphabetButton = new ImageAndTextButton(
				new Image(Resources.RESOURCE.getIconArrangeFingeralphabet()), I18N.getArrangeFingerAlphabet(),
				new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						fingerAlphabetListener.onArrangeFingerAlphabet();
					}
				});
		this.mainPanel.add(arrangeFingerAlphabetButton);

		mainPanel.add(fingerAlphabetKeyboard);
	}

	protected void repairFingerAlphabetTextBox() {
		final String oldText = fingerAlphabetTextBox.getText();
		final int oldCursorPos = fingerAlphabetTextBox.getCursorPos();
		int newCursorPos = oldCursorPos;

		final StringBuilder repairedText = new StringBuilder();

		for (int keyIndex = 0; keyIndex < oldText.length(); keyIndex++) {
			if (isValidFingerAlphabetKey(oldText.charAt(keyIndex))) {
				// only keep valid fingerAlphabet characters
				repairedText.append(oldText.charAt(keyIndex));
			} else if (keyIndex < oldCursorPos) {
				// modify cursor position to take into account deleted invalid
				// characters
				newCursorPos -= 1;
			}
		}
		fingerAlphabetTextBox.setText(repairedText.toString());
		fingerAlphabetTextBox.setCursorPos(newCursorPos);
	}

	protected boolean isValidFingerAlphabetKey(char charCode) {
		return characterToFingerAlphabetMap.containsKey(charCode);
	}

	private boolean isOtherAllowedKey(final int nativeKeyCode) {
		return nativeKeyCode == KeyCodes.KEY_LEFT || nativeKeyCode == KeyCodes.KEY_RIGHT
				|| nativeKeyCode == KeyCodes.KEY_HOME || nativeKeyCode == KeyCodes.KEY_END
				|| nativeKeyCode == KeyCodes.KEY_BACKSPACE || nativeKeyCode == KeyCodes.KEY_DELETE;
	}

	public void setFingerAlphabetKeysFor(final List<PositionedFingerAlphabetSymbol> fingerAlphabetSymbols) {
		assert fingerAlphabetSymbols != null : "Precondition failed: headSymbols != null";

		int cursorPosition = fingerAlphabetTextBox.getCursorPos();
		final StringBuilder stringBuilder = new StringBuilder();

		for (final PositionedFingerAlphabetSymbol fingerAlphabetSymbol : fingerAlphabetSymbols) {

			final Character fingerAlphabetSymbolCharacter = fingerAlphabetToCharacterMap
					.get(fingerAlphabetSymbol.getFingerAlphabetSymbol());
			if (fingerAlphabetSymbolCharacter != null) {
				stringBuilder.append(fingerAlphabetSymbolCharacter);
			}
		}

		fingerAlphabetTextBox.setText(stringBuilder.toString());
		if (fingerAlphabetTextBox.getText().length() >= cursorPosition) {
			fingerAlphabetTextBox.setCursorPos(cursorPosition);
		}
	}

	private void initFingerAlphabetMap() {
		addFingerAlphabetSymbol('a', FingerAlphabet.A);
		addFingerAlphabetSymbol('b', FingerAlphabet.B);
		addFingerAlphabetSymbol('c', FingerAlphabet.C);
		addFingerAlphabetSymbol('d', FingerAlphabet.D);
		addFingerAlphabetSymbol('e', FingerAlphabet.E);
		addFingerAlphabetSymbol('f', FingerAlphabet.F);
		addFingerAlphabetSymbol('g', FingerAlphabet.G);
		addFingerAlphabetSymbol('h', FingerAlphabet.H);
		addFingerAlphabetSymbol('i', FingerAlphabet.I);
		addFingerAlphabetSymbol('j', FingerAlphabet.J);
		addFingerAlphabetSymbol('k', FingerAlphabet.K);
		addFingerAlphabetSymbol('l', FingerAlphabet.L);
		addFingerAlphabetSymbol('m', FingerAlphabet.M);
		addFingerAlphabetSymbol('n', FingerAlphabet.N);
		addFingerAlphabetSymbol('o', FingerAlphabet.O);
		addFingerAlphabetSymbol('p', FingerAlphabet.P);
		addFingerAlphabetSymbol('q', FingerAlphabet.Q);
		addFingerAlphabetSymbol('r', FingerAlphabet.R);
		addFingerAlphabetSymbol('s', FingerAlphabet.S);
		addFingerAlphabetSymbol('t', FingerAlphabet.T);
		addFingerAlphabetSymbol('u', FingerAlphabet.U);
		addFingerAlphabetSymbol('v', FingerAlphabet.V);
		addFingerAlphabetSymbol('w', FingerAlphabet.W);
		addFingerAlphabetSymbol('x', FingerAlphabet.X);
		addFingerAlphabetSymbol('y', FingerAlphabet.Y);
		addFingerAlphabetSymbol('z', FingerAlphabet.Z);
		addFingerAlphabetSymbol('ä', FingerAlphabet.Ä);
		addFingerAlphabetSymbol('ö', FingerAlphabet.Ö);
		addFingerAlphabetSymbol('ü', FingerAlphabet.Ü);
		addFingerAlphabetSymbol('ß', FingerAlphabet.ß);
	}

	private void addFingerAlphabetSymbol(final char fingerAlphabetCharacter, FingerAlphabet fingerAlphabetSymbol) {
		characterToFingerAlphabetMap.put(fingerAlphabetCharacter, fingerAlphabetSymbol);
		fingerAlphabetToCharacterMap.put(fingerAlphabetSymbol, fingerAlphabetCharacter);

		fingerAlphabetKeyboard.addFingerAlphabetSymbol(fingerAlphabetSymbol, fingerAlphabetCharacter,
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						handleFingerAlphabetSymbolButtonClicked(fingerAlphabetCharacter);
					}
				});
	}

	public interface FingerAlphabetEditorListener extends FingerAlphabetKeyboardListener {
		void onArrangeFingerAlphabet();

		void onHistoryEvent();

		String onSpellSearchWord();

		void onFocusKeyTextBox();

	}

	private void handleFingerAlphabetSymbolButtonClicked(final char fingerAlphabetCharacter) {
		String newText = fingerAlphabetTextBox.getText() + fingerAlphabetCharacter;
		fingerAlphabetTextBox.setText(newText);
		handleFingerAlphabetTextBoxChanged();

	}

	private void handleSpellSearchWordClicked() {
		String searchWord = fingerAlphabetListener.onSpellSearchWord();
		fingerAlphabetTextBox.setText(searchWord);
		handleSpellSearchWord(searchWord);
	}

	private void handleSpellSearchWord(String searchWord) {
		for (Character searchWordChar : searchWord.toLowerCase().toCharArray()) {
			if (characterToFingerAlphabetMap.containsKey(searchWordChar)) {
				fingerAlphabetListener.onAddFingerAlphabetSymbols(
						new PositionedFingerAlphabetSymbol(characterToFingerAlphabetMap.get(searchWordChar), 0, 0, 1));
			}
		}
		fingerAlphabetListener.onArrangeFingerAlphabet();
		fingerAlphabetListener.onHistoryEvent();
	}

	private void handleFingerAlphabetTextBoxChanged() {
		repairFingerAlphabetTextBox();
		fingerAlphabetListener.onSpellSearchWord();
		String searchWord = fingerAlphabetTextBox.getText();

		handleSpellSearchWord(searchWord);
	}

	private void handleFocusFingerAlphabetTextBox() {
		fingerAlphabetListener.onFocusKeyTextBox();
	}

	public void setFingerAlphabetTextFor(
			List<PositionedFingerAlphabetSymbol> fingerAlphabeSymbolsSortedByImagePositions) {
		assert fingerAlphabeSymbolsSortedByImagePositions != null : "Precondition failed: fingerAlphabeSymbolsSortedByImagePositions != null";

		int cursorPosition = fingerAlphabetTextBox.getCursorPos();
		final StringBuilder stringBuilder = new StringBuilder();

		for (final PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol : fingerAlphabeSymbolsSortedByImagePositions) {

			FingerAlphabet fingerAlphabetSymbol = positionedFingerAlphabetSymbol.getFingerAlphabetSymbol();

			final Character fingerAlphabetSymbolCharacter = fingerAlphabetToCharacterMap.get(fingerAlphabetSymbol);
			if (fingerAlphabetSymbolCharacter != null) {
				stringBuilder.append(fingerAlphabetSymbolCharacter);
			}
		}

		fingerAlphabetTextBox.setText(stringBuilder.toString());
		if (fingerAlphabetTextBox.getText().length() >= cursorPosition) {
			fingerAlphabetTextBox.setCursorPos(cursorPosition);
		}
	}

	public void resetFingerAlphabetEditor() {
		fingerAlphabetTextBox.setText("");
	}

}
