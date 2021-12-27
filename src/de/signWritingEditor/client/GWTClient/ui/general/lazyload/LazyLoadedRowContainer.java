package de.signWritingEditor.client.GWTClient.ui.general.lazyload;

import com.google.gwt.user.client.ui.Widget;

public interface LazyLoadedRowContainer {

	/**
	 * @return the total number of rows
	 */
	int getRowCount();

	/**
	 * @param rowIndex
	 *            the index of the row
	 * @return the user object of the given row or null
	 * @pre rowIndex >= 0
	 * @pre rowIndex < getRowCount()
	 */
	Object getUserObject(int rowIndex);

	/**
	 * @param rowIndex
	 *            the index of the row
	 * @return the lazy load status of the row with the given index
	 * @pre rowIndex >= 0
	 * @pre rowIndex < getRowCount()
	 * @post result != null
	 */
	LazyLoadStatus getLazyLoadStatus(int rowIndex);

	/**
	 * @param rowIndex
	 *            the index of the lazy loaded row
	 * @param left
	 *            the horizontal position of the lazy loaded row
	 * @param rowWidget
	 *            the lazy loaded row widget
	 * @pre rowIndex >= 0
	 * @pre rowIndex < getRowCount()
	 * @pre rowWidget != null
	 * @pre LazyLoadStatus.DUE.equals(getLazyLoadStatus(rowIndex))
	 * @post LazyLoadStatus.LOADED.equals(getLazyLoadStatus(rowIndex))
	 */
	void onLazyLoadSuccess(int rowIndex, int left, Widget rowWidget);

	/**
	 * @param rowIndex
	 *            the index of the not lazy loaded row
	 * @pre rowIndex >= 0
	 * @pre rowIndex < getRowCount()
	 * @pre LazyLoadStatus.DUE.equals(getLazyLoadStatus(rowIndex))
	 * @post LazyLoadStatus.LAZY.equals(getLazyLoadStatus(rowIndex))
	 */
	void onLazyLoadFailure(int rowIndex);

}
