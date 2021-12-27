package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;

public class HeadSymbol extends PositionedSymbol implements Serializable, Cloneable {
	private static final long serialVersionUID = 6001608246777479534L;

	public static final int HEAD_CIRCLE_WIDTH = 36;
	public static final int HEAD_CIRCLE_HEIGHT = 35;
	public static final int HEAD_SYMBOL_HEIGHT = 50;
	public static final int HEAD_CIRCLE_OFFSET = HEAD_SYMBOL_HEIGHT - HEAD_CIRCLE_HEIGHT;

	private static final int EXPRESSION_UPPER_OVERHEAD = 6;
	private static final int EXPRESSION_LEFT_OVERHEAD = 5;
	private static final int TONGUE_MOVES_AGAINST_CHEEK_FILL_1_2_ROTATION_3_BOTTOM_OVERHEAD = 4;
	private static final int TONGUE_MOVES_AGAINST_CHEEK_FILL_1_ROTATION_1_FILL_2_ROTATION_1_6_7_8_LEFT_OVERHEAD = 3;
	private static final int TONGUE_MOVES_AGAINST_CHEEK_FILL_1_ROTATION_5_6_7_8_FILL_2_ROTATION_5_RIGHT_OVERHEAD = 3;
	private static final int NECK_SHIFT_UPWARDS = -1;
	private static final int EARS_SHIFT_INWARDS = 4;
	private static final int LEFT_EAR_LEFT_OVERHEAD = 6;
	public static final int JAW_HEAD_RIM_OFFSET_Y_FROM_CIRCLE_CENTER = 12;
	public static final int JAW_SYMBOL_ARROW_Y_DISTANCE_FROM_HEAD_CENTER = 13;
	private static final int JAW_SYMBOL_ARROW_X_DISTANCE_FROM_HEAD_BORDER = -6;
	private static final int HAIR_UPPER_OVERHEAD = 39;
	private static final int HAIR_LEFT_OVERHEAD = 38;

    // Distance to the vertical center of the eye and mouth symbol, measured
	// from bottom
	private static final int EYE_Y_OFFSET_CENTER = -7;
	private static final int LEFT_EYE_OFFSET = 2;
	private static final int RIGHT_EYE_OFFSET = LEFT_EYE_OFFSET;
	private static final int MOUTH_OFFSET = 8;
	private static final int BREATH_LEFT_OVERHEAD = 6;
	public static final int BREATH_CENTER_OFFSET = 7;

	private PositionedHeadPostureSymbol headPostureSymbol;
	private PositionedNoseSymbol noseSymbol;
	private PositionedNeckSymbol neckSymbol;
	private PositionedExpressionSymbol expressionSymbol;
	private PositionedHairSymbol hairSymbol;
	private PositionedMouthSymbol mouthSymbol;

	private List<PositionedEyeSymbol> eyeSymbols;
	private List<PositionedCheekSymbol> cheeksSymbols;
	private List<PositionedEarsSymbol> earsSymbols;
	private List<PositionedBreathSymbol> breathSymbols;
	private List<PositionedJawSymbol> jawSymbols;

	private boolean isFreePositionable;

	HeadSymbol(PositionedHeadPostureSymbol headPosture, PositionedSymbol... positionedSymbols) {
		this(headPosture, 0, 0, 1, positionedSymbols);
	}

	HeadSymbol(PositionedHeadPostureSymbol headPosture, int x, int y, int z, PositionedSymbol... positionedSymbols) {
		super(headPosture.getSymbol(), x, y, z);
		assert headPosture != null : "Precondition failed: headPosture != null";

		setFreePositionable(false);

		headPostureSymbol = headPosture;

		noseSymbol = new PositionedNoseSymbol(NoseBaseSymbol.NONE.getIswaSymbol());
		neckSymbol = new PositionedNeckSymbol(NeckBaseSymbol.NONE.getIswaSymbol());
		expressionSymbol = new PositionedExpressionSymbol(ExpressionBaseSymbol.NONE.getIswaSymbol());
		hairSymbol = new PositionedHairSymbol(HairBaseSymbol.NONE.getIswaSymbol());
		mouthSymbol = new PositionedMouthSymbol(MouthBaseSymbol.NONE.getIswaSymbol());

		eyeSymbols = new ArrayList<PositionedEyeSymbol>();
		cheeksSymbols = new ArrayList<PositionedCheekSymbol>();
		earsSymbols = new ArrayList<PositionedEarsSymbol>();
		breathSymbols = new ArrayList<PositionedBreathSymbol>();
		jawSymbols = new ArrayList<PositionedJawSymbol>();

		if (positionedSymbols != null) {
			for (PositionedSymbol positionedSymbol : positionedSymbols) {
				if (positionedSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
				} else {
					if (positionedSymbol instanceof PositionedEyeSymbol) {
						eyeSymbols.add((PositionedEyeSymbol) positionedSymbol);
					} else if (positionedSymbol instanceof PositionedNoseSymbol) {
						noseSymbol = (PositionedNoseSymbol) positionedSymbol;
					} else if (positionedSymbol instanceof PositionedCheekSymbol) {
						cheeksSymbols.add((PositionedCheekSymbol) positionedSymbol);
					} else if (positionedSymbol instanceof PositionedMouthSymbol) {
						mouthSymbol = ((PositionedMouthSymbol) positionedSymbol);
					} else if (positionedSymbol instanceof PositionedEarsSymbol) {
						earsSymbols.add((PositionedEarsSymbol) positionedSymbol);
					} else if (positionedSymbol instanceof PositionedBreathSymbol) {
						breathSymbols.add((PositionedBreathSymbol) positionedSymbol);
					} else if (positionedSymbol instanceof PositionedJawSymbol) {
						jawSymbols.add((PositionedJawSymbol) positionedSymbol);
					} else if (positionedSymbol instanceof PositionedNeckSymbol) {
						neckSymbol = (PositionedNeckSymbol) positionedSymbol;
					} else if (positionedSymbol instanceof PositionedExpressionSymbol) {
						expressionSymbol = (PositionedExpressionSymbol) positionedSymbol;
					} else if (positionedSymbol instanceof PositionedHairSymbol) {
						hairSymbol = (PositionedHairSymbol) positionedSymbol;
					} else if (positionedSymbol instanceof PositionedHeadPostureSymbol) {
						setSymbol(positionedSymbol.getSymbol());
						this.headPostureSymbol = (PositionedHeadPostureSymbol) positionedSymbol;
					}
				}
			}
		}
	}

	/**
	 * Return a new HeadSymbol representing whitespace between two head symbols.
	 */
	public static HeadSymbol createSpaceHead() {
		PositionedHeadPostureSymbol positionedHeadPostureSymbol = new PositionedHeadPostureSymbol(
				HeadPostureBaseSymbol.NONE_SPACE_WIDTH.getIswaSymbol());
		return new HeadSymbol(positionedHeadPostureSymbol);
	}

	public boolean hasBreath() {
		return !breathSymbols.isEmpty();
	}

	public boolean hasCheeks() {
		return !cheeksSymbols.isEmpty();
	}

	public boolean hasEars() {
		return !earsSymbols.isEmpty();
	}

	public boolean hasExpression() {
		return !expressionSymbol.getSymbol().equals(ExpressionBaseSymbol.NONE.getIswaSymbol());
	}

	public boolean hasEyes() {
		return !eyeSymbols.isEmpty();
	}

	public boolean hasHair() {
		return !(hairSymbol.getSymbol().equals(HairBaseSymbol.NONE.getIswaSymbol()));
	}

	public boolean hasHeadPosture() {
		return !headPostureSymbol.equals(PositionedHeadPostureSymbol.getEmptyHeadPostureSymbol());
	}

	public boolean hasJaw() {
		return !jawSymbols.isEmpty();
	}

	public boolean hasMouth() {
		return !(mouthSymbol.getSymbol().equals(MouthBaseSymbol.NONE.getIswaSymbol()));
	}

	public boolean hasNeck() {
		return !neckSymbol.getSymbol().equals(NeckBaseSymbol.NONE.getIswaSymbol());
	}

	public boolean hasNose() {
		return !noseSymbol.getSymbol().equals(NoseBaseSymbol.NONE.getIswaSymbol());
	}

	public boolean isPlaceholder() {
		return !(hasBreath() || hasCheeks() || hasEars() || hasExpression() || hasEyes() || hasHair()
				|| hasHeadPosture() || hasJaw() || hasMouth() || hasNeck() || hasNose());
	}

	public int getUpperExtension() {
		double result = 0;

		if (hasHair()) {
			PositionedHairSymbol hair = getPositionedHairSymbol();
			result = Math.max(result, (hair.getHeight() - HEAD_CIRCLE_HEIGHT) / 2.0 + hair.getY());
		}
		if (hasExpression()) {
			PositionedExpressionSymbol expression = getPositionedExpressionSymbol();
			result = Math.max(result, (expression.getHeight() - HEAD_CIRCLE_HEIGHT) / 2.0 + expression.getY());
		}
		if (hasHeadPosture()) {
			int headPostureOverhead = headPostureSymbol.getHeight() - HEAD_CIRCLE_HEIGHT;
			result = Math.max(result, headPostureOverhead);
		}

		return (int) Math.ceil(result);
	}

	public int getLowerExtension() {
		double result = 0;

		if (hasNeck()) {
			PositionedNeckSymbol neck = getPositionedNeckSymbol();
			result = Math.max(result, (neck.getHeight() + NECK_SHIFT_UPWARDS) + neck.getY());
		}
		if (hasJaw()) {
			for (PositionedJawSymbol jaw : jawSymbols) {
				if (!Symbol.JAW_PART_HEAD_RIM.equals(jaw.getSymbol())) {
					result = Math.max(result,
							(jaw.getHeight() + JAW_HEAD_RIM_OFFSET_Y_FROM_CIRCLE_CENTER - (HEAD_CIRCLE_HEIGHT / 2))
									- jaw.getY());
				}
			}
		}
		if (hasExpression()) {
			PositionedExpressionSymbol expression = getPositionedExpressionSymbol();
			result = Math.max(result, (expression.getHeight() - HEAD_CIRCLE_HEIGHT) / 2.0 + expression.getY());
		}
		if (hasHair()) {
			PositionedHairSymbol hair = getPositionedHairSymbol();
			result = Math.max(result, (hair.getHeight() - HEAD_CIRCLE_HEIGHT) / 2.0 - hair.getY());
		}

		return (int) Math.ceil(result);
	}

	public int getHeight() {
		int result = 0;

		if (!getAllPositionedSymbols().isEmpty()) {
			int symbolMaxY = Integer.MIN_VALUE;

			int symbolMinY = Integer.MAX_VALUE;

			for (PositionedSymbol positionedSymbol : getAllPositionedSymbols()) {
				if (!positionedSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
					int[] position = getPositionForPositionedSymbol(positionedSymbol);
					int symbolUp = position[1] + positionedSymbol.getY();
					int symbolDown = symbolUp + positionedSymbol.getSymbol().getHeight();

					if (symbolUp < symbolMinY) {
						symbolMinY = symbolUp;
					}

					if (symbolDown > symbolMaxY) {
						symbolMaxY = symbolDown;
					}
				}
			}

			result = symbolMaxY - symbolMinY;
		}

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public PositionedHeadPostureSymbol getPositionedHeadPostureSymbol() {
		return headPostureSymbol;
	}

	public void setHeadPostureSymbol(PositionedHeadPostureSymbol headPostureSymbol) {
		this.headPostureSymbol = headPostureSymbol;
	}

	public List<PositionedEyeSymbol> getPositionedEyeSymbols() {
		return eyeSymbols;
	}

	public void setEyeSymbols(List<PositionedEyeSymbol> eyeSymbols) {
		this.eyeSymbols = eyeSymbols;
	}

	public PositionedNoseSymbol getPositionedNoseSymbol() {
		return noseSymbol;
	}

	public void setNoseSymbol(PositionedNoseSymbol noseSymbol) {
		this.noseSymbol = noseSymbol;
	}

	public List<PositionedCheekSymbol> getPositionedCheekSymbols() {
		return cheeksSymbols;
	}

	public void setCheekSymbols(List<PositionedCheekSymbol> cheekSymbols) {
		this.cheeksSymbols = cheekSymbols;
	}

	public PositionedMouthSymbol getPositionedMouthSymbol() {
		return mouthSymbol;
	}

	public void setMouthSymbol(PositionedMouthSymbol mouthSymbol) {
		this.mouthSymbol = mouthSymbol;
	}

	public List<PositionedEarsSymbol> getPositionedEarSymbols() {
		return earsSymbols;
	}

	public void setEarSymbols(List<PositionedEarsSymbol> earsSymbol) {
		this.earsSymbols = earsSymbol;
	}

	public List<PositionedBreathSymbol> getPositionedBreathSymbols() {
		return breathSymbols;
	}

	public void setBreathSymbols(List<PositionedBreathSymbol> breathSymbols) {
		this.breathSymbols = breathSymbols;
	}

	public List<PositionedJawSymbol> getPositionedJawSymbols() {
		return jawSymbols;
	}

	public void setJawSymbol(List<PositionedJawSymbol> jawSymbols) {
		this.jawSymbols = jawSymbols;
	}

	public PositionedNeckSymbol getPositionedNeckSymbol() {
		return neckSymbol;
	}

	public void setNeckSymbol(PositionedNeckSymbol neckSymbol) {
		this.neckSymbol = neckSymbol;
	}

	public PositionedExpressionSymbol getPositionedExpressionSymbol() {
		return expressionSymbol;
	}

	public void setExpressionSymbol(PositionedExpressionSymbol expressionSymbol) {
		this.expressionSymbol = expressionSymbol;
	}

	public PositionedHairSymbol getPositionedHairSymbol() {
		return hairSymbol;
	}

	public void setHairSymbol(PositionedHairSymbol hairSymbol) {
		this.hairSymbol = hairSymbol;
	}

	public boolean isWhitespace() {
		return getPositionedHeadPostureSymbol().getSymbol()
				.equals(HeadPostureBaseSymbol.NONE_SPACE_WIDTH.getIswaSymbol())
				&& !(hasBreath() || hasCheeks() || hasEars() || hasExpression() || hasEyes() || hasHair() || hasJaw()
						|| !getPositionedMouthSymbol().getSymbol().equals(MouthBaseSymbol.WHITESPACE.getIswaSymbol())
						|| hasNeck() || hasNose());
	}

	@Override
	public int getWidth() {
		int result = 0;

		if (!getAllPositionedSymbols().isEmpty()) {
			int symbolMaxX = Integer.MIN_VALUE;

			int symbolMinX = Integer.MAX_VALUE;

			for (PositionedSymbol positionedSymbol : getAllPositionedSymbols()) {
				if (!positionedSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
					int[] position = getPositionForPositionedSymbol(positionedSymbol);
					int symbolLeft = position[0] + positionedSymbol.getX();
					int symbolRight = symbolLeft + positionedSymbol.getSymbol().getWidth();

					if (symbolLeft < symbolMinX) {
						symbolMinX = symbolLeft;
					}

					if (symbolRight > symbolMaxX) {
						symbolMaxX = symbolRight;
					}
				}
			}

			result = symbolMaxX - symbolMinX;
		}

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	private int[] getPositionForPositionedSymbol(PositionedSymbol positionedSymbol) {

		int[] result = new int[3];

		if (positionedSymbol instanceof PositionedEyeSymbol) {
			result = getRelativeEyeSymbolPosition(((PositionedEyeSymbol) positionedSymbol).getLocation(),
					positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedNoseSymbol) {
			result = getRelativeNoseSymbolPosition(positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedCheekSymbol) {
			result = getRelativeCheeksSymbolPosition(((PositionedCheekSymbol) positionedSymbol).getLocation(),
					positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedMouthSymbol) {
			result = getRelativeMouthSymbolPosition(positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedEarsSymbol) {
			result = getRelativeEarSymbolPosition(((PositionedEarsSymbol) positionedSymbol).getLocation(),
					positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedBreathSymbol) {
			result = getRelativeBreathSymbolPosition(((PositionedBreathSymbol) positionedSymbol).getLocation(),
					positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedJawSymbol) {
			result = getRelativeJawSymbolPosition(((PositionedJawSymbol) positionedSymbol).getLocation(),
					positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedNeckSymbol) {
			result = getRelativeNeckSymbolPosition(positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedExpressionSymbol) {
			result = getRelativeExpressionSymbolPosition(positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedHairSymbol) {
			result = getRelativeHairSymbolPosition(positionedSymbol.getWidth(), positionedSymbol.getHeight());
		} else if (positionedSymbol instanceof PositionedHeadPostureSymbol) {
			result = getRelativeHeadPosturePosition(positionedSymbol.getWidth(), positionedSymbol.getHeight());
		}

		return result;

	}

	public void rotateHeadPostureClockwise() {
		assert hasHeadPosture() : "Precondition failed: hasHeadPosture()";
		assert headPostureSymbol.canRotate() : "Precondition failed: headPostureSymbol.canRotate()";

		headPostureSymbol.rotateClockwise();
	}

	public void rotateHeadPostureCounterClockwise() {
		assert hasHeadPosture() : "Precondition failed: hasHeadPosture()";
		assert headPostureSymbol.canRotate() : "Precondition failed: headPostureSymbol.canRotate()";

		headPostureSymbol.rotateCounterClockwise();
	}

	public void switchHeadPostureToNormalArrows() {
		assert hasHeadPosture() : "Precondition failed: hasHeadPosture()";
		assert headPostureSymbol
				.canSwitchToNormalArrows() : "Precondition failed: headPostureSymbol.canSwitchToNormalArrows()";

		headPostureSymbol.switchToNormalArrows();
	}

	public void switchHeadPostureToAlternatingArrows() {
		assert hasHeadPosture() : "Precondition failed: hasHeadPosture()";
		assert headPostureSymbol
				.canSwitchToAlternatingArrows() : "Precondition failed: headPostureSymbol.canSwitchToAlternatingArrows()";

		headPostureSymbol.switchToAlternatingArrows();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;

		if (!result && obj != null && obj instanceof HeadSymbol) {
			HeadSymbol otherHeadSymbol = (HeadSymbol) obj;

			result = this.getX() == otherHeadSymbol.getX() && this.getY() == otherHeadSymbol.getY()
					&& this.getZ() == otherHeadSymbol.getZ();

			result &= this.getAllPositionedSymbols().size() == otherHeadSymbol.getAllPositionedSymbols().size();

			List<PositionedSymbol> one = new ArrayList<PositionedSymbol>(this.getAllPositionedSymbols());
			List<PositionedSymbol> two = new ArrayList<PositionedSymbol>(otherHeadSymbol.getAllPositionedSymbols());

			Comparator<PositionedSymbol> fastComp = new Comparator<PositionedSymbol>() {

				@Override
				public int compare(PositionedSymbol o1, PositionedSymbol o2) {

					return o1.hashCode() - o2.hashCode();
				}

			};
			Collections.sort(one, fastComp);
			Collections.sort(two, fastComp);

			result &= one.equals(two);

			result &= this.headPostureSymbol.equals(otherHeadSymbol.headPostureSymbol);
		}

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + breathSymbols.hashCode();
		result = prime * result + cheeksSymbols.hashCode();
		result = prime * result + earsSymbols.hashCode();
		result = prime * result + expressionSymbol.hashCode();
		result = prime * result + eyeSymbols.hashCode();
		result = prime * result + hairSymbol.hashCode();
		result = prime * result + headPostureSymbol.hashCode();
		result = prime * result + jawSymbols.hashCode();
		result = prime * result + mouthSymbol.hashCode();
		result = prime * result + neckSymbol.hashCode();
		result = prime * result + noseSymbol.hashCode();
		result = prime * result + getX();
		result = prime * result + getY();
		result = prime * result + getZ();

		return result;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Head: ");
		result.append(headPostureSymbol);
		result.append(", Eyes: ");
		result.append(eyeSymbols);
		result.append(", Mouth: ");
		result.append(mouthSymbol);
		result.append(", Cheek: ");
		result.append(cheeksSymbols);
		result.append(", Breath: ");
		result.append(breathSymbols);
		result.append(", Ears: ");
		result.append(earsSymbols);
		result.append(", Expression: ");
		result.append(expressionSymbol);
		result.append(", Hair: ");
		result.append(hairSymbol);
		result.append(", Jaw: ");
		result.append(jawSymbols);
		result.append(", Neck: ");
		result.append(neckSymbol);
		result.append(", Nose: ");
		result.append(noseSymbol);
		result.append("Pos: (");
		result.append(getX());
		result.append(",");
		result.append(getY());
		result.append(",");
		result.append(getZ());
		result.append(")");

		return result.toString();
	}

	public boolean hasRightEye() {
		boolean hasRightEye = false;

		for (int i = 0; i < getPositionedEyeSymbols().size() && !hasRightEye; i++) {
			hasRightEye = getPositionedEyeSymbols().get(i).isRightEye();
		}
		return hasRightEye;
	}

	public boolean hasLeftEye() {
		boolean hasLeftEye = false;

		for (int i = 0; i < getPositionedEyeSymbols().size() && !hasLeftEye; i++) {
			hasLeftEye = getPositionedEyeSymbols().get(i).isLeftEye();
		}
		return hasLeftEye;
	}

	public HeadSymbol clone() {

		PositionedSymbol[] temp = new PositionedSymbol[getAllPositionedSymbols().size()];
		int pos = 0;
		for (PositionedSymbol symbol : getAllPositionedSymbols()) {
			temp[pos] = symbol.clone();
			pos++;
		}
		HeadSymbol result = new HeadSymbol(getPositionedHeadPostureSymbol().clone(), getX(), getY(), getZ(), temp);
		result.setFreePositionable(isFreePositionable);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	/**
	 * For serialization only!
	 */
	@Deprecated
	protected HeadSymbol() {
	}

	public boolean isFreePositionable() {
		return isFreePositionable;
	}

	public void setFreePositionable(boolean isFreePositionable) {
		this.isFreePositionable = isFreePositionable;
	}

	public float getLeftOverhead() {
		int leftHeadOverhead = 0;

		if (hasEars()) {
			for (PositionedEarsSymbol positionedSymbol : earsSymbols) {
				if (positionedSymbol.isLeftEar()) {
					int leftEarOverhead = positionedSymbol.getWidth() - EARS_SHIFT_INWARDS - positionedSymbol.getX();
					leftHeadOverhead = Math.max(leftHeadOverhead, leftEarOverhead);
				}
			}
		}

		if (hasBreath()) {
			for (PositionedBreathSymbol positionedSymbol : breathSymbols) {
				if (positionedSymbol.isLeftBreathSymbol()) {
					int leftBreathOverhead = (BREATH_CENTER_OFFSET + positionedSymbol.getWidth())
							- positionedSymbol.getX() - (HEAD_CIRCLE_WIDTH / 2);
					leftHeadOverhead = Math.max(leftHeadOverhead, leftBreathOverhead);
				}
			}
		}

		if (hasExpression()) {
			int leftExpressionOverhead = (expressionSymbol.getWidth() - HEAD_CIRCLE_WIDTH) / 2
					- expressionSymbol.getX();
			leftHeadOverhead = Math.max(leftHeadOverhead, leftExpressionOverhead);
		}

		if (hasJaw()) {
			for (PositionedJawSymbol positionedSymbol : jawSymbols) {
				if (positionedSymbol.getLocation().equals(Location.LEFT)
						&& !positionedSymbol.getSymbol().equals(Symbol.JAW_PART_HEAD_RIM)) {
					int leftJawOverhead = (positionedSymbol.getWidth() + JAW_SYMBOL_ARROW_X_DISTANCE_FROM_HEAD_BORDER);
					leftHeadOverhead = Math.max(leftHeadOverhead, leftJawOverhead);
				}
			}
		}

		int headPostureLeftOverhead = getLeftOverheadOfHeadPosture();
		leftHeadOverhead = Math.max(leftHeadOverhead, headPostureLeftOverhead);

		return leftHeadOverhead;
	}

	public int[] getRelativeEyeSymbolPosition(Location position, int width, int height) {
		assert position != null : "Precondition failed: position != null";
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = 0;
		result[1] = (int) (EYE_Y_OFFSET_CENTER - (height / 2.0));
		result[2] = 1;

		if (Location.BOTH.equals(position)) {
			result[0] = (int) (-(width / 2.0));
		} else if (Location.LEFT.equals(position)) {
			result[0] = (int) (-LEFT_EYE_OFFSET - width);
		} else if (Location.RIGHT.equals(position)) {
			result[0] = RIGHT_EYE_OFFSET;
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;
	}

	public int[] getRelativeJawSymbolPosition(Location location, int width, int height) {
		assert location != null : "Precondition failed: location != null";
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = 0;
		result[1] = 0;
		result[2] = 1;

		if (Location.BOTH.equals(location)) {
			result[0] = ((int) (-width / 2));
			result[1] = (JAW_HEAD_RIM_OFFSET_Y_FROM_CIRCLE_CENTER);
		} else {
			result[1] = (JAW_SYMBOL_ARROW_Y_DISTANCE_FROM_HEAD_CENTER);
			if (Location.LEFT.equals(location)) {
				result[0] = ((int) (-(HEAD_CIRCLE_WIDTH / 2.0) - width - JAW_SYMBOL_ARROW_X_DISTANCE_FROM_HEAD_BORDER));
			} else if (Location.RIGHT.equals(location)) {
				result[0] = ((int) ((HEAD_CIRCLE_WIDTH / 2.0) + JAW_SYMBOL_ARROW_X_DISTANCE_FROM_HEAD_BORDER));
			}
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;

	}

	public int[] getRelativeEarSymbolPosition(Location position, int width, int height) {
		assert position != null : "Precondition failed: position != null";
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = 0;
		result[1] = (int) (-(height / 2.0));
		result[2] = 1;

		if (Location.BOTH.equals(position)) {
			result[0] = -(width / 2);
		} else if (Location.LEFT.equals(position)) {
			result[0] = (int) (-(HEAD_CIRCLE_WIDTH / 2.0) + EARS_SHIFT_INWARDS - width);
		} else if (Location.RIGHT.equals(position)) {
			result[0] = (int) ((HEAD_CIRCLE_WIDTH / 2.0) - EARS_SHIFT_INWARDS);
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;
	}

	public int[] getRelativeNoseSymbolPosition(int width, int height) {
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = (int) (-(width / 2.0));
		result[1] = (int) (-(height / 2.0));
		result[2] = 1;

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;
	}

	public int[] getRelativeNeckSymbolPosition(int width, int height) {
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = (int) (-(width / 2.0));
		result[1] = (int) (((HEAD_CIRCLE_HEIGHT / 2.0) + NECK_SHIFT_UPWARDS));
		result[2] = 1;

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length == 3";

		return result;
	}

	public int[] getRelativeHairSymbolPosition(int width, int height) {
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = (int) (-(width / 2.0));
		result[1] = (int) (-(height / 2.0));
		result[2] = 1;

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length == 3";

		return result;
	}

	public int[] getRelativeExpressionSymbolPosition(int width, int height) {
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = (int) (-(HEAD_CIRCLE_WIDTH / 2.0) - EXPRESSION_LEFT_OVERHEAD);
		result[1] = (int) (-(HEAD_CIRCLE_HEIGHT / 2.0) - EXPRESSION_UPPER_OVERHEAD);
		result[2] = 1;

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length == 3";

		return result;
	}

	public int[] getRelativeBreathSymbolPosition(Location position, int width, int height) {
		assert position != null : "Precondition failed: position != null";
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = 0;
		result[1] = (int) ((HEAD_CIRCLE_HEIGHT / 2.0) - height);
		result[2] = 1;

		if (Location.BOTH.equals(position)) {
			result[0] = -(width / 2);
		} else if (Location.LEFT.equals(position)) {
			result[0] = (int) (-width - BREATH_CENTER_OFFSET);
		} else if (Location.RIGHT.equals(position)) {
			result[0] = (int) (BREATH_CENTER_OFFSET);
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;
	}

	public int[] getRelativeMouthSymbolPosition(int width, int height) {
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = (int) (-Math.ceil((((float) width) / 2.0)));
		result[1] = (int) (MOUTH_OFFSET - (height / 2));
		result[2] = 1;

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length == 3";

		return result;
	}

	public int[] getRelativeCheeksSymbolPosition(Location position, int width, int height) {
		assert position != null : "Precondition failed: position != null";
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];

		result[0] = 0;
		result[1] = (int) (-(height / 2.0));
		result[2] = 1;

		if (Location.BOTH.equals(position)) {
			result[0] = -(width / 2);
		} else if (Location.LEFT.equals(position)) {
			result[0] = (int) (-(HEAD_CIRCLE_WIDTH / 2.0));
		} else if (Location.RIGHT.equals(position)) {
			result[0] = (int) ((HEAD_CIRCLE_WIDTH / 2.0) - width);
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;
	}

	public int[] getRelativeHeadPosturePosition(int width, int height) {
		assert width >= 0 : "Precondition failed: width>=0";
		assert height >= 0 : "Precondition failed: height>=0";

		int[] result = new int[3];
		int leftHeadOverhead = getLeftOverheadOfHeadPosture();

		float bottomOverhead = 0;
		if (hasHeadPosture()) {
			Symbol headPosture = headPostureSymbol.getSymbol();
			if (headPosture.getBaseSymbol().equals(
					HeadPostureBaseSymbol.TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF.getIswaSymbol().getBaseSymbol())) {
				if (headPosture.getRotation() == 3 && headPosture.getFill() < 3) {
					bottomOverhead = TONGUE_MOVES_AGAINST_CHEEK_FILL_1_2_ROTATION_3_BOTTOM_OVERHEAD;
				}
			}
		}

		result[0] = (int) (-(HEAD_CIRCLE_WIDTH / 2.0f) - leftHeadOverhead);
		result[1] = (int) (-height + (HEAD_CIRCLE_HEIGHT / 2.0f) + bottomOverhead);
		result[2] = 0;

		assert result != null : "Postcondition failed: result != null";
		assert result.length == 3 : "Postcondition failed: result.length==3";
		return result;
	}

	private int getLeftOverheadOfHeadPosture() {
		int leftHeadOverhead = 0;
		if (hasHeadPosture()) {
			Symbol headPosture = headPostureSymbol.getSymbol();
			if (headPosture.getBaseSymbol().equals(
					HeadPostureBaseSymbol.TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF.getIswaSymbol().getBaseSymbol())) {
				if ((headPosture.getRotation() == 1 && headPosture.getFill() <= 2)
						|| (headPosture.getFill() == 2 && headPosture.getRotation() > 5)) {
					leftHeadOverhead = headPostureSymbol.getWidth() - HEAD_CIRCLE_WIDTH;
				}
			}
			if (headPosture.getBaseSymbol()
					.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
				if ((headPosture.getRotation() == 2) || (headPosture.getRotation() == 6)) {
					leftHeadOverhead = headPostureSymbol.getWidth() - HEAD_CIRCLE_WIDTH;
				}
			}

			if (headPosture.getBaseSymbol()
					.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
				if ((headPosture.getRotation() == 2) || (headPosture.getRotation() == 6)) {
					leftHeadOverhead = headPostureSymbol.getWidth() - HEAD_CIRCLE_WIDTH;
				}
			}
		}
		return leftHeadOverhead;
	}

	// This method calculates the relative HeadCenterPosition from the most
	// upper-left point of the headsymbol
	public int[] getRelativeHeadCenterPosition() {
		int[] result = new int[3];

		assert headPostureSymbol != null : "Precondition failed: headPostureSymbol != null";

		result[0] = (int) (HEAD_CIRCLE_WIDTH / 2 + getLeftOverhead());
		result[1] = (int) (HEAD_CIRCLE_HEIGHT / 2 + getUpperExtension());

		assert result[0] > 0 : "Postcondition failed: result[0] > 0: has to be true since the center of the head has to be right of the upperleft corner of the head";
		assert result[1] > 0 : "Postcondition failed: result[1] > 0: has to be true since the center of the head has to be under the upperleft corner of the head";
		assert result[2] >= 0 : "Postcondition failed: result[2] >= 0: z value has to be 0 or greater";
		return result;
	}

	public int[] getRelativeSymbolPosition(Symbol symbol, Location location) {
		int result[] = new int[3];

		if (HeadPostureBaseSymbol.isValidHeadPostureSymbol(symbol)) {
			result = getRelativeHeadPosturePosition(symbol.getWidth(), symbol.getHeight());
		} else if (EyesBaseSymbol.isAnyEyesSymbol(symbol)) {
			result = getRelativeEyeSymbolPosition(location, symbol.getWidth(), symbol.getHeight());
		} else if (MouthBaseSymbol.isAnyMouthSymbol(symbol)) {
			result = getRelativeMouthSymbolPosition(symbol.getWidth(), symbol.getHeight());
		} else if (CheeksBaseSymbol.isAnyCheeksSymbol(symbol)) {
			result = getRelativeCheeksSymbolPosition(location, symbol.getWidth(), symbol.getHeight());
		} else if (NoseBaseSymbol.isAnyNoseSymbol(symbol)) {
			result = getRelativeNoseSymbolPosition(symbol.getWidth(), symbol.getHeight());
		} else if (EarsBaseSymbol.isAnyEarsSymbol(symbol)) {
			result = getRelativeEarSymbolPosition(location, symbol.getWidth(), symbol.getHeight());
		} else if (BreathBaseSymbol.isAnyBreathSymbol(symbol)) {
			result = getRelativeBreathSymbolPosition(location, symbol.getWidth(), symbol.getHeight());
		} else if (JawBaseSymbol.isAnyJawSymbol(symbol)) {
			result = getRelativeJawSymbolPosition(location, symbol.getWidth(), symbol.getHeight());
		} else if (NeckBaseSymbol.isAnyNeckSymbol(symbol)) {
			result = getRelativeNeckSymbolPosition(symbol.getWidth(), symbol.getHeight());
		} else if (ExpressionBaseSymbol.isAnyExpressionSymbol(symbol)) {
			result = getRelativeExpressionSymbolPosition(symbol.getWidth(), symbol.getHeight());
		} else if (HairBaseSymbol.isAnyHairSymbol(symbol)) {
			result = getRelativeHairSymbolPosition(symbol.getWidth(), symbol.getHeight());
		}

		return result;
	}

	public List<PositionedSymbol> getAllPositionedSymbols() {
		List<PositionedSymbol> allPositionedSymbols = new ArrayList<PositionedSymbol>();
		if (!headPostureSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
			allPositionedSymbols.add(headPostureSymbol);
		}
		if (!expressionSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
			allPositionedSymbols.add(expressionSymbol);
		}
		if (!neckSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
			allPositionedSymbols.add(neckSymbol);
		}
		if (!noseSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
			allPositionedSymbols.add(noseSymbol);
		}
		if (!hairSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
			allPositionedSymbols.add(hairSymbol);
		}
		if (!mouthSymbol.getSymbol().equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
			allPositionedSymbols.add(mouthSymbol);
		}

		allPositionedSymbols.addAll(cheeksSymbols);
		allPositionedSymbols.addAll(breathSymbols);
		allPositionedSymbols.addAll(earsSymbols);
		allPositionedSymbols.addAll(eyeSymbols);
		allPositionedSymbols.addAll(jawSymbols);

		return Collections.unmodifiableList(allPositionedSymbols);
	}

	public List<PositionedSymbol> getPostionedSymbolsForClassType(Class<? extends PositionedSymbol> classType) {
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		if (classType == PositionedEyeSymbol.class) {
			positionedSymbols.addAll(getPositionedEyeSymbols());
		} else if (classType == PositionedEarsSymbol.class) {
			positionedSymbols.addAll(getPositionedEarSymbols());
		} else if (classType == PositionedHairSymbol.class) {
			positionedSymbols.add(getPositionedHairSymbol());
		} else if (classType == PositionedExpressionSymbol.class) {
			positionedSymbols.add(getPositionedExpressionSymbol());
		} else if (classType == PositionedNoseSymbol.class) {
			positionedSymbols.add(getPositionedNoseSymbol());
		} else if (classType == PositionedJawSymbol.class) {
			positionedSymbols.addAll(getPositionedJawSymbols());
		} else if (classType == PositionedMouthSymbol.class) {
			positionedSymbols.add(getPositionedMouthSymbol());
		} else if (classType == PositionedHeadPostureSymbol.class) {
			positionedSymbols.add(getPositionedHeadPostureSymbol());
		} else if (classType == PositionedNeckSymbol.class) {
			positionedSymbols.add(getPositionedNeckSymbol());
		} else if (classType == PositionedBreathSymbol.class) {
			positionedSymbols.addAll(getPositionedBreathSymbols());
		} else if (classType == PositionedCheekSymbol.class) {
			positionedSymbols.addAll(getPositionedCheekSymbols());
		} else {
			throw new RuntimeException("ClassType not implemented yet.");
		}
		assert positionedSymbols != null : "Postcondition failed: positionedSymbols != null";
		return positionedSymbols;

	}

	@Override
	public void setLineColor(Color lineColor) {
		assert lineColor != null : "Precondition failed: lineColor != null";
		super.setLineColor(lineColor);
		for (PositionedSymbol positionedSymbol : getAllPositionedSymbols()) {
			positionedSymbol.setLineColor(lineColor);
		}
	}

	@Override
	public void setFillColor(Color color) {
		super.setFillColor(color);
		for (PositionedSymbol positionedSymbol : getAllPositionedSymbols()) {
			positionedSymbol.setFillColor(color);
		}
	}
}
