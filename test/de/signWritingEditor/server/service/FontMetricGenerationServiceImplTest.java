package de.signWritingEditor.server.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class FontMetricGenerationServiceImplTest {

	private static final String ALL_CHARS = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ¡¢£¤¥¦§¨©ª«¬®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠơƢƣƤƥƦƧƨƩƪƫƬƭƮƯưƱƲƳƴƵƶƷƸƹƺƻƼƽƾƿǀǁǂǃǄǅǆǇǈǉǊǋǌǍǎǏǐǑǒǓǔǕǖǗǘǙǚǛǜǝǞǟǠǡǢǣǤǥǦǧǨǩǪǫǬǭǮǯǰǱǲǳǴǵǶǷǸǹǺǻǼǽǾǿȀȁȂȃȄȅȆȇȈȉȊȋȌȍȎȏȐȑȒȓȔȕȖȗȘșȚțȜȝȞȟȠȡȢȣȤȥȦȧȨȩȪȫȬȭȮȯȰȱȲȳȴȵȶȷȸȹȺȻȼȽȾȿɀɁɂɃɄɅɆɇɈɉɊɋɌɍɎ€‐‑‒–—―‖‗‘’‚‛“”„‟†‡•‣․‥…‧   ‰‱′″‴‵‶‷‸‹›※‼‽‾‿⁀⁁⁂⁃⁄⁅⁆⁇⁈⁉⁊⁋⁌⁍⁎⁏⁐⁑⁒⁓⁔⁕⁖⁗⁘⁙⁚⁛⁜⁝⁞ ⁥⁦⁧⁨⁩\n\r\t";

	@Test
	public void testFontmetricGeneration() {

		try {
			FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
					new ConfigurationService("/ESFConfig_Junit.properties"));
			Map<FontMetricSpecifier, FontMetric> fontMetrics = fontMetricGenerationService.getFontMetrics();

			for (FontMetricSpecifier id : getFontMetricIds()) {
				assertTrue("Id : " + id.toString() + " not contained", fontMetrics.containsKey(id));
				Map<Character, Float> charMap = fontMetrics.get(id).getCharacterWidths();
				for (char c : ALL_CHARS.toCharArray()) {
					assertTrue("Id : " + id.toString() + " does not contain value for : " + c, charMap.containsKey(c));
				}
			}
		} catch (Exception e) {
			fail();
		}

	}

	private List<FontMetricSpecifier> getFontMetricIds() {
		List<FontMetricSpecifier> result = new ArrayList<FontMetricSpecifier>();

		for (Font font : Font.values()) {
			for (FontStyle style : FontStyle.values()) {
				for (FontWeight fontWeight : FontWeight.values()) {
					for (FontSize fontSize : FontSize.values()) {
						result.add(new FontMetricSpecifier(font, style, fontSize, fontWeight));
					}
				}
			}
		}
		return result;
	}

}
