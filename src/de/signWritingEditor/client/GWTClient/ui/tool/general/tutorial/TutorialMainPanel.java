package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialVideoElement.TutorialNavigationListener;

public class TutorialMainPanel extends DockLayoutPanel {

	private static final String PATH = "signwritingeditor/tutorials?tutorialname=";

	private static final int CATEGORY_COUNT = 3;

	private Widget video;
	private Widget selected;
	/*
	 * ae=\u00E4 oe=\u00F6 ue=\u00FC
	 */
	/**
	 * Label x = Copys
	 */
	final Grid navigationGrid = new Grid(1, 5);
	final Label home = new Label("HOME");
	final Label documentEditorLabel = new Label(I18N.getDocumentEditor());
	final Label signEditorLabel = new Label(I18N.getSignEditor());
	final Label documentManagerLabel = new Label(I18N.getDocumentManager());

	final Label weiter = new Label(">");
	final Label xweiter = new Label(">");

	public TutorialMainPanel(Unit unit) {
		super(unit);
		this.setHeight("100%");
		this.setWidth("100%");
		navigationGrid.getElement().getStyle().setProperty("borderBottom", "thin solid black");
		final Grid westgrid = new Grid();
		resizeGrid(westgrid, CATEGORY_COUNT);
		this.addNorth(navigationGrid, 50);
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("scrollPanel");
		scrollPanel.getElement().getStyle().setWidth(100, Unit.PCT);

		westgrid.setWidget(0, 0, documentManagerLabel);
		westgrid.setWidget(1, 0, documentEditorLabel);
		westgrid.setWidget(2, 0, signEditorLabel);

		scrollPanel.add(westgrid);
		this.addWest(scrollPanel, 210);
		navigationGrid.setWidget(0, 0, home);

		// Cursor
		documentManagerLabel.getElement().getStyle().setCursor(Cursor.POINTER);
		documentEditorLabel.getElement().getStyle().setCursor(Cursor.POINTER);
		signEditorLabel.getElement().getStyle().setCursor(Cursor.POINTER);
		home.getElement().getStyle().setCursor(Cursor.POINTER);

		// Grid-Einstellungen
		westgrid.getElement().getStyle().setBackgroundColor("#ffffff");
		westgrid.getElement().getStyle().setHeight(90, Unit.PX);
		westgrid.getElement().getStyle().setWidth(180, Unit.PX);
		westgrid.getElement().getStyle().setMargin(10, Unit.PX);
		westgrid.getElement().getStyle().setFontSize(20, Unit.EM);
		navigationGrid.getCellFormatter().setWidth(0, 0, "50px");
		navigationGrid.getCellFormatter().setWidth(0, 1, "19px");
		navigationGrid.getCellFormatter().setWidth(0, 2, "122px");
		navigationGrid.getCellFormatter().setWidth(0, 3, "19px");
		navigationGrid.getCellFormatter().setWidth(0, 4, "627px");
		navigationGrid.setHeight("36px");
		navigationGrid.getElement().getStyle().setMarginLeft(10, Unit.PX);
		navigationGrid.getElement().getStyle().setMarginRight(10, Unit.PX);

		for (int i = 0; i < navigationGrid.getColumnCount(); i++) {

			navigationGrid.getCellFormatter().setAlignment(0, i, HasHorizontalAlignment.ALIGN_LEFT,
					HasVerticalAlignment.ALIGN_MIDDLE);
			navigationGrid.getCellFormatter().getElement(0, i).getStyle().setPaddingRight(10, Unit.PX);

		}
		navigationGrid.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		// ClickHandler

		String pathToTutorialVideos = GWT.getModuleBaseURL().replaceAll(GWT.getModuleName() + "/", "") + PATH;

		final TutorialPart documentMangagerTutorial = new DocumentManagerTutorial(pathToTutorialVideos,
				getNewTutorialNavigationListener());
		final TutorialPart documentEditorTutorial = new DocumentenEditorTutorial(pathToTutorialVideos,
				getNewTutorialNavigationListener());
		final TutorialPart signEditorTutorial = new SignEditorTutorial(pathToTutorialVideos,
				getNewTutorialNavigationListener());

		documentManagerLabel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				navigationGrid.clear();
				navigationGrid.setWidget(0, 0, home);
				navigationGrid.setWidget(0, 1, weiter);
				navigationGrid.setWidget(0, 2, documentManagerLabel);

				int lectionSize = documentMangagerTutorial.getLectionSize();
				resizeGrid(westgrid, lectionSize);
				for (int i = 0; i < lectionSize; i++) {
					westgrid.setWidget(i, 0, documentMangagerTutorial.getTutorialElement(i).getNavigationLabel());
				}

			}

		});

		documentEditorLabel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				navigationGrid.clear();
				navigationGrid.setWidget(0, 0, home);
				navigationGrid.setWidget(0, 1, weiter);
				navigationGrid.setWidget(0, 2, documentEditorLabel);

				int lectionSize = documentEditorTutorial.getLectionSize();
				resizeGrid(westgrid, lectionSize);
				for (int i = 0; i < lectionSize; i++) {
					westgrid.setWidget(i, 0, documentEditorTutorial.getTutorialElement(i).getNavigationLabel());
				}

			}

		});

		signEditorLabel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				navigationGrid.clear();
				navigationGrid.setWidget(0, 0, home);
				navigationGrid.setWidget(0, 1, weiter);
				navigationGrid.setWidget(0, 2, signEditorLabel);

				int lectionSize = signEditorTutorial.getLectionSize();
				resizeGrid(westgrid, lectionSize);
				for (int i = 0; i < lectionSize; i++) {
					westgrid.setWidget(i, 0, signEditorTutorial.getTutorialElement(i).getNavigationLabel());
				}

			}
		});

		home.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				navigationGrid.clear();
				navigationGrid.setWidget(0, 0, home);
				westgrid.clear();
				resizeGrid(westgrid, CATEGORY_COUNT);
				westgrid.setWidget(0, 0, documentManagerLabel);
				westgrid.setWidget(1, 0, documentEditorLabel);
				westgrid.setWidget(2, 0, signEditorLabel);
			}
		});

	}

	private void resizeGrid(Grid grid, int rows) {
		grid.resize(rows, 1);
		for (int i = 0; i < grid.getRowCount(); i++) {
			grid.getCellFormatter().setHeight(i, 0, "30px");
		}
	}

	private TutorialNavigationListener getNewTutorialNavigationListener() {
		return new TutorialNavigationListener() {

			private Label categoryLabel;

			@Override
			public void setCategory(Label categoryLabel) {
				this.categoryLabel = categoryLabel;
			}

			@Override
			public void onNavigationChanged(Label headerLabel, Label navigationLabel, Widget tutorialElement) {
				update(categoryLabel, headerLabel, navigationLabel, tutorialElement);
			}
		};
	}

	public void update(Widget tutorialCategory, Label headerLabel, Label navigationLabel, Widget tutorialElement) {
		displayNavigation(tutorialCategory, headerLabel);
		if (this.video == null) {
			displayTutorialElement(tutorialElement);
		} else {
			replaceTutorialWidget(tutorialElement);
		}

		if (selected == null) {
			selected = navigationLabel;
			highlightLabel(selected);
		} else {
			normalizeLabel(selected);
			selected = navigationLabel;
			highlightLabel(selected);
		}
	}

	private void displayNavigation(Widget category, Widget tutorialElementHeader) {
		navigationGrid.clear();
		navigationGrid.setWidget(0, 0, home);
		navigationGrid.setWidget(0, 1, weiter);
		navigationGrid.setWidget(0, 2, category);
		navigationGrid.setWidget(0, 3, xweiter);
		navigationGrid.setWidget(0, 4, tutorialElementHeader);
	}

	private void replaceTutorialWidget(Widget tutorialWidget) {
		this.remove(video);
		tutorialWidget.setWidth("100%");
		tutorialWidget.setHeight("100%");
		this.add(tutorialWidget);
		this.video = tutorialWidget;
	}

	private void displayTutorialElement(Widget tutorialWidget) {
		tutorialWidget.setWidth("100%");
		tutorialWidget.setHeight("100%");

		this.add(tutorialWidget);
		video = tutorialWidget;
	}

	private void normalizeLabel(Widget selected) {
		selected.getElement().getStyle().setFontWeight(FontWeight.NORMAL);
		selected.getElement().getStyle().setBackgroundColor("#FfffFF");
	}

	private void highlightLabel(Widget selected) {
		selected.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		selected.getElement().getStyle().setBackgroundColor("#F2F6FF");
	}
}
