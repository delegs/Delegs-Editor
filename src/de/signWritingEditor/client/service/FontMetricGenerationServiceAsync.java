package de.signWritingEditor.client.service;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public interface FontMetricGenerationServiceAsync {

	void getFontMetrics(AsyncCallback<Map<FontMetricSpecifier, FontMetric>> callback);
}
