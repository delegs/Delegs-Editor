package de.signWritingEditor.test.integration.infrastructure;

import java.util.HashMap;
import java.util.Map;

import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class FontMetricGenerationServiceMock {

	private static Map<FontMetricSpecifier, FontMetric> mockFontMetric;

	public static Map<FontMetricSpecifier, FontMetric> getFontMetrics() {
		return mockFontMetric;
	}

	static {
		mockFontMetric = new HashMap<FontMetricSpecifier, FontMetric>();

		Map<Character, Float> charWidthMap = new HashMap<Character, Float>();
		charWidthMap.put('\u0020', 3.6140003f);
		charWidthMap.put('\u0030', 7.2280006f);
		charWidthMap.put('\u0031', 7.2280006f);
		charWidthMap.put('\u0032', 7.2280006f);
		charWidthMap.put('\u0033', 7.2280006f);
		charWidthMap.put('\u0034', 7.2280006f);
		charWidthMap.put('\u0035', 7.2280006f);
		charWidthMap.put('\u0036', 7.2280006f);
		charWidthMap.put('\u0037', 7.2280006f);
		charWidthMap.put('\u0038', 7.2280006f);
		charWidthMap.put('\u0039', 7.2280006f);
		charWidthMap.put('\u0061', 7.2280006f);
		charWidthMap.put('\u0062', 7.2280006f);
		charWidthMap.put('\u0063', 6.5f);
		charWidthMap.put('\u0064', 7.2280006f);
		charWidthMap.put('\u0065', 7.2280006f);
		charWidthMap.put('\u0066', 3.6140003f);
		charWidthMap.put('\u0067', 7.2280006f);
		charWidthMap.put('\u0068', 7.2280006f);
		charWidthMap.put('\u0069', 2.8860002f);
		charWidthMap.put('\u006a', 2.8860002f);
		charWidthMap.put('\u006b', 6.5f);
		charWidthMap.put('\u006c', 2.8860002f);
		charWidthMap.put('\u006d', 10.829f);
		charWidthMap.put('\u006e', 7.2280006f);
		charWidthMap.put('\u006f', 7.2280006f);
		charWidthMap.put('\u0070', 7.2280006f);
		charWidthMap.put('\u0071', 7.2280006f);
		charWidthMap.put('\u0072', 4.329f);
		charWidthMap.put('\u0073', 6.5f);
		charWidthMap.put('\u0074', 3.6140003f);
		charWidthMap.put('\u0075', 7.2280006f);
		charWidthMap.put('\u0076', 6.5f);
		charWidthMap.put('\u0077', 9.386001f);
		charWidthMap.put('\u0078', 6.5f);
		charWidthMap.put('\u0079', 6.5f);
		charWidthMap.put('\u007a', 6.5f);
		charWidthMap.put('\u0041', 8.6710005f);
		charWidthMap.put('\u0042', 8.6710005f);
		charWidthMap.put('\u0043', 9.386001f);
		charWidthMap.put('\u0044', 9.386001f);
		charWidthMap.put('\u0045', 8.6710005f);
		charWidthMap.put('\u0046', 7.943f);
		charWidthMap.put('\u0047', 10.114f);
		charWidthMap.put('\u0048', 9.386001f);
		charWidthMap.put('\u0049', 3.6140003f);
		charWidthMap.put('\u004a', 6.5f);
		charWidthMap.put('\u004b', 8.6710005f);
		charWidthMap.put('\u004c', 7.2280006f);
		charWidthMap.put('\u004d', 10.829f);
		charWidthMap.put('\u004e', 9.386001f);
		charWidthMap.put('\u004f', 10.114f);
		charWidthMap.put('\u0050', 8.6710005f);
		charWidthMap.put('\u0051', 10.114f);
		charWidthMap.put('\u0052', 9.386001f);
		charWidthMap.put('\u0053', 8.6710005f);
		charWidthMap.put('\u0054', 7.943f);
		charWidthMap.put('\u0055', 9.386001f);
		charWidthMap.put('\u0056', 8.6710005f);
		charWidthMap.put('\u0057', 12.272001f);
		charWidthMap.put('\u0058', 8.6710005f);
		charWidthMap.put('\u0059', 8.6710005f);
		charWidthMap.put('\u005a', 7.943f);
		charWidthMap.put('\u00f6', 7.2280006f);
		charWidthMap.put('\u00fc', 7.2280006f);
		charWidthMap.put('\u00e4', 7.2280006f);
		charWidthMap.put('\u00d6', 10.114f);
		charWidthMap.put('\u00dc', 9.386001f);
		charWidthMap.put('\u00c4', 8.6710005f);
		charWidthMap.put('\u00df', 7.943f);
		charWidthMap.put('\u00e0', 7.2280006f);
		charWidthMap.put('\u00e2', 7.2280006f);
		charWidthMap.put('\u00e1', 7.2280006f);
		charWidthMap.put('\u00e8', 7.2280006f);
		charWidthMap.put('\u00ea', 7.2280006f);
		charWidthMap.put('\u00e9', 7.2280006f);
		charWidthMap.put('\u00ec', 3.6140003f);
		charWidthMap.put('\u00ee', 3.6140003f);
		charWidthMap.put('\u00ed', 3.6140003f);
		charWidthMap.put('\u00f2', 7.2280006f);
		charWidthMap.put('\u00f4', 7.2280006f);
		charWidthMap.put('\u00f3', 7.2280006f);
		charWidthMap.put('\u00f9', 7.2280006f);
		charWidthMap.put('\u00fb', 7.2280006f);
		charWidthMap.put('\u00fa', 7.2280006f);
		charWidthMap.put('\u00c0', 8.6710005f);
		charWidthMap.put('\u00c2', 8.6710005f);
		charWidthMap.put('\u00c1', 8.6710005f);
		charWidthMap.put('\u00c8', 8.6710005f);
		charWidthMap.put('\u00ca', 8.6710005f);
		charWidthMap.put('\u00c9', 8.6710005f);
		charWidthMap.put('\u00cc', 3.6140003f);
		charWidthMap.put('\u00ce', 3.6140003f);
		charWidthMap.put('\u00cd', 3.6140003f);
		charWidthMap.put('\u00d2', 10.114f);
		charWidthMap.put('\u00d4', 10.114f);
		charWidthMap.put('\u00d3', 10.114f);
		charWidthMap.put('\u00d9', 9.386001f);
		charWidthMap.put('\u00db', 9.386001f);
		charWidthMap.put('\u00da', 9.386001f);
		charWidthMap.put('\u00b0', 5.2000003f);
		charWidthMap.put('\u0021', 3.6140003f);
		charWidthMap.put('\u0022', 4.6150002f);
		charWidthMap.put('\u00a7', 7.2280006f);
		charWidthMap.put('\u0024', 7.2280006f);
		charWidthMap.put('\u0025', 11.557001f);
		charWidthMap.put('\u0026', 8.6710005f);
		charWidthMap.put('\u002f', 3.6140003f);
		charWidthMap.put('\u0028', 4.329f);
		charWidthMap.put('\u0029', 4.329f);
		charWidthMap.put('\u003d', 7.5920005f);
		charWidthMap.put('\u003f', 7.2280006f);
		charWidthMap.put('\u0060', 4.329f);
		charWidthMap.put('\u00b2', 4.329f);
		charWidthMap.put('\u00b3', 4.329f);
		charWidthMap.put('\u007b', 4.3420005f);
		charWidthMap.put('\u005b', 3.6140003f);
		charWidthMap.put('\u005d', 3.6140003f);
		charWidthMap.put('\u007d', 4.3420005f);
		charWidthMap.put('\\', 3.6140003f);
		charWidthMap.put('\u00b4', 4.329f);
		charWidthMap.put('\u005e', 6.097f);
		charWidthMap.put('\u002c', 3.6140003f);
		charWidthMap.put('\u003b', 3.6140003f);
		charWidthMap.put('\u002e', 3.6140003f);
		charWidthMap.put('\u003a', 3.6140003f);
		charWidthMap.put('\u002d', 4.329f);
		charWidthMap.put('\u005f', 7.2280006f);
		charWidthMap.put('\u0023', 7.2280006f);
		charWidthMap.put('\'', 2.4830003f);
		charWidthMap.put('\u002b', 7.5920005f);
		charWidthMap.put('\u002a', 5.057f);
		charWidthMap.put('\u007e', 7.5920005f);
		charWidthMap.put('\u003c', 7.5920005f);
		charWidthMap.put('\u003e', 7.5920005f);
		charWidthMap.put('\u007c', 3.3800004f);
		charWidthMap.put('\u0040', 13.195002f);
		charWidthMap.put('\u20ac', 7.2280006f);
		charWidthMap.put('\u00b5', 7.2280006f);
		charWidthMap.put('\n', 0.0f);
		charWidthMap.put('\r', 0.0f);
		charWidthMap.put('\t', 0.0f);

		mockFontMetric.put(
				new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL, FontSize.SIZE_13, FontWeight.NORMAL),
				new FontMetric(16, 16, 0, charWidthMap));
		mockFontMetric.put(
				new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL, FontSize.SIZE_8, FontWeight.NORMAL),
				new FontMetric(10, 10, 0, null));
	}

}
