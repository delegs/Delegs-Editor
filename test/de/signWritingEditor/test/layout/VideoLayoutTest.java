package de.signWritingEditor.test.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.VideoTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class VideoLayoutTest extends LayoutTestCase {

	private TokenFactory tokenFactory;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		tokenFactory = new TokenFactory(getIdFactory());
		getDocumentLayouter().clear();
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
	}

	@Test
	public void testVideoTokenBoxSize() {
		Token videoToken = tokenFactory.createVideoToken();
		getDocumentLayouter().addToken(videoToken, true, true);

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		Box box = getDocumentLayouter().getBox(new BoxIndex(0, 0, 0));
		assertTrue("box is not a VideoTokenBox", box instanceof VideoTokenBox);
		VideoTokenBox videoTokenBox = (VideoTokenBox) box;

		assertEquals(225, videoTokenBox.getWidth_PX(), 0);
		assertEquals(5, videoTokenBox.getMarginRight_PX());
		assertEquals(207, videoTokenBox.getHeight_PX());
	}

}
