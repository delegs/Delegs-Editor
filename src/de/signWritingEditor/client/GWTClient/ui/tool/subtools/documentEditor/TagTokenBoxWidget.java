package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestBox.DefaultSuggestionDisplay;
import com.google.gwt.user.client.ui.SuggestOracle;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.widget.BulletList;
import de.signWritingEditor.client.GWTClient.ui.general.widget.HTMLParagraph;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ListItem;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTextbasedTokenBoxWidget.TextbasedTokenBoxWidgetListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.TagTokenBox;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

public class TagTokenBoxWidget extends AbstractTokenBoxWidget {
	private TagTokenBox tagTokenBox;
	private FlowPanel mainPanel;
	private Label descriptionLabel;
	private SuggestBoxWidget suggestBoxForm;
	private TagTokenBoxWidgetListener tagTokenBoxWidgetListener;
	private FontSizeService fontSizeService;
	private EventTranslatorStandardImpl eventTranslator;

	public TagTokenBoxWidget(TagTokenBox tagTokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService, TagTokenBoxWidgetListener tagTokenBoxWidgetListener) {
		assert tagTokenBox != null;
		this.tagTokenBox = tagTokenBox;
		this.tagTokenBoxWidgetListener = tagTokenBoxWidgetListener;
		this.fontSizeService = fontSizeService;
		this.eventTranslator = eventTranslator;

		mainPanel = new FlowPanel();
		descriptionLabel = new Label(tagTokenBox.getDescription());
		descriptionLabel.setWidth(tagTokenBox.getDescriptionWidth_PX() + "px");
		suggestBoxForm = new SuggestBoxWidget(tagTokenBox.getItemList(), tagTokenBox.getSelectedItemList());

		descriptionLabel.addStyleName("tagDescriptionLabel");
		descriptionLabel.addStyleName("textAreaHover");
		mainPanel.add(descriptionLabel);
		mainPanel.add(suggestBoxForm);
		mainPanel.addStyleName("formTokenWidget");
		initWidget(mainPanel);

		setTokenBox(tagTokenBox);
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {

	}

	@Override
	protected boolean isResizeable() {
		return false;
	}

	@Override
	public Id getId() {
		return tagTokenBox.getId();
	}

	@Override
	public void focus() {

	}

	@Override
	public void toggleSelection() {

	}

	@Override
	public TokenBox getTokenBox() {
		return tagTokenBox;
	}

	@Override
	public void setTokenBox(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert tokenBox instanceof TagTokenBox : "Precondition failed: tokenBox instanceof TagTokenBox";
		tagTokenBox = (TagTokenBox) tokenBox;

		descriptionLabel.getElement().getStyle().setProperty("fontFamily",
				tagTokenBox.getFontMetricSpecifier().getFont().toString());
		descriptionLabel.getElement().getStyle().setProperty("fontStyle",
				tagTokenBox.getFontMetricSpecifier().getFontStyle().name().toLowerCase());
		descriptionLabel.getElement().getStyle().setProperty("fontWeight",
				tagTokenBox.getFontMetricSpecifier().getFontWeight().name().toLowerCase());
		descriptionLabel.getElement().getStyle().setProperty("fontSize",
				tagTokenBox.getFontMetricSpecifier().getFontSize().getSize() + "px");
		descriptionLabel.getElement().getStyle().setColor(tagTokenBox.getColor().getCssValue());

		ExtendedRichTextBox inputBox = suggestBoxForm.getItemBox();
		inputBox.setFont(tagTokenBox.getFontMetricSpecifier().getFont());
		inputBox.setTextFontStyle(tagTokenBox.getFontMetricSpecifier().getFontStyle());
		inputBox.setTextFontWeight(tagTokenBox.getFontMetricSpecifier().getFontWeight());
		inputBox.setTextFontSize(fontSizeService.getActualFontSize(tagTokenBox.getFontMetricSpecifier().getFontSize()));
		inputBox.setTextColor(tagTokenBox.getColor());

		BulletList itemList = suggestBoxForm.getItemList();
		itemList.getElement().getStyle().setProperty("fontFamily",
				tagTokenBox.getFontMetricSpecifier().getFont().toString());
		itemList.getElement().getStyle().setProperty("fontStyle",
				tagTokenBox.getFontMetricSpecifier().getFontStyle().name().toLowerCase());
		itemList.getElement().getStyle().setProperty("fontWeight",
				tagTokenBox.getFontMetricSpecifier().getFontWeight().name().toLowerCase());
		itemList.getElement().getStyle().setProperty("fontSize",
				(tagTokenBox.getFontMetricSpecifier().getFontSize().getSize() - 3) + "px");
		itemList.getElement().getStyle().setColor(tagTokenBox.getColor().getCssValue());

		mainPanel.setHeight(tagTokenBox.getHeight_PX() + "px");
		suggestBoxForm.updateBackgroundColor();
	}

	@Override
	public int getCursorLeft() {
		return 0;
	}

	private class SuggestBoxWidget extends Composite {
		List<String> selectedItems = new ArrayList<String>();
		SuggestBox box;
		ExtendedRichTextBox itemBox;
		DefaultSuggestionDisplay suggestionDisplay;
		MultiWordSuggestOracle oracle;
		List<String> suggestions;
		PopupPanel errorPanel;
		final BulletList list;

		public SuggestBoxWidget(List<String> suggestions, List<String> previousSelectedList) {
			FlowPanel panel = new FlowPanel();
			initWidget(panel);
			suggestionDisplay = new DefaultSuggestionDisplay();
			this.suggestions = suggestions;
			errorPanel = new PopupPanel();
			errorPanel.add(new Label("Nicht gefunden"));
			errorPanel.getElement().getStyle().setCursor(Cursor.DEFAULT);

			oracle = new MultiWordSuggestOracle();
			updateSuggestions();

			list = new BulletList();
			list.setStyleName("token-input-list");
			list.setWidth(tagTokenBox.getInputWidth_PX() + "px");
			final ListItem item = new ListItem();
			item.setStyleName("token-input-input-token");
			itemBox = new ExtendedRichTextBox(eventTranslator, fontSizeService) {
				@Override
				public void onBrowserEvent(Event event) {
					super.onBrowserEvent(event);
					switch (event.getTypeInt()) {
					case Event.ONKEYUP:
//						handleTextAreaKeyUpAndPaste();
						break;
					case Event.ONMOUSEDOWN:
						handleMouseDownEvent(event);
						break;
					case Event.ONMOUSEMOVE:
						// Propagation needs to be stopped, because
						// DocumentPanel would prevent default behavior and
						// selection (only in IE)
						event.stopPropagation();
						break;
					}
				}
			};
			itemBox.setHeight(tagTokenBox.getHeight_PX() + "px");
			itemBox.getElement().setAttribute("autocomplete", "off");
			itemBox.getElement().setAttribute("style",
					"resize: none; border: none; overflow: hidden; width: 100%; outline-style: none");
			box = new SuggestBox(oracle, itemBox, suggestionDisplay);
			box.getElement().setId("suggestion_box_" + tagTokenBox.getId());
			updateBackgroundColor();
			item.add(box);
			list.add(item);

			if (!previousSelectedList.isEmpty()) {
				importPreviousSelectedList(previousSelectedList, list);
			}

			itemBox.addKeyDownHandler(new KeyDownHandler() {
				public void onKeyDown(KeyDownEvent event) {
					if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
						if (itemBox.getValue().contains("@")) {
							createListItem(itemBox, list);
							tagTokenBoxWidgetListener.onSuggestBoxHeightChanged(tagTokenBox.getId(),
									list.getOffsetHeight());
						}
					}
					if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
						if ("".equals(itemBox.getValue().trim()) && list.getWidgetCount() > 1) {
							ListItem li = (ListItem) list.getWidget(list.getWidgetCount() - 2);
							removeListItem(li, list);
							itemBox.setFocus(true);
						}
					}
				}
			});

			itemBox.addKeyUpHandler(new KeyUpHandler() {
				@Override
				public void onKeyUp(KeyUpEvent event) {
					if (!suggestionDisplay.isSuggestionListShowing() && !itemBox.getValue().equals("")) {
						errorPanel.showRelativeTo(itemBox);
					} else if (suggestionDisplay.isSuggestionListShowing()) {
						errorPanel.hide();
					}
				}

			});

			itemBox.addBlurHandler(new BlurHandler() {
				@Override
				public void onBlur(BlurEvent event) {
					itemBox.setValue("");
					errorPanel.hide();
					list.removeStyleName("focusedTagToken");
				}
			});

			itemBox.addFocusHandler(new FocusHandler() {

				@Override
				public void onFocus(FocusEvent event) {
					list.addStyleName("focusedTagToken");
				}
			});

			item.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					box.showSuggestionList();
					box.setFocus(true);
				}
			});

			box.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
				public void onSelection(SelectionEvent selectionEvent) {
					createListItem(itemBox, list);
					tagTokenBoxWidgetListener.onSuggestBoxHeightChanged(tagTokenBox.getId(), list.getOffsetHeight());
				}
			});

			panel.add(list);

			panel.getElement().setAttribute("onclick",
					"document.getElementById('suggestion_box_" + tagTokenBox.getId() + "').focus()");
			box.setFocus(true);

		}

		public void updateBackgroundColor() {
			String color = tagTokenBox.getBackgroundColor().getCssValue();
			if (color != null) {
				list.getElement().getStyle().setBackgroundColor(color);
				box.getElement().getStyle().setBackgroundColor(color);
			}
		}

		protected void handleMouseDownEvent(Event event) {
			assert event != null : "Precondition failed: event != null";
			assert event
					.getTypeInt() == Event.ONMOUSEDOWN : "Precondition failed: event.getTypeInt() == Event.ONMOUSEDOWN";
			// Call fireMoveCurosorInBox() deferred since text box changes its
			// cursor position after event is fired:
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				@Override
				public void execute() {
					tagTokenBoxWidgetListener.onSelectToken(tagTokenBox.getId(), false, true);
				}
			});
		}

		private void importPreviousSelectedList(List<String> previousSelectedList, final BulletList list) {
			for (String selectedWord : previousSelectedList) {
				itemBox.setValue(selectedWord);
				createListItem(itemBox, list);
			}
		}

		private void createListItem(final ExtendedRichTextBox itemBox, final BulletList list) {
			if (itemBox.getValue() != null && !"".equals(itemBox.getValue().trim())) {
				final ListItem displayItem = new ListItem();
				displayItem.setStyleName("token-input-token");

				HTMLParagraph p = new HTMLParagraph(itemBox.getValue());

				Label removeTagButton = new Label("x");
				removeTagButton.addStyleName("tagToken-label-x");
				removeTagButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent clickEvent) {
						removeListItem(displayItem, list);
					}
				});

				displayItem.add(p);
				displayItem.add(removeTagButton);
				list.insert(displayItem, list.getWidgetCount() - 1);
				tagTokenBox.selectWord(itemBox.getValue());
				if (tagTokenBox.getSelectedItemList().contains(itemBox.getValue())) {
					suggestions.remove(itemBox.getValue());
					updateSuggestions();
				}

				itemBox.setValue("");
				itemBox.setFocus(true);
			}
		}

		private void updateSuggestions() {
			oracle.clear();
			oracle.addAll(suggestions);
			oracle.setDefaultSuggestionsFromText(suggestions);
		}

		private void refreshSuggestions() {
			suggestionDisplay.hideSuggestions();
			box.refreshSuggestionList();
			box.showSuggestionList();
		}

		private void removeListItem(ListItem displayItem, BulletList list) {
			String text = displayItem.getWidget(0).getElement().getInnerHTML();
			selectedItems.remove(text);
			tagTokenBox.deselectWord(text);
			list.remove(displayItem);
			tagTokenBoxWidgetListener.onSuggestBoxHeightChanged(tagTokenBox.getId(), list.getOffsetHeight());
			suggestions.add(text);
			updateSuggestions();
			refreshSuggestions();
		}

		public ExtendedRichTextBox getItemBox() {
			return itemBox;
		}

		public BulletList getItemList() {
			return list;
		}

	}

	public interface TagTokenBoxWidgetListener
			extends ResizableTokenBoxWidgetListener, TextbasedTokenBoxWidgetListener {
		void onInputContentChanged(Id tokenId, String inputContent, int cursorPosition);

		void onSuggestBoxHeightChanged(Id tokenId, int newHeight);

		void onInsertLineOrPageBreakAfterFreeTextToken(Id tokenId, char breakCharacter);
	}
}