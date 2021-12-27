package de.signWritingEditor.client.GWTClient.ui.tool.subtools.mobileComponents;

import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.touch.client.Point;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.HistoryService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.SymbolServiceAsync;
import de.signWritingEditor.shared.model.material.PositionedSymbol;

public class SignEditorMobile extends SignEditor {

	@Override
	public void init(DictionaryServiceAsync dictionaryService, SymbolServiceAsync symbolService,
			HistoryService historyService, BadgeServiceClient badgeService, LocalSessionService localSessionService,
			SignEditorListener changeToolBarListener) {
		super.init(dictionaryService, symbolService, historyService, badgeService, localSessionService,
				changeToolBarListener);

		getWorkSurfacePanel().sinkEvents(Event.ONTOUCHSTART | Event.ONTOUCHEND | Event.ONTOUCHMOVE);

		// Implementation for mobile devices
		getWorkSurfacePanel().addHandler(new TouchMoveHandler() {
			@Override
			public void onTouchMove(TouchMoveEvent event) {
				event.preventDefault();
				event.stopPropagation();
				handleTouchMoveOnWorkSurfacePanel(event);
			}
		}, TouchMoveEvent.getType());

		getWorkSurfacePanel().addHandler(new TouchStartHandler() {
			@Override
			public void onTouchStart(TouchStartEvent event) {
				if (!isSymbolPressed()) {
					event.preventDefault();
					event.stopPropagation();
					deselectAllSymbols();
				}
			}
		}, TouchStartEvent.getType());

		getWorkSurfacePanel().addHandler(new TouchEndHandler() {
			@Override
			public void onTouchEnd(TouchEndEvent event) {
				handlePressEnd();
			}
		}, TouchEndEvent.getType());
	}

	private void handleTouchMoveOnWorkSurfacePanel(TouchMoveEvent event) {
		assert event != null : "Precondition failed: event != null";

		Point touchMovePosition = new Point(
				event.getTargetTouches().get(0).getRelativeX(getSignEditPanel().getElement()),
				event.getTargetTouches().get(0).getRelativeY(getSignEditPanel().getElement()));

		handleMoveSymbols(touchMovePosition);
	}

	private void handleTouchStartOnSymbol(PositionedSymbol symbol, TouchStartEvent event) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert event != null : "Precondition failed: event != null";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		event.preventDefault();

		Point touchStartPosition = new Point(
				event.getTargetTouches().get(0).getRelativeX(getSignEditPanel().getElement()),
				event.getTargetTouches().get(0).getRelativeY(getSignEditPanel().getElement()));

		handleDragStartOnSymbol(symbol, false, touchStartPosition);
	}

	@Override
	protected Image createSymbolImage(final PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		Image symbolImage = super.createSymbolImage(symbol);

		symbolImage.addTouchStartHandler(new TouchStartHandler() {
			@Override
			public void onTouchStart(TouchStartEvent event) {
				handleTouchStartOnSymbol(symbol, event);
			}
		});

		return symbolImage;
	}
}
