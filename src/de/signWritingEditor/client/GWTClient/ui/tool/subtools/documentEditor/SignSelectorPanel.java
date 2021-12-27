package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ChangeAlternativeToolTip.ChangeAlternativeToolTipListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ChangeAlternativeToolTip.ChangeAlternativeToolTipListenerMobile;
import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class SignSelectorPanel extends Composite {

	private static final int DOUBLE_CLICK_TIME_MS = 250;

	public static interface SignSelectorLoadHandler {
		public void onLoad();
	};

	private static final int TOOLTIP_SHOW_TIME = 1000;

	// Different values for desktop and mobile implementations
	private int toolTipTop;
	private int toolTipLeft;

	private AbsolutePanel contentPanel;

	private List<SignItem> signItems;

	private int selectedSignIndex;

	private Set<SignSelectorPanelListener> signSelectorPanelListeners = new HashSet<SignSelectorPanelListener>();

	private Timer hideToolTipTimer;

	private Timer singleClickTimer;

	private Id tokenId;

	private SignDataEncoder signDataEncoder;

	private boolean toolTipPanelMobile = false;

	private boolean turnProgressIndicatorOn = false;

	private SimplePanel notFoundFrame;

	private ChangeAlternativeToolTip changeAlternativeToolTip;

	private ChangeAlternativeToolTipListener alternativeChangedListener;

	private SimplePanel selectionMarkupPanel;

	private Image signImage;

	private boolean isSelected;

	public void init(Id tokenId, SignDataEncoder signDataEncoder, ChangeAlternativeToolTip changeAlternativeToolTip) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		this.tokenId = tokenId;
		this.changeAlternativeToolTip = changeAlternativeToolTip;

		this.signDataEncoder = signDataEncoder;

		setToolTipTop(60);
		setToolTipLeft(-67);

		contentPanel = new AbsolutePanel();
		contentPanel.ensureDebugId("signSelectorPanel");
		// the overlay can be slighlty outside of the panel
		contentPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		initWidget(contentPanel);

		selectionMarkupPanel = new SimplePanel();
		selectionMarkupPanel.setStyleName("selectionMarkupStyle");
		selectionMarkupPanel.getElement().getStyle().setZIndex(2);
		selectionMarkupPanel.setVisible(false);
		this.contentPanel.add(selectionMarkupPanel, 0, 0);
		setStyleName("signSelectorPanel");

		hideToolTipTimer = new Timer() {
			@Override
			public void run() {
				hideToolTipPanel();
			}
		};

		if (getToolTipPanelMobile()) {
			alternativeChangedListener = new ChangeAlternativeToolTipListenerMobile() {

				@Override
				public void onSelectNextSign() {
					SignSelectorPanel.this.onSelectNextSign();
				}

				@Override
				public void onSelectPreviousSign() {
					SignSelectorPanel.this.onSelectPreviousSign();
				}

				@Override
				public void handleDoubleClick() {
					SignSelectorPanel.this.handleDoubleClick();
				}

			};
		} else {
			alternativeChangedListener = new ChangeAlternativeToolTipListener() {

				@Override
				public void onSelectPreviousSign() {
					SignSelectorPanel.this.onSelectPreviousSign();
				}

				@Override
				public void onSelectNextSign() {
					SignSelectorPanel.this.onSelectNextSign();
				}
			};

		}
		hideToolTipPanel();

		addHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (singleClickTimer.isRunning()) {
					singleClickTimer.cancel();
				}
				handleDoubleClick();
			}
		}, DoubleClickEvent.getType());
		sinkEvents(Event.ONDBLCLICK);

		addHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				final boolean isShiftPressed = event.isShiftKeyDown();
				singleClickTimer = new Timer() {
					@Override
					public void run() {
						handleSingleClick(isShiftPressed);
					}
				};
				singleClickTimer.schedule(DOUBLE_CLICK_TIME_MS);
			}
		}, ClickEvent.getType());
		sinkEvents(Event.ONCLICK);

		addHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if (hasAlternativeSigns()) {
					showToolTipPanel();
				}
			}
		}, MouseOverEvent.getType());
		sinkEvents(Event.ONMOUSEOVER);

		addHandler(new MouseWheelHandler() {

			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				if (event.isShiftKeyDown()) {
					if (hasAlternativeSigns()) {
						onMouseWheelChange(event.isNorth());
						event.preventDefault();
					}
				}
			}
		}, MouseWheelEvent.getType());
		sinkEvents(Event.ONMOUSEWHEEL);

		addHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				hideToolTipPanel();
			}
		}, MouseOutEvent.getType());
		sinkEvents(Event.ONMOUSEOUT);

		setSignItems(new ArrayList<SignItem>());
		selectSign(-1);
	}

	public void showToolTipPanelBriefly() {
		assert hasAlternativeSigns() : "Precondition failed: hasAlternativeSigns()";

		showToolTipPanel();
		hideToolTipTimer.schedule(TOOLTIP_SHOW_TIME);
	}

	public SignItem getSelectedSign() {
		return signItems.get(selectedSignIndex);
	}

	public int getSelectedSignIndex() {
		return selectedSignIndex;
	}

	public void setSignItems(List<SignItem> signItems) {
		assert signItems != null : "signItems != null";

		this.signItems = signItems;
	}

	public void setTokenId(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		this.tokenId = tokenId;
	}

	public List<SignItem> getSignItems() {
		return signItems;
	}

	protected Timer getHideToolTipTimer() {
		return hideToolTipTimer;
	}

	protected ChangeAlternativeToolTip getToolTipPanel() {
		return changeAlternativeToolTip;
	}

	protected void setToolTipTop(int toolTipTop) {
		this.toolTipTop = toolTipTop;
	}

	protected void setToolTipLeft(int toolTipLeft) {
		this.toolTipLeft = toolTipLeft;
	}

	protected boolean getToolTipPanelMobile() {
		return toolTipPanelMobile;
	}

	protected void setToolTipPanelMobile(boolean toolTipPanelMobile) {
		this.toolTipPanelMobile = toolTipPanelMobile;
	}

	public void selectSign(int index) {
		assert index >= -1 : "index >= -1";
		assert index < signItems.size() : "index[" + index + "] < signItems.size()[" + signItems.size() + "]";

		selectedSignIndex = index;
		if (signImage != null) {
			contentPanel.remove(signImage);
		}

		if (index > -1) {
			SignItem signItem = signItems.get(index);
			this.setSignLoadingProgressIndicatorVisible(true);
			signImage = new Image(getSignImageUrl(signItem));
			signImage.addLoadHandler(new LoadHandler() {

				@Override
				public void onLoad(LoadEvent event) {
					SignSelectorPanel.this.setSignLoadingProgressIndicatorVisible(false);
					removeNotFoundFrame();
				}
			});
			signImage.setWidth(signItem.getSignWidth() + "px");
			signImage.ensureDebugId("signImage");
			contentPanel.add(signImage);
			changeAlternativeToolTip.updateSelectedIndex(index);
		}
		contentPanel.ensureDebugId("signSelectorPanel-loaded");
	}

	protected void setNotFoundFrame() {
		if (notFoundFrame == null) {
			notFoundFrame = new SimplePanel();
			notFoundFrame.setStyleName("notFoundFrame");
			contentPanel.add(notFoundFrame);
			hideToolTipPanel();
			this.setSignLoadingProgressIndicatorVisible(false);
		}
	}

	protected void removeNotFoundFrame() {
		if (notFoundFrame != null) {
			contentPanel.remove(notFoundFrame);
			notFoundFrame = null;
		}
	}

	public void showNotFoundFrame(boolean show) {
		notFoundFrame.setVisible(show);
		if (!show) {
			hideToolTipPanel();
			this.setSignLoadingProgressIndicatorVisible(false);
		}
	}

	private void setSignLoadingProgressIndicatorVisible(boolean visible) {
		turnProgressIndicatorOn = visible;
		if (visible) {
			Timer timer = new Timer() {
				@Override
				public void run() {
					setLastStyleName();
				}
			};

			timer.schedule(500);
		} else {
			this.contentPanel.removeStyleName("progressIndicator");
		}
	}

	public void addSignSelectorPanelListener(SignSelectorPanelListener signSelectorPanelListener) {
		assert signSelectorPanelListener != null : "Precondition failed: signSelectorPanelListener != null";

		this.signSelectorPanelListeners.add(signSelectorPanelListener);
	}

	private void setLastStyleName() {
		if (turnProgressIndicatorOn) {
			SignSelectorPanel.this.contentPanel.addStyleName("progressIndicator");
		}
	}

	public boolean hasAlternativeSigns() {
		return signItems.size() > 1;
	}

	/**
	 * Selects the next sign
	 * 
	 * @require hasAlternativeSigns()
	 */
	public void onSelectNextSign() {
		assert hasAlternativeSigns() : "hasAlternativeSigns()";

		int newSelectedSignIndex = (selectedSignIndex + 1) % signItems.size();

		fireSignAlternativeChanged(signItems.get(newSelectedSignIndex), newSelectedSignIndex);
	}

	/**
	 * Selects the previous sign
	 * 
	 * @require hasAlternativeSigns()
	 */
	public void onSelectPreviousSign() {
		assert hasAlternativeSigns() : "hasAlternativeSigns()";
		int newSelectedSignIndex = selectedSignIndex - 1;

		if (newSelectedSignIndex < 0) {
			newSelectedSignIndex = signItems.size() - 1;
		}

		fireSignAlternativeChanged(signItems.get(newSelectedSignIndex), newSelectedSignIndex);
	}

	public void hideToolTipPanel() {
		changeAlternativeToolTip.hide();
	}

	private String getSignImageUrl(SignItem signItem) {
		assert signItem != null : "Precondition failed: signItem != null";

		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append("signwritingeditor/signimages");

		if (signItem.hasLocalSign()) {
			SimpleSign sign = signItem.getLocalSign();
			String signDataCode = signDataEncoder.encodePositionedSymbols(sign.getPlainSymbols());

			resultBuilder.append("?signdata=");
			resultBuilder.append(signDataCode);
		} else {
			SignId signId = signItem.getSignId();

			resultBuilder.append("?upperId=");
			resultBuilder.append(signId.getUpperIdPart());

			resultBuilder.append("&lowerId=");
			resultBuilder.append(URL.encodePathSegment(signId.getLowerIdPart()));

			resultBuilder.append("&signlocale=");
			resultBuilder.append(signId.getSignLocale().name());

			resultBuilder.append("&timestamp=");
			resultBuilder.append(System.currentTimeMillis());

			resultBuilder.append("&source=");
			resultBuilder.append(signId.getSignSource().name());
		}
		resultBuilder.append("&transparent=true");
		resultBuilder.append("&scale=2");

		String result = resultBuilder.toString();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	protected void showToolTipPanel() {
		assert hasAlternativeSigns() : "Precondition failed: hasAlternativeSigns()";

		int alternativeTooltipPanelTop = getAbsoluteTop() + toolTipTop;
		int alternativeTooltipPanelLeft = getAbsoluteLeft() + toolTipLeft;

		changeAlternativeToolTip.show(alternativeChangedListener, alternativeTooltipPanelLeft,
				alternativeTooltipPanelTop, selectedSignIndex, signItems.size());
	}

	private void fireSignAlternativeChanged(SignItem newSelectedSignItem, int newSelectedSignIndex) {
		for (SignSelectorPanelListener listener : signSelectorPanelListeners) {
			listener.onSignAlternativeChanged(tokenId, newSelectedSignItem, newSelectedSignIndex);
		}
	}

	protected void handleDoubleClick() {
		if (hasSelectedSign()) {
			for (SignSelectorPanelListener listener : signSelectorPanelListeners) {
				listener.onEditSign(getSelectedSign(), tokenId);
			}
		} else {
			for (SignSelectorPanelListener listener : signSelectorPanelListeners) {
				listener.onEditSign(SignItem.emptySignItem, tokenId);
			}
		}
	}

	protected void handleSingleClick(boolean isShiftPressed) {
		for (SignSelectorPanelListener signSelectorPanelListener : signSelectorPanelListeners) {
			signSelectorPanelListener.onSelectSearchWord(tokenId, isShiftPressed);
		}
	}

	private boolean hasSelectedSign() {
		return selectedSignIndex >= 0 && !signItems.isEmpty();
	}

	public interface SignSelectorPanelListener {
		void onSignAlternativeChanged(Id tokenId, SignItem signItem, int selectedSignIndex);

		void onEditSign(SignItem signItem, Id tokenId);

		void onSelectSearchWord(Id tokenId, boolean isShiftPressed);
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelection(boolean select) {
		isSelected = select;
		selectionMarkupPanel.setVisible(select);
	}

	public void onMouseWheelChange(boolean up) {
		this.changeAlternativeToolTip.changeByMouseWheel(up);
	}
}
