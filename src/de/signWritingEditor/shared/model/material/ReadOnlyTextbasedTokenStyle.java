package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;

public interface ReadOnlyTextbasedTokenStyle {

	FontSize getFontSize();

	FontMetricSpecifier getFontMetricSpecifier();

	Color getFontColor();

	Color getTextBackgroundColor();

	FontStyle getFontStyle();

	FontWeight getFontWeight();

	Font getFont();

}