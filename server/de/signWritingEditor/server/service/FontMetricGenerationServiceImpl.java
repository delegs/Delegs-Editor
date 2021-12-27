package de.signWritingEditor.server.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class FontMetricGenerationServiceImpl implements FontMetricGenerationService {
	private static final String ESF_WAR_PATH = ConfigurationService.PROPERTY_WAR_PATH;
	private static final String FONT_METRICS_JSON = "font-metrics.json";
	private ConfigurationService config;

	// use UnicodeCharacterGenerationTool + \n\r\t
	private static final String ALL_CHARS = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ¡¢£¤¥¦§¨©ª«¬®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠơƢƣƤƥƦƧƨƩƪƫƬƭƮƯưƱƲƳƴƵƶƷƸƹƺƻƼƽƾƿǀǁǂǃǄǅǆǇǈǉǊǋǌǍǎǏǐǑǒǓǔǕǖǗǘǙǚǛǜǝǞǟǠǡǢǣǤǥǦǧǨǩǪǫǬǭǮǯǰǱǲǳǴǵǶǷǸǹǺǻǼǽǾǿȀȁȂȃȄȅȆȇȈȉȊȋȌȍȎȏȐȑȒȓȔȕȖȗȘșȚțȜȝȞȟȠȡȢȣȤȥȦȧȨȩȪȫȬȭȮȯȰȱȲȳȴȵȶȷȸȹȺȻȼȽȾȿɀɁɂɃɄɅɆɇɈɉɊɋɌɍɎ€‐‑‒–—―‖‗‘’‚‛“”„‟†‡•‣․‥…‧   ‰‱′″‴‵‶‷‸‹›※‼‽‾‿⁀⁁⁂⁃⁄⁅⁆⁇⁈⁉⁊⁋⁌⁍⁎⁏⁐⁑⁒⁓⁔⁕⁖⁗⁘⁙⁚⁛⁜⁝⁞ ⁥⁦⁧⁨⁩\n\r\t";

	public FontMetricGenerationServiceImpl(ConfigurationService config) {
		this.config = config;
	}

	@Override
	public Map<FontMetricSpecifier, FontMetric> getFontMetrics() {
		Map<FontMetricSpecifier, FontMetric> result = new HashMap<FontMetricSpecifier, FontMetric>();

		try {
			String warPath = config.getProperty(ESF_WAR_PATH);

			try (InputStreamReader inputStreamReader = new InputStreamReader(
					new FileInputStream(warPath + FONT_METRICS_JSON), StandardCharsets.UTF_8)) {
				char[] allChars = ALL_CHARS.toCharArray();
				Float zero = 0f;

				Gson gson = new Gson();
				JsonParser parser = new JsonParser();
				JsonObject fonts = parser.parse(inputStreamReader).getAsJsonObject();

				for (Entry<String, JsonElement> fontEntry : fonts.entrySet()) {
					Font font = Font.valueOf(fontEntry.getKey());
					for (Entry<String, JsonElement> styleEntry : fontEntry.getValue().getAsJsonObject().entrySet()) {
						FontStyle style = FontStyle.valueOf(styleEntry.getKey());

						for (Entry<String, JsonElement> weightEntry : styleEntry.getValue().getAsJsonObject()
								.entrySet()) {
							FontWeight weight = FontWeight.valueOf(weightEntry.getKey());

							for (Entry<String, JsonElement> sizeEntry : weightEntry.getValue().getAsJsonObject()
									.entrySet()) {

								FontSize size = FontSize.valueOf(sizeEntry.getKey());
								JsonObject json = sizeEntry.getValue().getAsJsonObject();
								FontMetricSpecifier specifier = new FontMetricSpecifier(font, style, size, weight);
								FontMetric metric = gson.fromJson(json, FontMetric.class);
								Map<Character, Float> characterWidths = metric.getCharacterWidths();
								for (char c : allChars) {
									if (!characterWidths.containsKey(c)) {
										characterWidths.put(c, zero);
									}
								}

								result.put(specifier, metric);
							}
						}
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return result;
	}
}
