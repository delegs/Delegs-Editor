package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.animation.UiUtil;
import de.signWritingEditor.client.GWTClient.ui.general.textHandling.UniversalLocaleCollator;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignHistoryItemWidget.SignHistoryItemWidgetListener;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class SignHistoryItemBrowser extends Composite {

	private int width;
	private final int TITLE_BAR_HEIGHT = SignHistoryItemWidget.HEIGHT;

	private boolean isActive;

	private DictionaryServiceAsync dictionaryService;

	private List<SignHistoryItem> signHistoryItems;
	private List<SignHistoryItem> sortedSignHistoryItems;
	private SignHistoryItem latestSavedSignHistoryItem;
	private SignHistoryItem editedSignHistoryItem;
	private SimpleSign editedUnsavedSign;
	private SimpleSign currentlySelectedSign;
	private SimpleSign latestSavedSign;

	private Map<SignHistoryItem, SignHistoryItemWidget> signHistoryItemToWidget;

	private SignHistoryItem selectedSignHistoryItem;
	private SignHistoryItem previouslySelectedSignHistoryItem;

	private Map<SortCriteria, Comparator<SignHistoryItem>> sortComparatorMap;
	private SortCriteria currentSortCriteria;
	private boolean isCurrentlyAscending;
	private int lastSelectedIndex;

	private SignHistoryItemBrowserListener listener;

	private AbsolutePanel signHistoryItemPanel;
	private List<SignHistoryItemWidget> unusedSignHistoryItemWidgets;
	private LocalSessionService localSessionService;

	/**
	 * Without scroll panel
	 */
	public void initWithoutScrollPanel(LocalSessionService localSessionService,
			DictionaryServiceAsync dictionaryService, int width, final SignHistoryItemBrowserListener listener) {
		initWithScrollPanel(localSessionService, dictionaryService, width, 0, listener);
	}

	/**
	 * With scroll panel
	 */
	public void initWithScrollPanel(LocalSessionService localSessionService, DictionaryServiceAsync dictionaryService,
			int width, int height, final SignHistoryItemBrowserListener listener) {
		assert listener != null : "Precondition failed: listener != null";
		assert dictionaryService != null : "Precondition failed: documentService != null";
		assert width > (SignHistoryItemWidget.LEFT_OFFSET + 2 * SignHistoryItemWidget.DATE_COLUMN_WIDTH
				+ SignHistoryItemWidget.AUTHOR_COLUMN_WIDTH) : "Precondition failed: width > (SignHistoryItemWidget.LEFT_OFFSET + 2 * SignHistoryItemWidget.DATE_COLUMN_WIDTH + SignHistoryItemWidget.AUTHOR_COLUMN_WIDTH)";
		assert height >= 0 : "Precondition failed: height > 0";

		initializeSignHistoryItemBrowser(localSessionService, dictionaryService, width, height, listener);
	}

	public void openedWithNewSign(SimpleSign sign) {
		latestSavedSign = sign.clone();
		selectEditedSignHistoryItem();
	}

	public SimpleSign getLatestSavedSign() {
		assert latestSavedSign != null : "Precondition failed: latestSavedSign != null";
		return latestSavedSign.clone();
	}

	public boolean hasSelectedSignHistoryItem() {
		return selectedSignHistoryItem != null;
	}

	public void sortAndShowFiles() {
		Comparator<SignHistoryItem> comparator = sortComparatorMap.get(currentSortCriteria);
		if (!isCurrentlyAscending) {
			comparator = Collections.reverseOrder(comparator);
		}
		Collections.sort(sortedSignHistoryItems, comparator);
		showSignHistoryItems();
	}

	public SignHistoryItem getSelectedSignHistoryItem() {
		return selectedSignHistoryItem;
	}

	public void refresh() {
	}

	@Override
	public void setHeight(String height) {
		assert height.endsWith("px") : "Precondition failed: height.endsWith(\"px\")";

		Integer newScrollPanelHeight = Integer.valueOf(height.split("px")[0]) - TITLE_BAR_HEIGHT;
		if (newScrollPanelHeight > 0) {
			signHistoryItemPanel.setHeight(newScrollPanelHeight + "px");
		}

	}

	public void showLoadingImage() {
		clearSignHistoryItemBrowser();

		Image loadingResourceWidget = new Image(Resources.RESOURCE.getLoadingImage());
		SimplePanel wrapperPanel = new SimplePanel(loadingResourceWidget);
		wrapperPanel.setPixelSize(signHistoryItemPanel.getOffsetWidth(), signHistoryItemPanel.getOffsetHeight());
		loadingResourceWidget.getElement().getStyle().setMarginTop(
				(signHistoryItemPanel.getOffsetHeight() / 2) - loadingResourceWidget.getHeight(), Unit.PX);
		wrapperPanel.getElement().setAttribute("align", "center");
		wrapperPanel.getElement().setAttribute("verticalAlign", "center");
	}

	protected void initializeSignHistoryItemBrowser(LocalSessionService localSessionService,
			DictionaryServiceAsync dictionaryService, int width, int height,
			final SignHistoryItemBrowserListener listener) {
		this.localSessionService = localSessionService;
		this.dictionaryService = dictionaryService;
		this.listener = listener;
		this.selectedSignHistoryItem = null;
		this.previouslySelectedSignHistoryItem = null;
		this.signHistoryItemToWidget = new HashMap<SignHistoryItem, SignHistoryItemWidget>();
		this.unusedSignHistoryItemWidgets = new ArrayList<SignHistoryItemWidget>();
		this.signHistoryItems = new ArrayList<SignHistoryItem>();
		this.sortedSignHistoryItems = new ArrayList<SignHistoryItem>();
		this.width = width;
		this.lastSelectedIndex = -1;
		this.isActive = false;

		OrientedFlowPanel mainPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		initWidget(mainPanel);
		mainPanel.setStyleName("LLSHIBMainPanel");

		mainPanel.add(createTitleBar());

		UiUtil.disableTextSelectInternal(mainPanel.getElement());

		signHistoryItemPanel = new AbsolutePanel();
		signHistoryItemPanel.setHeight((height - TITLE_BAR_HEIGHT) + "px");
		signHistoryItemPanel.setStyleName("SignHistoryItemPanel");
		signHistoryItemPanel.getElement().getStyle().setOverflow(Overflow.AUTO);
		mainPanel.add(signHistoryItemPanel);

		currentSortCriteria = SortCriteria.CREATION_DATE;
		isCurrentlyAscending = true;

		initComparators();

		setStyleName("signHistoryItemBrowser");
		this.getElement().getStyle().setWidth(700, Unit.PX);
		this.getElement().getStyle().setProperty("margin", "auto");

		mainPanel.addHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				// To stop DocumentMananager from deselecting current selection
				event.stopPropagation();
			}
		}, MouseDownEvent.getType());
		mainPanel.sinkEvents(Event.ONMOUSEDOWN);
	}

	private void initComparators() {
		sortComparatorMap = new HashMap<SignHistoryItemBrowser.SortCriteria, Comparator<SignHistoryItem>>();

		sortComparatorMap.put(SortCriteria.AUTHOR, new Comparator<SignHistoryItem>() {
			@Override
			public int compare(SignHistoryItem o1, SignHistoryItem o2) {
				return o1.getAuthorname().compareToIgnoreCase(o2.getAuthorname());
			}
		});

		sortComparatorMap.put(SortCriteria.COMMENT, new Comparator<SignHistoryItem>() {
			@Override
			public int compare(SignHistoryItem o1, SignHistoryItem o2) {
				return UniversalLocaleCollator.compareTo(o1.getComment(), o2.getComment());
			}
		});

		sortComparatorMap.put(SortCriteria.CREATION_DATE, new Comparator<SignHistoryItem>() {
			@Override
			public int compare(SignHistoryItem o1, SignHistoryItem o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});

	}

	private SignHistoryItem getSignHistoryItemFor(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		return new SignHistoryItem(sign.getSignId(), sign.getAuthor().getUsername(), sign.getComment(),
				sign.getModificationDate(), sign.getRevision());
	}

	private SignHistoryItem getSignHistoryItemWithCurrentTimeFor(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		return new SignHistoryItem(sign.getSignId(), sign.getAuthor().getUsername(), sign.getComment(), new Date(),
				sign.getRevision());
	}

	public void loadSignHistory(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		/*
		 * First we have to check if the sign is from the openSign or
		 * openSignFromHistory (undo/redo was clicked)
		 */
		SignHistoryItem signHistoryItemToOpen = getSignHistoryItemFor(sign);
		boolean signToOpenIsFromUndoRedo = false;

		for (int index = 0; index < signHistoryItems.size(); index++) {
			if (signHistoryItems.get(index).equals(signHistoryItemToOpen)) {
				currentlySelectedSign = sign.clone();
				// Now we know that this sign was from the undo/redo button
				signToOpenIsFromUndoRedo = true;
				break;
			}
		}

		if (!signToOpenIsFromUndoRedo) {
			latestSavedSign = sign.clone();
			previouslySelectedSignHistoryItem = null;
			selectedSignHistoryItem = null;
			if (currentlySelectedSign == null) {
				currentlySelectedSign = sign.clone();
			}

			latestSavedSignHistoryItem = getSignHistoryItemFor(latestSavedSign);

			dictionaryService.getSignHistoryFor(latestSavedSign.getSignId(),
					new AsyncCallback<List<SignHistoryItem>>() {

						@Override
						public void onSuccess(List<SignHistoryItem> result) {
							signHistoryItems = result;
							if (latestSavedSignHistoryItem != null) {
								signHistoryItems.add(0, latestSavedSignHistoryItem);
							}
							editedUnsavedSign = latestSavedSign.clone();
							editedUnsavedSign.setComment(I18N.getUnsavedSign());
							editedUnsavedSign.setAuthor(localSessionService.getCurrentUser());
							editedUnsavedSign.setRevision(-2);
							editedSignHistoryItem = getSignHistoryItemWithCurrentTimeFor(editedUnsavedSign);
							signHistoryItems.add(0, editedSignHistoryItem);
							sortedSignHistoryItems.clear();
							sortedSignHistoryItems.addAll(signHistoryItems);
							isActive = true;
							showSignHistoryItems();
						}

						@Override
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
						}
					});
		} else {
			updateEditedSign(sign, true);
		}

	}

	private void clearSelection() {
		selectedSignHistoryItem = null;
		lastSelectedIndex = -1;
	}

	private AbsolutePanel createTitleBar() {
		AbsolutePanel titleBar = new AbsolutePanel();

		titleBar.setHeight(SignHistoryItemWidget.HEIGHT + "px");

		Label authorLabel = new Label(I18N.getAuthor());
		authorLabel.setStyleName("label");
		authorLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.AUTHOR));
		titleBar.add(authorLabel, SignHistoryItemWidget.LEFT_OFFSET, SignHistoryItemWidget.TOP_OFFSET);

		Label creationDateLabel = new Label(I18N.getCreationDate());
		creationDateLabel.setStyleName("label");
		creationDateLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.CREATION_DATE));
		titleBar.add(creationDateLabel, SignHistoryItemWidget.LEFT_OFFSET + SignHistoryItemWidget.AUTHOR_COLUMN_WIDTH,
				SignHistoryItemWidget.TOP_OFFSET);

		Label changeDateLabel = new Label(I18N.getComment());
		changeDateLabel.setStyleName("label");
		changeDateLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.COMMENT));
		titleBar.add(changeDateLabel, SignHistoryItemWidget.LEFT_OFFSET + SignHistoryItemWidget.AUTHOR_COLUMN_WIDTH
				+ SignHistoryItemWidget.DATE_COLUMN_WIDTH, SignHistoryItemWidget.TOP_OFFSET);

		titleBar.setStyleName("titleBar");

		return titleBar;
	}

	private void showSignHistoryItems() {
		signHistoryItemPanel.getElement().setAttribute("align", "left");
		clearSignHistoryItemBrowser();

		for (int signHistoryItemIndex = 0; signHistoryItemIndex < this.sortedSignHistoryItems
				.size(); signHistoryItemIndex++) {
			SignHistoryItem signHistoryItem = sortedSignHistoryItems.get(signHistoryItemIndex);
			SignHistoryItemWidget signHistoryItemWidget = getUnusedSignHistoryItemWidget(signHistoryItem);
			signHistoryItemWidget.setColored(signHistoryItemIndex % 2 == 0);
			signHistoryItemWidget.markAsUnsaved(signHistoryItem.getRevision() < 0);
			signHistoryItemToWidget.put(signHistoryItem, signHistoryItemWidget);
			signHistoryItemPanel.add(signHistoryItemWidget);
		}

		if (previouslySelectedSignHistoryItem != null) {
			selectSignHistoryItem(previouslySelectedSignHistoryItem, true);
		}
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}

	private SignHistoryItemWidget getUnusedSignHistoryItemWidget(SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "Precondition failed: fileItem != null";

		SignHistoryItemWidget result;

		if (unusedSignHistoryItemWidgets.isEmpty()) {
			result = GWT.create(SignHistoryItemWidget.class);
			result.init(signHistoryItem, width);
		} else {
			result = unusedSignHistoryItemWidgets.remove(0);
			result.updateWithSignHistoryItem(signHistoryItem);
		}
		SignHistoryItemWidgetListener signHistoryItemWidgetListener = createSignHistoryItemWidgetListener(
				signHistoryItem);
		result.setListener(signHistoryItemWidgetListener);
		result.setWidth("100%");

		return result;
	}

	protected SignHistoryItemWidgetListener createSignHistoryItemWidgetListener(final SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "Precondition failed: fileItem != null";

		return new SignHistoryItemWidgetListener() {

			@Override
			public void onClick() {
				handleSignHistoryItemSelected(signHistoryItem);
				if (signHistoryItem.equals(latestSavedSignHistoryItem)) {
					listener.onOpenLatestSign();
				} else if (signHistoryItem.equals(editedSignHistoryItem)) {
					listener.onOpenEditedSign();
				} else {
					listener.onOpenSignHistoryItem(selectedSignHistoryItem);
				}

			}

			@Override
			public void onKeyDown(KeyDownEvent event) {
				listener.onWidgetKeyDownEvent(event);
			}
		};
	}

	protected int getLastSelectedIndex() {
		return lastSelectedIndex;
	}

	protected SignHistoryItemBrowserListener getSignHistoryItemBrowserListener() {
		return listener;
	}

	private void clearSignHistoryItemBrowser() {
		clearSelection();
		unusedSignHistoryItemWidgets.addAll(signHistoryItemToWidget.values());
		signHistoryItemToWidget.clear();
		signHistoryItemPanel.clear();
	}

	protected void handleSignHistoryItemSelected(SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "Precondition failed: signHistoryItem != null";

		selectSignHistoryItem(signHistoryItem, true);

		lastSelectedIndex = signHistoryItems.indexOf(signHistoryItem);
	}

	public void updateEditedSign(SimpleSign sign, boolean isCalledByUndoRedo) {
		assert sign != null : "Precondition failed: sign != null";

		if (currentlySelectedSign != null && (!currentlySelectedSign.contentBasedEquals(sign) || isCalledByUndoRedo)
				&& isActive) {
			editedUnsavedSign = sign.clone();
			editedUnsavedSign.setRevision(-1);
			editedUnsavedSign.setComment(I18N.getUnsavedSign());
			editedUnsavedSign.setAuthor(localSessionService.getCurrentUser());

			SignHistoryItemWidget widgetForEditedSign = signHistoryItemToWidget.get(editedSignHistoryItem);
			signHistoryItemToWidget.remove(editedSignHistoryItem);
			editedSignHistoryItem = getSignHistoryItemWithCurrentTimeFor(editedUnsavedSign);
			SignHistoryItem oldSignHistoryItem = signHistoryItems.get(0);
			signHistoryItems.set(0, editedSignHistoryItem);
			sortedSignHistoryItems.set(sortedSignHistoryItems.indexOf(oldSignHistoryItem), editedSignHistoryItem);

			widgetForEditedSign.updateWithSignHistoryItem(editedSignHistoryItem);
			widgetForEditedSign.setListener(createSignHistoryItemWidgetListener(editedSignHistoryItem));
			signHistoryItemToWidget.put(editedSignHistoryItem, widgetForEditedSign);

			selectSignHistoryItem(editedSignHistoryItem, false);
			currentlySelectedSign = editedUnsavedSign.clone();
		}
	}

	public void selectEditedSignHistoryItem() {
		selectSignHistoryItem(editedSignHistoryItem, false);
	}

	private void selectSignHistoryItem(SignHistoryItem signHistoryItem, boolean setFocus) {
		assert signHistoryItem != null : "Precondition failed: signHistoryItem != null";
		assert signHistoryItemToWidget.containsKey(
				signHistoryItem) : "Precondition failed: signHistoryItemToWidget.containsKey(signHistoryItem)";

		deselectSignHistoryItems();
		previouslySelectedSignHistoryItem = selectedSignHistoryItem;
		if (previouslySelectedSignHistoryItem == null) {
			previouslySelectedSignHistoryItem = signHistoryItem;
		}
		selectedSignHistoryItem = signHistoryItem;
		signHistoryItemToWidget.get(selectedSignHistoryItem).setSelected(true, setFocus);

		listener.onSelectSignHistoryItemChanged(selectedSignHistoryItem);
	}

	private void deselectSignHistoryItems() {
		selectedSignHistoryItem = null;
		for (SignHistoryItemWidget signHistoryItemWidget : signHistoryItemToWidget.values()) {
			signHistoryItemWidget.setSelected(false, false);
		}
	}

	public SimpleSign getLatestEditedSign() {
		return editedUnsavedSign.clone();
	}

	public interface SignHistoryItemBrowserListener {
		void onSelectSignHistoryItemChanged(SignHistoryItem selectedSignHistoryItem);

		void onOpenLatestSign();

		void onOpenEditedSign();

		void onOpenSignHistoryItem(SignHistoryItem signHistoryItem);

		void onWidgetKeyDownEvent(KeyDownEvent event);
	}

	private final class SortButtonClickHandler implements ClickHandler {
		private final SortCriteria sortCriteria;

		public SortButtonClickHandler(SortCriteria sortCriteria) {
			assert sortCriteria != null : "Precondition failed: sortCriteria != null";

			this.sortCriteria = sortCriteria;
		}

		@Override
		public void onClick(ClickEvent event) {
			if (currentSortCriteria != sortCriteria) {
				currentSortCriteria = sortCriteria;
				isCurrentlyAscending = true;
			} else {
				isCurrentlyAscending = !isCurrentlyAscending;
			}
			sortAndShowFiles();
		}
	}

	protected enum SortCriteria {
		COMMENT, AUTHOR, CREATION_DATE;
	}

	public void resetSignHistroyItemBrowser() {

		setActive(false);
		this.lastSelectedIndex = -1;
		this.selectedSignHistoryItem = null;
		this.currentlySelectedSign = null;
		this.editedUnsavedSign = null;
		this.latestSavedSign = null;
		this.previouslySelectedSignHistoryItem = null;
		this.signHistoryItemToWidget = new HashMap<SignHistoryItem, SignHistoryItemWidget>();
		this.unusedSignHistoryItemWidgets = new ArrayList<SignHistoryItemWidget>();
		this.signHistoryItems = new ArrayList<SignHistoryItem>();
		this.sortedSignHistoryItems = new ArrayList<SignHistoryItem>();
	}
}
