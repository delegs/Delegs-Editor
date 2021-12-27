package de.signWritingEditor.shared.layout;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.material.DateFormToken;

public class DateFormTokenBox extends FormTokenBox {

	private DateFormToken dateFormToken;

	public DateFormTokenBox(DateFormToken dateFormToken, FontSizeService fontSizeService) {
		super(dateFormToken, fontSizeService);
		this.dateFormToken = dateFormToken;
	}

	public void setValid(boolean valid) {
		dateFormToken.setValid(valid);
	}

}
