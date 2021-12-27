package de.signWritingEditor.client.model.layout;

import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.model.domainValue.Orientation;

public class TestOverflowListLayout extends OverflowListLayout {

	public TestOverflowListLayout(Orientation orientation, int overflowThreshold) {
		super(orientation, overflowThreshold);
	}

	@Override
	public int getMarginTop_PX() {
		
		return 0;
	}

	@Override
	public int getMarginBottom_PX() {
		
		return 0;
	}

}
