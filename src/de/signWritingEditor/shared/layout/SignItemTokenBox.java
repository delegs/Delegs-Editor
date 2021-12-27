package de.signWritingEditor.shared.layout;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TokenBox;

public class SignItemTokenBox extends AbstractIdBox implements TokenBox {

	private static final int EMPTY_SIGN_HEIGHT_PX = 179;
	private static final int DEFAULT_PADDING_PX = 6;
	private static final int SEARCH_WORD_MARGIN_RIGHT_PX = 7;
	private static final int SIGN_MARGIN_TOP = 15;

	private static final int MIN_MARGIN_BETWEEN_SIGN_AND_TEXT_PX = 10;

	private List<SignItem> signItems;
	private int selectedSignIndex;
	private SignItemToken signItemToken;
	private int marginBetweenSignItemAndText_PX;
	private float textWidth;
	private FontSizeService fontSizeService;

	public SignItemTokenBox(SignItemToken token, List<SignItem> signItems, int selectedSignIndex,
			boolean searchWordVisibility, boolean signVisibility, FontSizeService fontSizeService) {
		super(token.getId());

		assert token.getText() != null : "Precondition failed: word != null";
		assert signItems != null : "Precondition failed: signItems != null";
		assert selectedSignIndex >= 0
				|| signItems.isEmpty() : "Precondition failed: selectedSignIndex >= 0 || signItems.isEmpty()";
		assert selectedSignIndex < signItems.size() || signItems
				.isEmpty() : "Precondition failed: selectedSignIndex < signItems.size() || signItems.isEmpty()";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.fontSizeService = fontSizeService;
		this.signItems = signItems;
		this.selectedSignIndex = selectedSignIndex;
		this.signItemToken = token;
		this.marginBetweenSignItemAndText_PX = MIN_MARGIN_BETWEEN_SIGN_AND_TEXT_PX;
		this.textWidth = 0;
		setSearchWordVisibility(searchWordVisibility);
		setSignVisibility(signVisibility);
	}

	public SignItemTokenBox(SignItemToken token, boolean searchWordVisibility, boolean signVisibility,
			FontSizeService fontSizeService) {
		this(token, new ArrayList<SignItem>(), -1, searchWordVisibility, signVisibility, fontSizeService);
	}

	public SignItem getSelectedSign() {
		return getSignItems().isEmpty() ? null : signItems.get(selectedSignIndex);
	}

	public void selectSign(int selectedSignIndex) {
		assert selectedSignIndex >= 0
				|| getSignItems().isEmpty() : "Precondition failed: selectedSignIndex >= 0 || getSigns().isEmpty()";
		assert selectedSignIndex < getSignItems().size() || getSignItems()
				.isEmpty() : "Precondition failed: selectedSignIndex < getSigns().size() || getSigns().isEmpty()";

		this.selectedSignIndex = selectedSignIndex;
	}

	public List<SignItem> getSignItems() {
		assert signItems != null : "Postcondition failed: signItems != null";
		return signItems;
	}

	public void setSigns(List<SignItem> signItems) {
		assert signItems != null : "Precondition failed: signItems != null";

		this.signItems = signItems;

		selectSign(signItems.isEmpty() ? -1 : 0);

		assert signItems == getSignItems() : "Postcondition failed: signItems == getSigns()";
		assert signItems.isEmpty() || getSelectedSign() == signItems
				.get(0) : "Postcondition failed: signItems.isEmpty() || getSelectedSign() == signItems.get(0)";
	}

	public String getText() {
		return signItemToken.getText();
	}

	public void setText(String word) {
		assert word != null : "Precondition failed: word != null";
		signItemToken.setText(word);
	}

	public int getSelectedSignIndex() {
		return selectedSignIndex;
	}

	public boolean getSearchWordVisibility() {
		return signItemToken.isSearchWordVisibility();
	}

	public boolean getSignVisibility() {
		return signItemToken.isSignVisibility();
	}

	@Override
	public float getWidth_PX() {
		SignItem selectedSign = getSelectedSign();

		float result = 100 - getPaddingLeft_PX() - getPaddingRight_PX();

		if (selectedSign != null) {
			int signWidth = selectedSign.getSignWidth();

			if (signWidth > 0) {
				result = signWidth + getMarginRight_PX();
			}
		}
		result = Math.max(result, textWidth + getMarginRight_PX());

		result += getPaddingLeft_PX() + getPaddingRight_PX();
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	@Override
	public int getHeight_PX() {
		return getHeightWithoutMargin_PX() + getMarginBetweenSignItemAndText_PX();
	}

	@Override
	public String toString() {
		return getText() + " (TokenId: " + getId() + ")";
	}

	public void setSearchWordVisibility(boolean visible) {
		signItemToken.setSearchWordVisibility(visible);
	}

	public boolean isSearchWordVisible() {
		return signItemToken.isSearchWordVisibility();
	}

	public void setSignVisibility(boolean visible) {
		signItemToken.setSignVisibility(visible);
	}

	public boolean isSignVisible() {
		return signItemToken.isSignVisibility();
	}

	public Color getColor() {
		return signItemToken.getFontColor();
	}

	public int getTextHeight_PX() {
		return fontSizeService.getHeight_PX(getFontMetricSpecifier());
	}

	public FontMetricSpecifier getFontMetricSpecifier() {
		return signItemToken.getStyle().getFontMetricSpecifier();
	}

	public int getSignHeight() {
		return signItemToken.getSignHeight_PX();
	}

	public void updateMarginBetweenSignItemAndText(int maxHeight) {
		marginBetweenSignItemAndText_PX = maxHeight - getTextHeight_PX() + MIN_MARGIN_BETWEEN_SIGN_AND_TEXT_PX;
	}

	public int getMarginBetweenSignItemAndText_PX() {
		return marginBetweenSignItemAndText_PX;
	}

	public int getHeightWithoutMargin_PX() {
		SignItem selectedSign = getSelectedSign();

		int selectedSignHeight_PX = EMPTY_SIGN_HEIGHT_PX;

		if (selectedSign != null) {
			selectedSignHeight_PX = signItemToken.getSignHeight_PX();
		}

		int fontHeight_PX = getTextHeight_PX();
		return fontHeight_PX + selectedSignHeight_PX;
	}

	public void setTextWidth(float width) {
		this.textWidth = width;
	}

	@Override
	public Color getBackgroundColor() {
		return signItemToken.getBackgroundColor();
	}

	public Color getTextBackgroundColor() {
		return signItemToken.getTextBackgroundColor();
	}

	public int getPaddingRight_PX() {
		return DEFAULT_PADDING_PX;
	}

	public int getPaddingLeft_PX() {
		return DEFAULT_PADDING_PX;
	}

	public int getMarginRight_PX() {
		return SEARCH_WORD_MARGIN_RIGHT_PX;
	}

	public int getFontAscent() {
		return fontSizeService.getFontAscent_PX(getFontMetricSpecifier());
	}

	public int getFontDescent_PX() {
		return fontSizeService.getFontDescent_PX(getFontMetricSpecifier());
	}

	public int getSignMarginTop() {
		return SIGN_MARGIN_TOP;
	}

	@Override
	public boolean isLockedLayout() {
		return signItemToken.isLayoutLocked();
	}

	@Override
	public boolean isContentLocked() {
		return signItemToken.isContentLocked();
	}
}
