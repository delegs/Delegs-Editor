package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import java.util.List;

@Deprecated
public abstract class ObjectStorageImpl<T> implements ObjectFoundStorage<T> {
	public static void fireObjectFound(List<ObjectFoundStorage<?>> sectionFoundHandlers, Object foundObject,
			boolean hasNext) {
		for (ObjectFoundStorage<?> sectionFoundHandler : sectionFoundHandlers) {
			sectionFoundHandler.process(foundObject, hasNext);
		}
	}
}
