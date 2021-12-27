package de.signWritingEditor.shared.i18n;

public class I18NAccess {
	public static final I18N I18N_DE = new I18NImpl_de();
	public static final I18N I18N_EN = new I18NImpl_en();
	public static final I18N I18N_ES = new I18NImpl_es();
	public static final I18N I18N_FR = new I18NImpl_fr();
	public static final I18N I18N_BR = new I18NImpl_br();
	public static final I18N[] I18N_OPTIONS = { I18N_DE, I18N_EN, I18N_ES, I18N_FR, I18N_BR };

	public static I18N I18N = I18N_DE;

}
