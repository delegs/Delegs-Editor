package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ArrowPanel extends Composite {
	private DecoratorPanel contentPanel;

	public ArrowPanel(ArrowDirection arrowDirection, ArrowAlignment arrowAlignment) {
		boolean directedHorizontally = arrowDirection.equals(ArrowDirection.RIGHT)
				|| arrowDirection.equals(ArrowDirection.LEFT);

		CellPanel mainPanel = directedHorizontally ? new HorizontalPanel() : new VerticalPanel();
		mainPanel.setStyleName("arrowPanel");
		initWidget(mainPanel);

		contentPanel = new DecoratorPanel();
		mainPanel.add(contentPanel);

		SimplePanel arrowPanel = new SimplePanel();
		arrowPanel.setStyleName("arrow");
		arrowPanel.addStyleName(arrowDirection.getStyleName());

		int arrowIndex = arrowDirection.equals(ArrowDirection.UP) || arrowDirection.equals(ArrowDirection.LEFT) ? 0 : 1;
		// It's either a HorizontalPanel or a VerticalPanel so just cast it
		((InsertPanel) mainPanel).insert(arrowPanel, arrowIndex);

		alignArrowPanel(mainPanel, arrowPanel, arrowDirection, arrowAlignment);
	}

	public void add(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";

		contentPanel.add(widget);
	}

	public void remove(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";

		contentPanel.remove(widget);
	}

	private void alignArrowPanel(CellPanel mainPanel, Panel arrowPanel, ArrowDirection arrowDirection,
			ArrowAlignment alignment) {
		if (alignment == ArrowAlignment.ALIGN_LEFT) {
			mainPanel.setCellHorizontalAlignment(arrowPanel, HasAlignment.ALIGN_LEFT);
		} else if (alignment == ArrowAlignment.ALIGN_CENTER) {
			mainPanel.setCellHorizontalAlignment(arrowPanel, HasAlignment.ALIGN_CENTER);
		} else if (alignment == ArrowAlignment.ALIGN_RIGHT) {
			mainPanel.setCellHorizontalAlignment(arrowPanel, HasAlignment.ALIGN_RIGHT);
		}
		if (arrowDirection == ArrowDirection.LEFT) {
			if (alignment == ArrowAlignment.ALIGN_LEFT) {
				mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_BOTTOM);
			} else if (alignment == ArrowAlignment.ALIGN_CENTER) {
				mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_MIDDLE);
			} else if (alignment == ArrowAlignment.ALIGN_RIGHT) {
				mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_TOP);
			}
		} else if (arrowDirection == ArrowDirection.RIGHT) {
			if (alignment == ArrowAlignment.ALIGN_LEFT) {
				mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_TOP);
			} else if (alignment == ArrowAlignment.ALIGN_CENTER) {
				mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_MIDDLE);
			} else if (alignment == ArrowAlignment.ALIGN_RIGHT) {
				mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_BOTTOM);
			}
		} else {
			mainPanel.setCellVerticalAlignment(arrowPanel, HasAlignment.ALIGN_MIDDLE);
		}
	}

	public enum ArrowDirection {
		UP("up"), DOWN("down"), LEFT("left"), RIGHT("right");

		private String styleName;

		ArrowDirection(String styleName) {
			assert styleName != null : "Precondition failed: styleName != null";
			assert !styleName.isEmpty() : "Precondition failed: !styleName.isEmpty()";

			this.styleName = styleName;
		}

		public String getStyleName() {
			assert styleName != null : "Postcondition failed: result != null";
			assert !styleName.isEmpty() : "Postcondition failed: !result.isEmpty()";
			return styleName;
		}
	}

	public enum ArrowAlignment {
		ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT;
	}
}
