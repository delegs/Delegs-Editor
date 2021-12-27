package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.PersistenceLocation;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class SimpleSign extends AuthoredObject implements Serializable {
	public static final int HEAD_SYMBOL_OVERLAP = 7;
	public static final int HEAD_OFFSET = 30;
	public static final int SHOULDER_OFFSET = HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT + 5;
	public static final int SIGN_HEIGHT_PX = 179;

	private static final long serialVersionUID = 3971667035137900896L;

	private SignId signId;

	private Date modificationDate;

	private List<HeadSymbol> headSymbols;
	// Intermediate state for HeadSymbols: Mouth, Eyes and HeadPosture are
	// captured in a HeadSymbol, but not necessarily automatically arranged
	private List<HeadSymbol> disarrangedHeadSymbols;
	private List<PositionedSymbol> handSymbols;
	private List<PositionedFingerAlphabetSymbol> fingerAlphabetSymbols;
	private List<PositionedSymbol> symbols;
	private long revision;
	private String comment;
	private PersistenceLocation persistenceLocation;

	public SimpleSign(SignId id, User author, SignLocale language, Date modificationDate, String comment) {
		super(author, language);
		assert id != null : "Precondition failed: id != null";
		assert modificationDate != null : "Precondition failed: modificationDate != null";

		this.signId = id;
		this.modificationDate = modificationDate;
		this.comment = comment;
		this.persistenceLocation = PersistenceLocation.NONE;

		headSymbols = new ArrayList<HeadSymbol>();
		disarrangedHeadSymbols = new ArrayList<HeadSymbol>();
		handSymbols = new ArrayList<PositionedSymbol>();
		symbols = new ArrayList<PositionedSymbol>();
		fingerAlphabetSymbols = new ArrayList<PositionedFingerAlphabetSymbol>();
	}

	public void setPersistenceLocation(PersistenceLocation persistenceLocation) {
		this.persistenceLocation = persistenceLocation;
	}

	public PersistenceLocation getPersistenceLocation() {
		return persistenceLocation;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		if (comment == null) {
			comment = "";
		}
		return comment;
	}

	public int getWidth() {
		int result = 0;

		if (!getPlainSymbols().isEmpty()) {
			int symbolMaxX = Integer.MIN_VALUE;
			int symbolMinX = Integer.MAX_VALUE;

			for (PositionedSymbol positionedSymbol : getPlainSymbols()) {
				int symbolLeft = positionedSymbol.getX();
				int symbolRight = symbolLeft + positionedSymbol.getWidth();

				if (symbolRight > symbolMaxX) {
					symbolMaxX = symbolRight;
				}
				if (symbolLeft < symbolMinX) {
					symbolMinX = symbolLeft;
				}
			}

			result = symbolMaxX - symbolMinX;
		}

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public int getHeight() {
		return SIGN_HEIGHT_PX;
	}

	public void setSignId(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		this.signId = signId;
	}

	public SignId getSignId() {
		return signId;
	}

	public void addHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		headSymbols.add(headSymbol);
	}

	public void addFingerAlphabetSymbol(PositionedFingerAlphabetSymbol fingerAlphabetSymbol) {
		assert fingerAlphabetSymbol != null : "Precondition failed: fingerAlphabetSymbol != null";

		fingerAlphabetSymbols.add(fingerAlphabetSymbol);
	}

	public List<PositionedFingerAlphabetSymbol> getFingerAlphabetSymbols() {
		assert fingerAlphabetSymbols != null : "Postcondition failed: fingerAlphabetSymbols != null";
		return Collections.unmodifiableList(fingerAlphabetSymbols);
	}

	public void sortFingerAlphabetSymbols() {
		Collections.sort(fingerAlphabetSymbols, createPositionedSymbolComparator());
	}

	public void insertFingerAlphabetSymbol(int index, PositionedFingerAlphabetSymbol fingerAlphabetSymbol) {
		assert fingerAlphabetSymbol != null : "Precondition failed: fingerAlphabetSymbol != null";
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index <= fingerAlphabetSymbols.size() : "Precondition failed: index [" + index
				+ "] <= fingerAlphabetSymbols.size() [" + fingerAlphabetSymbols.size() + "]";

		fingerAlphabetSymbols.add(index, fingerAlphabetSymbol);
	}

	public List<HeadSymbol> getHeadSymbols() {
		assert headSymbols != null : "Postcondition failed: headSymbols != null";
		return Collections.unmodifiableList(headSymbols);
	}

	public void addDisarrangedHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		disarrangedHeadSymbols.add(headSymbol);
	}

	public List<HeadSymbol> getDisarrangedHeadSymbols() {
		assert disarrangedHeadSymbols != null;
		return Collections.unmodifiableList(disarrangedHeadSymbols);
	}

	public void insertHeadSymbol(int index, HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index <= getHeadSymbolCount() : "Precondition failed: index [" + index + "] <= getHeadSymbolCount() ["
				+ getHeadSymbolCount() + "]";

		headSymbols.add(index, headSymbol);
	}

	public HeadSymbol getHeadSymbolAt(int index) {
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index < getHeadSymbolCount() : "Precondition failed: index [" + index + "] < getHeadSymbolCount() ["
				+ getHeadSymbolCount() + "]";

		return headSymbols.get(index);
	}

	public void removeHeadSymbolAt(int index) {
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index < getHeadSymbolCount() : "Precondition failed: index [" + index + "] < getHeadSymbolCount() ["
				+ getHeadSymbolCount() + "]";

		headSymbols.remove(index);
	}

	public void removeHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert hasHeadSymbol(headSymbol) : "Precondition failed: hasHeadSymbol(headSymbol)";

		headSymbols.remove(headSymbol);
	}

	public void removeDisarrangedHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert hasDisarrangedHeadSymbol(headSymbol) : "Precondition failed: hasHeadSymbol(headSymbol)";

		disarrangedHeadSymbols.remove(headSymbol);
	}

	public int getHeadSymbolCount() {
		return headSymbols.size();
	}

	public void removeAllHeadSymbols() {
		headSymbols.clear();
	}

	public int getHeadSymbolIndex(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert hasHeadSymbol(headSymbol) : "Precondition failed: hasHeadSymbol(headSymbol)";

		return headSymbols.indexOf(headSymbol);
	}

	public List<PositionedSymbol> getAllSymbols() {
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		result.addAll(getOtherSymbols());
		result.addAll(getHandSymbols());
		result.addAll(getHeadSymbols());
		result.addAll(getDisarrangedHeadSymbols());
		result.addAll(getFingerAlphabetSymbols());

		return Collections.unmodifiableList(result);
	}

	public List<PositionedSymbol> getPlainSymbols() {
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		result.addAll(getOtherSymbols());
		result.addAll(getHandSymbols());
		result.addAll(getFingerAlphabetSymbols());

		for (HeadSymbol headSymbol : getHeadSymbols()) {
			result.addAll(SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol, headSymbol.getX(),
					headSymbol.getY(), headSymbol.getZ()));
		}
		for (HeadSymbol headSymbol : getDisarrangedHeadSymbols()) {
			result.addAll(SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol, headSymbol.getX(),
					headSymbol.getY(), headSymbol.getZ()));
		}

		return Collections.unmodifiableList(result);
	}

	public List<PositionedSymbol> getOtherSymbols() {
		return Collections.unmodifiableList(symbols);
	}

	public List<PositionedSymbol> getArrowSymbols() {
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		for (PositionedSymbol positionedSymbol : getOtherSymbols()) {
			Symbol symbol = positionedSymbol.getSymbol();
			if (ArrowSymbol.isValid(symbol.getBaseSymbol())) {
				result.add(positionedSymbol);
			}
		}

		return Collections.unmodifiableList(result);
	}

	public List<PositionedSymbol> getTouchSymbols() {
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		for (PositionedSymbol positionedSymbol : getOtherSymbols()) {
			Symbol symbol = positionedSymbol.getSymbol();
			if (TouchSymbol.isValid(symbol.getBaseSymbol())) {
				result.add(positionedSymbol);
			}
		}

		return Collections.unmodifiableList(result);
	}

	public List<PositionedSymbol> getHandSymbols() {
		return Collections.unmodifiableList(handSymbols);
	}

	public void addSymbol(PositionedSymbol symbol) {
		assert symbol != null : "symbol != null";

		if (SymbolCategoryAnalyzer.isHandSymbol(symbol.getSymbol())) {
			handSymbols.add(symbol);
		} else if (SymbolCategoryAnalyzer.isFingerAlphabetSymbol(symbol.getSymbol())) {
			assert symbol instanceof PositionedFingerAlphabetSymbol : "Precondition failed: symbol instanceof PositionedFingerAlphabetSymbol";
			fingerAlphabetSymbols.add((PositionedFingerAlphabetSymbol) symbol);
		} else {
			symbols.add(symbol);
		}
	}

	public void addSymbols(List<PositionedSymbol> extractPositionedSymbols) {
		for (PositionedSymbol positionedSymbol : extractPositionedSymbols) {
			addSymbol(positionedSymbol);
		}
	}

	public void removeSymbol(PositionedSymbol symbol) {
		assert symbol != null : "symbol != null";
		assert hasSymbol(symbol) : "hasSymbol(symbol)";

		if (SymbolCategoryAnalyzer.isFingerAlphabetSymbol(symbol.getSymbol())) {
			fingerAlphabetSymbols.remove(symbol);
		} else if (SymbolCategoryAnalyzer.isHandSymbol(symbol.getSymbol())) {
			handSymbols.remove(symbol);
		} else {
			symbols.remove(symbol);
		}
	}

	public boolean hasSymbol(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = false;
		if (symbol instanceof HeadSymbol) {
			result = hasHeadSymbol((HeadSymbol) symbol) || hasDisarrangedHeadSymbol((HeadSymbol) symbol);
		} else if (symbol instanceof PositionedSymbol) {
			PositionedSymbol positionedSymbol = (PositionedSymbol) symbol;
			result = hasOtherSymbol(positionedSymbol) || hasHandSymbol(positionedSymbol)
					|| hasFingerAlphabetSymbol(positionedSymbol);
		}

		return result;
	}

	private boolean hasFingerAlphabetSymbol(PositionedSymbol positionedSymbol) {
		assert positionedSymbol != null : "Precondition failed: positionedSymbol != null";

		return fingerAlphabetSymbols.contains(positionedSymbol);
	}

	public boolean hasOtherSymbol(PositionedSymbol symbol) {
		assert symbol != null : "symbol != null";

		return symbols.contains(symbol);
	}

	public boolean hasHandSymbol(PositionedSymbol handSymbol) {
		assert handSymbol != null : "Precondition failed: handSymbol != null";

		return handSymbols.contains(handSymbol);
	}

	public boolean hasHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		return headSymbols.contains(headSymbol);
	}

	public boolean hasDisarrangedHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		return disarrangedHeadSymbols.contains(headSymbol);
	}

	public boolean hasHeadSymbols() {
		return !headSymbols.isEmpty();
	}

	public boolean hasDisarrangedHeadSymbols() {
		return !disarrangedHeadSymbols.isEmpty();
	}

	public boolean hasFingerAlphabetSymbols() {
		return !fingerAlphabetSymbols.isEmpty();
	}

	public void normalize() {
		normalizeX();

		if (hasAnyHeadSymbols()) {
			normalizeY(0);
			normalizeToHeadOffset();
		} else {
			normalizeY(SHOULDER_OFFSET);
		}
	}

	private void normalizeY(int offset) {
		assert offset >= 0 : "Precondition failed: offset >= 0";

		int smallestY = Integer.MAX_VALUE;

		for (PositionedSymbol symbol : getAllSymbols()) {
			int y = symbol.getY();

			if (y < smallestY) {
				smallestY = y;
			}
		}

		moveAllSymbolsY(offset - smallestY);
	}

	private void normalizeX() {

		int leftMostXValue = Integer.MAX_VALUE;
		int rightMostXValue = Integer.MIN_VALUE;

		List<PositionedSymbol> symbolsToConsider = new ArrayList<PositionedSymbol>();

		for (PositionedSymbol positionedSymbol : getAllSymbols()) {
			if (positionedSymbol.getBaseSymbol().getCategory() == 4) {
				symbolsToConsider.add(positionedSymbol);
			}
		}

		if (symbolsToConsider.isEmpty()) {
			symbolsToConsider = getAllSymbols();
		}

		for (PositionedSymbol symbol : symbolsToConsider) {
			int leftMostSymbolXValue = symbol.getX();
			int rightMostSymbolXValue = leftMostSymbolXValue + symbol.getWidth();

			if (leftMostSymbolXValue < leftMostXValue) {
				leftMostXValue = leftMostSymbolXValue;
			}
			if (rightMostSymbolXValue > rightMostXValue) {
				rightMostXValue = rightMostSymbolXValue;
			}
		}

		assert rightMostXValue >= leftMostXValue : "Postcondition failed: rightMostXValue >= leftMostXValue";
		int centerX = leftMostXValue + (rightMostXValue - leftMostXValue) / 2;
		moveAllSymbolsX(-centerX);
	}

	private void normalizeToHeadOffset() {
		int smallestHeadY = Integer.MAX_VALUE;

		for (PositionedSymbol positionedSymbol : getPlainSymbols()) {
			Symbol symbol = positionedSymbol.getSymbol();

			int headCircleTop = symbol.getHeight() - HeadSymbol.HEAD_CIRCLE_HEIGHT;

			// Only consider head symbols with minimum height of a head circle
			if (symbol.getCategory() == SymbolCategory.HEAD.getCategoryNumber() && headCircleTop >= 0) {
				int symbolY = positionedSymbol.getY() + headCircleTop;
				if (symbolY < smallestHeadY) {
					smallestHeadY = symbolY;
				}
			}
		}

		// Only move symbols if heads are above yOffset
		if (smallestHeadY < HEAD_OFFSET) {
			moveAllSymbolsY(HEAD_OFFSET - smallestHeadY);
		}
	}

	public int getMaxZ() {
		int result = 0;

		for (PositionedSymbol symbol : getPlainSymbols()) {
			result = Math.max(result, symbol.getZ());
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj.getClass().equals(getClass())) {
			SignId otherSign = ((SimpleSign) obj).getSignId();

			result = otherSign.equals(this.getSignId());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (int) generateHashCode();
	}

	private long generateHashCode() {
		final int prime = 31;
		long result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((disarrangedHeadSymbols == null) ? 0 : disarrangedHeadSymbols.hashCode());
		result = prime * result + ((handSymbols == null) ? 0 : handSymbols.hashCode());
		result = prime * result + ((headSymbols == null) ? 0 : headSymbols.hashCode());
		result = prime * result + ((modificationDate == null) ? 0 : modificationDate.hashCode());
		result = prime * result + (int) (revision ^ (revision >>> 32));
		result = prime * result + ((signId == null) ? 0 : signId.hashCode());
		result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
		result = prime * result + ((fingerAlphabetSymbols == null) ? 0 : fingerAlphabetSymbols.hashCode());
		return result;
	}

	public SimpleSign clone() {
		SimpleSign result = new SimpleSign(signId, getAuthor(), getSignLocale(), getModificationDate(), getComment());
		result.setRevision(getRevision());
		result.setPersistenceLocation(getPersistenceLocation());

		for (PositionedSymbol positionedSymbol : symbols) {
			result.addSymbol(positionedSymbol.clone());
		}

		for (HeadSymbol headSymbol : headSymbols) {
			result.addHeadSymbol(headSymbol.clone());
		}

		for (HeadSymbol headSymbol : disarrangedHeadSymbols) {
			result.addDisarrangedHeadSymbol(headSymbol.clone());
		}

		for (PositionedSymbol positionedSymbol : handSymbols) {
			result.addSymbol(positionedSymbol.clone());
		}

		for (PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol : fingerAlphabetSymbols) {
			result.addSymbol(positionedFingerAlphabetSymbol.clone());
		}

		return result;
	}

	public boolean contentBasedEquals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		SimpleSign other = (SimpleSign) obj;
		if (disarrangedHeadSymbols == null) {
			if (other.disarrangedHeadSymbols != null)
				return false;
		} else if (!disarrangedHeadSymbols.equals(other.disarrangedHeadSymbols))
			return false;
		if (handSymbols == null) {
			if (other.handSymbols != null)
				return false;
		} else if (!handSymbols.equals(other.handSymbols))
			return false;
		if (headSymbols == null) {
			if (other.headSymbols != null)
				return false;
		} else if (!headSymbols.equals(other.headSymbols))
			return false;
		if (comment == null) {
			if (other.getComment() != null) {
				return false;
			}
		} else if (!comment.equals(other.getComment())) {
			return false;
		}
		if (signId == null) {
			if (other.signId != null)
				return false;
		} else if (!signId.equals(other.signId))
			return false;
		if (symbols == null) {
			if (other.symbols != null)
				return false;
		} else if (!symbols.equals(other.symbols))
			return false;
		if (fingerAlphabetSymbols == null) {
			if (other.fingerAlphabetSymbols != null)
				return false;
		} else if (!fingerAlphabetSymbols.equals(other.fingerAlphabetSymbols))
			return false;
		if (getSignLocale() == null) {
			if (other.getSignLocale() != null)
				return false;
		} else if (!getSignLocale().equals(other.getSignLocale()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sign(id: ");
		builder.append(signId);

		builder.append(", symbols: [\n");
		for (PositionedSymbol symbol : symbols) {
			builder.append("  ");
			builder.append(symbol);
			builder.append("\n");
		}

		builder.append("], headSymbols: [\n");
		for (HeadSymbol headSymbol : headSymbols) {
			builder.append("  ");
			builder.append(headSymbol);
			builder.append("\n");
		}

		builder.append("], disarrangedHeadSymbols: [\n");
		for (HeadSymbol headSymbol : disarrangedHeadSymbols) {
			builder.append("  ");
			builder.append(headSymbol);
			builder.append("\n");
		}

		builder.append("], handSymbols: [\n");
		for (PositionedSymbol handSymbol : handSymbols) {
			builder.append("  ");
			builder.append(handSymbol);
			builder.append("\n");
		}

		builder.append("])");

		return builder.toString();
	}

	public int contentBasedHashCode() {
		final int prime = 31;
		int result = super.hashCode();

		for (PositionedSymbol symbol : getOtherSymbols()) {
			result = prime * result + symbol.hashCode();
		}

		for (HeadSymbol headSymbol : getHeadSymbols()) {
			result = prime * result + headSymbol.hashCode();
		}

		for (HeadSymbol headSymbol : getDisarrangedHeadSymbols()) {
			result = prime * result + headSymbol.hashCode();
		}

		for (PositionedSymbol handSymbol : getHandSymbols()) {
			result = prime * result + handSymbol.hashCode();
		}

		return result;
	}

	private boolean hasAnyHeadSymbols() {
		boolean result = hasHeadSymbols() || hasDisarrangedHeadSymbols();

		if (!result) {
			List<PositionedSymbol> symbols = getOtherSymbols();

			for (int i = 0, l = symbols.size(); i < l && !result; i++) {
				result = symbols.get(i).getSymbol().getCategory() == SymbolCategory.HEAD.getCategoryNumber();
			}
		}

		return result;
	}

	private void moveAllSymbolsY(int offset) {
		for (PositionedSymbol symbol : getAllSymbols()) {
			symbol.setY(symbol.getY() + offset);
		}
	}

	private void moveAllSymbolsX(int offset) {
		for (PositionedSymbol symbol : getAllSymbols()) {
			symbol.setX(symbol.getX() + offset);
		}
	}

	private Comparator<PositionedFingerAlphabetSymbol> createPositionedSymbolComparator() {
		return new Comparator<PositionedFingerAlphabetSymbol>() {

			public int compare(PositionedFingerAlphabetSymbol o1, PositionedFingerAlphabetSymbol o2) {
				return o1.getX() - o2.getX();
			}
		};
	}

	// protected

	/**
	 * Constructor.
	 * 
	 * @deprecated Only for serialization.
	 */
	@Deprecated
	protected SimpleSign() {
	}

	public long getRevision() {
		return revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

}
