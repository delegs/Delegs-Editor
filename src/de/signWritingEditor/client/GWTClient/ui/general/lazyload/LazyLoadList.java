package de.signWritingEditor.client.GWTClient.ui.general.lazyload;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.animation.UiUtil;

public class LazyLoadList extends LayoutComposite implements LazyLoadedRowContainer {

	private static class RowWrapper {

		private LazyLoadedRow row;

		private Object userObject;

		private LazyLoadStatus status;
		private int height;

		private Widget widget;

		public RowWrapper(int height, Widget widget, Object optionalUserObject) {
			assert height >= 0 : "Precondition failed: height >= 0";
			assert widget != null : "Precondition failed: widget != null";

			this.row = null;

			this.userObject = optionalUserObject;

			this.status = LazyLoadStatus.LOADED;
			this.height = height;

			this.widget = widget;
		}

		public RowWrapper(int expectedHeight, LazyLoadedRow row, Object optionalUserObject) {
			assert row != null : "Precondition failed: row != null";
			assert expectedHeight >= 0 : "Precondition failed: expectedHeight >= 0";

			this.row = row;

			this.userObject = optionalUserObject;

			this.status = LazyLoadStatus.LAZY;
			this.height = expectedHeight;

			this.widget = null;
		}

		public LazyLoadedRow getRow() {
			assert !LazyLoadStatus.LOADED
					.equals(getStatus()) : "Precondition failed: !LazyLoadStatus.LOADED.equals(getStatus())";
			assert row != null : "Postcondition failed: result != null";
			return row;
		}

		public Object getUserObject() {
			return userObject;
		}

		public LazyLoadStatus getStatus() {
			assert status != null : "Postcondition failed: result != null";
			return status;
		}

		public void setStatus(LazyLoadStatus status) {
			assert !LazyLoadStatus.LOADED.equals(status) : "Precondition failed: !LazyLoadStatus.LOADED.equals(status)";
			assert !LazyLoadStatus.LOADED
					.equals(getStatus()) : "Precondition failed: !LazyLoadStatus.LOADED.equals(getStatus())";
			this.status = status;
			assert getStatus().equals(status) : "Postcondition failed: getStatus().equals(status)";
		}

		public int getHeight() {
			int result = height;
			if (widget != null && widget.isAttached()) {
				result = widget.getOffsetHeight();
			}
			assert result >= 0 : "Postcondition failed: result >= 0";
			return result;
		}

		public Widget getWidget() {
			assert LazyLoadStatus.LOADED
					.equals(getStatus()) : "Precondition failed: LazyLoadStatus.LOADED.equals(getStatus())";
			return widget;
		}

		public void setWidget(Widget widget) {
			assert widget != null : "Precondition failed: widget != null";
			this.widget = widget;
			this.status = LazyLoadStatus.LOADED;
			assert LazyLoadStatus.LOADED
					.equals(getStatus()) : "Postcondition failed: LazyLoadStatus.LOADED.equals(getStatus())";
			assert getWidget() == widget : "Postcondition failed: getWidget() == widget";
		}
	}

	private List<RowWrapper> rowWrappers;

	private int dueFromPixel;
	private int dueToPixel;

	private int padding;
	private int spacing;

	private AbsolutePanel mainPanel;
	private Widget titleWidget;
	private ScrollPanel clientScrollPanel;
	private FlowPanel clientPanel;

	/**
	 * @param padding the space before first and after last row
	 * @param spacing the space between rows
	 * @param optionalListener
	 */
	public LazyLoadList(int padding, int spacing, Listener optionalListener) {
		super(optionalListener);

		assert padding >= 0 : "Precondition failed: padding >= 0";
		assert spacing >= 0 : "Precondition failed: spacing >= 0";

		rowWrappers = new ArrayList<LazyLoadList.RowWrapper>();

		dueFromPixel = -1;
		dueToPixel = -1;

		this.padding = padding;
		this.spacing = spacing;

		mainPanel = new AbsolutePanel();
		initWidget(mainPanel);

		titleWidget = null;

		clientPanel = new FlowPanel();
		clientPanel.addStyleName("clientPanel");
		clientScrollPanel = new ScrollPanel(clientPanel);
		clientScrollPanel.getElement().setId("clientScrollPanel");
		clientScrollPanel.addScrollHandler(new ScrollHandler() {
			@Override
			public void onScroll(ScrollEvent event) {
				int verticalScrollPosition = clientScrollPanel.getVerticalScrollPosition();
				lazyLoad(verticalScrollPosition, verticalScrollPosition + clientScrollPanel.getOffsetHeight());
			}
		});
		mainPanel.add(clientScrollPanel);
	}

	@Override
	public void setHeight(String height) {
		super.setHeight(height);
		this.clientScrollPanel.setHeight(height);
	}

	public int getPadding() {
		assert padding >= 0 : "Postcondition failed: padding >= 0";
		return padding;
	}

	public int getSpacing() {
		assert spacing >= 0 : "Postcondition failed: spacing >= 0";
		return spacing;
	}

	public Widget getTitleWidget() {
		return titleWidget;
	}

	public void setTitleWidget(Widget titleWidget) {
		if (this.titleWidget != null) {
			mainPanel.remove(this.titleWidget);
		}

		this.titleWidget = titleWidget;

		if (titleWidget != null) {
			mainPanel.add(titleWidget);
		}

		invalidateLayout();

		assert getTitleWidget() == titleWidget : "Postcondition failed: getTitleWidget() == titleWidget";
	}

	public void scrollAllUp() {
		clientScrollPanel.setVerticalScrollPosition(0);
	};

	public void addRow(int left, int height, Widget rowWidget) {
		addRow(left, height, rowWidget, null);
	}

	public void addRow(int left, int height, Widget rowWidget, Object optionalUserObject) {
		assert height >= 0 : "Precondition failed: height >= 0";
		assert rowWidget != null : "Precondition failed: rowWidget != null";

		clientPanel.add(rowWidget);

		rowWrappers.add(new RowWrapper(height, rowWidget, optionalUserObject));

		invalidateLayout();
	}

	public void addLazyLoadedRow(int expectedHeight, LazyLoadedRow lazyLoadedRow) {
		addLazyLoadedRow(expectedHeight, lazyLoadedRow, null);
	}

	public void addLazyLoadedRow(int expectedHeight, LazyLoadedRow lazyLoadedRow, Object optionalUserObject) {
		assert expectedHeight >= 0 : "Precondition failed: expectedHeight >= 0";
		assert lazyLoadedRow != null : "Precondition failed: lazyLoadedRow != null";
		rowWrappers.add(new RowWrapper(expectedHeight, lazyLoadedRow, optionalUserObject));
	}

	public void scrollTo(Object userObject) {
		assert userObject != null : "Precondition failed: userObject != null";
		int top = padding;

		lazyLoad(0, Integer.MAX_VALUE);
		for (RowWrapper rowWrapper : rowWrappers) {
			if (userObject.equals(rowWrapper.getUserObject())) {
				clientPanel.setHeight(top + "px");
				clientScrollPanel.setVerticalScrollPosition(top - (clientScrollPanel.getOffsetHeight() / 2));
				break;
			}
			top += rowWrapper.getHeight() + spacing;

		}
	}

	public void clearRows() {
		for (RowWrapper rowWrapper : rowWrappers) {
			if (rowWrapper.getStatus() == LazyLoadStatus.LOADED) {
				rowWrapper.getWidget().removeFromParent();
			}
		}
		rowWrappers.clear();
		scrollAllUp();
	}

	public void lazyLoadVisible() {
		int verticalScrollPosition = clientScrollPanel.getVerticalScrollPosition();
		lazyLoad(verticalScrollPosition, verticalScrollPosition + clientScrollPanel.getOffsetHeight());
	}

	public void lazyLoad(int fromPixel, int toPixel) {
		assert fromPixel >= 0 : "Precondition failed: fromPixel >= 0";
		assert fromPixel <= toPixel : "Precondition failed: fromPixel <= toPixel";

		if (fromPixel < toPixel) {
			boolean isDue = dueToPixel < 0;
			dueFromPixel = fromPixel;
			dueToPixel = toPixel;

			if (isDue) {
				doLazyLoad();
			}
		}
	}

	public int getLazyLoadHeight() {
		int result = padding;
		for (RowWrapper rowWrapper : rowWrappers) {
			result += rowWrapper.getHeight() + spacing;
		}
		if (rowWrappers.size() > 0) {
			result -= spacing;
		}
		result += padding;
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	@Override
	public int getRowCount() {
		int result = rowWrappers.size();
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	@Override
	public Object getUserObject(int rowIndex) {
		assert rowIndex >= 0 : "Precondition failed: rowIndex >= 0";
		assert rowIndex < getRowCount() : "Precondition failed: rowIndex < getRowCount()";
		return rowWrappers.get(rowIndex).getUserObject();
	}

	@Override
	public LazyLoadStatus getLazyLoadStatus(int rowIndex) {
		assert rowIndex >= 0 : "Precondition failed: rowIndex >= 0";
		assert rowIndex < getRowCount() : "Precondition failed: rowIndex < getRowCount()";
		LazyLoadStatus result = rowWrappers.get(rowIndex).getStatus();
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public void onLazyLoadSuccess(int rowIndex, int left, Widget rowWidget) {
		assert rowIndex >= 0 : "Precondition failed: rowIndex >= 0";
		assert rowIndex < getRowCount() : "Precondition failed: rowIndex < getRowCount()";
		assert rowWidget != null : "Precondition failed: rowWidget != null";
		assert LazyLoadStatus.DUE.equals(getLazyLoadStatus(
				rowIndex)) : "Precondition failed: LazyLoadStatus.DUE.equals(getLazyLoadStatus(rowIndex))";

		UiUtil.setOpacity(rowWidget, 0d, true);

		clientPanel.add(rowWidget);
		rowWrappers.get(rowIndex).setWidget(rowWidget);

		invalidateLayout();

		assert LazyLoadStatus.LOADED.equals(getLazyLoadStatus(
				rowIndex)) : "Postcondition failed: LazyLoadStatus.LOADED.equals(getLazyLoadStatus(rowIndex))";
	}

	@Override
	public void onLazyLoadFailure(int rowIndex) {
		assert rowIndex >= 0 : "Precondition failed: rowIndex >= 0";
		assert rowIndex < getRowCount() : "Precondition failed: rowIndex < getRowCount()";
		assert LazyLoadStatus.DUE.equals(getLazyLoadStatus(
				rowIndex)) : "Precondition failed: LazyLoadStatus.DUE.equals(getLazyLoadStatus(rowIndex))";

		rowWrappers.get(rowIndex).setStatus(LazyLoadStatus.LAZY);

		assert LazyLoadStatus.LAZY.equals(getLazyLoadStatus(
				rowIndex)) : "Postcondition failed: LazyLoadStatus.LAZY.equals(getLazyLoadStatus(rowIndex))";
	}

	// protected interface

	protected void doLazyLoad() {
		int top = padding;
		int fromRow = rowWrappers.size();
		int toRow = 0;
		while (top < dueToPixel && toRow < rowWrappers.size()) {
			RowWrapper rowWrapper = rowWrappers.get(toRow);

			top += rowWrapper.getHeight();
			if (fromRow > toRow && top >= dueFromPixel) {
				fromRow = toRow;
			}
			top += spacing;

			toRow++;
		}

		if (fromRow < toRow) {
			if (fromRow > 0) {
				fromRow--;
			}
			if (toRow < rowWrappers.size()) {
				toRow++;
			}
			for (int i = fromRow; i < toRow; i++) {
				RowWrapper rowWrapper = rowWrappers.get(i);
				if (LazyLoadStatus.LAZY.equals(rowWrapper.getStatus())) {
					rowWrapper.setStatus(LazyLoadStatus.DUE);
					rowWrapper.getRow().lazyLoad(i, rowWrapper.getUserObject(), this);
				}
			}
		}

		dueFromPixel = -1;
		dueToPixel = -1;
	}

	@Override
	protected void rearrangeWidgets() {
		int clientHeight = 0;
		if (titleWidget != null) {
			UiUtil.setPixelPos(titleWidget, 0, 0);
			UiUtil.setPixelWidth(titleWidget, mainPanel.getOffsetWidth());
			clientHeight = titleWidget.getOffsetHeight();
		}
		UiUtil.setPixelPos(clientScrollPanel, 0, clientHeight);
		UiUtil.setPixelHeight(clientScrollPanel, mainPanel.getOffsetHeight() - clientHeight);
		UiUtil.setPixelWidth(clientScrollPanel, mainPanel.getOffsetWidth());

		int top = padding;
		for (RowWrapper rowWrapper : rowWrappers) {
			if (LazyLoadStatus.LOADED.equals(rowWrapper.getStatus())) {
				UiUtil.setOpacity(rowWrapper.getWidget(), 1d, true);
			}
			top += rowWrapper.getHeight();
		}
		if (rowWrappers.size() > 0) {
			top -= spacing;
		}
		clientPanel.setHeight((top - spacing) + "px");
	}

}
