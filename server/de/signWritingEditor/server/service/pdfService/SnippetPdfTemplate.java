package de.signWritingEditor.server.service.pdfService;

public class SnippetPdfTemplate extends PdfLineTemplate {

	private int z;

	public SnippetPdfTemplate(float width, float height, float pointsPerPixel, int x, int y, int z) {
		super(width, height, pointsPerPixel, x, y);
		this.z = z;
	}

	public int getZIndex() {
		return z;
	}

	@Override
	public int compareTo(PdfLineTemplate o) {
		if (o instanceof SnippetPdfTemplate) {
			SnippetPdfTemplate template = (SnippetPdfTemplate) o;
			if (template.getZIndex() == z) {
				return 0;
			} else if (template.getZIndex() > z) {
				return -1;
			} else {
				return 1;
			}
		} else if (o instanceof PdfLineTemplate) {
			return 1;
		}
		return super.compareTo(o);
	}
}
