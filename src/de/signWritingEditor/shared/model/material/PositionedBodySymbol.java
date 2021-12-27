package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class PositionedBodySymbol extends PositionedSymbol implements Cloneable {

	private static final long serialVersionUID = 3987202349931243741L;

	private Set<Symbol> validVariations;

	public PositionedBodySymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height,
			int x, int y, int z, Set<Symbol> validVariations) {
		super(new Symbol(SymbolCategory.BODY.getCategoryNumber(), group, symbol, variation, fill, rotation, width,
				height), x, y, z);

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedBodySymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert SymbolCategoryAnalyzer
				.isBodySymbol(symbol) : "Precondition failed: TEMPSymbolCategoryAnalyzer.isBodySymbol(symbol)";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedBodySymbol clone() {
		return new PositionedBodySymbol(
				new Symbol(getSymbol().getCategory(), getSymbol().getGroup(), getSymbol().getSymbol(),
						getSymbol().getVariation(), getSymbol().getFill(), getSymbol().getRotation(),
						getSymbol().getWidth(), getSymbol().getHeight()),
				getX(), getY(), getZ(), new HashSet<Symbol>(validVariations));
	}

	@Override
	public BaseSymbol getBaseSymbol() {
		return getSymbol().getBaseSymbol();
	}

	@Override
	public boolean canManipulate() {
		return validVariations.size() > 1;
	}

	@Override
	public boolean canRotate() {
		boolean result = false;

		if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.FINGERS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.TORSO_STRAIGHT_STRETCH_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.TORSO_CURVED_BLEND_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.TORSO_TWIST_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())) {
			result = true;
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_SPINE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() <= 2 && getSymbol().getRotation() != 3) {
			result = true;
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_POSITIONS.getIswaSymbol().getBaseSymbol())
				&& (getSymbol().getFill() <= 4 || (getSymbol().getFill() == 5 && getSymbol().getRotation() >= 3))) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean canMirror() {
		return (canManipulate() && BodyBaseSymbol.getBodyBaseSymbol(getSymbol().getBaseSymbol()).canBeMirrored())
				|| getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol().getBaseSymbol());
	}

	public boolean canSwitchToAlternatingArrows() {
		boolean result = false;

		if ((getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()))
				&& (getSymbol().getFill() == 2 || getSymbol().getFill() == 4)) {
			result = true;
		} else if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_STRAIGHT_STRETCH_WALL.getIswaSymbol().getBaseSymbol())
				&& (getSymbol().getFill() == 1 || getSymbol().getFill() == 3)
				&& (getSymbol().getRotation() == 1 || getSymbol().getRotation() == 3)) {
			result = true;
		}

		return result;
	}

	public boolean canSwitchToNormalArrows() {
		boolean result = false;

		if ((getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()))
				&& (getSymbol().getFill() == 3 || getSymbol().getFill() == 5)) {
			result = true;
		} else if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_STRAIGHT_STRETCH_WALL.getIswaSymbol().getBaseSymbol())
				&& (getSymbol().getFill() == 2 || getSymbol().getFill() == 4)
				&& (getSymbol().getRotation() == 1 || getSymbol().getRotation() == 3)) {
			result = true;
		}

		return result;
	}

	public boolean canSwitchSize() {
		boolean result = false;

		if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	public void switchToAlternatingArrows() {
		assert canSwitchToAlternatingArrows() : "Precondition failed: canSwitchToAlternatingArrows()";

		setFillAndRotation(getSymbol().getFill() + 1, getSymbol().getRotation());
	}

	public void switchToNormalArrows() {
		assert canSwitchToNormalArrows() : "Precondition failed: canSwitchToNormalArrows()";

		setFillAndRotation(getSymbol().getFill() - 1, getSymbol().getRotation());
	}

	@Override
	protected boolean isValidFill(int fill) {
		return BodyBaseSymbol.getBodyBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(fill);
	}

	@Override
	protected boolean isValidRotation(int rotation) {
		return BodyBaseSymbol.getBodyBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues()
				.contains(rotation);
	}

	public void switchSize() {
		assert canSwitchSize() : "Precondition failed: canSwitchSize()";

		int newFill = getSymbol().getFill();
		int newRotation = getSymbol().getRotation();
		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 13, 32, 17));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 12, 30, 30));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 15, 32, 2));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 14, 32, 9));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 16, 32, 9));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 5, 32, 17));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 4, 30, 30));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 7, 32, 2));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 6, 32, 9));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 9, 2, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 8, 32, 9));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 11, 17, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 10, 9, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 1, 5, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 2, 12, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 3, 18, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 4, 30, 30));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 16, 32, 12));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 15, 32, 5));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 14, 32, 12));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 13, 32, 18));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 12, 30, 30));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 11, 18, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 10, 12, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 9, 5, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 8, 32, 12));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 7, 32, 5));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 6, 32, 12));
			allVariations.add(new Symbol(5, 2, 2, 2, 2, 5, 32, 18));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 2, 9, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 3, 17, 32));
			allVariations.add(new Symbol(5, 2, 2, 2, 1, 1, 2, 32));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 2, 11, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 1, 2, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 7, 40, 5));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 6, 40, 14));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 5, 40, 22));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 4, 38, 38));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 11, 22, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 3, 22, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 2, 14, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 10, 14, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 1, 5, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 9, 5, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 8, 40, 14));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 15, 40, 5));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 14, 40, 14));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 13, 40, 22));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 12, 38, 38));
			allVariations.add(new Symbol(5, 2, 2, 3, 2, 16, 40, 14));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 13, 40, 21));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 14, 40, 11));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 11, 21, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 12, 39, 39));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 15, 40, 2));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 16, 40, 11));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 5, 40, 21));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 6, 40, 11));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 3, 21, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 4, 39, 39));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 9, 2, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 10, 11, 40));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 7, 40, 2));
			allVariations.add(new Symbol(5, 2, 2, 3, 1, 8, 40, 11));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 9, 2, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 8, 48, 13));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 7, 48, 2));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 6, 48, 13));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 5, 48, 25));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 4, 47, 47));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 3, 25, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 2, 13, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 16, 48, 13));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 15, 48, 2));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 14, 48, 13));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 13, 48, 25));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 12, 47, 47));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 11, 25, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 10, 13, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 1, 5, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 2, 16, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 4, 45, 45));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 3, 25, 46));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 6, 48, 16));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 5, 46, 25));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 8, 48, 16));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 7, 48, 5));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 10, 16, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 9, 5, 48));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 12, 45, 45));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 11, 25, 46));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 14, 48, 16));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 13, 46, 25));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 16, 48, 16));
			allVariations.add(new Symbol(5, 2, 2, 4, 2, 15, 48, 5));
			allVariations.add(new Symbol(5, 2, 2, 4, 1, 1, 2, 48));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 1, 2, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 2, 3, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 3, 5, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 10, 4, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 9, 3, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 12, 9, 9));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 11, 6, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 6, 8, 4));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 5, 8, 6));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 8, 8, 4));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 7, 8, 3));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 14, 8, 4));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 13, 8, 6));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 16, 8, 4));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 15, 8, 3));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 3, 6, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 4, 9, 9));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 1, 3, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 2, 2, 4, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 11, 5, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 10, 3, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 9, 2, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 8, 8, 3));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 7, 8, 2));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 6, 8, 3));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 5, 8, 5));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 4, 8, 8));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 16, 8, 3));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 15, 8, 2));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 14, 8, 3));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 13, 8, 5));
			allVariations.add(new Symbol(5, 2, 3, 3, 1, 12, 8, 8));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 2, 10, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 3, 14, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 4, 22, 22));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 5, 24, 14));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 1, 5, 25));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 10, 7, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 9, 2, 25));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 12, 22, 22));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 11, 13, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 6, 24, 7));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 5, 24, 13));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 8, 24, 7));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 7, 25, 2));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 14, 24, 7));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 13, 24, 13));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 16, 24, 7));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 15, 25, 2));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 3, 13, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 4, 22, 22));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 1, 2, 25));
			allVariations.add(new Symbol(5, 2, 2, 1, 1, 2, 7, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 16, 24, 10));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 14, 24, 10));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 15, 25, 5));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 8, 24, 10));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 9, 5, 25));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 6, 24, 10));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 7, 25, 5));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 12, 22, 22));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 13, 24, 14));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 10, 10, 24));
			allVariations.add(new Symbol(5, 2, 2, 1, 2, 11, 15, 24));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());

		} else if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 7, 16, 2));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 6, 16, 5));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 9, 2, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 8, 16, 5));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 11, 8, 14));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 10, 5, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 13, 14, 8));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 12, 12, 12));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 15, 16, 2));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 14, 16, 5));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 16, 16, 5));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 1, 4, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 2, 7, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 3, 10, 14));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 4, 13, 13));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 5, 14, 10));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 6, 16, 7));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 10, 7, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 9, 4, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 8, 16, 7));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 7, 16, 4));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 14, 16, 7));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 13, 14, 10));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 12, 13, 13));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 11, 10, 14));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 16, 16, 7));
			allVariations.add(new Symbol(5, 2, 3, 1, 2, 15, 16, 4));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 4, 12, 12));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 5, 14, 8));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 2, 5, 16));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 3, 8, 14));
			allVariations.add(new Symbol(5, 2, 3, 1, 1, 1, 2, 16));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 14, 12, 4));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 13, 10, 6));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 16, 12, 4));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 15, 12, 2));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 10, 4, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 9, 2, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 12, 10, 10));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 11, 6, 10));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 6, 12, 4));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 5, 10, 6));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 8, 12, 4));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 7, 12, 2));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 2, 6, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 3, 8, 10));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 4, 11, 11));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 5, 10, 8));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 1, 4, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 16, 12, 6));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 15, 12, 4));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 14, 12, 6));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 13, 10, 8));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 12, 11, 11));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 11, 8, 10));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 10, 6, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 9, 4, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 8, 12, 6));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 7, 12, 4));
			allVariations.add(new Symbol(5, 2, 3, 2, 2, 6, 12, 6));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 4, 10, 10));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 3, 6, 10));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 2, 4, 12));
			allVariations.add(new Symbol(5, 2, 3, 2, 1, 1, 2, 12));

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() % 2 == 1) {
				newFill = getSymbol().getFill() - 2;
				newFill = newFill > 0 ? newFill : 5;
			} else {
				newFill = getSymbol().getFill() - 2;
				newFill = newFill > 0 ? newFill : 6;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() % 2 == 1) {
				newFill = getSymbol().getFill() - 2;
				newFill = newFill > 0 ? newFill : 5;
			} else {
				newFill = getSymbol().getFill() - 2;
				newFill = newFill > 0 ? newFill : 6;
			}
		}
		setFillAndRotation(newFill, newRotation);
	}

	private boolean isMirrored() {
		boolean result = false;

		if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.FINGERS.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() > 8) {
				result = true;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_CURVED_BLEND_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() >= 3) {
				result = true;
			}
		}

		return result;

	}

	@Override
	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int nextRotation = getSymbol().getRotation();
		int nextFill = getSymbol().getFill();

		if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_STRAIGHT_STRETCH_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 1) {
				nextRotation = 2;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 2) {
				nextFill = 2;
				nextRotation = 4;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 3) {
				nextFill = 2;
				nextRotation = 2;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 4) {
				nextRotation = 1;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 2) {
				nextFill = 1;
				nextRotation = 4;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 4) {
				nextFill = 1;
				nextRotation = 3;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 1) {
				nextRotation = 3;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 3) {
				nextRotation = 1;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_CURVED_BLEND_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.TORSO_TWIST_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 1) {
				nextFill = 2;
				nextRotation = 2;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 2) {
				nextRotation = 1;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 3) {
				nextRotation = 4;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 4) {
				nextFill = 2;
				nextRotation = 1;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 1) {
				nextRotation = 4;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 2) {
				nextRotation = 3;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 3) {
				nextFill = 1;
				nextRotation = 2;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 4) {
				nextFill = 1;
				nextRotation = 3;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_POSITIONS.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 2;
				} else if (getSymbol().getRotation() == 2) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 3) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 4;
				}
			} else if (getSymbol().getFill() == 2) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 2;
				} else if (getSymbol().getRotation() == 2) {
					nextFill = 3;
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 3) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 5) {
					nextFill = 3;
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 4;
				}
			} else if (getSymbol().getFill() == 3) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 2;
				} else if (getSymbol().getRotation() == 2) {
					nextFill = 2;
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 3) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 5) {
					nextFill = 2;
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 4;
				}
			} else if (getSymbol().getFill() == 4) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 2;
				} else if (getSymbol().getRotation() == 2) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 3) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 4;
				}
			} else if (getSymbol().getFill() == 5) {
				if (getSymbol().getRotation() == 3) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 4;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 3;
				}
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_SPINE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() <= 2) {
			if (getSymbol().getRotation() == 1) {
				nextRotation = 2;
			} else if (getSymbol().getRotation() == 2) {
				nextRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				nextRotation = 1;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 3) {
			if (getSymbol().getRotation() == 1) {
				nextRotation = 2;
			} else if (getSymbol().getRotation() == 2) {
				nextRotation = 3;
			} else if (getSymbol().getRotation() == 3) {
				nextRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				nextRotation = 1;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 4) {
			if (getSymbol().getRotation() == 1) {
				nextRotation = 2;
			} else if (getSymbol().getRotation() == 2) {
				nextRotation = 4;
			} else if (getSymbol().getRotation() == 3) {
				nextRotation = 1;
			} else if (getSymbol().getRotation() == 4) {
				nextRotation = 3;
			}
		} else {
			if (isMirrored()) {
				nextRotation = getPreviousRotation();
			} else {
				nextRotation = getNextRotation();
			}
		}

		setFillAndRotation(nextFill, nextRotation);
	}

	@Override
	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int nextRotation = getSymbol().getRotation();
		int nextFill = getSymbol().getFill();

		if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_STRAIGHT_STRETCH_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 1) {
				nextRotation = 4;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 2) {
				nextRotation = 1;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 3) {
				nextFill = 2;
				nextRotation = 4;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 4) {
				nextFill = 2;
				nextRotation = 2;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 2) {
				nextFill = 1;
				nextRotation = 3;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 4) {
				nextFill = 1;
				nextRotation = 2;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 1) {
				nextFill = 2;
				nextRotation = 3;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 3) {
				nextFill = 2;
				nextRotation = 1;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_CURVED_BLEND_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.TORSO_TWIST_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 1) {
				nextRotation = 2;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 2) {
				nextFill = 2;
				nextRotation = 3;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 3) {
				nextFill = 2;
				nextRotation = 4;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 4) {
				nextRotation = 3;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 1) {
				nextFill = 1;
				nextRotation = 4;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 2) {
				nextFill = 1;
				nextRotation = 1;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 3) {
				nextRotation = 2;
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 4) {
				nextFill = 2;
				nextRotation = 1;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_POSITIONS.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 2) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 3) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 4;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 2;
				}
			} else if (getSymbol().getFill() == 2) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 2) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 3) {
					nextFill = 3;
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 4;
				} else if (getSymbol().getRotation() == 6) {
					nextFill = 3;
					nextRotation = 2;
				}
			} else if (getSymbol().getFill() == 3) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 2) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 3) {
					nextFill = 2;
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 4;
				} else if (getSymbol().getRotation() == 6) {
					nextFill = 2;
					nextRotation = 2;
				}
			} else if (getSymbol().getFill() == 4) {
				if (getSymbol().getRotation() == 1) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 2) {
					nextRotation = 1;
				} else if (getSymbol().getRotation() == 3) {
					nextRotation = 2;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 4;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 5;
				}
			} else if (getSymbol().getFill() == 5) {
				if (getSymbol().getRotation() == 3) {
					nextRotation = 6;
				} else if (getSymbol().getRotation() == 4) {
					nextRotation = 5;
				} else if (getSymbol().getRotation() == 5) {
					nextRotation = 3;
				} else if (getSymbol().getRotation() == 6) {
					nextRotation = 4;
				}
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_SPINE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() <= 2) {
			if (getSymbol().getRotation() == 1) {
				nextRotation = 4;
			} else if (getSymbol().getRotation() == 2) {
				nextRotation = 1;
			} else if (getSymbol().getRotation() == 4) {
				nextRotation = 2;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 3) {
			if (getSymbol().getRotation() == 1) {
				nextRotation = 4;
			} else if (getSymbol().getRotation() == 2) {
				nextRotation = 1;
			} else if (getSymbol().getRotation() == 3) {
				nextRotation = 2;
			} else if (getSymbol().getRotation() == 4) {
				nextRotation = 3;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 4) {
			if (getSymbol().getRotation() == 1) {
				nextRotation = 3;
			} else if (getSymbol().getRotation() == 2) {
				nextRotation = 1;
			} else if (getSymbol().getRotation() == 3) {
				nextRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				nextRotation = 2;
			}
		} else {
			if (isMirrored()) {
				nextRotation = getNextRotation();
			} else {
				nextRotation = getPreviousRotation();
			}
		}

		setFillAndRotation(nextFill, nextRotation);

	}

	private int getPreviousRotation() {

		int maxRotations = Collections
				.max(BodyBaseSymbol.getBodyBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues());
		int unmirroredRotations = canMirror() ? maxRotations / 2 : maxRotations;

		int result = getSymbol().getRotation();

		result -= 1;
		if (result < 1) {
			result = unmirroredRotations;
		} else if (result == unmirroredRotations) {
			result = maxRotations;
		}

		return result;
	}

	private int getNextRotation() {
		int maxRotations = Collections
				.max(BodyBaseSymbol.getBodyBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues());
		int unmirroredRotations = canMirror() ? maxRotations / 2 : maxRotations;
		boolean isMirrored = getSymbol().getRotation() > unmirroredRotations;

		int result = getSymbol().getRotation() % unmirroredRotations + 1;

		if (isMirrored) {
			result += unmirroredRotations;
		}

		return result;
	}

	@Override
	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : validVariations) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	@Deprecated
	protected PositionedBodySymbol() {

	}

	@Override
	public void mirror() {
		assert canMirror();

		int newRotation = getSymbol().getRotation();
		int newFill = getSymbol().getFill();

		if (getBaseSymbol().equals(BodyBaseSymbol.TORSO_CURVED_BLEND_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.TORSO_TWIST_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			newRotation += 2;
			if (newRotation > 4) {
				newRotation -= 4;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_POSITIONS.getIswaSymbol().getBaseSymbol())) {
			if (newFill == 1) {
				if (getSymbol().getRotation() == 1) {
					newRotation = 1;
				} else if (getSymbol().getRotation() == 2) {
					newRotation = 3;
				} else if (getSymbol().getRotation() == 3) {
					newRotation = 2;
				} else if (getSymbol().getRotation() == 4) {
					newRotation = 4;
				} else if (getSymbol().getRotation() == 5) {
					newRotation = 6;
				} else if (getSymbol().getRotation() == 6) {
					newRotation = 5;
				}
			} else if (newFill >= 2 && newFill <= 4) {
				if (getSymbol().getRotation() == 1) {
					newRotation = 4;
				} else if (getSymbol().getRotation() == 2) {
					newRotation = 6;
				} else if (getSymbol().getRotation() == 3) {
					newRotation = 5;
				} else if (getSymbol().getRotation() == 4) {
					newRotation = 1;
				} else if (getSymbol().getRotation() == 5) {
					newRotation = 3;
				} else if (getSymbol().getRotation() == 6) {
					newRotation = 2;
				}
			} else if (newFill == 5) {
				if (getSymbol().getRotation() == 1) {
					newRotation = 2;
				} else if (getSymbol().getRotation() == 2) {
					newRotation = 1;
				} else if (getSymbol().getRotation() == 3) {
					newRotation = 3;
				} else if (getSymbol().getRotation() == 4) {
					newRotation = 4;
				} else if (getSymbol().getRotation() == 5) {
					newRotation = 6;
				} else if (getSymbol().getRotation() == 6) {
					newRotation = 5;
				}
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& newFill == 3) {
			if (getSymbol().getRotation() == 2) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 2;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& newFill == 4) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 3;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 1;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 2;
			}

		} else if (getBaseSymbol().equals(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() % 2 == 1) {
				newFill = getSymbol().getFill() + 1;
			} else {
				newFill = getSymbol().getFill() - 1;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() % 2 == 1) {
				newFill = getSymbol().getFill() + 1;
			} else {
				newFill = getSymbol().getFill() - 1;
			}
		} else {
			newRotation += 8;
			if (newRotation > 16) {
				newRotation -= 16;
			}
		}
		setFillAndRotation(newFill, newRotation);
	}

	@Override
	public boolean canIncrease() {
		boolean result = false;

		if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1) {
				result = true;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() <= 3) {
				result = true;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_SPINE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() < 2) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean canDecrease() {
		boolean result = false;

		if (getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 2) {
				result = true;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() != 1 && getSymbol().getFill() != 3) {
				result = true;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_SPINE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 2) {
			result = true;
		}

		return result;
	}

	@Override
	public void increase() {
		assert canIncrease();

		int newFill = getSymbol().getFill();

		if (getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 1) {
				newFill = 2;
			} else if (getSymbol().getFill() == 2) {
				newFill = 4;
			} else if (getSymbol().getFill() == 3) {
				newFill = 5;
			}
		} else {
			newFill = 2;
		}

		setFillAndRotation(newFill, getSymbol().getRotation());
	}

	@Override
	public void decrease() {
		assert canDecrease();

		int newFill = getSymbol().getFill();

		if (getBaseSymbol().equals(BodyBaseSymbol.UPPER_BODY_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() == 2) {
				newFill = 1;
			} else if (getSymbol().getFill() == 4) {
				newFill = 2;
			} else if (getSymbol().getFill() == 5) {
				newFill = 3;
			}
		} else {
			newFill = 1;
		}

		setFillAndRotation(newFill, getSymbol().getRotation());

	}

	@Override
	public boolean canMirrorVertically() {
		return (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 3)
				|| getBaseSymbol().equals(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol().getBaseSymbol());
	}

	@Override
	public void mirrorVertically() {
		int newRotation = getSymbol().getRotation();
		if (getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 3) {
			if (getSymbol().getRotation() == 2) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 2;
			}
		} else if (getBaseSymbol().equals(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol().getBaseSymbol())) {
			validVariations.clear();
			validVariations.add(new Symbol(4, 3, 7, 2, 3, 1, 7, 12));
			validVariations.add(new Symbol(4, 3, 7, 2, 2, 1, 11, 19));
			validVariations.add(new Symbol(4, 3, 7, 2, 4, 1, 7, 12));
			validVariations.add(new Symbol(4, 3, 7, 2, 1, 1, 11, 19));
			validVariations.add(new Symbol(4, 3, 7, 2, 5, 1, 6, 9));
			validVariations.add(new Symbol(4, 3, 7, 2, 6, 1, 6, 9));
		} else if (getBaseSymbol().equals(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol().getBaseSymbol())) {
			validVariations.clear();
			validVariations.add(new Symbol(4, 3, 7, 1, 3, 1, 7, 12));
			validVariations.add(new Symbol(4, 3, 7, 1, 4, 1, 7, 12));
			validVariations.add(new Symbol(4, 3, 7, 1, 6, 1, 6, 9));
			validVariations.add(new Symbol(4, 3, 7, 1, 5, 1, 6, 9));
			validVariations.add(new Symbol(4, 3, 7, 1, 2, 1, 11, 19));
			validVariations.add(new Symbol(4, 3, 7, 1, 1, 1, 11, 19));
		}
		setFillAndRotation(getSymbol().getFill(), newRotation);
	}

}
