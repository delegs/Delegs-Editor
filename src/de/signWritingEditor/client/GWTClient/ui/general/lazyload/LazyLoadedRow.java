package de.signWritingEditor.client.GWTClient.ui.general.lazyload;

public abstract class LazyLoadedRow {
	public abstract void lazyLoad(int rowIndex, Object userObject, LazyLoadedRowContainer container);
}