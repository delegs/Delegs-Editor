package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class TokenFactory {

	// Start counting IDs @ 0!
	private final IdFactory idFactory;
	private TextbasedTokenStyleFactory tokenStyleFactory;

	public TokenFactory(IdFactory idFactory) {
		this.idFactory = idFactory;
		tokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	public SignItemToken createEmptySignItemToken(ReadOnlyTextbasedTokenStyle tokenStyle, Color tokenBackgroundColor,
			SignLocale signLocale) {
		return createSignItemToken("", null, idFactory.createId(), tokenStyle, tokenBackgroundColor, signLocale, false,
				false);
	}

	public SignItemToken createSignItemToken(String word, ReadOnlyTextbasedTokenStyle tokenStyle,
			Color tokenBackgroundColor, SignLocale signLocale) {
		return this.createSignItemToken(word, null, tokenStyle, tokenBackgroundColor, signLocale);
	}

	public SignItemToken createSignItemToken(String word, SignItem signItem, ReadOnlyTextbasedTokenStyle tokenStyle,
			Color tokenBackgroundColor, SignLocale signLocale) {
		Id newId = idFactory.createId();
		return this.createSignItemToken(word, signItem, newId, tokenStyle, tokenBackgroundColor, signLocale, false,
				false);
	}

	public SignItemToken createSignItemToken(String word, SignItem signItem, Id tokenId,
			ReadOnlyTextbasedTokenStyle tokenStyle, Color tokenBackgroundColor, SignLocale signLocale,
			boolean isLockedLayout, boolean isLockedContent) {
		assert word != null : "Precondition failed: word != null";
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert tokenStyle != null : "Precondition failed: tokenStyle != null";

		// To be safe that we have differnt styles
		ReadOnlyTextbasedTokenStyle newStyle = tokenStyleFactory.createTextbasedTokenStyleFromStyle(tokenStyle);

		SignItemToken token = new SignItemToken(word, signItem, tokenId, newStyle, isLockedLayout, isLockedContent);
		token.setSignLocale(signLocale);
		token.setBackgroundColor(tokenBackgroundColor);

		return token;
	}

	public FreeTextToken createFreeTextLineToken(ReadOnlyTextbasedTokenStyle tokenStyle) {
		FreeTextToken freeTextToken = createFreeTextToken(tokenStyle);
		freeTextToken.setIsFreeTextLine(true);
		return freeTextToken;
	}

	public FreeTextToken createFreeTextToken(ReadOnlyTextbasedTokenStyle tokenStyle) {
		return createFreeTextToken(idFactory.createId(), tokenStyle);
	}

	public FreeTextToken createFreeTextToken(Id tokenId, ReadOnlyTextbasedTokenStyle textbasedTokenStyle) {
		return createFreeTextToken(tokenId, new String(), textbasedTokenStyle);
	}

	public FreeTextToken createFreeTextToken(Id tokenId, String freeText, ReadOnlyTextbasedTokenStyle style) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert freeText != null : "Precondition failed: freeText != null";
		assert style != null : "Precondition failed: style != null";

		ReadOnlyTextbasedTokenStyle newStyle = tokenStyleFactory.createTextbasedTokenStyleFromStyle(style);

		FreeTextToken freeTextToken = new FreeTextToken(tokenId, freeText, newStyle);
		freeTextToken.setIsFreeTextLine(false);
		return freeTextToken;
	}

	public FrameToken createFrameToken() {
		return createFrameToken(idFactory.createId());
	}

	public FrameToken createFrameToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		FrameToken frameToken = new FrameToken(tokenId);
		return frameToken;
	}

	public VideoToken createVideoToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		VideoToken videoToken = new VideoToken(tokenId);
		return videoToken;
	}

	public VideoToken createVideoToken() {
		Id tokenId = idFactory.createId();
		return createVideoToken(tokenId);
	}

	public ImageToken createImageToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		ImageToken imageToken = new ImageToken(tokenId);
		return imageToken;
	}

	public ImageToken createImageToken() {
		Id tokenId = idFactory.createId();
		return createImageToken(tokenId);
	}

	public UrlFormToken createUrlFormToken(Id tokenId, ReadOnlyTextbasedTokenStyle originalTokenStyle,
			String description, String pattern) {
		return new UrlFormToken(tokenId, originalTokenStyle, description, pattern);
	}

	private UrlFormToken createUrlFormToken(ReadOnlyTextbasedTokenStyle originalTokenStyle, String description,
			String pattern) {
		Id tokenId = idFactory.createId();
		return createUrlFormToken(tokenId, originalTokenStyle, description, pattern);
	}

	public FormToken createFormToken(Id tokenId, ReadOnlyTextbasedTokenStyle tokenStyle, String description) {
		return new FormToken(tokenId, tokenStyle, description);
	}

	public FormToken createFormToken(ReadOnlyTextbasedTokenStyle tokenStyle, String description) {
		Id tokenId = idFactory.createId();
		return createFormToken(tokenId, tokenStyle, description);
	}

	public TagToken createTagToken(Id tokenId, ReadOnlyTextbasedTokenStyle textbasedTokenStyle) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		TagToken tagToken = new TagToken(tokenId, textbasedTokenStyle);
		return tagToken;
	}

	public TagToken createTagToken(ReadOnlyTextbasedTokenStyle textbasedTokenStyle) {
		Id tokenId = idFactory.createId();
		return createTagToken(tokenId, textbasedTokenStyle);
	}

	public Token createNewTokenFromToken(Token originalToken) {
		assert originalToken != null : "Precondition failed: originalToken != null";
		Token result = null;

		ReadOnlyTextbasedTokenStyle originalTokenStyle = null;
		if (originalToken instanceof TextbasedToken) {
			originalTokenStyle = tokenStyleFactory
					.createTextbasedTokenStyleFromStyle(((TextbasedToken) originalToken).getStyle());
		}

		if (originalToken instanceof SignItemToken) {
			SignItemToken originalSignItemToken = (SignItemToken) originalToken;
			SignItemToken signItemToken = createSignItemToken(originalSignItemToken.getText(),
					originalSignItemToken.getSignItem(), originalTokenStyle, originalSignItemToken.getBackgroundColor(),
					((SignItemToken) originalToken).getLocale());
			result = signItemToken;
		} else if (originalToken instanceof FreeTextToken) {
			FreeTextToken originalFreeTextToken = (FreeTextToken) originalToken;
			FreeTextToken freeTextToken;
			if (originalFreeTextToken.isFreeTextLine()) {
				freeTextToken = createFreeTextLineToken(originalTokenStyle);
			} else {
				freeTextToken = createFreeTextToken(originalTokenStyle);
			}
			freeTextToken.setFixedWidth(originalFreeTextToken.hasFixedWidth(), originalFreeTextToken.getWidth());
			freeTextToken.setText(originalFreeTextToken.getText());
			result = freeTextToken;
		} else if (originalToken instanceof ImageToken) {
			ImageToken originalImageToken = (ImageToken) originalToken;
			ImageToken imageToken = createImageToken();
			imageToken.setUrl(originalImageToken.getUrl());
			imageToken.setHeight(originalImageToken.getHeight());
			imageToken.setWidth(originalImageToken.getWidth());
			imageToken.setBackgroundColor(originalImageToken.getBackgroundColor());
			result = imageToken;
		} else if (originalToken instanceof VideoToken) {
			VideoToken originalVideoToken = (VideoToken) originalToken;
			VideoToken videoToken = createVideoToken();
			videoToken.setUrl(originalVideoToken.getUrl());
			videoToken.setHeight(originalVideoToken.getHeight());
			videoToken.setWidth(originalVideoToken.getWidth());
			videoToken.setBackgroundColor(originalVideoToken.getBackgroundColor());
			videoToken.setUrlVisible(originalVideoToken.isUrlVisible());
			result = videoToken;
		} else if (originalToken instanceof FrameToken) {
			FrameToken originalFrameToken = (FrameToken) originalToken;
			FrameToken frameToken = createFrameToken();
			frameToken.setHeight(originalFrameToken.getHeight());
			frameToken.setWidth(originalFrameToken.getWidth());
			frameToken.setBorderWidth(originalFrameToken.getBorderWidth_PX());
			frameToken.setBackgroundColor(originalFrameToken.getBackgroundColor());
			frameToken.setFrameColor(originalFrameToken.getFrameColor());
			result = frameToken;
		} else if (originalToken instanceof UrlFormToken) {
			UrlFormToken originalUrlFormToken = (UrlFormToken) originalToken;
			UrlFormToken urlFormToken = createUrlFormToken(originalTokenStyle, originalUrlFormToken.getDescription(),
					originalUrlFormToken.getPattern());
			urlFormToken.setBackgroundColor(originalUrlFormToken.getBackgroundColor());
			urlFormToken.setDescriptionWidth(originalUrlFormToken.getDescriptionWidthPx());
			urlFormToken.setFontColor(originalUrlFormToken.getFontColor());
			urlFormToken.setInputContent(originalUrlFormToken.getInputContent());
			urlFormToken.setInputWidth(originalUrlFormToken.getInputWidthPx());
			urlFormToken.setWidthPx(originalUrlFormToken.getWidthPx());
			result = urlFormToken;
		} else if (originalToken instanceof FormToken) {
			FormToken originalFormToken = (FormToken) originalToken;
			FormToken formToken = createFormToken(originalTokenStyle, originalFormToken.getDescription());
			formToken.setBackgroundColor(originalFormToken.getBackgroundColor());
			formToken.setDescriptionWidth(originalFormToken.getDescriptionWidthPx());
			formToken.setFontColor(originalFormToken.getFontColor());
			formToken.setInputContent(originalFormToken.getInputContent());
			formToken.setInputWidth(originalFormToken.getInputWidthPx());
			formToken.setWidthPx(originalFormToken.getWidthPx());
			formToken.setPattern(originalFormToken.getPattern());
			result = formToken;
		} else if (originalToken instanceof TagToken) {
			TagToken originalTagToken = (TagToken) originalToken;
			TagToken tagToken = createTagToken(originalTokenStyle);
			tagToken.setWidth(originalTagToken.getWidth());
			tagToken.setItemList(originalTagToken.getItemList());
			tagToken.setSelectedItemList(originalTagToken.getSelectedItemList());
			result = tagToken;
		} else {
			throw new RuntimeException("Type not implemented");
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.getClass().equals(originalToken
				.getClass()) : "Postcondition failed: result instanceof result.getClass().equals(originalToken.getClass())";
		return result;
	}

    public DateFormToken createDateFormToken(Id tokenId, ReadOnlyTextbasedTokenStyle tokenStyle, String description) {
		return new DateFormToken(tokenId, tokenStyle, description);
    }
}
