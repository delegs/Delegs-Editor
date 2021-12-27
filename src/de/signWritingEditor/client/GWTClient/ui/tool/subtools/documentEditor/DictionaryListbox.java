package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DictionarySelectionListbox.DictionarySelectionListener;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class DictionaryListbox extends Composite {

	private ListBox dictionaryList;
	private static Map<SignLocale, String> dictionaryToCountryCodeMap = new HashMap<SignLocale, String>();

	static {
		dictionaryToCountryCodeMap.put(SignLocale.DGS, "DE");
		dictionaryToCountryCodeMap.put(SignLocale.ASL, "US");
		dictionaryToCountryCodeMap.put(SignLocale.BSL, "GB");
		dictionaryToCountryCodeMap.put(SignLocale.LIBRAS, "BR");
		dictionaryToCountryCodeMap.put(SignLocale.LSE, "ES");
		dictionaryToCountryCodeMap.put(SignLocale.LSF, "FR");
		dictionaryToCountryCodeMap.put(SignLocale.LSFB, "BE");
		dictionaryToCountryCodeMap.put(SignLocale.LSM, "MX");
		dictionaryToCountryCodeMap.put(SignLocale.LSQ, "CA");
		dictionaryToCountryCodeMap.put(SignLocale.PJM, "PL");
		dictionaryToCountryCodeMap.put(SignLocale.SZJ, "SI");
		dictionaryToCountryCodeMap.put(SignLocale.IS, "IS");
		dictionaryToCountryCodeMap.put(SignLocale.TSE, "FR");
		dictionaryToCountryCodeMap.put(SignLocale.DSGS, "CH-de");
	}

	public DictionaryListbox(final DictionarySelectionListener listener) {
		dictionaryList = new ListBox();

		for (SignLocale locale : SignLocale.values()) {
			String name = locale.name();

			dictionaryList.addItem(name + " (" + dictionaryToCountryCodeMap.get(locale) + ")");
		}

		dictionaryList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				listener.onChangeLocale(getSelectedSignLocale());
			}
		});

		initWidget(dictionaryList);
		dictionaryList.getElement().getStyle().setMarginTop(10, Unit.PX);

		this.getElement().getStyle().setMarginBottom(20, Unit.PX);
		this.addStyleName("dictionarySelection");
	}

	public SignLocale getSelectedSignLocale() {
		int selectedIndex = dictionaryList.getSelectedIndex();
		String selectedDictionary = dictionaryList.getItemText(selectedIndex);
		int splitIndex = selectedDictionary.indexOf(" ");
		SignLocale locale = SignLocale.valueOf(selectedDictionary.substring(0, splitIndex));
		return locale;
	}

	public void setNewLocale(SignLocale newLocale) {
		int index;
		for (index = 0; index < dictionaryList.getItemCount(); ++index) {
			if (dictionaryList.getItemText(index).contains(newLocale.name())) {
				break;
			}
		}
		this.dictionaryList.setSelectedIndex(index);
	}
}
