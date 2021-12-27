package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class DictionarySelectionListbox extends Composite
		implements HasClickHandlers, HasMouseOverHandlers, HasMouseOutHandlers, HasMouseDownHandlers, HasBlurHandlers {

	private FlowPanel contentPanel;
	private ListBox dictionaryList;
	private Image dictionaryImage;
	private SimplePanel dictionaryImagePanel;
	private DictionarySelectionListener listener;
	private static Map<SignLocale, ImageResource> dictionaryToFlagMap = new HashMap<SignLocale, ImageResource>();
	private static Map<SignLocale, String> dictionaryToCountryCodeMap = new HashMap<SignLocale, String>();

	static {
		dictionaryToFlagMap.put(SignLocale.DGS, Resources.RESOURCE.getGermanFlag());
		dictionaryToCountryCodeMap.put(SignLocale.DGS, "DE");
		dictionaryToFlagMap.put(SignLocale.ASL, Resources.RESOURCE.getUSAFlag());
		dictionaryToCountryCodeMap.put(SignLocale.ASL, "US");
		dictionaryToFlagMap.put(SignLocale.BSL, Resources.RESOURCE.getUKFlag());
		dictionaryToCountryCodeMap.put(SignLocale.BSL, "GB");
		dictionaryToFlagMap.put(SignLocale.LIBRAS, Resources.RESOURCE.getBrazilianFlag());
		dictionaryToCountryCodeMap.put(SignLocale.LIBRAS, "BR");
		dictionaryToFlagMap.put(SignLocale.LSE, Resources.RESOURCE.getSpanishFlag());
		dictionaryToCountryCodeMap.put(SignLocale.LSE, "ES");
		dictionaryToFlagMap.put(SignLocale.LSF, Resources.RESOURCE.getFrenchFlag());
		dictionaryToCountryCodeMap.put(SignLocale.LSF, "FR");
		dictionaryToFlagMap.put(SignLocale.LSFB, Resources.RESOURCE.getBelgianFlag());
		dictionaryToCountryCodeMap.put(SignLocale.LSFB, "BE");
		dictionaryToFlagMap.put(SignLocale.LSM, Resources.RESOURCE.getMexicanFlag());
		dictionaryToCountryCodeMap.put(SignLocale.LSM, "MX");
		dictionaryToFlagMap.put(SignLocale.LSQ, Resources.RESOURCE.getCanadianFlag());
		dictionaryToCountryCodeMap.put(SignLocale.LSQ, "CA");
		dictionaryToFlagMap.put(SignLocale.PJM, Resources.RESOURCE.getPolishFlag());
		dictionaryToCountryCodeMap.put(SignLocale.PJM, "PL");
		dictionaryToFlagMap.put(SignLocale.SZJ, Resources.RESOURCE.getSlovenianFlag());
		dictionaryToCountryCodeMap.put(SignLocale.SZJ, "SI");
		dictionaryToFlagMap.put(SignLocale.IS, Resources.RESOURCE.getSign8Flag());
		dictionaryToCountryCodeMap.put(SignLocale.IS, "IS");
		dictionaryToFlagMap.put(SignLocale.TSE, Resources.RESOURCE.getTunisianFlag());
		dictionaryToCountryCodeMap.put(SignLocale.TSE, "FR");
		dictionaryToFlagMap.put(SignLocale.DSGS, Resources.RESOURCE.getSwissFlag());
		dictionaryToCountryCodeMap.put(SignLocale.DSGS, "CH-de");
	}

	public DictionarySelectionListbox(DictionarySelectionListener listener) {
		contentPanel = new FlowPanel();
		dictionaryList = new ListBox();

		dictionaryImagePanel = new SimplePanel();
		dictionaryImagePanel.setStyleName("dictionaryImage");
		dictionaryImagePanel.getElement().getStyle().setMarginLeft(10, Unit.PX);
		dictionaryImagePanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		dictionaryImage = new Image();
		this.listener = listener;

		for (SignLocale locale : SignLocale.values()) {
			String name = locale.name();

			dictionaryList.addItem(name + " (" + dictionaryToCountryCodeMap.get(locale) + ")");
		}
		dictionaryList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				handleSelectionChanged();
			}
		});
		initWidget(contentPanel);
		dictionaryImagePanel.add(dictionaryImage);
		dictionaryList.getElement().getStyle().setMarginTop(10, Unit.PX);
		contentPanel.add(dictionaryList);
		contentPanel.add(dictionaryImagePanel);

		contentPanel.setHeight("25px");
		contentPanel.setWidth("230px");
		contentPanel.getElement().getStyle().setMarginLeft(0, Unit.PX);
		contentPanel.getElement().getStyle().setMarginTop(0, Unit.PX);
		contentPanel.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);

		this.getElement().getStyle().setMarginBottom(20, Unit.PX);
		this.addStyleName("dictionarySelection");
	}

	private void handleSelectionChanged() {
		SignLocale locale = getSelectedSignLocale();
		listener.onChangeLocale(locale);
		updateImage(locale);
	}

	public SignLocale getSelectedSignLocale() {
		int selectedIndex = dictionaryList.getSelectedIndex();
		String selectedDictionary = dictionaryList.getItemText(selectedIndex);
		int splitIndex = selectedDictionary.indexOf(" ");
		SignLocale locale = SignLocale.valueOf(selectedDictionary.substring(0, splitIndex));
		return locale;
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {

		return contentPanel.addHandler(handler, MouseOverEvent.getType());
	}

	@Override
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return contentPanel.addHandler(handler, BlurEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return contentPanel.addHandler(handler, MouseDownEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return contentPanel.addHandler(handler, MouseOutEvent.getType());
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return contentPanel.addHandler(handler, ClickEvent.getType());
	}

	public void setNewLocale(SignLocale newLocale) {
		int index;
		for (index = 0; index < dictionaryList.getItemCount(); ++index) {
			if (dictionaryList.getItemText(index).contains(newLocale.name())) {
				break;
			}
		}
		this.dictionaryList.setSelectedIndex(index);
		updateImage(newLocale);

	}

	private void updateImage(SignLocale newLocale) {
		this.dictionaryImage.setResource(dictionaryToFlagMap.get(newLocale));
	}

	public interface DictionarySelectionListener {
		void onChangeLocale(SignLocale locale);
	}
}
