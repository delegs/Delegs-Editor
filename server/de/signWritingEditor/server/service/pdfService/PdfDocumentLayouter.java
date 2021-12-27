package de.signWritingEditor.server.service.pdfService;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.DocumentLayout;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.layout.VideoTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;

public class PdfDocumentLayouter extends DocumentLayout {

	private final FontSizeService fontSizeService;

	public PdfDocumentLayouter(Document document, TokenBoxFactory tokenBoxFactory, FontSizeService fontSizeService) {
		this.fontSizeService = fontSizeService;
		boolean isCollage = false;
		if (!document.isEmpty()) {
			PageFormat pageFormat = document.getPageFormat();
			tokenBoxFactory.setPageHeight(pageFormat.getPixelInnerHeight());

			for (int sectionIndex = document.getSectionCount() - 1; sectionIndex >= 0; sectionIndex--) {
				isCollage = document.getSection(sectionIndex).isCollage();
				insertNewPage(pageFormat, 0, isCollage, document.getSection(sectionIndex).getCollageId(),
						document.showCollageGrid());

				for (int paragraphIndex = document.getParagraphCount(sectionIndex)
						- 1; paragraphIndex >= 0; paragraphIndex--) {
					Paragraph paragraph = document.getParagraph(sectionIndex, paragraphIndex);

					LineIndex lineIndexObject;
					if (isCollage) {
						lineIndexObject = new LineIndex(0, 0, 0);
						insertSnippet(0, 0, paragraph.getPositionX(), paragraph.getPositionY(), paragraph.getZIndex(),
								paragraph.getWidth());
					} else {
						lineIndexObject = new LineIndex(0, 0);
						insertNewLine(lineIndexObject);
					}

					loadTokens(document, tokenBoxFactory, sectionIndex, paragraphIndex, isCollage, paragraph,
							getLine(lineIndexObject).getInnerWidth_PX());

					compensate(lineIndexObject);
				}
			}

			for (int pageIndex = 0; pageIndex < this.getPageCount(); pageIndex++) {
				if (isCollage(pageIndex)) {
					for (int snippetIndex = 0; snippetIndex < getPage(pageIndex).getBoxCount(); snippetIndex++) {
						LineIndex snippetLineIndexObject = new LineIndex(pageIndex, snippetIndex, 0);
						for (int lineIndex = 0; lineIndex < this.getLineCount(snippetLineIndexObject); lineIndex++) {
							LineIndex lineIndexObject = new LineIndex(pageIndex, snippetIndex, lineIndex);
							updateLine(this.getLine(lineIndexObject),
									getLine(lineIndexObject).getMaxSignItemTokenBoxHeight_PX(), lineIndexObject);
						}
					}
				} else {
					for (int lineIndex = 0; lineIndex < this.getLineCount(pageIndex); lineIndex++) {
						LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
						updateLine(this.getLine(lineIndexObject),
								getLine(lineIndexObject).getMaxSignItemTokenBoxHeight_PX(), lineIndexObject);
					}
				}
			}
		}
	}

	private void loadTokens(Document document, TokenBoxFactory tokenBoxFactory, int sectionIndex, int paragraphIndex,
			boolean isCollage, Paragraph paragraph, int paragraphWidth) {
		for (int tokenIndex = document.getTokenCount(sectionIndex, paragraphIndex) - 1; tokenIndex >= 0; tokenIndex--) {
			Token token = document.getToken(sectionIndex, paragraphIndex, tokenIndex);

			TokenBox tokenBox;
			if (token instanceof SignItemToken) {
				tokenBox = tokenBoxFactory.create(token, ((SignItemToken) token).isSearchWordVisibility(),
						((SignItemToken) token).isSignVisibility(), false, paragraphWidth);
			} else {
				tokenBox = tokenBoxFactory.create(token, paragraph.isSearchWordLineVisible(),
						paragraph.isSignLineVisible(), false, paragraphWidth);
			}

			if (tokenBox instanceof FreeTextTokenBox) {
				FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) tokenBox;
				freeTextTokenBox.splitFreeTextToLines();
			}
			if (tokenBox instanceof SignItemTokenBox) {
				SignItemTokenBox signItemTokenBox = (SignItemTokenBox) tokenBox;
				float stringWidthFromWidget = fontSizeService.getStringWidth(signItemTokenBox.getText(),
						signItemTokenBox.getFontMetricSpecifier());
				signItemTokenBox.setTextWidth(stringWidthFromWidget);
			}

			BoxIndex boxIndexObject;
			if (isCollage) {
				boxIndexObject = new BoxIndex(0, 0, 0, 0);
			} else {
				boxIndexObject = new BoxIndex(0, 0, 0);
			}
			insertBox(tokenBox, boxIndexObject);
		}
	}

	public Box getBox(BoxIndex boxIndex) {
		assert boxIndex != null : "Precondition failed: boxIndex != null";

		return super.getBox(boxIndex);
	}

	public int getLineHeight_PX(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		return getLine(lineIndexObject).getHeight_PX();
	}

	@Override
	public void onInsertPage(int pageIndex, PageLayout pageLayout) {
		// not required
	}

	@Override
	public void onRemovePage(int pageIndex) {
		// not required
	}

	@Override
	public void onInsertNewLine(LineIndex lineIndexObject, Orientation pageOrientation) {
		// not required
	}

	@Override
	public void onRemoveLine(LineIndex lineIndexObject) {
		// not required
	}

	@Override
	public void onSetBox(Box box, BoxIndex boxIndexObject) {
		// not required
	}

	@Override
	public void onInsertBox(Box box, BoxIndex boxIndexObject, Orientation pageOrientation) {
		// not required
	}

	@Override
	public void onRemoveBox(BoxIndex boxIndexObject) {
		// not required
	}

	@Override
	public void onMoveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength) {
		// not required
	}

	@Override
	public void onMovePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject, int segmentLength) {
		// not required
	}

	@Override
	public void onMoveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject) {
		// not required
	}

	private void updateLine(OverflowListLayout line, int maxHeight, LineIndex lineIndexObject) {
		for (int i = 0, tokenBoxCount = line.getBoxCount(); i < tokenBoxCount; i++) {
			Box box = line.getBox(i);
			if (box instanceof SignItemTokenBox) {
				((SignItemTokenBox) box).updateMarginBetweenSignItemAndText(maxHeight);
				setBox(box, new BoxIndex(lineIndexObject, i));
			} else if (box instanceof VideoTokenBox) {
				((VideoTokenBox) box).updateMarginBetweenVideoAndText(maxHeight);
				setBox(box, new BoxIndex(lineIndexObject, i));
			} else if (box instanceof ImageTokenBox) {
				((ImageTokenBox) box).updateMarginBetweenImageAndText(maxHeight);
				setBox(box, new BoxIndex(lineIndexObject, i));
			}
		}
	}

	@Override
	public void onRemoveSnippet(int pageIndex, int snippetIndex) {
		// not required
	}

}
