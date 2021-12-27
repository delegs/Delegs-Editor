package de.signWritingEditor.server.service.pdfService;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

/*
 * Das PdfSnippetTemplate muss die "render-Methoden" der TokenBoxTemplate
 * Objekte in der Liste tokenBoxTemplateList aufrufen und auf den
 * contentStream "schreiben".
 * 
 * Frage 1: schreiben sich die tokenBoxTemplate Objekte selber auf den
 * Stream oder macht das PdfLineTeamplate Frage 2: müssen das naming
 * überdenken (Template bezogen)
 * 
 */

public class PdfSnippetTemplate extends TokenBoxTemplate implements Comparable<PdfSnippetTemplate> {

	protected final float pointsPerPixel;
	protected List<PdfLineTemplate> lineTemplateList;
	private float x_PT;
	private float y_PT;
	private int z;

	protected float width_PT;
	protected float height_PT;

	public PdfSnippetTemplate(float width, float height, float pointsPerPixel, float x_PX, float y_PX, int z) {
		this.width_PT = width;
		this.height_PT = height;
		this.pointsPerPixel = pointsPerPixel;
		this.lineTemplateList = new ArrayList<PdfLineTemplate>();
		this.x_PT = ((float) x_PX) * pointsPerPixel;
		this.y_PT = ((float) y_PX) * pointsPerPixel;
		this.z = z;
	}

	@Override
	public float getWidth_PT() {
		return 0f;
	}

	@Override
	public float getHeight_PT() {
		return 0f;
	}

	public void addLine(PdfLineTemplate lineTemplate) {
		lineTemplateList.add(lineTemplate);
	}

	public float getX_PT() {
		return x_PT;
	}

	public float getY_PT() {
		return y_PT;
	}

	public int getZIndex() {
		return z;
	}

	public void draw(PDPageContentStream contentStream, float x_, float y_) throws Exception {
		// x_ und y_ sind PT
		// steht hier nicht, damit man es nicht mit x_PT und y_PT verwechselt

		// x, y start koordinaten des snippets
		// wenn die start koordinaten und links anfangen wir aber vorwärts über
		// die liste laufen
		// dann müssen wir neue start x, y werte bestimmen

		for (int i = lineTemplateList.size() - 1; i >= 0; i--) {
			PdfLineTemplate template = lineTemplateList.get(i);

			template.draw(contentStream, x_,
					y_ - template.getHeight_PT() - PageFormat.COLLAGE_PADDING * pointsPerPixel);
			y_ -= lineTemplateList.get(i).getHeight_PT();
		}
	}

	@Override
	public int compareTo(PdfSnippetTemplate o) {
		return 0;
	}

	public float getSnippetPadding_PT() {
		return SnippetLayout.getSnippetPadding_PX() * pointsPerPixel;
	}
}
