package de.signWritingEditor.shared.layout;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.material.*;

public class TokenBoxFactory {

    private static final int RESIZABLE_TOKEN_BOX_MIN_WIDTH = 100;
    private FontSizeService fontSizeService;
    private int pageHeight;

    public TokenBoxFactory(FontSizeService fontSizeService) {
        this.fontSizeService = fontSizeService;
        // initial pageHeight is -1, to indicate it has not been set yet
        this.pageHeight = -1;
    }

    public TokenBox create(Token token, boolean searchWordVisible, boolean signVisible, int paragraphWidth) {
        return create(token, searchWordVisible, signVisible, true, paragraphWidth);
    }

    public TokenBox create(Token token, boolean searchWordVisible, boolean signVisible, boolean clearSign,
                           int paragraphWidth) {
        if (token instanceof SignItemToken) {
            return createSignItemTokenBox(token, searchWordVisible, signVisible, clearSign);
        } else if (token instanceof FreeTextToken) {
            return createFreeTextTokenBox(token, paragraphWidth);
        } else if (token instanceof FrameToken) {
            return createFrameTokenBox(token, paragraphWidth);
        } else if (token instanceof VideoToken) {
            return createVideoTokenBox(token, paragraphWidth);
        } else if (token instanceof ImageToken) {
            return createImageTokenBox(token, paragraphWidth);
        } else if (token instanceof DateFormToken) {
            return createDateFormTokenBox(token);
        } else if (token instanceof UrlFormToken) {
            return createUrlFormTokenBox(token);
        } else if (token instanceof FormToken) {
            return createFormTokenBox(token);
        } else if (token instanceof TagToken) {
            return createTagTokenBox(token);
        } else {
            throw new RuntimeException("unexpected token-type");
        }
    }

    private DateFormTokenBox createDateFormTokenBox(Token token) {
        return new DateFormTokenBox((DateFormToken) token, fontSizeService);
    }

    private FrameTokenBox createFrameTokenBox(Token token, int paragraphWidth) {
        assert pageHeight > 0 : "Precondition failed: pageHeight > 0";
        return new FrameTokenBox((FrameToken) token, RESIZABLE_TOKEN_BOX_MIN_WIDTH, paragraphWidth, pageHeight);
    }

    private ImageTokenBox createImageTokenBox(Token token, int paragraphWidth) {
        return new ImageTokenBox((ImageToken) token, RESIZABLE_TOKEN_BOX_MIN_WIDTH, paragraphWidth, getPageHeight());
    }

    private TagTokenBox createTagTokenBox(Token token) {
        return new TagTokenBox((TagToken) token, fontSizeService);
    }

    private VideoTokenBox createVideoTokenBox(Token token, int paragraphWidth) {
        return new VideoTokenBox((VideoToken) token, RESIZABLE_TOKEN_BOX_MIN_WIDTH, paragraphWidth, getPageHeight());
    }

    private TokenBox createFreeTextTokenBox(Token token, int maxLineWidth) {
        FreeTextToken freeTextToken = (FreeTextToken) token;

        return new FreeTextTokenBox(freeTextToken, freeTextToken.isVisible(), RESIZABLE_TOKEN_BOX_MIN_WIDTH,
                maxLineWidth, getPageHeight(), fontSizeService);
    }

    private FormTokenBox createFormTokenBox(Token token) {
        return new FormTokenBox((FormToken) token, fontSizeService);
    }

    private UrlFormTokenBox createUrlFormTokenBox(Token token) {
        return new UrlFormTokenBox((UrlFormToken) token, fontSizeService);
    }

    private TokenBox createSignItemTokenBox(Token token, boolean searchWordVisible, boolean signVisible,
                                            boolean clearSign) {
        SignItemTokenBox box = new SignItemTokenBox((SignItemToken) token, searchWordVisible, signVisible,
                fontSizeService);
        if (!clearSign) {
            List<SignItem> signList = new ArrayList<SignItem>();
            signList.add(((SignItemToken) token).getSignItem());
            box.setSigns(signList);
        }
        return box;
    }

    private int getPageHeight() {
        assert pageHeight > 0 : "Postcondition failed: pageHeight > 0";
        return pageHeight;
    }

    public void setPageHeight(int pageHeight) {
        assert pageHeight > 0 : "Precondition failed: pageHeight > 0";
        this.pageHeight = pageHeight;
    }

}
