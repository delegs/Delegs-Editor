package de.delegs.memo.client;

import static de.delegs.memo.client.resources.Resources.RESOURCES;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.delegs.memo.client.resources.Resources;

public class WpsDelegsMemo3 implements EntryPoint {

	private static final int HELP_ICON_WIDTH = 83;
	private static final int PLAYER_WIDTH = 48;
	private static final int PLAYER_STACK_WIDTH = 48;
	private static final int PLAYER_ROW_HEIGHT = 83;
	private static final int MAX_PLAYER_COUNT = 8;

	private static final int CARD_SIZE = 128;

	private static final int SPACING = 13;

	private static final int FULL_SCALE = 100;
	private static final int MOBILE_SCALE = 60;

	private static final double DIMMED_OPACITY = 0.3d;

	private static final String[] PLAYER_NAMES = {"Rot", "Orange", "Gelb", "Gr&uuml;n", "T&uuml;rkis", "Blau", "Lila",
			"Grau"};

	private static enum PlayerState {
		PASSIVE, ACTIVE;
	}

	private static enum CardState {
		HIDDEN, SHOWN, FOUND;
	}

	private boolean isVideoVersion;

	private int scale;

	private int cardPairCount;
	private int cardCount;

	private int playerTurnIndex;

	private int foundCardPairs;
	private int shownCardIndex0;
	private int shownCardIndex1;

	private AbsolutePanel mainPanel;
	private AbsolutePanel gamePanel;
	private AbsolutePanel cheatPanel;

	private SimplePanel wpsLogo;

	private int playerCount;
	private PlayerState[] playerStates;
	private int[] playerFoundPairs;
	private Button[] players;
	private SimplePanel[] playerStacks;

	private Button cheatIcon;

	private int[] cardValues;
	private int[] cardXs;
	private int[] cardYs;
	private CardState[] cardStates;
	private Button[] cards;
	private SimplePanel[] cheatCards;

	private HTML message;

	@Override
	public void onModuleLoad() {
		isVideoVersion = "true".equalsIgnoreCase(Location.getParameter("video"));

		scale = readIntParameter("scale", FULL_SCALE / 10, 2 * FULL_SCALE, //
				UiUtil.isMobileDevice() ? MOBILE_SCALE : FULL_SCALE);

		int width = Window.getClientWidth() * FULL_SCALE / scale;
		int height = Window.getClientHeight() * FULL_SCALE / scale;

		ImageResource wpsLogoImage = Resources.RESOURCES.getWpsLogoImage();
		int wpsLogoWidth = wpsLogoImage.getWidth() / 2;
		int wpsLogoHeight = wpsLogoImage.getHeight() / 2;

		playerCount = UiUtil.min(MAX_PLAYER_COUNT, //
				UiUtil.max(1, (width - wpsLogoWidth - HELP_ICON_WIDTH - 3 * SPACING) //
						/ (PLAYER_WIDTH + PLAYER_STACK_WIDTH + SPACING)));
		if (UiUtil.isMobileDevice()) {
			playerCount = UiUtil.min(playerCount, //
					UiUtil.max(1, (height - wpsLogoWidth - HELP_ICON_WIDTH - 3 * SPACING) // device rotated
							/ (PLAYER_WIDTH + PLAYER_STACK_WIDTH + SPACING)));
		}
		playerCount = readIntParameter("players", 1, playerCount, playerCount);
		playerTurnIndex = -1;

		int maxCardsPerRow = UiUtil.max(1, (width - SPACING) / (CARD_SIZE + SPACING));
		int maxCardsPerCol = UiUtil.max(1, (height - SPACING - PLAYER_ROW_HEIGHT - SPACING) // last row shows players
				/ (CARD_SIZE + SPACING));
		cardPairCount = UiUtil.min(Resources.CARD_PAIR_COUNT, UiUtil.max(1, maxCardsPerRow * maxCardsPerCol / 2));
		cardPairCount = readIntParameter("pairs", 1, cardPairCount, cardPairCount);
		cardCount = 2 * cardPairCount; // convenience

		foundCardPairs = 0;
		shownCardIndex0 = -1;
		shownCardIndex1 = -1;

		RootPanel.get().getElement().getStyle().setProperty("margin", "0px");

		mainPanel = new AbsolutePanel();
		if (scale != FULL_SCALE) {
			mainPanel.getElement().getStyle().setProperty("transform", //
					"scale(" + UiUtil.formatCssFloatingPoint((double) scale / FULL_SCALE) + ")");
			mainPanel.getElement().getStyle().setProperty("transformOrigin", "0px 0px");
		}
		RootPanel.get().add(mainPanel);

		gamePanel = new AbsolutePanel();
		gamePanel.getElement().getStyle().setProperty("background",
				"url(" + RESOURCES.getTexturImage().getSafeUri().asString() + ") repeat");
		mainPanel.add(gamePanel, 0, 0);

		cheatPanel = new AbsolutePanel();
		cheatPanel.getElement().getStyle().setProperty("background",
				"url(" + RESOURCES.getTexturImage().getSafeUri().asString() + ") repeat");
		mainPanel.add(cheatPanel, 0, 0);
		UiUtil.setOpacity(cheatPanel, 0d, false);

		wpsLogo = new SimplePanel();
		wpsLogo.setPixelSize(wpsLogoWidth, wpsLogoHeight);
		Style wpsLogoStyle = wpsLogo.getElement().getStyle();
		wpsLogoStyle.setProperty("background", //
				"url(" + wpsLogoImage.getSafeUri().asString() + ") no-repeat center transparent");
		wpsLogoStyle.setProperty("backgroundSize", //
				wpsLogoWidth + "px " + wpsLogoHeight + "px");
		wpsLogoStyle.setProperty("cursor", "pointer");
		mainPanel.add(wpsLogo);
		wpsLogo.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.open("http://www.wps.de/portfolio-items/delegs/?portfolioID=11881", "_BLANK", null);
			}
		}, ClickEvent.getType());

		playerStates = new PlayerState[playerCount];
		playerFoundPairs = new int[playerCount];
		players = new Button[playerCount];
		playerStacks = new SimplePanel[playerCount];
		for (int i = 0; i < playerCount; i++) {
			final int index = i;

			playerStates[i] = PlayerState.PASSIVE;
			playerFoundPairs[i] = 0;

			players[i] = new Button();
			players[i].setPixelSize(PLAYER_WIDTH, PLAYER_ROW_HEIGHT);
			Style playerStyle = players[i].getElement().getStyle();
			playerStyle.setProperty("border", "none");
			playerStyle.setProperty("outline", "none");
			playerStyle.setProperty("background", getPlayerImageCss(i));
			playerStyle.setProperty("cursor", "pointer");
			gamePanel.add(players[i], 0, 0);

			players[i].addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (foundCardPairs < cardPairCount) {
						message.setVisible(false);

						if (PlayerState.PASSIVE.equals(playerStates[index])) {
							activatePlayer(index);
						} else {
							deactivatePlayer(index);
						}
					}
				}
			});

			playerStacks[i] = new SimplePanel();
			playerStacks[i].setPixelSize(PLAYER_STACK_WIDTH, PLAYER_ROW_HEIGHT);
			playerStacks[i].getElement().getStyle().setProperty("background", getPlayerStackImageCss(0));
			gamePanel.add(playerStacks[i], 0, 0);
		}

		cheatIcon = new Button();
		cheatIcon.setPixelSize(HELP_ICON_WIDTH, PLAYER_ROW_HEIGHT);
		Style cheatStyle = cheatIcon.getElement().getStyle();
		cheatStyle.setProperty("border", "none");
		cheatStyle.setProperty("outline", "none");
		cheatStyle.setProperty("background",
				"url(" + RESOURCES.getCheatIconImage().getSafeUri().asString() + ") no-repeat 0px 0px");
		cheatStyle.setProperty("backgroundSize", HELP_ICON_WIDTH + "px " + PLAYER_ROW_HEIGHT + "px");
		cheatStyle.setProperty("cursor", "pointer");
		UiUtil.setOpacity(cheatIcon, DIMMED_OPACITY, true);
		mainPanel.add(cheatIcon, 0, 0);

		cheatIcon.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				toggleCheatPanel();
			}
		});

		List<Integer> randomCardValues = new ArrayList<Integer>();
		for (int i = 0; i < cardCount; i++) {
			randomCardValues.add(Random.nextInt(randomCardValues.size() + 1), i);
		}
		cardValues = new int[cardCount];
		cardXs = new int[cardCount];
		cardYs = new int[cardCount];
		cardStates = new CardState[cardCount];
		cards = new Button[cardCount];
		cheatCards = new SimplePanel[cardCount];
		for (int i = 0; i < cardCount; i++) {
			final int index = i;

			cardValues[i] = randomCardValues.get(i);
			cardStates[i] = CardState.HIDDEN;

			cards[i] = (Button) createCard(i, true, cardValues[index], (357 + Random.nextInt(7)) % 360, false);
			gamePanel.add(cards[i], 0, 0);

			cards[i].addMouseOverHandler(new MouseOverHandler() {
				@Override
				public void onMouseOver(MouseOverEvent event) {
					if (foundCardPairs < cardPairCount && !CardState.FOUND.equals(cardStates[index])) {
						cards[index].getElement().getStyle().setProperty("borderWidth", "2px");
					}
				}
			});

			cards[i].addMouseOutHandler(new MouseOutHandler() {
				@Override
				public void onMouseOut(MouseOutEvent event) {
					if (foundCardPairs < cardPairCount && !CardState.FOUND.equals(cardStates[index])) {
						cards[index].getElement().getStyle().setProperty("borderWidth", "1px");
					}
				}
			});

			cards[i].addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (foundCardPairs < cardPairCount) {
						message.setVisible(false);

						if (CardState.HIDDEN.equals(cardStates[index])) {
							showCard(index);
						} else if (CardState.SHOWN.equals(cardStates[index])) {
							hideCard();
						}
					}
				}
			});

			cheatCards[i] = (SimplePanel) createCard(i, false, i, i % 2 == 0 ? 6 : 2, true);
			cheatPanel.add(cheatCards[i], 0, 0);
		}

		message = new HTML(isVideoVersion
				? getVideoHtml("bCpUGQwp23s")
				: "<div style='padding-bottom:6px;font-size:30px;'>" //
						+ "<b>delegs-MEMO</b></div>" //
						+ "<ul><li>W&auml;hle Deine Spielfigur.</li>" //
						+ "<li><b>Finde Kartenpaare, bei denen Bild und Text <br>" //
						+ "mit der Geb&auml;rde &uuml;bereinstimmen!</b></li>"
						+ "<li>Tippe die Karten an, die Du umdrehen m&ouml;chtest.</li>" //
						+ "<li>Wer die meisten Kartenpaare findet, gewinnt!</li>" //
						+ "<li>Der Spieler mit der markierten Spielfigur beginnt.</li></ul>");
		Style messageStyle = message.getElement().getStyle();
		messageStyle.setProperty("fontSize", "20px");
		messageStyle.setProperty("color", "#ffffff");
		messageStyle.setProperty("backgroundColor", "#47adbb");
		messageStyle.setProperty("border", "none");
		messageStyle.setProperty("padding", "20px");
		gamePanel.add(message, 0, 0);

		message.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (foundCardPairs < cardPairCount) {
					message.setVisible(false);
				}
			}
		});

		rearrangeWidgets();
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				rearrangeWidgets();
			}
		});
	}

	private String getVideoHtml(String videoId) {
		assert videoId != null : "Precondition failed: videoId != null";
		return "<iframe style='margin: 0px;' width='554' height='315' src='http://www.youtube.com/embed/" + videoId
				+ "?hl=de&fs=1&start=0&showinfo=0&rel=0&autoplay=1' frameborder='0' allowfullscreen></iframe>";
	}

	private Widget createCard(int index, boolean isActive, int cardValue, int rotateDeg, boolean isShown) {
		assert rotateDeg >= 0 : "Precondition failed: rotateDeg >= 0";
		assert rotateDeg < 360 : "Precondition failed: rotateDeg < 360";

		Widget result = isActive ? new Button() : new SimplePanel();
		result.setPixelSize(CARD_SIZE, CARD_SIZE);
		String cardUrl = isShown //
				? Resources.Access.getCardImage(cardValue).getSafeUri().asString() //
				: RESOURCES.getCardBackImage().getSafeUri().asString();
		Style style = result.getElement().getStyle();
		style.setProperty("border", "1px solid #777777");
		style.setProperty("outline", "none");
		style.setProperty("background", "url(" + cardUrl + ") no-repeat 0px 0px");
		style.setProperty("backgroundSize", "contain");
		UiUtil.setCss3StyleAttribute(result, "transform", "rotate(" + rotateDeg + "deg)");
		style.setProperty("cursor", "pointer");
		UiUtil.setBorderRadius(result, 11);
		UiUtil.setBoxShadow(result, 2, 2, 6, "rgba(0, 0, 0, 0.5)");

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void toggleCheatPanel() {
		if (cheatPanel.isVisible()) {
			UiUtil.setOpacity(cheatPanel, 0d, false);
			UiUtil.setOpacity(gamePanel, 1d, false);

			UiUtil.setOpacity(cheatIcon, DIMMED_OPACITY, false);
		} else {
			message.setVisible(false);

			UiUtil.setOpacity(gamePanel, 0d, false);
			UiUtil.setOpacity(cheatPanel, 1d, false);

			UiUtil.setOpacity(cheatIcon, 1d, false);
		}

		rearrangeWidgets();
	}

	private String getPlayerStackImageCss(int pairCount) {
		assert pairCount >= 0 : "Precondition failed: pairCount >= 0";
		assert pairCount <= cardPairCount : "Precondition failed: pairCount <= cardPairCount";
		return "url(" + RESOURCES.getStapelImage().getSafeUri().asString() + ") no-repeat "
				+ (-PLAYER_STACK_WIDTH * (Resources.CARD_PAIR_COUNT - pairCount)) + "px 0px";
	}

	private String getPlayerImageCss(int index) {
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index < playerCount : "Precondition failed: index < playerCount";
		return "url(" + RESOURCES.getSpielerImage().getSafeUri().asString() + ") no-repeat "
				+ (index == playerTurnIndex ? -2 * PLAYER_WIDTH : -PLAYER_WIDTH * playerStates[index].ordinal()) + "px "
				+ (-PLAYER_ROW_HEIGHT * index) + "px";
	}

	private void activatePlayer(int index) {
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index < playerCount : "Precondition failed: index < playerCount";

		playerStates[index] = PlayerState.ACTIVE;
		if (playerTurnIndex < 0) {
			turnToNextPlayer();
		}

		players[index].getElement().getStyle().setProperty("background", getPlayerImageCss(index));
	}

	private void deactivatePlayer(int index) {
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index < playerCount : "Precondition failed: index < playerCount";

		if (shownCardIndex0 < 0 || index != playerTurnIndex) {
			if (index == playerTurnIndex) {
				turnToNextPlayer();
			}
			playerStates[index] = PlayerState.PASSIVE;

			players[index].getElement().getStyle().setProperty("background", getPlayerImageCss(index));
		}
	}

	private void turnToNextPlayer() {
		int lastPlayerTurnIndex = playerTurnIndex;
		int stopIndex = (playerCount + playerTurnIndex) % playerCount;

		int i = (playerTurnIndex + 1) % playerCount;
		while (i != stopIndex && PlayerState.PASSIVE.equals(playerStates[i])) {
			i = (i + 1) % playerCount;
		}

		if (i == stopIndex && (playerTurnIndex < 0 || PlayerState.PASSIVE.equals(playerStates[playerTurnIndex]))) {
			playerTurnIndex = -1;
		} else {
			playerTurnIndex = i;

			players[playerTurnIndex].getElement().getStyle().setProperty("background",
					getPlayerImageCss(playerTurnIndex));
		}

		if (lastPlayerTurnIndex >= 0) {
			players[lastPlayerTurnIndex].getElement().getStyle().setProperty("background",
					getPlayerImageCss(lastPlayerTurnIndex));
		}
	}

	private void showCard(final int index) {
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index < cardCount : "Precondition failed: index < cardCount";

		if (shownCardIndex1 < 0) {
			cards[index].getElement().getStyle().setProperty("background", //
					"url(" + Resources.Access.getCardImage(cardValues[index]).getSafeUri().asString() //
							+ ") no-repeat 0px 0px");
			cards[index].getElement().getStyle().setProperty("backgroundSize", "contain");

			cardStates[index] = CardState.SHOWN;

			if (shownCardIndex0 < 0) {
				shownCardIndex0 = index;
			} else {
				shownCardIndex1 = index;
			}
		}
	}

	private void hideCard() {
		if (shownCardIndex1 >= 0) {
			if (cardValues[shownCardIndex0] / 2 == cardValues[shownCardIndex1] / 2) {
				foundCardPairs++;

				cardStates[shownCardIndex0] = CardState.FOUND;
				cardStates[shownCardIndex1] = CardState.FOUND;

				cards[shownCardIndex0].getElement().getStyle().setProperty("cursor", "default");
				cards[shownCardIndex1].getElement().getStyle().setProperty("cursor", "default");

				UiUtil.setOpacity(cards[shownCardIndex0], DIMMED_OPACITY, true);
				UiUtil.setOpacity(cards[shownCardIndex1], DIMMED_OPACITY, true);

				if (playerTurnIndex >= 0) {
					playerFoundPairs[playerTurnIndex]++;

					playerStacks[playerTurnIndex].getElement().getStyle().setProperty("background",
							getPlayerStackImageCss(playerFoundPairs[playerTurnIndex]));
				}

				if (foundCardPairs >= cardPairCount) {
					highlightWinner();
				}
			} else {
				cards[shownCardIndex0].getElement().getStyle().setProperty("background", //
						"url(" + RESOURCES.getCardBackImage().getSafeUri().asString() + ") no-repeat 0px 0px");
				cards[shownCardIndex0].getElement().getStyle().setProperty("backgroundSize", "contain");

				cards[shownCardIndex1].getElement().getStyle().setProperty("background", //
						"url(" + RESOURCES.getCardBackImage().getSafeUri().asString() + ") no-repeat 0px 0px");
				cards[shownCardIndex1].getElement().getStyle().setProperty("backgroundSize", "contain");

				cardStates[shownCardIndex0] = CardState.HIDDEN;
				cardStates[shownCardIndex1] = CardState.HIDDEN;

				turnToNextPlayer();
			}

			shownCardIndex0 = -1;
			shownCardIndex1 = -1;
		}
	}

	private void highlightWinner() {
		int maxPlayerFoundCards = 0;

		// remove turn mark
		if (playerTurnIndex >= 0) {
			int i = playerTurnIndex;
			playerTurnIndex = -1;
			activatePlayer(i);
		}

		// dim all players and determine maximum of found cards
		for (int i = 0; i < playerCount; i++) {
			UiUtil.setOpacity(players[i], DIMMED_OPACITY, true);

			players[i].getElement().getStyle().setProperty("cursor", "default");
			if (maxPlayerFoundCards < playerFoundPairs[i]) {
				maxPlayerFoundCards = playerFoundPairs[i];
			}
		}

		int lastPlayerTurnIndex = playerTurnIndex;

		// determine winner (if any) and un-dim top players
		String winnerName = null;
		if (maxPlayerFoundCards > 0) {
			for (int i = 0; i < playerCount; i++) {
				if (maxPlayerFoundCards <= playerFoundPairs[i]) {
					if (winnerName == null) {
						winnerName = PLAYER_NAMES[i];
						playerTurnIndex = i;
					} else {
						winnerName = "";
						playerTurnIndex = -1;
					}

					UiUtil.setOpacity(players[i], 1d, true);
				}
			}
		}

		if (playerTurnIndex >= 0) {
			players[playerTurnIndex].getElement().getStyle().setProperty("background",
					getPlayerImageCss(playerTurnIndex));
		}

		if (lastPlayerTurnIndex >= 0) {
			players[lastPlayerTurnIndex].getElement().getStyle().setProperty("background",
					getPlayerImageCss(lastPlayerTurnIndex));
		}

		// announce winner / tie
		String winnerHtml = null;
		if (isVideoVersion) {
			if (winnerName == null) {
				winnerHtml = getVideoHtml("wL5NO9IGYN4");
			} else if (winnerName.isEmpty()) {
				winnerHtml = getVideoHtml("9RkaERioiys");
			} else if (playerTurnIndex == 0) {
				winnerHtml = getVideoHtml("WEBQthWEDX0");
			} else if (playerTurnIndex == 1) {
				winnerHtml = getVideoHtml("ab5HVjKdK4A");
			} else if (playerTurnIndex == 2) {
				winnerHtml = getVideoHtml("E1Df5itMias");
			} else if (playerTurnIndex == 3) {
				winnerHtml = getVideoHtml("vDvajRHyDzM");
			} else if (playerTurnIndex == 4) {
				winnerHtml = getVideoHtml("PpXY1d0Zt5M");
			} else if (playerTurnIndex == 5) {
				winnerHtml = getVideoHtml("dhMf_etvusc");
			} else if (playerTurnIndex == 6) {
				winnerHtml = getVideoHtml("A_AjPJPTKeA");
			} else if (playerTurnIndex == 7) {
				winnerHtml = getVideoHtml("C5ZRyVCnAPc");
			}
			winnerHtml += "<br><a style='padding-top: 20px; display: inline-block; text-align: center; width: 554px;' "
					+ " href=''>NOCH EINMAL!</a>";
		} else {
			if (winnerName == null) {
				winnerHtml = "Bravo!";
			} else if (winnerName.isEmpty()) {
				winnerHtml = "Unentschieden!";
			} else {
				winnerHtml = "Spieler <b>" + winnerName + "</b> hat gewonnen!";
			}
			ImageResource delegsMemoOfferImage = Resources.RESOURCES.getDelegsMemoOfferImage();
			winnerHtml = "<div style='padding-bottom: 6px; font-size: 30px; color: #ffffff; width: 315px'>" + winnerHtml
					+ "</div>" //
					+ "<a href=''>NOCH EINMAL!</a><br><br><br>"
					+ "<a href='mailto:info@delegs.de?subject=delegs-Memo%20bestellen&body=Hallo%20delegs-Team,%0D%0A%0D%0Aich%20möchte%20gerne%20ein%20delegs-Memo%20für%2012,90%20Euro,%20zzgl.%205%20Euro%20Versand%20bestellen.%20Bitte%20senden%20Sie%20mir%20alle%20Informationen%20zu%20Bezahlung%20und%20Versand.%0D%0A%0D%0AMeine%20Adresse lautet:%0D%0A%0D%0ADanke%20und%20Gruß,'>"
					+ "<img width='315px' height='315px' src='" + delegsMemoOfferImage.getSafeUri().asString()
					+ "' /></a>";
		}
		message.setHTML(winnerHtml);
		message.setVisible(true);

		rearrangeWidgets();
	}

	private void rearrangeWidgets() {
		final int width = Window.getClientWidth() * FULL_SCALE / scale;
		final int height = Window.getClientHeight() * FULL_SCALE / scale;

		mainPanel.setPixelSize(width, height);
		gamePanel.setPixelSize(width, height);
		cheatPanel.setPixelSize(width, height);

		mainPanel.setWidgetPosition(wpsLogo, SPACING, height - SPACING - wpsLogo.getOffsetHeight());

		int halfPlayerSpacing = (width - wpsLogo.getOffsetWidth() - HELP_ICON_WIDTH - 4 * SPACING
				- playerCount * (PLAYER_WIDTH + PLAYER_STACK_WIDTH)) / playerCount / 2;
		int firstPlayerLeft = 2 * SPACING + wpsLogo.getOffsetWidth() + halfPlayerSpacing;
		for (int i = 0; i < playerCount; i++) {
			gamePanel.setWidgetPosition(players[i],
					firstPlayerLeft + (2 * halfPlayerSpacing + PLAYER_WIDTH + PLAYER_STACK_WIDTH) * i, //
					height - SPACING - PLAYER_ROW_HEIGHT);

			gamePanel.setWidgetPosition(playerStacks[i],
					firstPlayerLeft + PLAYER_STACK_WIDTH
							+ (2 * halfPlayerSpacing + PLAYER_WIDTH + PLAYER_STACK_WIDTH) * i, //
					height - SPACING - PLAYER_ROW_HEIGHT);
		}

		mainPanel.setWidgetPosition(cheatIcon, width - SPACING - HELP_ICON_WIDTH,
				height - SPACING - cheatIcon.getOffsetHeight());

		// actual cards

		int cardsPerRow = (width - SPACING) / (CARD_SIZE + SPACING);
		if (cardsPerRow < 1) {
			cardsPerRow = 1;
		} else if (cardsPerRow > cardCount) {
			cardsPerRow = cardCount;
		}
		int maxCardsPerCol = (cardCount + cardsPerRow - 1) / cardsPerRow;
		if (maxCardsPerCol < 2) {
			maxCardsPerCol = 2;
		}
		cardsPerRow = (cardCount + maxCardsPerCol - 1) / maxCardsPerCol;
		int totalCardsWidth = (CARD_SIZE + SPACING) * cardsPerRow - SPACING;
		int totalCardsHeight = (CARD_SIZE + SPACING) * maxCardsPerCol - SPACING;
		int cardsOffsX = (width - totalCardsWidth - 2 * SPACING) / 2;
		int cardsOffsY = (height - totalCardsHeight - PLAYER_ROW_HEIGHT - 3 * SPACING) / 2;
		for (int y = 0; y < maxCardsPerCol; y++) {
			for (int x = 0; x < cardsPerRow; x++) {
				int i = y * cardsPerRow + x;
				if (i < cardCount) {
					int cardX = cardsOffsX + SPACING + (SPACING + CARD_SIZE) * x;
					int cardY = cardsOffsY + SPACING + (SPACING + CARD_SIZE) * y;

					cards[i].setPixelSize(CARD_SIZE, CARD_SIZE);
					cardXs[i] = cardX + Random.nextInt(5) - 2;
					cardYs[i] = cardY + Random.nextInt(5) - 2;
					gamePanel.setWidgetPosition(cards[i], cardXs[i], cardYs[i]);
				}
			}
		}

		// cheat cards

		int cheatCardSize = CARD_SIZE;
		int cheatCardsPerRow = ((width - SPACING) / (cheatCardSize + SPACING) / 2) * 2;
		if (cheatCardsPerRow < 2) {
			cheatCardsPerRow = 2;
		} else if (cheatCardsPerRow > cardCount) {
			cheatCardsPerRow = cardCount;
		}
		int maxCheatCardsPerCol = (cardCount + cheatCardsPerRow - 1) / cheatCardsPerRow;
		int totalCheatCardsWidth = (cheatCardSize + SPACING) * cheatCardsPerRow - SPACING;
		int totalCheatCardsHeight = (cheatCardSize + SPACING) * maxCheatCardsPerCol - SPACING;
		int cheatCardsOffsX = (width - totalCheatCardsWidth - 2 * SPACING) / 2;
		int cheatCardsOffsY = (height - totalCheatCardsHeight - PLAYER_ROW_HEIGHT - 3 * SPACING) / 2;
		for (int y = 0; y < maxCheatCardsPerCol; y++) {
			for (int x = 0; x < cheatCardsPerRow; x++) {
				int i = y * cheatCardsPerRow + x;
				if (i < cardCount) {
					int cheatCardX = cheatCardsOffsX + ((i + 1) % 2) * 2 * SPACING + (SPACING + cheatCardSize) * x;
					int cheatCardY = cheatCardsOffsY + SPACING + (SPACING + cheatCardSize) * y;

					cheatCards[i].setPixelSize(cheatCardSize, cheatCardSize);
					cheatCards[i].getElement().getStyle().setProperty("zIndex", "" + (1000 - i));
					cheatPanel.setWidgetPosition(cheatCards[i], cheatCardX + 2 * (i % 2), cheatCardY + 4 - (i % 2) * 8);
				}
			}
		}

		gamePanel.setWidgetPosition(message, //
				((width - message.getOffsetWidth()) / 2), //
				((height - message.getOffsetHeight()) / 3));
	}

	private int readIntParameter(String parameterName, int minValue, int maxValue, int defaultValue) {
		assert parameterName != null : "Precondition failed: parameterName != null";
		assert minValue <= maxValue : "Precondition failed: minValue <= maxValue: " + minValue + ", " + maxValue;
		assert defaultValue >= minValue : "Precondition failed: defaultValue >= minValue";
		assert defaultValue <= maxValue : "Precondition failed: defaultValue <= maxValue";

		int result = defaultValue;
		try {
			result = Integer.parseInt(Location.getParameter(parameterName));
		} catch (NumberFormatException e) {
			// blubber
		}
		if (result < minValue || result > maxValue) {
			result = defaultValue;
		}
		assert result >= minValue : "Postcondition failed: result >= minValue";
		assert result <= maxValue : "Postcondition failed: result <= maxValue";
		return result;
	}
}
