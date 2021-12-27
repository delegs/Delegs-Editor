package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.MediaElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.SourceElement;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ProgressBar;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.VisibilityListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.VideoTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.TokenBox;

public class VideoTokenBoxWidget extends AbstractTextbasedTokenBoxWidget {

    private static final String URL_BOX_STYLE_NAME = "urlBoxWidget";
    public static final int SIDE_RATIO_X = 16;
    public static final int SIDE_RATIO_Y = 10;
    private VideoTokenBox videoTokenBox;
    private String oldText;
    private final ExtendedRichTextArea urlTextBox;
    private final Video video;
    private final FlowPanel contentPanel;
    private FlowPanel videoWrapperPanel;
    private final FlowPanel videoPanel;
    private final FlowPanel buttonPanel;
    private final Timer timer;
    private final VideoListener videoListener;
    private final FontMetricSpecifier fontMetricSpecifier;
    private final URLConverter urlConverter;
    private final ProgressBar progressBar;
    private final Label progressPercentageText;
    private final Label progressTextAbove;
    private final Label progressTextUnder;

    public VideoTokenBoxWidget(VideoTokenBox videoTokenBox, URLConverter urlConverter, final VideoListener listener,
            EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
        assert videoTokenBox != null : "Precondition failed: videoTokenBox != null";
        assert urlConverter != null : "Precondition failed: urlConverter != null";
        assert listener != null : "Precondition failed: listener != null";
        assert eventTranslator != null : "Precondition failed: eventTranslator != null";
        assert fontSizeService != null : "Precondition failed: fontSizeService != null";

        this.videoTokenBox = videoTokenBox;
        this.urlConverter = urlConverter;
        this.videoListener = listener;

        progressTextAbove = new HTML(I18NAccess.I18N.getProgressBarTextAbove());
        progressTextAbove.setVisible(false);
        progressTextAbove.addStyleName("videoTokenUploadProgressTextAbove");

        progressBar = new ProgressBar(0.0, 1.0);
        progressBar.addStyleName("videoTokenUploadProgressBar");
        progressBar.setVisible(false);

        progressPercentageText = new Label("0 %");
        progressPercentageText.addStyleName("videoTokenUploadProgressPercentageText");
        progressPercentageText.setVisible(false);

        FlowPanel progressBarPanel = new FlowPanel();
        progressBarPanel.add(progressBar);
        progressBarPanel.add(progressPercentageText);
        progressBarPanel.addStyleName("videoTokenUploadProgressPanel");

        progressTextUnder = new HTML(I18NAccess.I18N.getProgressBarTextUnder());
        progressTextUnder.setVisible(false);
        progressTextUnder.addStyleName("videoTokenUploadProgressTextUnder");

        FlowPanel progressWrapperPanel = new FlowPanel();
        progressWrapperPanel.add(progressTextAbove);
        progressWrapperPanel.add(progressBarPanel);
        progressWrapperPanel.add(progressTextUnder);
        progressWrapperPanel.addStyleName("progressWrapperPanel");

        contentPanel = new FlowPanel();

        timer = new Timer() {
            @Override
            public void run() {
                this.cancel();
                checkDelegsVideoSource();
            }
        };
        int videoTokenBoxWidth = fontSizeService
                .getPixelSize(videoTokenBox.getWidth_PX() - videoTokenBox.getMarginRight_PX());
        int videoTokenBoxHeight = fontSizeService.getPixelSize(videoTokenBox.getHeight_PX()
                - videoTokenBox.getURLBoxHeight_PX() - videoTokenBox.getButtonPanelHeight());

        buttonPanel = new FlowPanel();
        buttonPanel.addStyleName("buttonPanel");
        // videoTokenBoxWidth +2 because off dashed border around video
        buttonPanel.setPixelSize(videoTokenBoxWidth + 2, videoTokenBox.getButtonPanelHeight());
        buttonPanel.getElement().getStyle().setPosition(Position.RELATIVE);
        buttonPanel.getElement().getStyle().setMarginBottom(videoTokenBox.getMarginBetweenVideoAndTextPX(), Unit.PX);

        addResizeButtonToPanel(buttonPanel);

        fontMetricSpecifier = new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL, FontSize.SIZE_13,
                FontWeight.NORMAL);

        urlTextBox = new ExtendedRichTextArea(eventTranslator, fontSizeService);
        urlTextBox.setReadOnly(true);
        urlTextBox.getElement().setId(DocumentPanel.ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR);
        // videoTokenBoxWidth +2 because off dashed border around video
        urlTextBox.setPixelSize(videoTokenBoxWidth + 2, videoTokenBox.getURLBoxHeight_PX());

        if (videoTokenBox.isLockedLayout() && !videoTokenBox.isContentLocked()) {
            urlTextBox.addStyleName("freeTextLineTemplate");
        } else {
            urlTextBox.addStyleName(URL_BOX_STYLE_NAME);
        }

        urlTextBox.addMouseDownHandler(event -> handleSelectVideoToken(event.getNativeEvent().getShiftKey(), false));

        urlTextBox.addDoubleClickHandler(event -> {
            handleSelectVideoToken(false, false);
            handleSelectVideoToken(true, true);
        });

        contentPanel.getElement().getStyle().setMarginRight(videoTokenBox.getMarginRight_PX(), Unit.PX);

        urlTextBox.addKeyDownHandler(this::handleKeyDownEvent);

        urlTextBox.addPasteHandler(event -> handlePaste());

        videoPanel = new FlowPanel();
        videoPanel.setPixelSize(videoTokenBoxWidth, videoTokenBoxHeight);
        videoPanel.addStyleName("basicTokenBorder");
        videoPanel.addStyleName("videoPanel");

        this.oldText = null;
        video = Video.createIfSupported();

        if (video == null) {
            assert false : "Precondition failed video not supported";
        } else {
            video.setMuted(true);
            video.setControls(true);
            if (videoTokenBox.getUrl() == null || videoTokenBox.getUrl().equals("")) {
                String imageString = generateErrorImageURL(I18NAccess.I18N.getNoVideoFound());
                video.setPoster(imageString);
            } else {
                checkVideoSource();
            }
            video.setPreload(MediaElement.PRELOAD_NONE);
            video.getElement().getStyle().setFloat(Float.LEFT);
            video.getElement().getStyle().setBackgroundColor("black");

            videoWrapperPanel = new FlowPanel();
            videoWrapperPanel.add(video);
            videoWrapperPanel.setWidth(videoTokenBoxWidth + "px");
            videoWrapperPanel.setHeight(videoTokenBoxHeight + "px");
            video.setSize("100%", "100%");

            videoPanel.add(videoWrapperPanel);
            video.addLoadedMetadataHandler(event -> {
                videoWrapperPanel.setWidth(video.getVideoWidth() + "px");
                videoWrapperPanel.setHeight(video.getVideoHeight() + "px");
                scaleVideoToFitToken();
            });

            video.addClickHandler(event -> handleOnClick());

            addVideoOnClickHandlerForFirefox(video.getElement());
        }

        videoPanel.add(progressWrapperPanel);

        contentPanel.add(videoPanel);
        contentPanel.add(buttonPanel);
        contentPanel.add(urlTextBox);
        contentPanel.setPixelSize(videoTokenBoxWidth, videoTokenBox.getHeight_PX());

        initWidget(contentPanel);
    }

    private void handleOnClick() {
        videoListener.onSelectToken(getId(), false);
    }

    private native void addVideoOnClickHandlerForFirefox(Element video)/*-{
        var videoWidget = this;

        var onClickHandler = function (event) {
            videoWidget.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::handleOnClick()();
        }

        video.onplay = onClickHandler;

        video.onpause = onClickHandler;

    }-*/;

    private void scaleVideoToFitToken() {
        float tokenWidth = videoTokenBox.getWidth_PX() - videoTokenBox.getMarginRight_PX();
        float tokenHeight = videoTokenBox.getHeight_PX() - videoTokenBox.getURLBoxHeight_PX()
                - videoTokenBox.getButtonPanelHeight();

        float widthScale = tokenWidth / SIDE_RATIO_X;
        float heightScale = tokenHeight / SIDE_RATIO_Y;

        if (heightScale * SIDE_RATIO_X < tokenWidth) {
            videoWrapperPanel.setWidth((heightScale * SIDE_RATIO_X) + "px");
            videoWrapperPanel.setHeight((heightScale * SIDE_RATIO_Y) + "px");
        } else {
            videoWrapperPanel.setWidth((widthScale * SIDE_RATIO_X) + "px");
            videoWrapperPanel.setHeight((widthScale * SIDE_RATIO_Y) + "px");
        }

        int offsetWidth = videoWrapperPanel.getOffsetWidth();
        int offsetHeight = videoWrapperPanel.getOffsetHeight();

        float xIndex = 0;
        float yIndex = 21;

        if (0 < offsetWidth) {
            xIndex = (tokenWidth - offsetWidth) / 2;
        }
        if (0 < offsetHeight) {
            yIndex = (tokenHeight - offsetHeight) / 2;
        }

        videoWrapperPanel.getElement().getStyle().setPosition(Position.RELATIVE);
        videoWrapperPanel.getElement().getStyle().setLeft(xIndex, Unit.PX);
        videoWrapperPanel.getElement().getStyle().setTop(yIndex, Unit.PX);
    }

    @Override
    protected void setTokenBoxSize(int width, int height) {
        int newWidth = getVideoTokenBoxWidgetMaxWidth();
        height += videoTokenBox.getURLBoxHeight_PX();
        if (isLessOrEqlMaxWidth(width)) {
            newWidth = width;
        }

        if (isLessThenMinWidth(newWidth)) {
            newWidth = videoTokenBox.getMinWidth();
        }

        int newHeight = videoTokenBox.getMinHeight();

        if (isGreaterMinHeight(height)) {
            newHeight = height;
        }

        if (newHeight > getMaxImageHeight()) {
            newHeight = getMaxImageHeight();
        }

        videoTokenBox.setWidth(newWidth);
        videoTokenBox.setHeight(newHeight);
        setTokenBox(videoTokenBox);
        videoListener.onResizeToken(getId());
        scaleVideoToFitToken();
    }

    private int getMaxImageHeight() {
        return videoTokenBox.getMaxHeight() - videoTokenBox.getURLBoxHeight_PX() - videoTokenBox.getButtonPanelHeight();
    }

    private boolean isGreaterMinHeight(int height) {
        return height > videoTokenBox.getMinHeight();
    }

    private boolean isLessThenMinWidth(int newWidth) {
        return newWidth < videoTokenBox.getMinWidth();
    }

    private boolean isLessOrEqlMaxWidth(int width) {
        return width <= getVideoTokenBoxWidgetMaxWidth();
    }

    private int getVideoTokenBoxWidgetMaxWidth() {
        return videoTokenBox.getMaxWidth() - videoTokenBox.getMarginRight_PX();
    }

    protected void handleKeyDownEvent(KeyDownEvent event) {
        assert event != null : "Precondition failed: event != null";
        switch (event.getNativeKeyCode()) {
            case KeyCodes.KEY_BACKSPACE:
                handleKeyBackspaceEvent(event);
                break;
            case KeyCodes.KEY_DELETE:
                handleKeyDeleteEvent(event);
                break;
            case KeyCodes.KEY_LEFT:
                handleKeyLeft(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_RIGHT:
                handleKeyRight(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_UP:
                handleKeyUp(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_DOWN:
                handleKeyDown(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_TAB:
                handleKeyTabEvent(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_HOME:
                handleKeyHome(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_END:
                handleKeyEndEvent(event.isControlKeyDown(), event.isShiftKeyDown());
                break;
            case KeyCodes.KEY_C:
                if (event.isControlKeyDown()) {
                    sinkEvents(event.getNativeKeyCode());
                }
                break;
            default:
                updateURL();
                switch (urlTextBox.getInteractionFromEvent(event)) {
                    case COPY:
                        handleCopy();
                        break;
                    case CUT:
                        handleCut();
                        break;
                    default:
                        int keyCode = event.getNativeKeyCode();
                        if (keyCode == (int) 'S') {
                            if (event.isControlKeyDown() || event.isMetaKeyDown()) {
                                event.preventDefault();
                            }
                        }
                        break;
                }
                break;
        }

    }

    private void updateURL() {
        Scheduler.get().scheduleDeferred(() -> videoListener.onPreUpdateVideoSource(videoTokenBox.getId(), videoTokenBox.getUrl()));
    }

    private void handleKeyEndEvent(boolean controlKeyDown, boolean shiftKeyDown) {
        if (controlKeyDown) {
            videoListener.onMoveCursorToDocumentEnd(getId(), shiftKeyDown);
        } else {
            videoListener.onMoveCursorToLineEnd(getId(), shiftKeyDown);
        }
    }

    private void handleKeyHome(boolean controlKeyDown, boolean shiftKeyDown) {
        if (controlKeyDown) {
            videoListener.onMoveCursorToDocumentTop(getId(), shiftKeyDown);
        } else {
            videoListener.onMoveCursorToLineStart(getId(), shiftKeyDown);
        }
    }

    private void handleKeyTabEvent(boolean controlKeyDown, boolean shiftKeyDown) {
        if (!shiftKeyDown) {
            videoListener.onMoveCursorToNextBox(getId(), false);
        } else {
            videoListener.onMoveCursorToPreviousBox(getId(), false, false);
        }
    }

    private void handleCut() {
        videoListener.onCut();
    }

    private void handleCopy() {
        videoListener.onCopy();
    }

    private void handleKeyDown(boolean controlKeyDown, boolean shiftKeyDown) {
        if (controlKeyDown) {
            videoListener.onMoveCursorToNextParagraph(getId(), shiftKeyDown);
        } else {
            videoListener.onMoveCursorLineDown(getId(), shiftKeyDown);
        }
    }

    private void handleKeyUp(boolean controlKeyDown, boolean shiftKeyDown) {
        if (controlKeyDown) {
            videoListener.onMoveCursorToPreviousParagraph(getId(), shiftKeyDown);
        } else {
            videoListener.onMoveCursorLineUp(getId(), shiftKeyDown);
        }
    }

    private void handleKeyRight(final boolean controlKeyDown, final boolean shiftKeyDown) {
        final int cursorPos = urlTextBox.getCursorPosition();
        final boolean wasWholeTextSelected = isWholeTextSelected();
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {

                if (controlKeyDown || cursorPos >= urlTextBox.getCursorAbsoluteRight()
                        || (wasWholeTextSelected && shiftKeyDown)) {
                    videoListener.onMoveCursorToNextBox(getId(), shiftKeyDown);
                } else if (shiftKeyDown && isWholeTextSelected()) {
                    videoListener.onSelectToken(getId(), true);
                } else if (!shiftKeyDown) {
                    videoListener.onSelectToken(getId(), false);
                }
            }
        });
    }

    private void handleKeyLeft(final boolean controlKeyDown, final boolean shiftKeyDown) {
        // Wait until cursor and selection are changed
        final int cursorPos = urlTextBox.getCursorPosition();
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                if (controlKeyDown || cursorPos <= 0) {
                    videoListener.onMoveCursorToPreviousBox(getId(), false, shiftKeyDown);
                } else if (shiftKeyDown && isWholeTextSelected()) {
                    videoListener.onSelectToken(getId(), true);
                } else if (!shiftKeyDown) {
                    videoListener.onSelectToken(getId(), false);
                }
            }
        });
    }

    protected void cleanUpTimer() {
        timer.cancel();
    }

    private void handleKeyDeleteEvent(KeyDownEvent event) {
        assert event != null : "Precondition failed: event != null";
        assert event
                .getNativeKeyCode() == KeyCodes.KEY_DELETE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_DELETE";

        boolean performDefault = videoListener.handleForTokenSelection(getId(), false);
        if (performDefault) {
            if ((getCursorPosition() == urlTextBox.getText().length() && urlTextBox.getSelectionLength() == 0)) {
                cleanUpTimer();
                videoListener.onDeleteNext(getId());
                event.preventDefault();
            } else {
                updateURL();
            }
        }
    }

    public int getCursorPosition() {
        return urlTextBox.getCursorPos();
    }

    private void handleKeyBackspaceEvent(KeyDownEvent event) {
        assert event != null : "Precondition failed: event != null";
        assert event
                .getNativeKeyCode() == KeyCodes.KEY_BACKSPACE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE";

        boolean performDefault = videoListener.handleForTokenSelection(getId(), false);
        if (performDefault) {

            if ((getCursorPosition() == 0) && urlTextBox.getSelectionLength() == 0) {
                cleanUpTimer();
                videoListener.onDeletePrevious(getId());
                event.preventDefault();
            } else if (getCursorPosition() == urlTextBox.getTextLength()) {
                event.preventDefault();
                event.stopPropagation();
                updateURL();

            } else {
                updateURL();
            }
        }
    }

    protected void handleSelectVideoToken(boolean select, boolean doubleClick) {
        if (videoListener != null) {
            videoListener.onSelectToken(getId(), select, doubleClick);
        }
    }

    public void checkVideoSource() {
        String text = videoTokenBox.getUrl();
        String url = text.trim();

        if (video != null && !"".equals(url)) {
            if (text.equals(oldText)) {
                return;
            }

            clearVideo();
            setVideoPosterToConverting();

            videoListener.onUpdateVideoSource(videoTokenBox.getId(), url);
            oldText = text;
        } else if ("".equals(url)) {
            setVideoToNoVideoLoaded();
            oldText = "";
        }

    }

    public void checkDelegsVideoSource() {
        String text = videoTokenBox.getUrl();
        String url = text.trim();
        if (video != null && !"".equals(url)) {
            final boolean isVideoHostedByDelegs = !url.startsWith(GWT.getHostPageBaseURL());
            if (isVideoHostedByDelegs && text.equals(oldText)) {
                return;
            }

            clearVideo();
            setVideoPosterToConverting();

            videoListener.onUpdateVideoSource(videoTokenBox.getId(), url);
            oldText = text;
        }
    }

    private void setVideoToNoVideoLoaded() {
        clearVideo();
        String imgURL = generateErrorImageURL(I18NAccess.I18N.getNoVideoLoaded());
        video.setPoster(imgURL);
    }

    private void loadVideo(String url) {
        clearVideo();
        if (!url.isEmpty()) {
            String encodedUrl = GWT.getModuleBaseURL() + "video-cache?filename=" + urlConverter.encodeQueryString(url);
            video.addSource(encodedUrl + ".webm");
            video.addSource(encodedUrl + ".mp4");
            video.getVideoElement().setPoster(encodedUrl + ".jpg");
            video.load();
            timer.cancel();
        }
    }

    private void clearVideo() {
        if (video != null) {
            video.setSrc("");
            video.getElement().removeAttribute("src");
            video.getElement().removeAttribute("poster");
            List<SourceElement> sources = new ArrayList<SourceElement>();
            for (int i = 0; i < video.getElement().getChildCount(); ++i) {
                Node child = video.getElement().getChild(i);
                if (SourceElement.is(child)) {
                    sources.add((SourceElement) child);
                }
            }
            for (SourceElement source : sources) {
                video.removeSource(source);
            }
        }
    }

    public void setVideoTokenBoxUrl(String url) {
        oldText = getUrl();
        videoTokenBox.setUrl(url);
    }

    public void startVideo() {
        video.setControls(true);
        video.setPreload(MediaElement.PRELOAD_NONE);
        video.play();
    }

    public void reload() {
        if (video != null) {
            clearVideo();
            video.setPreload(MediaElement.PRELOAD_AUTO);
            loadVideo(videoTokenBox.getUrl());
            startVideo();
        }
    }

    public void noVideoFound() {
        if (video != null) {
            clearVideo();
            String imgUrl = generateErrorImageURL(I18NAccess.I18N.getNoVideoFound());
            video.setPoster(imgUrl);
            scaleVideoToFitToken();

            if (!timer.isRunning()) {
                timer.scheduleRepeating(1000);
            }
        }
    }

    @Override
    public Id getId() {
        return videoTokenBox.getId();
    }

    @Override
    public void focus() {
        urlTextBox.setFocus(true);
    }

    @Override
    public void toggleSelection() {
        this.urlTextBox.setSelection(!this.urlTextBox.isSelected());
    }

    public interface VideoListener
            extends TextbasedTokenBoxWidgetListener, ResizableTokenBoxWidgetListener, VisibilityListener {
        void onUpdateVideoSource(Id id, String url);

        void onPreUpdateVideoSource(Id id, String url);

        void onReport(String url);
    }

    @Override
    public TokenBox getTokenBox() {
        return videoTokenBox;
    }

    @Override
    public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
        assert mouseOverHandler != null : "Precondition failed: mouseOverHandler != null";
        assert mouseOutHandler != null : "Precondition failed: mouseOutHandler != null";

        contentPanel.addHandler(mouseOverHandler, MouseOverEvent.getType());
        contentPanel.addHandler(mouseOutHandler, MouseOutEvent.getType());
        contentPanel.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
    }

    @Override
    public void setTokenBox(TokenBox tokenBox) {
        assert tokenBox != null : "Precondition failed: tokenBox != null";
        assert tokenBox instanceof VideoTokenBox : "Precondition failed: tokenBox instanceof VideoTokenBox";

        videoTokenBox = (VideoTokenBox) tokenBox;
        setURLTextBoxVisibility(videoTokenBox.isURLVisible());

        updateVideoTokenBoxWidget();
    }

    private void updateVideoTokenBoxWidget() {
        updateButtonPanelMargin();
        int contentWidth = (int) (videoTokenBox.getWidth_PX() - videoTokenBox.getMarginRight_PX());
        contentPanel.setPixelSize(contentWidth, videoTokenBox.getHeightWithMargin_PX());
        videoPanel.setPixelSize(contentWidth, videoTokenBox.getHeight_PX() - videoTokenBox.getURLBoxHeight_PX()
                - videoTokenBox.getButtonPanelHeight());
        buttonPanel.setPixelSize(contentWidth, videoTokenBox.getButtonPanelHeight());
        urlTextBox.setWidth(contentWidth + "px");
        if (videoTokenBox.getUrl() == null || videoTokenBox.getUrl().equals("")) {
            setVideoToNoVideoLoaded();
        } else {
            checkVideoSource();
        }
    }

    private void setURLTextBoxVisibility(boolean urlVisible) {
        if (urlVisible) {
            urlTextBox.getElement().getStyle().setVisibility(Visibility.VISIBLE);
        } else {
            urlTextBox.getElement().getStyle().setVisibility(Visibility.HIDDEN);
        }
    }

    @Override
    public int getCursorPositionAt(int left) {
        return urlTextBox.getCursorPositionAt(left, fontMetricSpecifier);
    }

    @Override
    public boolean isValidCursorPosition(int cursorPosition) {
        return urlTextBox.isValidPosition(cursorPosition);
    }

    @Override
    public int getCursorLeft() {
        return urlTextBox.getCursorLeft(fontMetricSpecifier);
    }

    @Override
    public void setCursorPositionAndFocus(int cursorPosition) {
        urlTextBox.setCursorPos(cursorPosition);
        urlTextBox.setFocus(true);
    }

    @Override
    public String getText() {
        return urlTextBox.getText();
    }

    @Override
    public void setTextBoxBackgroundColor(Color color) {
        urlTextBox.setTextBackground(color);
    }

    private void handlePaste() {
        updateURL();
    }

    @Override
    public void setDragModeHandler(MouseDragListener listener) {
        urlTextBox.setMouseDragListener(listener);
    }

    @Override
    protected boolean isResizeable() {
        return true;
    }

    @Override
    public boolean isWholeTextSelected() {
        return urlTextBox.getSelectionLength() == urlTextBox.getTextLength();
    }

    public VideoListener getVideoListener() {
        return videoListener;
    }

    public String getUrl() {
        return videoTokenBox.getUrl();
    }

    private void updateButtonPanelMargin() {
        buttonPanel.getElement().getStyle().setMarginBottom(videoTokenBox.getMarginBetweenVideoAndTextPX(), Unit.PX);
    }

    public void updateUploadProgress(double percentage) {
        assert percentage >= 0.0 : "Precondition: percentage >= 0.0";
        progressPercentageText.setVisible(true);

        if (percentage >= 1.0) {
            progressTextAbove.setVisible(false);
            progressBar.setVisible(false);
            progressPercentageText.setVisible(false);
            progressTextUnder.setVisible(false);
            videoWrapperPanel.setVisible(true);
            setVideoPosterToConverting();
        } else {
            progressTextAbove.setVisible(true);
            progressBar.setVisible(true);
            progressPercentageText.setVisible(true);
            progressTextUnder.setVisible(true);
            videoWrapperPanel.setVisible(false);

        }
        progressBar.setProgress(percentage);

    }

    public void setProgressbarText(double percentage) {
        progressPercentageText.setText(progressBar.getText());
    }

    public void setVideoPosterToConvertingAndRetry() {
        setVideoPosterToConverting();
        if (!timer.isRunning()) {
            timer.scheduleRepeating(1000);
        }
    }

    public void setVideoPosterToConverting() {
        switch (I18NAccess.I18N.getLocale()) {
            case DE:
                video.setPoster(Resources.RESOURCE.getProcessingImageDE().getSafeUri().asString());
                break;
            case EN:
                video.setPoster(Resources.RESOURCE.getProcessingImageEN().getSafeUri().asString());
                break;
            case BR:
                video.setPoster(Resources.RESOURCE.getProcessingImageEN().getSafeUri().asString());
                break;
            case ES:
                video.setPoster(Resources.RESOURCE.getProcessingImageEN().getSafeUri().asString());
                break;
            case FR:
                video.setPoster(Resources.RESOURCE.getProcessingImageEN().getSafeUri().asString());
                break;
        }

    }

}
