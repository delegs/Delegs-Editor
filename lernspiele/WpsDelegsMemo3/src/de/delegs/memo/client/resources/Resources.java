package de.delegs.memo.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	public static final Resources RESOURCES = GWT.create(Resources.class);

	public static final int PLAYER_COUNT = 9;
	public static final int CARD_PAIR_COUNT = 18;
	public static final int CARD_COUNT = CARD_PAIR_COUNT * 2;

	public static class Access {

		public static ImageResource getCardImage(int index) {
			assert index >= 0 : "Precondition failed: index >= 0";
			assert index < CARD_COUNT : "Precondition failed: index < CARD_COUNT";

			ImageResource result = null;
			switch (index) {
				case 0 :
					result = RESOURCES.getBauerImage();
					break;
				case 1 :
					result = RESOURCES.getGebaerdeBauerImage();
					break;
				case 2 :
					result = RESOURCES.getMutterImage();
					break;
				case 3 :
					result = RESOURCES.getGebaerdeMutterImage();
					break;
				case 4 :
					result = RESOURCES.getFuchsImage();
					break;
				case 5 :
					result = RESOURCES.getGebaerdeFuchsImage();
					break;
				case 6 :
					result = RESOURCES.getHuhnImage();
					break;
				case 7 :
					result = RESOURCES.getGebaerdeHuhnImage();
					break;
				case 8 :
					result = RESOURCES.getEiImage();
					break;
				case 9 :
					result = RESOURCES.getGebaerdeEiImage();
					break;
				case 10 :
					result = RESOURCES.getBrotImage();
					break;
				case 11 :
					result = RESOURCES.getGebaerdeBrotImage();
					break;
				case 12 :
					result = RESOURCES.getPfanneImage();
					break;
				case 13 :
					result = RESOURCES.getGebaerdePfanneImage();
					break;
				case 14 :
					result = RESOURCES.getGlueckImage();
					break;
				case 15 :
					result = RESOURCES.getGebaerdeGlueckImage();
					break;
				case 16 :
					result = RESOURCES.getHungerImage();
					break;
				case 17 :
					result = RESOURCES.getGebaerdeHungerImage();
					break;
				case 18 :
					result = RESOURCES.getAngstImage();
					break;
				case 19 :
					result = RESOURCES.getGebaerdeAngstImage();
					break;
				case 20 :
					result = RESOURCES.getSchlauImage();
					break;
				case 21 :
					result = RESOURCES.getGebaerdeSchlauImage();
					break;
				case 22 :
					result = RESOURCES.getSchnellImage();
					break;
				case 23 :
					result = RESOURCES.getGebaerdeSchnellImage();
					break;
				case 24 :
					result = RESOURCES.getTraurigImage();
					break;
				case 25 :
					result = RESOURCES.getGebaerdeTraurigImage();
					break;
				case 26 :
					result = RESOURCES.getLeckerImage();
					break;
				case 27 :
					result = RESOURCES.getGebaerdeLeckerImage();
					break;
				case 28 :
					result = RESOURCES.getStehlenImage();
					break;
				case 29 :
					result = RESOURCES.getGebaerdeStehlenImage();
					break;
				case 30 :
					result = RESOURCES.getSuchenImage();
					break;
				case 31 :
					result = RESOURCES.getGebaerdeSuchenImage();
					break;
				case 32 :
					result = RESOURCES.getEssenImage();
					break;
				case 33 :
					result = RESOURCES.getGebaerdeEssenImage();
					break;
				case 34 :
					result = RESOURCES.getVersteckenImage();
					break;
				case 35 :
					result = RESOURCES.getGebaerdeVersteckenImage();
			}
			assert result != null : "Postcondition failed: result != null";
			return result;
		}
	}

	@Source("Spieler.png")
	public abstract ImageResource getSpielerImage();

	@Source("Stapel.png")
	public abstract ImageResource getStapelImage();

	@Source("Textur.png")
	public abstract ImageResource getTexturImage();

	@Source("card_back_128x128.x2.jpg")
	public abstract ImageResource getCardBackImage();

	// Bild + Text

	@Source("ABSTRAKT_Angst_128x128.x2.jpg")
	public abstract ImageResource getAngstImage();

	@Source("LEBENDIG_Bauer_128x128.x2.jpg")
	public abstract ImageResource getBauerImage();

	@Source("UNBELEBT_Brot_128x128.x2.jpg")
	public abstract ImageResource getBrotImage();

	@Source("UNBELEBT_Ei_128x128.x2.jpg")
	public abstract ImageResource getEiImage();

	@Source("AKTION_essen_128x128.x2.jpg")
	public abstract ImageResource getEssenImage();

	@Source("LEBENDIG_Fuchs_128x128.x2.jpg")
	public abstract ImageResource getFuchsImage();

	@Source("ABSTRAKT_Glueck_128x128.x2.jpg")
	public abstract ImageResource getGlueckImage();

	@Source("LEBENDIG_Huhn_128x128.x2.jpg")
	public abstract ImageResource getHuhnImage();

	@Source("ABSTRAKT_Hunger_128x128.x2.jpg")
	public abstract ImageResource getHungerImage();

	@Source("ZUSTAND_lecker_128x128.x2.jpg")
	public abstract ImageResource getLeckerImage();

	@Source("LEBENDIG_Mutter_128x128.x2.jpg")
	public abstract ImageResource getMutterImage();

	@Source("UNBELEBT_Pfanne_128x128.x2.jpg")
	public abstract ImageResource getPfanneImage();

	@Source("ZUSTAND_schlau_128x128.x2.jpg")
	public abstract ImageResource getSchlauImage();

	@Source("ZUSTAND_schnell_128x128.x2.jpg")
	public abstract ImageResource getSchnellImage();

	@Source("AKTION_stehlen_128x128.x2.jpg")
	public abstract ImageResource getStehlenImage();

	@Source("AKTION_suchen_128x128.x2.jpg")
	public abstract ImageResource getSuchenImage();

	@Source("ZUSTAND_traurig_128x128.x2.jpg")
	public abstract ImageResource getTraurigImage();

	@Source("AKTION_verstecken_128x128.x2.jpg")
	public abstract ImageResource getVersteckenImage();

	// Gebärde

	@Source("ABSTRAKT_Angst_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeAngstImage();

	@Source("LEBENDIG_Bauer_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeBauerImage();

	@Source("UNBELEBT_Brot_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeBrotImage();

	@Source("UNBELEBT_Ei_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeEiImage();

	@Source("AKTION_essen_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeEssenImage();

	@Source("LEBENDIG_Fuchs_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeFuchsImage();

	@Source("ABSTRAKT_Glueck_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeGlueckImage();

	@Source("LEBENDIG_Huhn_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeHuhnImage();

	@Source("ABSTRAKT_Hunger_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeHungerImage();

	@Source("ZUSTAND_lecker_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeLeckerImage();

	@Source("LEBENDIG_Mutter_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeMutterImage();

	@Source("UNBELEBT_Pfanne_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdePfanneImage();

	@Source("ZUSTAND_schlau_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeSchlauImage();

	@Source("AKTION_stehlen_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeStehlenImage();

	@Source("ZUSTAND_schnell_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeSchnellImage();

	@Source("AKTION_suchen_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeSuchenImage();

	@Source("ZUSTAND_traurig_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeTraurigImage();

	@Source("AKTION_verstecken_Gebaerde_128x128.x2.jpg")
	public abstract ImageResource getGebaerdeVersteckenImage();

	@Source("help_icon_83x83.x2.png")
	public abstract ImageResource getCheatIconImage();

	@Source("WPS_logo_icon_80x80.x2.png")
	public abstract ImageResource getWpsLogoImage();

	@Source("delegs_memo_offer_210x210.x2.jpg")
	public abstract ImageResource getDelegsMemoOfferImage();

}