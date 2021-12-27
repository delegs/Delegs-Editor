package de.signWritingEditor.client.model.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import de.signWritingEditor.shared.layout.ContinuousPageLayout;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class PageLayoutTest {

	@Test
	public void testAll() {
		// horizontal orientation

		PageFormat pageDimensionH = new PageFormat("test", Orientation.HORIZONTAL, 120d, 100, 200, 0, 0, 0, 0);
		ContinuousPageLayout pageLayoutH = new ContinuousPageLayout(pageDimensionH);
		assertSame(pageDimensionH, pageLayoutH.getPageDimension());
		assertEquals(Orientation.HORIZONTAL, pageLayoutH.getOrientation());
		assertEquals(100, pageLayoutH.getMaxWidth());
		assertEquals(200, pageLayoutH.getMaxHeight());

		pageLayoutH.setMaxSize(300, 400);
		assertEquals(300, pageLayoutH.getMaxWidth());
		assertEquals(400, pageLayoutH.getMaxHeight());

		pageLayoutH.insertNewLine(0);
		pageLayoutH.insertNewLine(1);
		pageLayoutH.insertNewLine(2);

		assertEquals(3, pageLayoutH.getLineCount());
		assertEquals(400, pageLayoutH.getLine(0).getOverflowThreshold());
		assertEquals(400, pageLayoutH.getLine(1).getOverflowThreshold());
		assertEquals(400, pageLayoutH.getLine(2).getOverflowThreshold());

		pageLayoutH.setMaxSize(500, 600);
		assertEquals(500, pageLayoutH.getMaxWidth());
		assertEquals(600, pageLayoutH.getMaxHeight());
		assertEquals(600, pageLayoutH.getLine(0).getOverflowThreshold());
		assertEquals(600, pageLayoutH.getLine(1).getOverflowThreshold());
		assertEquals(600, pageLayoutH.getLine(2).getOverflowThreshold());

		// vertical orientation

		PageFormat pageDimensionV = new PageFormat("test", Orientation.VERTICAL, 120d, 100, 200, 0, 0, 0, 0);
		ContinuousPageLayout pageLayoutV = new ContinuousPageLayout(pageDimensionV);
		assertSame(pageDimensionV, pageLayoutV.getPageDimension());
		assertEquals(Orientation.VERTICAL, pageLayoutV.getOrientation());
		assertEquals(100, pageLayoutV.getMaxWidth());
		assertEquals(200, pageLayoutV.getMaxHeight());

		pageLayoutV.setMaxSize(300, 400);
		assertEquals(300, pageLayoutV.getMaxWidth());
		assertEquals(400, pageLayoutV.getMaxHeight());

		pageLayoutV.insertNewLine(0);
		pageLayoutV.insertNewLine(1);
		pageLayoutV.insertNewLine(2);

		assertEquals(3, pageLayoutV.getLineCount());
		assertEquals(300, pageLayoutV.getLine(0).getOverflowThreshold());
		assertEquals(300, pageLayoutV.getLine(1).getOverflowThreshold());
		assertEquals(300, pageLayoutV.getLine(2).getOverflowThreshold());

		pageLayoutV.setMaxSize(500, 600);
		assertEquals(500, pageLayoutV.getMaxWidth());
		assertEquals(600, pageLayoutV.getMaxHeight());
		assertEquals(500, pageLayoutV.getLine(0).getOverflowThreshold());
		assertEquals(500, pageLayoutV.getLine(1).getOverflowThreshold());
		assertEquals(500, pageLayoutV.getLine(2).getOverflowThreshold());
	}

}
