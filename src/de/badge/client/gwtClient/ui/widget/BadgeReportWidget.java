package de.badge.client.gwtClient.ui.widget;

import java.util.Date;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.badge.client.gwtService.BadgeService;

public class BadgeReportWidget extends Composite {

	private BadgeService badgeService;

	public BadgeReportWidget(BadgeService service) {
		assert service != null : "Precondition failed: service != null";

		this.badgeService = service;

		FlowPanel mainPanel = new FlowPanel();
		initWidget(mainPanel);

		Date sevenDaysAgo = new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 7));

		final FlowPanel linkOrErrorHolder = new FlowPanel();
		linkOrErrorHolder.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		linkOrErrorHolder.getElement().getStyle().setMargin(10, Unit.PX);
		linkOrErrorHolder.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);

		DatePicker datePicker = new DatePicker();
		datePicker.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		datePicker.getElement().getStyle().setMargin(10, Unit.PX);
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				final Date date = event.getValue();
				badgeService.getCSVBadgeReportsSince(date, new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						assert result != null : "Precondition failed: result != null";

						linkOrErrorHolder.clear();
						Anchor anchor = new Anchor("Download reports since "
								+ DateTimeFormat.getFormat(PredefinedFormat.DATE_FULL).format(date));
						anchor.setHref(UriUtils.encode(result));
						String filename = "reportsSince"
								+ DateTimeFormat.getFormat(PredefinedFormat.DATE_FULL).format(date) + ".csv";
						anchor.getElement().setAttribute("download", filename);
						linkOrErrorHolder.add(anchor);
					}

					@Override
					public void onFailure(Throwable caught) {
						Label error = new Label("Error creating reports");
						linkOrErrorHolder.add(error);
					}
				});
			}
		});
		mainPanel.add(datePicker);
		mainPanel.add(linkOrErrorHolder);

		// setting default value
		datePicker.setValue(sevenDaysAgo, true);
	}
}
