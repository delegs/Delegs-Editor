package de.signWritingEditor.client.GWTClient.ui.general.textHandling;

public class UniversalLocaleCollator {

	// when strings are compared by this class special chars will be mapped
	// to regular chars
	private static final String SPECIAL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZßÀàÁáÂâÃãÄäÅåÆæÇçÈèÉéÊêËëÌìÍíÎîÏïÑñÒòÓóÔôÕõÖöØøÙùÚúÛûÜüÝýÞþŸÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįIıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŹźŻżŽžSſƀ";
	private static final String REGULAR_CHARS = "abcdefghijklmnopqrstuvwxyzsaaaaaaaaaaaaaacceeeeeeeeiiiiiiiinnoooooooooooouuuuuuuuyyttyyaaaaaaccccccccddddeeeeeeeeeegggggggghhhhiiiiiiiiiiiijjkkkllllllllllnnnnnnnnnoooooooorrrrrrssssssssttttttuuuuuuuuuuuuwwyyzzzzzzssb";

	public static int compareTo(String s1, String s2) {
		int result = 0;

		if (s1 == null) {
			s1 = "".intern();
		}

		if (s2 == null) {
			s2 = "".intern();
		}

		for (int i = 0; result == 0 && i < s1.length() && i < s2.length(); i++) {
			char c1 = s1.charAt(i);
			int p1 = SPECIAL_CHARS.indexOf(c1);
			if (p1 >= 0) {
				c1 = REGULAR_CHARS.charAt(p1);
			}

			char c2 = s2.charAt(i);
			int p2 = SPECIAL_CHARS.indexOf(c2);
			if (p2 >= 0) {
				c2 = REGULAR_CHARS.charAt(p2);
			}

			result = c1 - c2;
		}

		if (result == 0) {
			result = s1.length() - s2.length();
		}

		if (result < 0) {
			result = -1;
		} else if (result > 0) {
			result = 1;
		}

		return result;
	}

}
