package de.signWritingEditor.server.service.pdfService;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

//for collage
//TODO check it
public class PdfLineTemplate extends TokenBoxTemplate implements Comparable<PdfLineTemplate> {
	protected final float pointsPerPixel;
	protected List<TokenBoxTemplate> tokenBoxTemplateList;
	private float x_PT;
	private float y_PT;

	protected float width_PT;
	protected float height_PT;

	/*
	 * Das PdfLineTemplate muss die "render-Methoden" der TokenBoxTemplate
	 * Objekte in der Liste tokenBoxTemplateList aufrufen und auf den
	 * contentStream "schreiben".
	 * 
	 * Frage 1: schreiben sich die tokenBoxTemplate Objekte selber auf den
	 * Stream oder macht das PdfLineTeamplate Frage 2: müssen das naming
	 * überdenken (Template bezogen)
	 * 
	 */

	public PdfLineTemplate(float width, float height, float pointsPerPixel, int x_PT, int y_PT) {
		this.width_PT = width;
		this.height_PT = height;
		this.pointsPerPixel = pointsPerPixel;
		this.tokenBoxTemplateList = new ArrayList<TokenBoxTemplate>();
		this.x_PT = ((float) x_PT) * pointsPerPixel;
		this.y_PT = ((float) y_PT) * pointsPerPixel;
	}

	@Override
	public float getWidth_PT() {
		return this.width_PT;
	}

	@Override
	public float getHeight_PT() {
		return this.height_PT;
	}

	public void addTokenBoxTemplate(TokenBoxTemplate tokenBoxTemplate) {
		tokenBoxTemplateList.add(tokenBoxTemplate);
	}

	public float getX() {
		return x_PT;
	}

	public float getY() {
		return y_PT;
	}

	public void draw(PDPageContentStream contentStream, float x_, float y_) throws Exception {
		// Hier sind x_ und y_ aus Verwechslungsgründen ohne PT am Ende
		// Damit dies beim lesen nicht mit den Objektvariablen x_PT und y_PT
		// verwechselt wird
		for (TokenBoxTemplate template : tokenBoxTemplateList) {
			template.draw(contentStream, x_, y_);
			x_ += template.getWidth_PT();
		}
	}

	@Override
	public int compareTo(PdfLineTemplate o) {
		return 0;
	}
}
