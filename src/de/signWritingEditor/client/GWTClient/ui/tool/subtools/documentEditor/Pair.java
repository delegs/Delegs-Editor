package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.io.Serializable;

public class Pair<X, Y> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private X _1;
	private Y _2;

	@Deprecated
	public Pair() {

	}

	public Pair(X _1, Y _2) {
		this._1 = _1;
		this._2 = _2;
	}

	public X getA() {
		return _1;
	}

	public Y getB() {
		return _2;
	}

	@Override
	public String toString() {
		return "Pair(" + _1 + ", " + _2 + ")";
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Pair)) {
			return false;
		}
		Pair<X, Y> other = (Pair<X, Y>) object;
		return this._1.equals(other._1) && this._2.equals(other._2);
	}
}