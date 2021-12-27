package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowAlignment;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowDirection;

public class ChangeAlternativeToolTip extends Composite {

	private static final int DEFAULT_FONT_SIZE = 10;

	private static final String DEFAULT_FONT_COLOR = "#777777";

	private static final int DEFAULT_ALTERNATIVE_LABEL_WIDTH = 40;

	private static final String COLOR_WHITE = "#FFF";

	private Label numberLabel;
	private int selectedAlternative;
	private int numberOfAlternatives;

	private ChangeAlternativeToolTipListener listener;

	private boolean mobile;

	public ChangeAlternativeToolTip(boolean mobile) {
		this.mobile = mobile;
		ArrowPanel toolTipPanel = new ArrowPanel(ArrowDirection.RIGHT, ArrowAlignment.ALIGN_CENTER);
		toolTipPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
		initWidget(toolTipPanel);

		FlowPanel toolTipAlternativePanel = new FlowPanel();
		toolTipAlternativePanel.getElement().setAttribute("align", "center");
		toolTipAlternativePanel.setWidth(DEFAULT_ALTERNATIVE_LABEL_WIDTH + "px");
		toolTipAlternativePanel.getElement().getStyle().setBackgroundColor(COLOR_WHITE);

		toolTipPanel.add(toolTipAlternativePanel);
		toolTipPanel.addHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		}, DoubleClickEvent.getType());
		toolTipPanel.sinkEvents(Event.ONDBLCLICK);

		Image upArrow = new Image(RESOURCE.getToolTipButtonUp());
		upArrow.setStyleName("signAlternativeButton");
		upArrow.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onSelectNextSign();
			}
		});

		upArrow.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		});

		upArrow.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		});

		toolTipAlternativePanel.add(upArrow);

		// add Signedit Button for mobile devices, since double tap has native functionality
		if (mobile) {
			Image editButton = new Image(RESOURCE.getSignEditButton());
			editButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					handleDoubleClick();
				}
			});

			editButton.addMouseDownHandler(new MouseDownHandler() {

				@Override
				public void onMouseDown(MouseDownEvent event) {
					event.stopPropagation();
					event.preventDefault();
				}
			});

			editButton.addDoubleClickHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					event.stopPropagation();
					event.preventDefault();
				}
			});

			editButton.setStyleName("signEditButton");
			toolTipAlternativePanel.add(editButton);
		}

		numberLabel = new Label();
		numberLabel.setStyleName("numberLabel");
		numberLabel.getElement().getStyle().setColor(DEFAULT_FONT_COLOR);
		numberLabel.getElement().getStyle().setFontSize(DEFAULT_FONT_SIZE, Unit.PX);
		toolTipAlternativePanel.add(numberLabel);

		Image downArrow = new Image(RESOURCE.getToolTipButtonDown());
		downArrow.setStyleName("signAlternativeButton");
		downArrow.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onSelectPreviousSign();
			}
		});

		downArrow.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		});

		downArrow.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		});

		toolTipAlternativePanel.add(downArrow);

		toolTipPanel.addHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				setVisible(true);
				event.stopPropagation();
			}
		}, MouseOverEvent.getType());
		toolTipPanel.sinkEvents(Event.ONMOUSEOVER);

		toolTipPanel.addHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				event.stopPropagation();
				setVisible(false);
			}
		}, MouseOutEvent.getType());
		toolTipPanel.sinkEvents(Event.ONMOUSEOUT);
	}

	public void show(ChangeAlternativeToolTipListener listener, int positionX, int positionY, int selectedAlternative,
			int allAlternatives) {
		assert listener != null : "Precondition failed listerner != null";
		this.listener = listener;
		setPosition(positionX, positionY);
		setAlternativeValues(selectedAlternative, allAlternatives);
		this.setVisible(true);
	}

	private void setAlternativeValues(int selectedAlternative, int allAlternatives) {
		this.numberOfAlternatives = allAlternatives;
		this.selectedAlternative = selectedAlternative + 1;
		updateNumberLabel();
	}

	private void updateNumberLabel() {
		numberLabel.setText(this.selectedAlternative + "/" + numberOfAlternatives);
	}

	private void setPosition(int positionX, int positionY) {
		this.getElement().getStyle().setLeft(positionX, Unit.PX);
		this.getElement().getStyle().setTop(positionY, Unit.PX);
	}

	public void hide() {
		this.setVisible(false);
	}

	// Only for mobile
	private void handleDoubleClick() {
		assert listener != null : "Precondition failed listerner != null";
		if (mobile) {
			assert listener instanceof ChangeAlternativeToolTipListenerMobile : "Precondition failed listener instanceof AlternativeChangedListenerMobile";
			((ChangeAlternativeToolTipListenerMobile) listener).handleDoubleClick();
		}
	}

	private void onSelectPreviousSign() {
		assert listener != null : "Precondition failed listerner != null";
		listener.onSelectPreviousSign();
	}

	private void onSelectNextSign() {
		assert listener != null : "Precondition failed listerner != null";
		listener.onSelectNextSign();
	}

	public interface ChangeAlternativeToolTipListener {
		void onSelectNextSign();

		void onSelectPreviousSign();
	}

	public interface ChangeAlternativeToolTipListenerMobile extends ChangeAlternativeToolTipListener {
		void handleDoubleClick();
	}

	public void updateSelectedIndex(int index) {
		selectedAlternative = index + 1;
		updateNumberLabel();
	}

	public void changeByMouseWheel(boolean up) {

		if (up) {
			this.onSelectNextSign();
		} else {
			this.onSelectPreviousSign();
		}

	}
}
