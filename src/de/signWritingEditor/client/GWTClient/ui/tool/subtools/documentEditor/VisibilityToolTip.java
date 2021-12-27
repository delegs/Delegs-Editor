package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowAlignment;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowDirection;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.VisibilityToolTipListener;
import de.signWritingEditor.shared.model.material.TokenBox;

public class VisibilityToolTip extends Composite {
	private static final String HIDE_BUTTON_CAPTION = "\u2013";
	private static final String SHOW_BUTTON_CAPTION = "+";

	// Different values for desktop and mobile implementations
	private int defaultSignVisibilityToolTipOffset;

	private Button visibilityButton;
	private VisiblityToolTipButtonListener visibilityToolTipButtonListener;

	/**
	 * To determine what the visibility button is doing when clicked
	 */
	private boolean resultingVisibilityOnClick;

	public VisibilityToolTip(boolean resultingVisibilityOnClick, int wrapperSize) {
		SimplePanel wrapperPanel = new SimplePanel() {
			@Override
			public void onBrowserEvent(Event event) {
				super.onBrowserEvent(event);

				switch (event.getTypeInt()) {
				case Event.ONMOUSEOVER:
					setVisibleCustom(true);
					break;
				case Event.ONMOUSEOUT:
					setVisibleCustom(false);
					break;
				}
			}
		};
		wrapperPanel.sinkEvents(Event.ONMOUSEOVER);
		wrapperPanel.sinkEvents(Event.ONMOUSEOUT);
		wrapperPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		wrapperPanel.setWidth(wrapperSize + "px");

		ArrowPanel toolTipPanel = new ArrowPanel(ArrowDirection.RIGHT, ArrowAlignment.ALIGN_CENTER);
		wrapperPanel.add(toolTipPanel);

		visibilityButton = new Button();
		visibilityButton.setWidth("30px");
		toolTipPanel.add(visibilityButton);

		visibilityButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleVisiblityButtonClicked();
			}
		});

		visibilityButton.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		});
		setResultingVisibilityOnClick(resultingVisibilityOnClick);

		initWidget(wrapperPanel);
	}

	public void setDefaultSignVisibilityToolTipOffset(int defaultSignVisibilityToolTipOffset) {
		this.defaultSignVisibilityToolTipOffset = defaultSignVisibilityToolTipOffset;
	}

	public int getDefaultSignVisibilityToolTipOffset() {
		return this.defaultSignVisibilityToolTipOffset;
	}

	private void handleVisiblityButtonClicked() {
		if (visibilityButton != null) {
			visibilityToolTipButtonListener.onVisibilityButtonClicked(resultingVisibilityOnClick);
		}
	}

	private void setVisibilityButtonCaption(boolean resultingVisibilityOnClick) {
		visibilityButton.setText(resultingVisibilityOnClick ? SHOW_BUTTON_CAPTION : HIDE_BUTTON_CAPTION);
	}

	public void setVisibilityToolTipListener(VisiblityToolTipButtonListener visibilityToolTipListener) {
		assert visibilityToolTipListener != null : "Precondition failed: visibilityToolTipListener != null";

		this.visibilityToolTipButtonListener = visibilityToolTipListener;
	}

	public void setResultingVisibilityOnClick(boolean resultingVisibilityOnClick) {
		this.resultingVisibilityOnClick = resultingVisibilityOnClick;
		setVisibilityButtonCaption(resultingVisibilityOnClick);
	}

	public void setVisibleCustom(boolean visible) {
		if (visible) {
			getElement().getStyle().setVisibility(Visibility.VISIBLE);
		} else {
			getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
	}

	public void showVisiblityToolTip(AbstractTokenBoxWidget tokenBoxWidget, int offset,
			boolean resultingVisibilityOnClick, final VisibilityToolTipListener listener) {
		assert tokenBoxWidget != null : "Precondition failed: tokenBoxWidget != null";

		final TokenBox tokenBox = tokenBoxWidget.getTokenBox();

		if (!tokenBox.isLockedLayout()) {
			int toolTipPosLeft = tokenBoxWidget.getAbsoluteLeft() - getOffsetWidth();
			int toolTipPosTop = tokenBoxWidget.getAbsoluteTop() + tokenBoxWidget.getOffsetHeight() - getOffsetHeight()
					+ offset;
			RootPanel.get().setWidgetPosition(this, toolTipPosLeft, toolTipPosTop);

			setVisibleCustom(true);

			setResultingVisibilityOnClick(resultingVisibilityOnClick);
			setVisibilityToolTipListener(new VisiblityToolTipButtonListener() {
				@Override
				public void onVisibilityButtonClicked(boolean visible) {
					listener.onVisibilityChanged(tokenBox.getId(), visible);
					setResultingVisibilityOnClick(!visible);
				}
			});
		}
	}
}
