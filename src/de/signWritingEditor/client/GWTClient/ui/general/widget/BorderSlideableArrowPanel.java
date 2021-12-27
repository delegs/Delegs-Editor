package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.shared.model.domainValue.CardinalDirection;

public class BorderSlideableArrowPanel extends Composite {

	private static final int HEIGHT = 250;

	private final AbsolutePanel holderPanel;
	private AbsolutePanel contentPanel;

	private CardinalDirection slideDirection;

	private int startPosition;
	private int visibleBorder;
	private Image arrow;
	private boolean isOpen;
	private String title;
	private Label titleLabel;
	private SimplePanel headerPanel;
	private HorizontalPanel headerContentPanel;
	private BorderSlideableArrowPanelListener listener;

	private boolean isActive;

	private AbsolutePanel mainPanel;

	public BorderSlideableArrowPanel(AbsolutePanel holderPanel, String title, CardinalDirection slideDirection,
			BorderSlideableArrowPanelListener borderSlideableArrowPanelListener) {
		assert slideDirection != null : "Precondition failed: slideDirection != null";
		assert title != null : "Precondition failed: title != null";
		assert holderPanel != null : "Precondition failed: holderPanel != null";
		assert slideDirection == CardinalDirection.SOUTH : "Precondition failed: slideDirection == CardinalDirection.SOUTH";

		this.holderPanel = holderPanel;
		this.slideDirection = slideDirection;
		this.visibleBorder = Resources.RESOURCE.getToolBarIconLeft().getWidth() + 5;
		this.title = title;
		this.listener = borderSlideableArrowPanelListener;
		this.isActive = true;
		initiate();
	}

	@Override
	public Widget getParent() {
		
		return super.getParent();
	}

	public void setPosition(int lengthAtBorder, int startPosition) {
		this.startPosition = startPosition;
		if (slideDirection.equals(CardinalDirection.SOUTH)) {
			this.getElement().getStyle().setWidth(lengthAtBorder, Unit.PX);
			this.getElement().getStyle().setLeft(startPosition, Unit.PX);
		} else if (slideDirection.equals(CardinalDirection.NORTH)) {
			this.getElement().getStyle().setWidth(lengthAtBorder, Unit.PX);
			this.getElement().getStyle().setLeft(startPosition, Unit.PX);
		} else if (slideDirection.equals(CardinalDirection.EAST)) {
			this.getElement().getStyle().setHeight(lengthAtBorder, Unit.PX);
			this.getElement().getStyle().setTop(startPosition, Unit.PX);
		} else if (slideDirection.equals(CardinalDirection.WEST)) {
			this.getElement().getStyle().setHeight(lengthAtBorder, Unit.PX);
			this.getElement().getStyle().setTop(startPosition, Unit.PX);
		}
		this.getElement().getStyle().setPosition(Position.FIXED);
	}

	private void initiate() {
		mainPanel = new AbsolutePanel();
		this.initWidget(mainPanel);
		this.setStyleName("borderSlideableArrowPanel");
		this.getElement().getStyle().setPosition(Position.FIXED);

		holderPanel.add(this);

		arrow = new Image(Resources.RESOURCE.getToolBarIconRight());
		arrow.addStyleName("arrow");
		titleLabel = new Label(title);
		titleLabel.setStyleName("titleLabel");

		headerContentPanel = new HorizontalPanel();
		headerContentPanel.setHeight("27px");
		headerContentPanel.getElement().getStyle().setProperty("margin", "auto");
		headerContentPanel.add(arrow);
		headerContentPanel.add(titleLabel);

		headerPanel = new SimplePanel(headerContentPanel);
		headerPanel.setWidth("100%");

		mainPanel.add(headerPanel, 0, 0);
		headerPanel.sinkEvents(Event.ONCLICK);
		headerPanel.addStyleName("headerPanel");
		headerPanel.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (isOpen) {
					close();
				} else {
					open();
					listener.onOpen();
				}
			}
		}, ClickEvent.getType());

		contentPanel = new AbsolutePanel();
		contentPanel.setStyleName("borderSlideableArrowContentPanel");
		contentPanel.setWidth("100%");
		mainPanel.setHeight(HEIGHT + "px");
		mainPanel.add(contentPanel, 0, 28);

		setupBorderAlignment(slideDirection);
		close();
	}

	private void setupBorderAlignment(CardinalDirection direction) {
		toggleArrowState();

		if (direction == CardinalDirection.SOUTH) {
			this.addStyleName("topOrBottomBorderSlideableArrowPanel");
		}
	}

	private void toggleArrowState() {
		ImageResource arrowResource = null;

		if (slideDirection == CardinalDirection.NORTH) {
			arrowResource = isOpen ? Resources.RESOURCE.getToolBarIconUp() : Resources.RESOURCE.getToolBarIconDown();
		} else if (slideDirection == CardinalDirection.SOUTH) {
			arrowResource = isOpen ? Resources.RESOURCE.getToolBarIconDown() : Resources.RESOURCE.getToolBarIconUp();
		} else if (slideDirection == CardinalDirection.EAST) {
			arrowResource = isOpen ? Resources.RESOURCE.getToolBarIconRight() : Resources.RESOURCE.getToolBarIconLeft();
		} else if (slideDirection == CardinalDirection.WEST) {
			arrowResource = isOpen ? Resources.RESOURCE.getToolBarIconLeft() : Resources.RESOURCE.getToolBarIconRight();
		}

		arrow.setResource(arrowResource);
	}

	public void resize() {
		if (isOpen) {
			open();
		} else {
			close();
		}
	}

	public void close() {
		if (isActive) {
			isOpen = false;
			toggleArrowState();
			if (slideDirection == CardinalDirection.SOUTH) {
				this.getElement().getStyle().setBottom(visibleBorder - HEIGHT, Unit.PX);
				this.getElement().getStyle().setLeft(startPosition, Unit.PX);
				this.getElement().getStyle().setPosition(Position.FIXED);
			}
		}
	}

	public void setActive(boolean active) {
		isActive = active;
		if (!isActive) {
			mainPanel.getElement().getStyle().setDisplay(Display.NONE);
		} else {
			mainPanel.getElement().getStyle().setDisplay(Display.BLOCK);
		}
	}

	public void open() {
		if (isActive) {
			isOpen = true;
			toggleArrowState();
			if (slideDirection == CardinalDirection.SOUTH) {
				this.getElement().getStyle().setBottom(0, Unit.PX);
				this.getElement().getStyle().setLeft(startPosition, Unit.PX);
				this.getElement().getStyle().setPosition(Position.FIXED);
			}
		}
	}

	public void addContent(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";
		contentPanel.add(widget);
	}

	public interface BorderSlideableArrowPanelListener {
		void onOpen();
	}
}
