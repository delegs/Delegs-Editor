package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTextbasedTokenBoxWidget.MouseDragListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.VisibilityToolTipListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.*;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

public class TokenBoxWidgetFactory {

	private final EventTranslatorStandardImpl eventTranslator;
	private final DocumentUiListener documentUiListener;
	private final FontSizeService fontSizeService;
	private final URLConverter urlConverter;
	private SignDataEncoder signDataEncoder;
	protected ChangeAlternativeToolTip changeAlternativeTooltip;

	private final VisibilityToolTip visibilityToolTip;
	private final DocumentPanelListener documentPanelListener;
	private final boolean mobile;

	@Deprecated
	private Timer signVisibilityToolTipTimer;
	@Deprecated
	private static final int DEFAULT_SIGN_VISIBILITY_OFFSET_MOBIL = 65;
	private static final int TOOLTIP_SHOW_TIME_ON_TOUCH = 3000;

	private static final int DEFAULT_SIGN_VISIBILITY_OFFSET = 85;
	private static final int SIGN_VISIBILITY_TO_SIGN_ALTERNATIVE_OFFSET = -45;

	public TokenBoxWidgetFactory(boolean mobile, URLConverter urlConverter, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService, VisibilityToolTip visibilityToolTip, DocumentUiListener documentUiListener,
			DocumentPanelListener documentPanelListener) {
		this.mobile = mobile;
		this.urlConverter = urlConverter;
		this.eventTranslator = eventTranslator;
		this.fontSizeService = fontSizeService;
		this.visibilityToolTip = visibilityToolTip;
		this.documentUiListener = documentUiListener;
		this.documentPanelListener = documentPanelListener;

		changeAlternativeTooltip = new ChangeAlternativeToolTip(mobile);
		changeAlternativeTooltip.hide();
		RootPanel.get().add(changeAlternativeTooltip);

		if (mobile) {
			visibilityToolTip.setDefaultSignVisibilityToolTipOffset(DEFAULT_SIGN_VISIBILITY_OFFSET_MOBIL);

			signVisibilityToolTipTimer = new Timer() {

				@Override
				public void run() {
					hideVisibilityToolTip();
				}
			};
		} else {
			visibilityToolTip.setDefaultSignVisibilityToolTipOffset(
					DEFAULT_SIGN_VISIBILITY_OFFSET + SIGN_VISIBILITY_TO_SIGN_ALTERNATIVE_OFFSET);
		}
	}

	@Deprecated
	public SignDataEncoder getSignDataEncoder() {
		if (signDataEncoder == null) {
			signDataEncoder = new SignDataEncoder();
		}
		return signDataEncoder;
	}

	public AbstractTokenBoxWidget create(TokenBox tokenBox) {
		AbstractTokenBoxWidget widget;
		if (tokenBox instanceof SignItemTokenBox) {
			if (mobile) {
				widget = createSignItemTokenBoxWidgetMobile((SignItemTokenBox) tokenBox, getSignDataEncoder(),
						changeAlternativeTooltip);
			} else {
				widget = createSignItemTokenBoxWidget((SignItemTokenBox) tokenBox, getSignDataEncoder(),
						changeAlternativeTooltip);
			}
		} else if (tokenBox instanceof FreeTextTokenBox) {
			widget = createFreeTextLineWidget((FreeTextTokenBox) tokenBox);
		} else if (tokenBox instanceof FrameTokenBox) {
			widget = createFrameTokenBoxWidget((FrameTokenBox) tokenBox);
		} else if (tokenBox instanceof VideoTokenBox) {
			widget = createVideoTokenBoxWidget((VideoTokenBox) tokenBox);
		} else if (tokenBox instanceof ImageTokenBox) {
			widget = createImageTokenBoxWidget((ImageTokenBox) tokenBox);
        } else if (tokenBox instanceof DateFormTokenBox) {
            widget = createDateFormTokenBoxWidget((DateFormTokenBox) tokenBox);
		} else if (tokenBox instanceof UrlFormTokenBox) {
			widget = createUrlFormTokenBoxWidget((UrlFormTokenBox) tokenBox);
		} else if (tokenBox instanceof FormTokenBox) {
			widget = createFormTokenBoxWidget((FormTokenBox) tokenBox);
		} else if (tokenBox instanceof TagTokenBox) {
			widget = createTagTokenBoxWidget((TagTokenBox) tokenBox);
		} else {
			throw new RuntimeException("unexpected tokenBox-type");
		}
		return widget;
	}

    private AbstractTokenBoxWidget createDateFormTokenBoxWidget(DateFormTokenBox tokenBox) {
        final DateFormTokenBoxWidget result = new DateFormTokenBoxWidget(tokenBox, eventTranslator, fontSizeService);

        result.addDateTokenBoxWidgetListener(documentUiListener);

        return result;
    }

	private AbstractTokenBoxWidget createUrlFormTokenBoxWidget(UrlFormTokenBox urlTokenBox) {
		final UrlFormTokenBoxWidget result = new UrlFormTokenBoxWidget(urlTokenBox, eventTranslator, fontSizeService);

		result.addFormTokenBoxWidgetListener(documentUiListener);
		return result;
	}

	private FormTokenBoxWidget createFormTokenBoxWidget(FormTokenBox formTokenBox) {
		final FormTokenBoxWidget result = new FormTokenBoxWidget(formTokenBox, eventTranslator, fontSizeService);

		result.addFormTokenBoxWidgetListener(documentUiListener);
		return result;
	}

	private AbstractTokenBoxWidget createImageTokenBoxWidget(ImageTokenBox imageTokenBox) {
		ImageTokenBoxWidget imageTokenBoxWidget = new ImageTokenBoxWidget(imageTokenBox, eventTranslator,
				fontSizeService, documentUiListener);

		imageTokenBoxWidget.setDragModeHandler(new MouseDragListener() {

			@Override
			public void setInDragMode(MouseDownEvent event) {
				documentPanelListener.onActivateDragMode(event);
			}
		});

		return imageTokenBoxWidget;
	}

	private TagTokenBoxWidget createTagTokenBoxWidget(TagTokenBox tagTokenBox) {
		assert tagTokenBox != null : "tagToken is null";
		TagTokenBoxWidget tagTokenBoxWidget = new TagTokenBoxWidget(tagTokenBox, eventTranslator, fontSizeService,
				documentUiListener);

		return tagTokenBoxWidget;
	}

	private FrameTokenBoxWidget createFrameTokenBoxWidget(FrameTokenBox frameTokenBox) {
		assert frameTokenBox != null : "Precondition failed: frameTokenBox != null";

		FrameTokenBoxWidget result = new FrameTokenBoxWidget(frameTokenBox, eventTranslator, fontSizeService);

		result.addFrameTokenBoxWidgetListener(documentUiListener);

		return result;
	}

	private VideoTokenBoxWidget createVideoTokenBoxWidget(final VideoTokenBox videoTokenBox) {
		assert videoTokenBox != null : "Precondition failed: frameTokenBox != null";

		final VideoTokenBoxWidget result = new VideoTokenBoxWidget(videoTokenBox, urlConverter, documentUiListener,
				eventTranslator, fontSizeService);

		final VisibilityToolTipListener videoTokenVisibilityListener = new VisibilityToolTipListener() {

			@Override
			public void onVisibilityChanged(Id id, boolean visible) {
				documentUiListener.onVideoURLVisibilityChanged(id, visible);
			}
		};
		MouseOverHandler mouseOverHandler = new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				visibilityToolTip.showVisiblityToolTip(result, 8, !videoTokenBox.isURLVisible(),
						videoTokenVisibilityListener);
			}
		};
		MouseOutHandler mouseOutHandler = new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				hideVisibilityToolTip();
			}
		};
		result.addTextMouseOverHandlers(mouseOverHandler, mouseOutHandler);

		result.setDragModeHandler(new MouseDragListener() {

			@Override
			public void setInDragMode(MouseDownEvent event) {
				documentPanelListener.onActivateDragMode(event);
			}
		});

		return result;
	}

	private FreeTextTokenBoxWidget createFreeTextLineWidget(final FreeTextTokenBox freeTextBox) {
		assert freeTextBox != null : "Precondition failed: freeTextBox != null";

		final FreeTextTokenBoxWidget result = new FreeTextTokenBoxWidget(freeTextBox, eventTranslator, fontSizeService);
		result.addDragHandlingToTextArea(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				documentPanelListener.setInDragMode(true);
				event.stopPropagation();
			}
		}, new MouseMoveHandler() {

			@Override
			public void onMouseMove(MouseMoveEvent event) {
				documentPanelListener.onMouseDragged((Event) event.getNativeEvent());
			}
		});
		result.sinkEvents(Event.ONMOUSEDOWN);

		result.setDragModeHandler(new MouseDragListener() {

			@Override
			public void setInDragMode(MouseDownEvent event) {
				documentPanelListener.onActivateDragMode(event);
			}
		});

		final VisibilityToolTipListener freeTextVisibilityListener = new VisibilityToolTipListener() {

			@Override
			public void onVisibilityChanged(Id id, boolean visible) {
				documentUiListener.onFreeTextVisibilityChanged(id, visible);
			}
		};

		MouseOverHandler mouseOverHandler = new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				visibilityToolTip.showVisiblityToolTip(result, 8, !freeTextBox.isVisible(), freeTextVisibilityListener);
			}
		};

		MouseOutHandler mouseOutHandler = new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				hideVisibilityToolTip();
			}
		};
		result.addTextMouseOverHandlers(mouseOverHandler, mouseOutHandler);

		result.addFreeTextTokenBoxWidgetListener(documentUiListener);

		return result;
	}

	private LayoutedSignItemTokenBoxWidget createSignItemTokenBoxWidgetMobile(SignItemTokenBox tokenBox,
			SignDataEncoder signDataEncoder, ChangeAlternativeToolTip tooltip) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";

		final LayoutedSignItemTokenBoxWidget result = createSignItemTokenBoxWidget(tokenBox, signDataEncoder, tooltip);

		result.sinkEvents(Event.ONTOUCHSTART);
		result.addHandler(new TouchStartHandler() {
			@Override
			public void onTouchStart(TouchStartEvent event) {
				signVisibilityToolTipTimer.schedule(TOOLTIP_SHOW_TIME_ON_TOUCH);
			}
		}, TouchStartEvent.getType());

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private LayoutedSignItemTokenBoxWidget createSignItemTokenBoxWidget(final SignItemTokenBox tokenBox,
			SignDataEncoder signDataEncoder, ChangeAlternativeToolTip changeAlternativeToolTip) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";

		final LayoutedSignItemTokenBoxWidget result = new LayoutedSignItemTokenBoxWidget(tokenBox, documentUiListener,
				signDataEncoder, changeAlternativeToolTip, eventTranslator, fontSizeService);

		result.addHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				documentPanelListener.onActivateDragMode(event);
			}

		}, MouseDownEvent.getType());
		result.sinkEvents(Event.ONMOUSEDOWN);

		result.setDragModeHandler(new MouseDragListener() {

			@Override
			public void setInDragMode(MouseDownEvent event) {
				documentPanelListener.onActivateDragMode(event);
			}
		});

		final VisibilityToolTipListener textVisibilityListener = new VisibilityToolTipListener() {

			@Override
			public void onVisibilityChanged(Id id, boolean visible) {
				documentUiListener.onSearchWordVisibilityChanged(id, visible);
			}
		};

		MouseOverHandler mouseOverTextBoxHandler = new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				visibilityToolTip.showVisiblityToolTip(result, 8, !tokenBox.isSearchWordVisible(),
						textVisibilityListener);
			}
		};
		MouseOutHandler mouseOutTextBoxHandler = new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				hideVisibilityToolTip();
			}
		};
		result.addTextMouseOverHandlers(mouseOverTextBoxHandler, mouseOutTextBoxHandler);

		final VisibilityToolTipListener signItemVisibilityListener = new VisibilityToolTipListener() {

			@Override
			public void onVisibilityChanged(Id id, boolean visible) {
				documentUiListener.onSignVisibilityChanged(id, visible);
			}
		};

		MouseOverHandler mouseOverSignHandler = new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				visibilityToolTip.showVisiblityToolTip(result,
						-visibilityToolTip.getDefaultSignVisibilityToolTipOffset(), !tokenBox.isSignVisible(),
						signItemVisibilityListener);
			}
		};
		MouseOutHandler mouseOutSignHandler = new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				hideVisibilityToolTip();
			}
		};

		result.addMouseOverSignHandlers(mouseOverSignHandler, mouseOutSignHandler);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void hideVisibilityToolTip() {
		visibilityToolTip.setVisibleCustom(false);
	}
}
