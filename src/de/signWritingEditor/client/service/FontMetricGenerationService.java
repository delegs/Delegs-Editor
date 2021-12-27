package de.signWritingEditor.client.service;

import java.util.Map;

import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public interface FontMetricGenerationService {

	Map<FontMetricSpecifier, FontMetric> getFontMetrics();

}
