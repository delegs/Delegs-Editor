package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolEnum;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

public enum HandBaseSymbol implements SymbolEnum {
	INDEX(new Symbol(1, 1, 1, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_ON_CIRCLE(new Symbol(1, 1, 2, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_ON_CUP(new Symbol(1, 1, 3, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_ON_OVAL(new Symbol(1, 1, 4, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_ON_HINGE(new Symbol(1, 1, 5, 1, 1, 1, 22, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_ON_ANGLE(new Symbol(1, 1, 6, 1, 1, 1, 22, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_BENT(new Symbol(1, 1, 7, 1, 1, 1, 15, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_BENT_ON_CIRCLE(new Symbol(1, 1, 8, 1, 1, 1, 16, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_BENT_ON_FIRST_THUMB_UNDER(new Symbol(1, 1, 9, 1, 1, 1, 15, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RAISED_KNUCKLE(new Symbol(1, 1, 10, 1, 1, 1, 15, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_CUP(new Symbol(1, 1, 11, 1, 1, 1, 15, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_HINGE_ON_FIST(new Symbol(1, 1, 12, 1, 1, 1, 17, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_HINGE_ON_FIST_LOW(new Symbol(1, 1, 13, 1, 1, 1, 17, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_HINGE_ON_CIRCLE(new Symbol(1, 1, 14, 1, 1, 1, 18, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE(new Symbol(1, 2, 1, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_ON_CIRCLE(new Symbol(1, 2, 2, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_BENT(new Symbol(1, 2, 3, 1, 1, 1, 15, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RAISED_KNUCKLES(new Symbol(1, 2, 4, 1, 1, 1, 15, 20),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_HINGE(new Symbol(1, 2, 5, 1, 1, 1, 19, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_UP_MIDDLE_HINGE(new Symbol(1, 2, 6, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_HINGE_MIDDLE_UP(new Symbol(1, 2, 7, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT(new Symbol(1, 2, 8, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_INDEX_BENT(new Symbol(1, 2, 9, 1, 1, 1, 15, 32),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_MIDDLE_BENT(new Symbol(1, 2, 10, 1, 1, 1, 15, 32),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_CUP(new Symbol(1, 2, 11, 1, 1, 1, 15, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_HINGE(new Symbol(1, 2, 12, 1, 1, 1, 17, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_CROSS(new Symbol(1, 2, 13, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_CROSS_ON_CIRCLE(new Symbol(1, 2, 14, 1, 1, 1, 16, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_BENT_OVER_INDEX(new Symbol(1, 2, 15, 1, 1, 1, 15, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_BENT_OVER_MIDDLE(new Symbol(1, 2, 16, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB(new Symbol(1, 3, 1, 1, 1, 1, 23, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_ON_CIRCLE(new Symbol(1, 3, 2, 1, 1, 1, 24, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_STRAIGHT_THUMB_BENT(new Symbol(1, 3, 3, 1, 1, 1, 22, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_BENT_THUMB_STRAIGHT(new Symbol(1, 3, 4, 1, 1, 1, 24, 27),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_BENT(new Symbol(1, 3, 5, 1, 1, 1, 22, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_HINGE_SPREAD_THUMB_SIDE(new Symbol(1, 3, 6, 1, 1, 1, 23, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_UP_MIDDLE_HINGE_THUMB_SIDE(new Symbol(1, 3, 7, 1, 1, 1, 23, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_UP_MIDDLE_HINGE_THUMB_UNIT(new Symbol(1, 3, 8, 1, 1, 1, 18, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_HINGE_MIDDLE_UP_THUMB_SIDE(new Symbol(1, 3, 9, 1, 1, 1, 23, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UP_SPREAD_THUMB_FORWARD(new Symbol(1, 3, 10, 1, 1, 1, 15, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_CUP(new Symbol(1, 3, 11, 1, 1, 1, 23, 24), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_CIRCLE(new Symbol(1, 3, 12, 1, 1, 1, 24, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_HOOK(new Symbol(1, 3, 13, 1, 1, 1, 25, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_HINGE(new Symbol(1, 3, 14, 1, 1, 1, 29, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_BETWEEN_INDEX_MIDDLE_STRAIGHT(new Symbol(1, 3, 15, 1, 1, 1, 30, 19),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_THUMB_SIDE(new Symbol(1, 3, 16, 1, 1, 1, 23, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_THUMB_SIDE_UNIT(new Symbol(1, 3, 17, 1, 1, 1, 18, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_THUMB_SIDE_BENT(new Symbol(1, 3, 18, 1, 1, 1, 22, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_HOOK_INDEX_UP(new Symbol(1, 3, 19, 1, 1, 1, 18, 32),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HOOK_MIDDLE_UP(new Symbol(1, 3, 20, 1, 1, 1, 21, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })),
	INDEX_MIDDLE_UNIT_HINGE_THUMB_SIDE(new Symbol(1, 3, 21, 1, 1, 1, 24, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_CROSS_THUMB_SIDE(new Symbol(1, 3, 22, 1, 1, 1, 22, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_THUMB_FORWARD(new Symbol(1, 3, 23, 1, 1, 1, 15, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_UNIT_CUP_THUMB_FORWARD(new Symbol(1, 3, 24, 1, 1, 1, 24, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_CUP_INDEX_UP(new Symbol(1, 3, 25, 1, 1, 1, 23, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CUP_MIDDLE_UP(new Symbol(1, 3, 26, 1, 1, 1, 23, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_CIRCLE_INDEX_UP(new Symbol(1, 3, 27, 1, 1, 1, 24, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_CIRCLE_INDEX_HINGE(new Symbol(1, 3, 28, 1, 1, 1, 24, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_ANGLE_OUT_MIDDLE_UP(new Symbol(1, 3, 29, 1, 1, 1, 24, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_ANGLE_IN_MIDDLE_UP(new Symbol(1, 3, 30, 1, 1, 1, 23, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CIRCLE_MIDDLE_UP(new Symbol(1, 3, 31, 1, 1, 1, 24, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_UNIT_HINGE(new Symbol(1, 3, 32, 1, 1, 1, 29, 15),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_ANGLE_OUT(new Symbol(1, 3, 33, 1, 1, 1, 29, 19),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_THUMB_ANGLE(new Symbol(1, 3, 34, 1, 1, 1, 29, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_ANGLE_OUT_INDEX_UP(new Symbol(1, 3, 35, 1, 1, 1, 29, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_ANGLE_OUT_INDEX_CROSSED(new Symbol(1, 3, 36, 1, 1, 1, 29, 21),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_ANGLE_INDEX_UP(new Symbol(1, 3, 37, 1, 1, 1, 29, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HOOK_MIDDLE_HINGE(new Symbol(1, 3, 38, 1, 1, 1, 29, 24),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS(new Symbol(1, 4, 1, 1, 1, 1, 22, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_BENT(new Symbol(1, 4, 2, 1, 1, 1, 23, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_HINGE(new Symbol(1, 4, 3, 1, 1, 1, 18, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_UNIT(new Symbol(1, 4, 4, 1, 1, 1, 14, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_UNIT_SPLIT(new Symbol(1, 4, 5, 1, 1, 1, 14, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_UNIT_CLAW(new Symbol(1, 4, 6, 1, 1, 1, 16, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_UNIT_BENT(new Symbol(1, 4, 7, 1, 1, 1, 15, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FOUR_FINGERS_UNIT_HINGE(new Symbol(1, 4, 8, 1, 1, 1, 23, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD(new Symbol(1, 5, 1, 1, 1, 1, 23, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_HEEL(new Symbol(1, 5, 2, 1, 2, 1, 30, 18), Arrays.asList(new Integer[] { 2 })), //
	FIVE_FINGERS_SPREAD_FOUR_BENT(new Symbol(1, 5, 3, 1, 1, 1, 25, 31),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_FOUR_BENT_HEEL(new Symbol(1, 5, 4, 1, 2, 1, 30, 16), Arrays.asList(new Integer[] { 2 })), //
	FIVE_FINGERS_SPREAD_BENT(new Symbol(1, 5, 5, 1, 1, 1, 25, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_BENT_HEEL(new Symbol(1, 5, 6, 1, 2, 1, 29, 16), Arrays.asList(new Integer[] { 2 })), //
	FIVE_FINGERS_SPREAD_THUMB_FORWARD(new Symbol(1, 5, 7, 1, 1, 1, 20, 31),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_CUP(new Symbol(1, 5, 8, 1, 1, 1, 15, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_CUP_OPEN(new Symbol(1, 5, 9, 1, 1, 1, 15, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_HINGE_OPEN(new Symbol(1, 5, 10, 1, 1, 1, 15, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_OVAL(new Symbol(1, 5, 11, 1, 1, 1, 16, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_HINGE(new Symbol(1, 5, 12, 1, 1, 1, 18, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_HINGE_THUMB_SIDE(new Symbol(1, 5, 13, 1, 1, 1, 26, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIVE_FINGERS_SPREAD_HINGE_NO_THUMB(new Symbol(1, 5, 14, 1, 1, 1, 18, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT(new Symbol(1, 5, 15, 1, 1, 1, 12, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_BETWEEN_PALM_FACINGS(new Symbol(1, 5, 16, 1, 1, 1, 12, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4 })), //
	FLAT_HEEL(new Symbol(1, 5, 17, 1, 2, 1, 20, 9), Arrays.asList(new Integer[] { 2 })), //
	FLAT_THUMB_SIDE(new Symbol(1, 5, 18, 1, 1, 1, 19, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_THUMB_SIDE_HEEL(new Symbol(1, 5, 19, 1, 2, 1, 27, 10), Arrays.asList(new Integer[] { 2 })), //
	FLAT_THUMB_BENT(new Symbol(1, 5, 20, 1, 1, 1, 20, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_THUMB_FORWARD(new Symbol(1, 5, 21, 1, 1, 1, 12, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_SPLIT_INDEX_THUMB_SIDE(new Symbol(1, 5, 22, 1, 1, 1, 20, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_SPLIT_CENTER(new Symbol(1, 5, 23, 1, 1, 1, 12, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_SPLIT_CENTER_THUMB_SIDE(new Symbol(1, 5, 24, 1, 1, 1, 20, 27),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_SPLIT_CENTER_THUMB_SID_BENT(new Symbol(1, 5, 25, 1, 1, 1, 20, 27),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FLAT_SPLIT_BABY(new Symbol(1, 5, 26, 1, 1, 1, 19, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CLAW(new Symbol(1, 5, 27, 1, 1, 1, 16, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CLAW_THUMB_SIDE(new Symbol(1, 5, 28, 1, 1, 1, 23, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CLAW_NO_THUMB(new Symbol(1, 5, 29, 1, 1, 1, 16, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CLAW_THUMB_FORWARD(new Symbol(1, 5, 30, 1, 1, 1, 19, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HOOK_CURLICUE(new Symbol(1, 5, 31, 1, 1, 1, 20, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HOOK(new Symbol(1, 5, 32, 1, 1, 1, 16, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_OPEN(new Symbol(1, 5, 33, 1, 1, 1, 20, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP(new Symbol(1, 5, 34, 1, 1, 1, 17, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_OPEN_THUMB_SIDE(new Symbol(1, 5, 35, 1, 1, 1, 23, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_THUMB_SIDE(new Symbol(1, 5, 36, 1, 1, 1, 24, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_OPEN_NO_THUMB(new Symbol(1, 5, 37, 1, 1, 1, 17, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_NO_THUMB(new Symbol(1, 5, 38, 1, 1, 1, 17, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_OPEN_THUMB_FORWARD(new Symbol(1, 5, 39, 1, 1, 1, 17, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CUP_THUMB_FORWARD(new Symbol(1, 5, 40, 1, 1, 1, 17, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CURLICUE_OPEN(new Symbol(1, 5, 41, 1, 1, 1, 21, 16), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CURLICUE(new Symbol(1, 5, 42, 1, 1, 1, 21, 17), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	CIRCLE(new Symbol(1, 5, 43, 1, 1, 1, 16, 16), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	OVAL(new Symbol(1, 5, 44, 1, 1, 1, 20, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	OVAL_THUMB_SIDE(new Symbol(1, 5, 45, 1, 1, 1, 26, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	OVAL_NO_THUMB(new Symbol(1, 5, 46, 1, 1, 1, 20, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	OVAL_THUMB_FORWARD(new Symbol(1, 5, 47, 1, 1, 1, 20, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_OPEN(new Symbol(1, 5, 48, 1, 1, 1, 17, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_OPEN_THUMB_FORWARD(new Symbol(1, 5, 49, 1, 1, 1, 17, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE(new Symbol(1, 5, 50, 1, 1, 1, 23, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_SMALL(new Symbol(1, 5, 51, 1, 1, 1, 23, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_OPEN_THUMB_SIDE(new Symbol(1, 5, 52, 1, 1, 1, 15, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_THUMB_SIDE(new Symbol(1, 5, 53, 1, 1, 1, 30, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_OPEN_NO_THUMB(new Symbol(1, 5, 54, 1, 1, 1, 12, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_NO_THUMB(new Symbol(1, 5, 55, 1, 1, 1, 23, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_THUMB_SIDE_TOUCHES_INDEX(new Symbol(1, 5, 56, 1, 1, 1, 24, 19),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	HINGE_THUMB_BETWEEN_MIDDLE_RING(new Symbol(1, 5, 57, 1, 1, 1, 24, 18),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	ANGLE(new Symbol(1, 5, 58, 1, 1, 1, 24, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING(new Symbol(1, 6, 1, 1, 1, 1, 18, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING_ON_CIRCLE(new Symbol(1, 6, 2, 1, 1, 1, 18, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING_ON_HINGE(new Symbol(1, 6, 3, 1, 1, 1, 20, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING_ON_ANGLE(new Symbol(1, 6, 4, 1, 1, 1, 19, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_HINGE(new Symbol(1, 6, 5, 1, 1, 1, 23, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING_BENT(new Symbol(1, 6, 6, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING_UNIT(new Symbol(1, 6, 7, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_RING_UNIT_HINGE(new Symbol(1, 6, 8, 1, 1, 1, 20, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_DOWN(new Symbol(1, 6, 9, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_DOWN_RIPPLE_STRAIGHT(new Symbol(1, 6, 10, 1, 1, 1, 21, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_DOWN_RIPPLE_CURVED(new Symbol(1, 6, 11, 1, 1, 1, 23, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_DOWN_OTHERS_CIRCLE(new Symbol(1, 6, 12, 1, 1, 1, 24, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_UP(new Symbol(1, 6, 13, 1, 1, 1, 21, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_UP_ON_FIRST_THUMB_UNDER(new Symbol(1, 6, 14, 1, 1, 1, 21, 19),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_UP_ON_CIRCLE(new Symbol(1, 6, 15, 1, 1, 1, 21, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_UP_ON_OVAL(new Symbol(1, 6, 16, 1, 1, 1, 20, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_UP_ON_ANGLE(new Symbol(1, 6, 17, 1, 1, 1, 23, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_RAISED_KNUCKLE(new Symbol(1, 6, 18, 1, 1, 1, 18, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_BENT(new Symbol(1, 6, 19, 1, 1, 1, 19, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_THOUCHES_THUMB(new Symbol(1, 6, 20, 1, 1, 1, 22, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_THUMB(new Symbol(1, 6, 21, 1, 1, 1, 28, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_THUMB_ON_HINGE(new Symbol(1, 6, 22, 1, 1, 1, 30, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_THUMB(new Symbol(1, 6, 23, 1, 1, 1, 28, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_THUMB_ON_HINGE(new Symbol(1, 6, 24, 1, 1, 1, 29, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_THUMB_INDEX_THUMB_ANGLE_OUT(new Symbol(1, 6, 25, 1, 1, 1, 30, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_THUMB_INDEX_THUMB_ANGLE(new Symbol(1, 6, 26, 1, 1, 1, 29, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX(new Symbol(1, 6, 27, 1, 1, 1, 20, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_ON_CIRCLE(new Symbol(1, 6, 28, 1, 1, 1, 21, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_ON_HINGE(new Symbol(1, 6, 29, 1, 1, 1, 23, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	BABY_INDEX_ON_ANGLE(new Symbol(1, 6, 30, 1, 1, 1, 23, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_BABY(new Symbol(1, 7, 1, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_BABY_ON_CIRCLE(new Symbol(1, 7, 2, 1, 1, 1, 21, 28),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_BABY_ON_HINGE(new Symbol(1, 7, 3, 1, 1, 1, 18, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_HINGE(new Symbol(1, 7, 4, 1, 1, 1, 25, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_BABY_ON_ANGLE(new Symbol(1, 7, 5, 1, 1, 1, 18, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_CROSS_WITH_BABY(new Symbol(1, 7, 6, 1, 1, 1, 20, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_MIDDLE_CROSS_WITH_BABY_ON_CIRCLE(new Symbol(1, 7, 7, 1, 1, 1, 21, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_DOWN(new Symbol(1, 7, 8, 1, 1, 1, 25, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_DOWN_INDEX_THUMB_HOOK_MIDDLE_HINGE(new Symbol(1, 7, 9, 1, 1, 1, 34, 24),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_DOWN_MIDDLE_THUMB_ANGLE_INDEX_CROSS(new Symbol(1, 7, 10, 1, 1, 1, 34, 21),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_UP(new Symbol(1, 7, 11, 1, 1, 1, 16, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_RAISED_KNUCKLE(new Symbol(1, 7, 12, 1, 1, 1, 15, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_BABY(new Symbol(1, 7, 13, 1, 1, 1, 20, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_BABY_ON_CIRCLE(new Symbol(1, 7, 14, 1, 1, 1, 21, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_BABY_ON_OVAL(new Symbol(1, 7, 15, 1, 1, 1, 20, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_BABY_ON_ANGLE(new Symbol(1, 7, 16, 1, 1, 1, 23, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_MIDDLE(new Symbol(1, 7, 17, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_MIDDLE_UNIT(new Symbol(1, 7, 18, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_MIDDLE_RAISED_KNUCKLES(new Symbol(1, 7, 19, 1, 1, 1, 15, 20),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_INDEX(new Symbol(1, 7, 20, 1, 1, 1, 16, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_THUMB(new Symbol(1, 7, 21, 1, 1, 1, 23, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	RING_THUMB_HOOK(new Symbol(1, 7, 22, 1, 1, 1, 15, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY(new Symbol(1, 8, 1, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_CIRCLE(new Symbol(1, 8, 2, 1, 1, 1, 21, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_CURLICUE(new Symbol(1, 8, 3, 1, 1, 1, 21, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_HOOK_OUT(new Symbol(1, 8, 4, 1, 1, 1, 17, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_HOOK_IN(new Symbol(1, 8, 5, 1, 1, 1, 17, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_HOOK_UNDER(new Symbol(1, 8, 6, 1, 1, 1, 17, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_CUP(new Symbol(1, 8, 7, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_HINGE(new Symbol(1, 8, 8, 1, 1, 1, 23, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_ANGLE_OUT(new Symbol(1, 8, 9, 1, 1, 1, 23, 28),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_RING_BABY_ON_ANGLE(new Symbol(1, 8, 10, 1, 1, 1, 23, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_DOWN(new Symbol(1, 8, 11, 1, 1, 1, 25, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_HINGE(new Symbol(1, 8, 12, 1, 1, 1, 30, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_UP(new Symbol(1, 8, 13, 1, 1, 1, 15, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_UP_ON_CIRCLE(new Symbol(1, 8, 14, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RAISED_KNUCKLE(new Symbol(1, 8, 15, 1, 1, 1, 15, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_UP_THUMB_SIDE(new Symbol(1, 8, 16, 1, 1, 1, 22, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_HOOK(new Symbol(1, 8, 17, 1, 1, 1, 15, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_THUMB_BABY(new Symbol(1, 8, 18, 1, 1, 1, 27, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_BABY(new Symbol(1, 8, 19, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY(new Symbol(1, 9, 1, 1, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_CIRCLE(new Symbol(1, 9, 2, 1, 1, 1, 22, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_CURLICUE(new Symbol(1, 9, 3, 1, 1, 1, 21, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_CUP(new Symbol(1, 9, 4, 1, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_HINGE(new Symbol(1, 9, 5, 1, 1, 1, 23, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_ANGLE_OUT(new Symbol(1, 9, 6, 1, 1, 1, 23, 28),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_ANGLE_IN(new Symbol(1, 9, 7, 1, 1, 1, 23, 28),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_ON_ANGLE(new Symbol(1, 9, 8, 1, 1, 1, 23, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_BENT(new Symbol(1, 9, 9, 1, 1, 1, 24, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_UNIT_ON_CLAW(new Symbol(1, 9, 10, 1, 1, 1, 14, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_UNIT_ON_CLAW_SIDE(new Symbol(1, 9, 11, 1, 1, 1, 19, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_UNIT_ON_HOOK_OUT(new Symbol(1, 9, 12, 1, 1, 1, 17, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_UNIT_ON_HOOK_IN(new Symbol(1, 9, 13, 1, 1, 1, 16, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	MIDDLE_RING_BABY_UNIT_ON_HOOK(new Symbol(1, 9, 14, 1, 1, 1, 16, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_HINGE(new Symbol(1, 9, 15, 1, 1, 1, 28, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE(new Symbol(1, 9, 16, 1, 1, 1, 24, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_ON_HINGE(new Symbol(1, 9, 17, 1, 1, 1, 28, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_THUMB_DIAGONAL(new Symbol(1, 9, 18, 1, 1, 1, 22, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_THUMB_UNIT(new Symbol(1, 9, 19, 1, 1, 1, 18, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_THUMB_BENT(new Symbol(1, 9, 20, 1, 1, 1, 23, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_INDEX_BENT(new Symbol(1, 9, 21, 1, 1, 1, 24, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_BOTH_BENT(new Symbol(1, 9, 22, 1, 1, 1, 22, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_SIDE_INDEX_HINGE(new Symbol(1, 9, 23, 1, 1, 1, 24, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_FORWARD_INDEX_STRAIGHT(new Symbol(1, 9, 24, 1, 1, 1, 15, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_FORWARD_INDEX_BENT(new Symbol(1, 9, 25, 1, 1, 1, 15, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HOOK(new Symbol(1, 9, 26, 1, 1, 1, 23, 24), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CURLICUE(new Symbol(1, 9, 27, 1, 1, 1, 26, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CURVE_THUMB_INSIDE(new Symbol(1, 9, 28, 1, 1, 1, 25, 21),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CURVE_THUMB_INSIDE_ON_CLAW(new Symbol(1, 9, 29, 1, 1, 1, 18, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CURVE_THUMB_UNDER(new Symbol(1, 9, 30, 1, 1, 1, 23, 21),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CIRCLE(new Symbol(1, 9, 31, 1, 1, 1, 24, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CUP(new Symbol(1, 9, 32, 1, 1, 1, 23, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_CUP_OPEN(new Symbol(1, 9, 33, 1, 1, 1, 26, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HINGE_OPEN(new Symbol(1, 9, 34, 1, 1, 1, 25, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HINGE_LARGE(new Symbol(1, 9, 35, 1, 1, 1, 29, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HINGE(new Symbol(1, 9, 36, 1, 1, 1, 29, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_HINGE_SMALL(new Symbol(1, 9, 37, 1, 1, 1, 29, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_ANGLE_OUT(new Symbol(1, 9, 38, 1, 1, 1, 30, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_ANGLE_IN(new Symbol(1, 9, 39, 1, 1, 1, 30, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	INDEX_THUMB_ANGLE(new Symbol(1, 9, 40, 1, 1, 1, 29, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB(new Symbol(1, 10, 1, 1, 1, 1, 24, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_HEEL(new Symbol(1, 10, 2, 1, 2, 1, 24, 10), Arrays.asList(new Integer[] { 2 })), //
	THUMB_SIDE_DIAGONAL(new Symbol(1, 10, 3, 1, 1, 1, 20, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_SIDE_UNIT(new Symbol(1, 10, 4, 1, 1, 1, 18, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_SIDE_BENT(new Symbol(1, 10, 5, 1, 1, 1, 23, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_FORWARD(new Symbol(1, 10, 6, 1, 1, 1, 15, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_BETWEEN_INDEX_MIDDLE(new Symbol(1, 10, 7, 1, 1, 1, 15, 19),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_BETWEEN_MIDDLE_RING(new Symbol(1, 10, 8, 1, 1, 1, 15, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_BETWEEN_RING_BABY(new Symbol(1, 10, 9, 1, 1, 1, 15, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_UNDER_TWO_FINGERS(new Symbol(1, 10, 10, 1, 1, 1, 15, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_OVER_TWO_FINGERS(new Symbol(1, 10, 11, 1, 1, 1, 15, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_UNDER_THREE_FINGERS(new Symbol(1, 10, 12, 1, 1, 1, 15, 18),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_UNDER_FOUR_FINGERS(new Symbol(1, 10, 13, 1, 1, 1, 15, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	THUMB_OVER_FOUR_RAISED_KNUCKLES(new Symbol(1, 10, 14, 1, 1, 1, 18, 20),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIST(new Symbol(1, 10, 15, 1, 1, 1, 15, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 })), //
	FIST_HEEL(new Symbol(1, 10, 16, 1, 2, 1, 15, 11), Arrays.asList(new Integer[] { 2 })), //
	;

	private Symbol iswaSymbol;
	private List<Integer> validFills;

	private static final List<SymbolRotation> VALID_ROTATIONS = Arrays.asList(new SymbolRotation[] {
			SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST, SymbolRotation.SOUTH_WEST,
			SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST, SymbolRotation.NORTH_EAST,
			SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST, SymbolRotation.MIRRORED_WEST,
			SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH, SymbolRotation.MIRRORED_SOUTH_EAST,
			SymbolRotation.MIRRORED_EAST, SymbolRotation.MIRRORED_NORTH_EAST });

	private HandBaseSymbol(Symbol iswaSymbol, List<Integer> validFills) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
	}

	public List<SymbolRotation> getValidRotations() {
		return VALID_ROTATIONS;
	}

	public List<Integer> getValidRotationValues() {
		List<Integer> result = new ArrayList<Integer>();

		for (SymbolRotation symbolRotationEnum : VALID_ROTATIONS) {
			result.add(symbolRotationEnum.getRotationValue());
		}
		return result;
	}

	public static HandBaseSymbol getHandBaseSymbol(BaseSymbol baseSymbol) {
		HandBaseSymbol result = null;
		for (HandBaseSymbol handBaseSymbol : HandBaseSymbol.values()) {
			if (handBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& handBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& handBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& handBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = handBaseSymbol;
				break;
			}
		}

		return result;
	}

	@Override
	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	public List<Integer> getValidFills() {
		return this.validFills;
	}

	@Override
	public boolean canBeMirrored() {
		return true;
	}
}