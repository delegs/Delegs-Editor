package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolEnum;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

/**
 * BaseSymbols from the movement category
 */
public enum MovementBaseSymbol implements SymbolEnum {

	TOUCH_SINGLE(new Symbol(2, 1, 1, 1, 1, 1, 10, 11), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TOUCH_MULTIPE(new Symbol(2, 1, 2, 1, 1, 1, 22, 11), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	TOUCH_BETWEEN(new Symbol(2, 1, 3, 1, 1, 1, 18, 15), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	GRASP_SINGLE(new Symbol(2, 1, 4, 1, 1, 1, 10, 10), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	GRASP_MULTIPLE(new Symbol(2, 1, 5, 1, 1, 1, 22, 10), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	GRASP_BETWEEN(new Symbol(2, 1, 6, 1, 1, 1, 18, 15), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	STRIKE_SINGLE(new Symbol(2, 1, 7, 1, 1, 1, 13, 13), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	STRIKE_MULTIPLE(new Symbol(2, 1, 8, 1, 1, 1, 28, 13), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	STRIKE_BETWEEN(new Symbol(2, 1, 9, 1, 1, 1, 21, 15), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	BRUSH_SINGLE(new Symbol(2, 1, 10, 1, 1, 1, 12, 12), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	BRUSH_MULTIPLE(new Symbol(2, 1, 11, 1, 1, 1, 26, 12), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	BRUSH_BETWEEN(new Symbol(2, 1, 12, 1, 1, 1, 20, 15), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	RUB_SINGLE(new Symbol(2, 1, 13, 1, 1, 1, 13, 14), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	RUB_MULTIPLE(new Symbol(2, 1, 14, 1, 1, 1, 28, 14), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	RUB_BETWEEN(new Symbol(2, 1, 15, 1, 1, 1, 21, 16), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	SURFACE_SYMBOLS(new Symbol(2, 1, 16, 1, 1, 1, 15, 5), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SURFACE_BETWEEN(new Symbol(2, 1, 17, 1, 1, 1, 16, 9), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	SQUEEZE_LARGE_SINGLE(new Symbol(2, 2, 1, 1, 1, 1, 8, 8), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	SQUEEZE_SMALL_SINGLE(new Symbol(2, 2, 1, 2, 1, 1, 6, 6), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	SQUEEZE_LARGE_MULTIPLE(new Symbol(2, 2, 2, 1, 1, 1, 18, 8), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	SQUEEZE_SMALL_MULTIPLE(new Symbol(2, 2, 2, 2, 1, 1, 14, 6), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	SQUEEZE_SEQUENTIAL(new Symbol(2, 2, 3, 1, 1, 1, 12, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	FLICK_LARGE_SINGLE(new Symbol(2, 2, 4, 1, 1, 1, 8, 8), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	FLICK_SMALL_SINGLE(new Symbol(2, 2, 4, 2, 1, 1, 6, 6), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	FLICK_LARGE_MULTIPLE(new Symbol(2, 2, 5, 1, 1, 1, 18, 8), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	FLICK_SMALL_MULTIPLE(new Symbol(2, 2, 5, 2, 1, 1, 14, 6), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	FLICK_SEQUENTIAL(new Symbol(2, 2, 6, 1, 1, 1, 12, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	SQUEEZE_FLICK_ALTERNATING(new Symbol(2, 2, 7, 1, 1, 1, 34, 11), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HINGE_MOVEMENT_UP_DOWN_LARGE(new Symbol(2, 2, 8, 1, 1, 1, 12, 7), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HINGE_MOVEMENT_UP_DOWN_SMALL(new Symbol(2, 2, 8, 2, 1, 1, 10, 5), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HINGE_MOVEMENT_UP_SEQUENTIAL(new Symbol(2, 2, 9, 1, 1, 1, 20, 35),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HINGE_MOVEMENT_DOWN_SEQUENTIAL(new Symbol(2, 2, 9, 2, 1, 1, 20, 35),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE(new Symbol(2, 2, 10, 1, 1, 1, 12, 13),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL(new Symbol(2, 2, 10, 2, 1, 1, 10, 9),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS(new Symbol(2, 2, 11, 1, 1, 1, 16, 9),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	FINGER_CONTACT_MOVEMENT_WALL_PLANE(new Symbol(2, 2, 12, 1, 1, 1, 10, 10),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	FINGER_CONTACT_MOVEMENT_FLOOR_PLANE(new Symbol(2, 2, 13, 1, 1, 1, 10, 10),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	// // From here on the Symbols are arrows
	SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL(new Symbol(2, 3, 1, 1, 1, 1, 13, 15),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM(new Symbol(2, 3, 1, 2, 1, 1, 16, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE(new Symbol(2, 3, 1, 3, 1, 1, 16, 42),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST(new Symbol(2, 3, 1, 4, 1, 1, 16, 50),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_WRIST_FLEX_WALL_PLANE(new Symbol(2, 3, 1, 5, 1, 1, 17, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE(new Symbol(2, 3, 2, 1, 1, 1, 25, 14), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	DOUBLE_WRIST_FLEX_WALL_PLANE(new Symbol(2, 3, 2, 2, 1, 1, 25, 18), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE(new Symbol(2, 3, 3, 1, 1, 1, 26, 17),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE(new Symbol(2, 3, 3, 2, 1, 1, 26, 20),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CROSS_MOVEMENT_WALL_PLANE(new Symbol(2, 3, 4, 1, 1, 1, 30, 26), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE(new Symbol(2, 3, 5, 1, 1, 1, 37, 14), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TRIPPLE_WRIST_FLEX_WALL_PLANE(new Symbol(2, 3, 5, 2, 1, 1, 37, 18), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE(new Symbol(2, 3, 6, 1, 1, 1, 39, 17),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE(new Symbol(2, 3, 6, 2, 1, 1, 39, 21),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BLEND_WALL_PLANE_SMALL(new Symbol(2, 3, 7, 1, 1, 1, 17, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BLEND_WALL_PLANE_MEDIUM(new Symbol(2, 3, 7, 2, 1, 1, 20, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BLEND_WALL_PLANE_LARGE(new Symbol(2, 3, 7, 3, 1, 1, 26, 42), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_WALL_PLANE_SMALL(new Symbol(2, 3, 8, 1, 1, 1, 19, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_WALL_PLANE_MEDIUM(new Symbol(2, 3, 8, 2, 1, 1, 23, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_WALL_PLANE_LARGE(new Symbol(2, 3, 8, 3, 1, 1, 27, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_WALL_PLANE_WITH_ROTATION(new Symbol(2, 3, 8, 4, 1, 1, 30, 32), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CHECK_WALL_PLANE_SMALL(new Symbol(2, 3, 9, 1, 1, 1, 21, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CHECK_WALL_PLANE_MEDIUM(new Symbol(2, 3, 9, 2, 1, 1, 26, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CHECK_WALL_PLANE_LARGE(new Symbol(2, 3, 9, 3, 1, 1, 28, 39), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BOX_WALL_PLANE_SMALL(new Symbol(2, 3, 10, 1, 1, 1, 24, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BOX_WALL_PLANE_MEDIUM(new Symbol(2, 3, 10, 2, 1, 1, 29, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BOX_WALL_PLANE_LARGE(new Symbol(2, 3, 10, 3, 1, 1, 33, 33), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ZIGZAG_WALL_PLANE_SMALL(new Symbol(2, 3, 11, 1, 1, 1, 18, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ZIGZAG_WALL_PLANE_MEDIUM(new Symbol(2, 3, 11, 2, 1, 1, 24, 39), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ZIGZAG_WALL_PLANE_LARGE(new Symbol(2, 3, 11, 3, 1, 1, 26, 43), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	PEAKS_WALL_PLANE_SMALL(new Symbol(2, 3, 12, 1, 1, 1, 16, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	PEAKS_WALL_PLANE_MEDIUM(new Symbol(2, 3, 12, 2, 1, 1, 19, 36), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	PEAKS_WALL_PLANE_LARGE(new Symbol(2, 3, 12, 3, 1, 1, 21, 47), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_SINGLE_WALL_PLANE(new Symbol(2, 3, 13, 1, 1, 1, 22, 26),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_DOUBLE_WALL_PLANE(new Symbol(2, 3, 14, 1, 1, 1, 22, 35),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_ALTERNATING_WALL_PLANE(new Symbol(2, 3, 15, 1, 1, 1, 24, 35),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_SINGLE_FLOOR_PLANE(new Symbol(2, 3, 16, 1, 1, 1, 21, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE(new Symbol(2, 3, 17, 1, 1, 1, 20, 36),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE(new Symbol(2, 3, 18, 1, 1, 1, 22, 36),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_SHAKING_WALL_PLANE(new Symbol(2, 3, 19, 1, 1, 1, 18, 33), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TRAVEL_ARM_SPIRAL_WALL_PLANE_SINGLE(new Symbol(2, 3, 20, 1, 1, 1, 25, 35), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE(new Symbol(2, 3, 20, 2, 1, 1, 25, 42), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ARM_SPIRAL_WALL_PLANE_TRIPLE(new Symbol(2, 3, 20, 3, 1, 1, 25, 50), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	DIAGONAL_AWAY_MOVEMENT_SMALL(new Symbol(2, 4, 1, 1, 1, 1, 13, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_AWAY_MOVEMENT_MEDIUM(new Symbol(2, 4, 1, 2, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_AWAY_MOVEMENT_LARGE(new Symbol(2, 4, 1, 3, 1, 1, 16, 42), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_AWAY_MOVEMENT_LARGEST(new Symbol(2, 4, 1, 4, 1, 1, 16, 50), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_TOWARDS_MOVEMENT_SMALL(new Symbol(2, 4, 2, 1, 1, 1, 14, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_TOWARDS_MOVEMENT_MEDIUM(new Symbol(2, 4, 2, 2, 1, 1, 16, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_TOWARDS_MOVEMENT_LARGE(new Symbol(2, 4, 2, 3, 1, 1, 16, 42),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_TOWARDS_MOVEMENT_LARGEST(new Symbol(2, 4, 2, 4, 1, 1, 16, 50),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_AWAY_SMALL(new Symbol(2, 4, 3, 1, 1, 1, 14, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_AWAY_MEDIUM(new Symbol(2, 4, 3, 2, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_AWAY_LARGE(new Symbol(2, 4, 3, 3, 1, 1, 16, 40), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_AWAY_LARGEST(new Symbol(2, 4, 3, 4, 1, 1, 16, 50), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_TOWARDS_SMALL(new Symbol(2, 4, 4, 1, 1, 1, 14, 19), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_TOWARDS_MEDIUM(new Symbol(2, 4, 4, 2, 1, 1, 16, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_TOWARDS_LARGE(new Symbol(2, 4, 4, 3, 1, 1, 16, 42), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	DIAGONAL_BETWEEN_TOWARDS_LARGEST(new Symbol(2, 4, 4, 4, 1, 1, 16, 50), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(
					new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.SOUTH_WEST,
							SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL(new Symbol(2, 5, 1, 1, 1, 1, 14, 15),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM(new Symbol(2, 5, 1, 2, 1, 1, 16, 30),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE(new Symbol(2, 5, 1, 3, 1, 1, 16, 42),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST(new Symbol(2, 5, 1, 4, 1, 1, 16, 50),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SINGLE_WRIST_FLEX_FLOOR_PLANE(new Symbol(2, 5, 1, 5, 1, 1, 16, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE(new Symbol(2, 5, 2, 1, 1, 1, 27, 14), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	DOUBLE_WRIST_FLEX_FLOOR_PLANE(new Symbol(2, 5, 2, 2, 1, 1, 27, 18), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE(new Symbol(2, 5, 3, 1, 1, 1, 27, 15),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE(new Symbol(2, 5, 3, 2, 1, 1, 27, 19),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CROSS_MOVEMENT_FLOOR_PLANE(new Symbol(2, 5, 4, 1, 1, 1, 31, 27), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE(new Symbol(2, 5, 5, 1, 1, 1, 40, 14), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TRIPLE_WRIST_FLEX_FLOOR_PLANE(new Symbol(2, 5, 5, 2, 1, 1, 40, 18), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE(new Symbol(2, 5, 6, 1, 1, 1, 40, 15),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE(new Symbol(2, 5, 6, 2, 1, 1, 40, 19),
			Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BENT_FLOOR_PLANE(new Symbol(2, 5, 7, 1, 1, 1, 16, 27), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_FLOOR_PLANE_SMALL(new Symbol(2, 5, 8, 1, 1, 1, 18, 17), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_FLOOR_PLANE_MEDIUM(new Symbol(2, 5, 8, 2, 1, 1, 24, 24), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CORNER_FLOOR_PLANE_LARGE(new Symbol(2, 5, 8, 3, 1, 1, 29, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CHECK_FLOOR_PLANE(new Symbol(2, 5, 9, 1, 1, 1, 20, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BOX_FLOOR_PLANE_SMALL(new Symbol(2, 5, 10, 1, 1, 1, 19, 18), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BOX_FLOOR_PLANE_MEDIUM(new Symbol(2, 5, 10, 2, 1, 1, 24, 24), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	BOX_FLOOR_PLANE_LARGE(new Symbol(2, 5, 10, 3, 1, 1, 29, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ZIGZAG_FLOOR_PLANE_SMALL(new Symbol(2, 5, 11, 1, 1, 1, 16, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ZIGZAG_FLOOR_PLANE_MEDIUM(new Symbol(2, 5, 11, 2, 1, 1, 21, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ZIGZAG_FLOOR_PLANE_LARGE(new Symbol(2, 5, 11, 3, 1, 1, 22, 40), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	PEAKS_FLOOR_PLANE_SMALL(new Symbol(2, 5, 12, 1, 1, 1, 23, 25), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	PEAKS_FLOOR_PLANE_MEDIUM(new Symbol(2, 5, 12, 2, 1, 1, 33, 36), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	PEAKS_FLOOR_PLANE_LARGE(new Symbol(2, 5, 12, 3, 1, 1, 35, 40), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW(new Symbol(2, 5, 13, 1, 1, 1, 20, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), // added
															// FILLED_ARROW to
															// name to
															// prevent duplicate
															// names
	TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW(new Symbol(2, 5, 14, 1, 1, 1, 20, 31),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), // added
															// FILLED_ARROW to
															// name to
															// prevent duplicate
															// names
	TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE_FILLED_ARROW(new Symbol(2, 5, 15, 1, 1, 1, 22, 31),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), // added
															// FILLED_ARROW to
															// name to
															// prevent duplicate
															// names
	TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW(new Symbol(2, 5, 16, 1, 1, 1, 22, 28),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), // added
															// FILLED_ARROW to
															// name to
															// prevent duplicate
															// names
	TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW(new Symbol(2, 5, 17, 1, 1, 1, 22, 39),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), // added
															// FILLED_ARROW to
															// name to
															// prevent duplicate
															// names
	TRAVEL_ROTATION_ALTERNATING_WALL_PLANE_FILLED_ARROW(new Symbol(2, 5, 18, 1, 1, 1, 25, 39),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TRAVEL_SHAKING_FLOOR_PLANE(new Symbol(2, 5, 19, 1, 1, 1, 16, 32), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	CURVE_WALL_PLANE_QUARTER_SMALL(new Symbol(2, 6, 1, 1, 1, 1, 12, 22), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_QUARTER_MEDIUM(new Symbol(2, 6, 1, 2, 1, 1, 15, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_QUARTER_LARGE(new Symbol(2, 6, 1, 3, 1, 1, 17, 36), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_QUARTER_LARGEST(new Symbol(2, 6, 1, 4, 1, 1, 20, 44), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_HALF_CIRCLE_SMALL(new Symbol(2, 6, 2, 1, 1, 1, 21, 28),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_HALF_CIRCLE_MEDIUM(new Symbol(2, 6, 2, 2, 1, 1, 24, 33),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_HALF_CIRCLE_LARGE(new Symbol(2, 6, 2, 3, 1, 1, 29, 36),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_HALF_CIRCLE_LARGEST(new Symbol(2, 6, 2, 4, 1, 1, 37, 54),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_3_QUARTER_CIRCLE_SMALL(new Symbol(2, 6, 3, 1, 1, 1, 23, 27),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_WALL_PLANE_3_QUARTER_CIRCLE_MEDIUM(new Symbol(2, 6, 3, 2, 1, 1, 28, 33),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HUMP_WALL_PLANE_SMALL(new Symbol(2, 6, 4, 1, 1, 1, 14, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HUMP_WALL_PLANE_MEDIUM(new Symbol(2, 6, 4, 2, 1, 1, 14, 41), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HUMP_WALL_PLANE_LARGE(new Symbol(2, 6, 4, 3, 1, 1, 16, 44), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LOOP_WALL_PLANE_SMALL(new Symbol(2, 6, 5, 1, 1, 1, 13, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LOOP_WALL_PLANE_MEDIUM(new Symbol(2, 6, 5, 2, 1, 1, 15, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LOOP_WALL_PLANE_LARGE(new Symbol(2, 6, 5, 3, 1, 1, 19, 47), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LOOP_WALL_PLANE_SMALL_DOUBLE(new Symbol(2, 6, 5, 4, 1, 1, 13, 44), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_WALL_PLANE_2_CURVES_SMALL(new Symbol(2, 6, 6, 1, 1, 1, 14, 32), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_WALL_PLANE_2_CURVES_MEDIUM(new Symbol(2, 6, 6, 2, 1, 1, 15, 35), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_WALL_PLANE_2_CURVES_LARGE(new Symbol(2, 6, 6, 3, 1, 1, 18, 39), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_WALL_PLANE_3_CURVES_SMALL(new Symbol(2, 6, 6, 4, 1, 1, 17, 37), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_WALL_PLANE_3_CURVES_MEDIUM(new Symbol(2, 6, 6, 5, 1, 1, 21, 51), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_WALL_PLANE_3_CURVES_LARGE(new Symbol(2, 6, 6, 6, 1, 1, 30, 51), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_THEN_STRAIGHT_MOVEMENT_WALL_PLANE(new Symbol(2, 6, 7, 1, 1, 1, 19, 33),
			Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVED_CROSS_MOVEMENT_WALL_SMALL(new Symbol(2, 6, 7, 2, 1, 1, 21, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVED_CROSS_MOVEMENT_WALL_MEDIUM(new Symbol(2, 6, 7, 3, 1, 1, 27, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ROTATION_SINGLE_WALL_PLANE(new Symbol(2, 6, 8, 1, 1, 1, 23, 28), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ROTATION_DOUBLE_WALL_PLANE(new Symbol(2, 6, 9, 1, 1, 1, 23, 36), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ROTATION_ALTERNATE_WALL_PLANE(new Symbol(2, 6, 10, 1, 1, 1, 25, 36),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	SHAKING_WALL_PLANE(new Symbol(2, 6, 11, 1, 1, 1, 21, 33), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_HITS_FRONT_WALL(new Symbol(2, 7, 1, 1, 1, 1, 17, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	HUMP_HITS_FRONT_WALL(new Symbol(2, 7, 2, 1, 1, 1, 18, 35), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	LOOP_HITS_FRONT_WALL(new Symbol(2, 7, 3, 1, 1, 1, 24, 47), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	WAVE_HITS_FRONT_WALL(new Symbol(2, 7, 4, 1, 1, 1, 17, 31), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	ROTATION_SINGLE_HITS_FRONT_WALL(new Symbol(2, 7, 5, 1, 1, 1, 28, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	ROTATION_DOUBLE_HITS_FRONT_WALL(new Symbol(2, 7, 6, 1, 1, 1, 36, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	ROTATION_ALTERNATING_HITS_FRONT_WALL(new Symbol(2, 7, 7, 1, 1, 1, 40, 25), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	CURVE_HITS_CHEST(new Symbol(2, 7, 9, 1, 1, 1, 13, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	HUMP_HITS_CHEST(new Symbol(2, 7, 10, 1, 1, 1, 13, 36), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	LOOP_HITS_CHEST(new Symbol(2, 7, 11, 1, 1, 1, 20, 47), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	WAVE_HITS_CHEST(new Symbol(2, 7, 12, 1, 1, 1, 19, 36), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	ROTATION_SINGLE_HITS_CHEST(new Symbol(2, 7, 13, 1, 1, 1, 28, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	ROTATION_DOUBLE_HITS_CHEST(new Symbol(2, 7, 14, 1, 1, 1, 36, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	ROTATION_ALTERNATIVE_HITS_CHEST(new Symbol(2, 7, 15, 1, 1, 1, 40, 25), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	WAVE_DIAGONAL_PATH_SMALL(new Symbol(2, 7, 16, 1, 1, 1, 22, 37), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_DIAGONAL_PATH_MEDIUM(new Symbol(2, 7, 16, 2, 1, 1, 26, 51), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_DIAGONAL_PATH_LARGE(new Symbol(2, 7, 16, 3, 1, 1, 38, 51), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_HITS_CEILING_SMALL(new Symbol(2, 8, 1, 1, 1, 1, 19, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	CURVE_HITS_CEILING_LARGE(new Symbol(2, 8, 1, 2, 1, 1, 23, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_CEILING_2_HUMPS_SMALL(new Symbol(2, 8, 2, 1, 1, 1, 26, 24), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_CEILING_2_HUMPS_LARGE(new Symbol(2, 8, 2, 2, 1, 1, 31, 33), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_CEILING_3_HUMPS_SMALL(new Symbol(2, 8, 2, 3, 1, 1, 33, 32), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_CEILING_3_HUMPS_LARGE(new Symbol(2, 8, 2, 4, 1, 1, 38, 41), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_CEILING_SMALL_SINGLE(new Symbol(2, 8, 3, 1, 1, 1, 19, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_CEILING_LARGE_SINGLE(new Symbol(2, 8, 3, 2, 1, 1, 22, 32), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_CEILING_SMALL_DOUBLE(new Symbol(2, 8, 3, 3, 1, 1, 19, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_CEILING_LARGE_DOUBLE(new Symbol(2, 8, 3, 4, 1, 1, 22, 40), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	WAVE_HITS_CEILING_SMALL(new Symbol(2, 8, 4, 1, 1, 1, 23, 30), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	WAVE_HITS_CEILING_LARGE(new Symbol(2, 8, 4, 2, 1, 1, 33, 40), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ROTATION_SINGLE_HITS_CEILING(new Symbol(2, 8, 5, 1, 1, 1, 26, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ROTATION_DOUBLE_HITS_CEILING(new Symbol(2, 8, 6, 1, 1, 1, 40, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ROTATION_ALTERNATING_HITS_CEILING(new Symbol(2, 8, 7, 1, 1, 1, 40, 24),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	CURVE_HITS_FLOOR_SMALL(new Symbol(2, 8, 8, 1, 1, 1, 19, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	CURVE_HITS_FLOOR_LARGE(new Symbol(2, 8, 8, 2, 1, 1, 23, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_FLOOR_2_HUMPS_SMALL(new Symbol(2, 8, 9, 1, 1, 1, 23, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_FLOOR_2_HUMPS_LARGE(new Symbol(2, 8, 9, 2, 1, 1, 31, 33), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_FLOOR_3_HUMPS_SMALL(new Symbol(2, 8, 9, 3, 1, 1, 29, 31), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HUMP_HITS_FLOOR_3_HUMPS_LARGE(new Symbol(2, 8, 9, 4, 1, 1, 39, 43), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_FLOOR_SMALL_SINGLE(new Symbol(2, 8, 10, 1, 1, 1, 19, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_FLOOR_LARGE_SINGLE(new Symbol(2, 8, 10, 2, 1, 1, 22, 32), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_FLOOR_SMALL_DOUBLE(new Symbol(2, 8, 10, 3, 1, 1, 20, 34), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOOP_HITS_FLOOR_LARGE_DOUBLE(new Symbol(2, 8, 10, 4, 1, 1, 22, 40), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	WAVE_HITS_FLOOR_SMALL(new Symbol(2, 8, 11, 1, 1, 1, 24, 26), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	WAVE_HITS_FLOOR_LARGE(new Symbol(2, 8, 11, 2, 1, 1, 36, 39), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ROTATION_SINGLE_HITS_FLOOR(new Symbol(2, 8, 12, 1, 1, 1, 26, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ROTATION_DOUBLE_HITS_FLOOR(new Symbol(2, 8, 13, 1, 1, 1, 39, 23), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ROTATION_ALTERNATING_HITS_FLOOR(new Symbol(2, 8, 14, 1, 1, 1, 43, 23),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	CURVE_FLOOR_PLANE_SMALL(new Symbol(2, 9, 1, 1, 1, 1, 22, 9), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_FLOOR_PLANE_MEDIUM_1(new Symbol(2, 9, 1, 2, 1, 1, 29, 12), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_FLOOR_PLANE_MEDIUM_2(new Symbol(2, 9, 1, 3, 1, 1, 39, 14), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_FLOOR_PLANE_LARGE(new Symbol(2, 9, 1, 4, 1, 1, 46, 15), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	CURVE_FLOOR_PLANE_COMBINED(new Symbol(2, 9, 1, 5, 1, 1, 38, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HUMP_FLOOR_PLANE_SMALL(new Symbol(2, 9, 2, 1, 1, 1, 40, 11), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LOOP_FLOOR_PLANE_SMALL(new Symbol(2, 9, 3, 1, 1, 1, 40, 11), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_FLOOR_PLANE_SNAKE(new Symbol(2, 9, 4, 1, 1, 1, 49, 13), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_FLOOR_PLANE_SMALL(new Symbol(2, 9, 4, 2, 1, 1, 42, 16), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WAVE_FLOOR_PLANE_LARGE(new Symbol(2, 9, 4, 3, 1, 1, 50, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ROTATION_SINGLE_FLOOR_PLANE(new Symbol(2, 9, 5, 1, 1, 1, 21, 21), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ROTATION_DOUBLE_FLOOR_PLANE(new Symbol(2, 9, 6, 1, 1, 1, 21, 29), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ROTATION_ALTERNATING_FLOOR_PLANE(new Symbol(2, 9, 7, 1, 1, 1, 23, 29),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	SHAKING_PARALLEL_FLOOR(new Symbol(2, 9, 8, 1, 1, 1, 20, 32), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_WALL_SMALL_SINGLE(new Symbol(2, 10, 1, 1, 1, 1, 23, 27), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_WALL_MEDIUM_SINGLE(new Symbol(2, 10, 1, 2, 1, 1, 29, 33), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_WALL_SMALL_DOUBLE(new Symbol(2, 10, 2, 1, 1, 1, 23, 27), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_WALL_MEDIUM_DOUBLE(new Symbol(2, 10, 2, 2, 1, 1, 29, 33), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_HITS_WALL_SMALL_SINGLE(new Symbol(2, 10, 3, 1, 1, 1, 15, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE(new Symbol(2, 10, 3, 2, 1, 1, 15, 32),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_HITS_WALL_LARGE_SINGLE(new Symbol(2, 10, 3, 3, 1, 1, 15, 40),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE(new Symbol(2, 10, 4, 1, 1, 1, 15, 25),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE(new Symbol(2, 10, 4, 2, 1, 1, 15, 32),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE(new Symbol(2, 10, 4, 3, 1, 1, 15, 40),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WRIST_CIRCLE_FRONT_WALL_SINGLE(new Symbol(2, 10, 5, 1, 1, 1, 17, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WRIST_CIRCLE_FRONT_WALL_DOUBLE(new Symbol(2, 10, 5, 2, 1, 1, 21, 23), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	WRIST_CIRCLE_HITS_WALL_SINGLE(new Symbol(2, 10, 6, 1, 1, 1, 18, 20), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST })), //
	WRIST_CIRCLE_HITS_WALL_DOUBLE(new Symbol(2, 10, 6, 2, 1, 1, 21, 20), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST })), //
	FINGER_CIRCLES_WALL_SINGLE(new Symbol(2, 10, 7, 1, 1, 1, 16, 17), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	FINGER_CIRCLES_WALL_DOUBLE(new Symbol(2, 10, 7, 2, 1, 1, 16, 17), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	FINGER_CIRCLES_HITS_WALL_SINGLE(new Symbol(2, 10, 7, 3, 1, 1, 9, 22), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	FINGER_CIRCLES_HITS_WALL_DOUBLE(new Symbol(2, 10, 7, 4, 1, 1, 10, 22), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ARROWHEADS_SMALL(new Symbol(2, 10, 8, 1, 1, 1, 13, 7), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	ARROWHEADS_LARGE(new Symbol(2, 10, 8, 2, 1, 1, 16, 8), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	;

	private static final List<SymbolRotation> MIRRORED_ROTATIONS = Arrays.asList(new SymbolRotation[] {
			SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST, SymbolRotation.MIRRORED_WEST,
			SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH, SymbolRotation.MIRRORED_SOUTH_EAST,
			SymbolRotation.MIRRORED_EAST, SymbolRotation.MIRRORED_NORTH_EAST });

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;

	public enum MovementsSymbolGroups {
		TOUCH(1), FINGER_MOVEMENTS(2);

		private int group;

		MovementsSymbolGroups(int group) {
			this.group = group;
		}

		public int getGroup() {
			return this.group;
		}
	}

	private MovementBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public static MovementBaseSymbol getMovementBaseSymbol(BaseSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		MovementBaseSymbol result = null;
		for (MovementBaseSymbol movementBaseSymbol : MovementBaseSymbol.values()) {
			if (movementBaseSymbol.getIswaSymbol().getCategory() == symbol.getCategory()
					&& movementBaseSymbol.getIswaSymbol().getGroup() == symbol.getGroup()
					&& movementBaseSymbol.getIswaSymbol().getSymbol() == symbol.getSymbol()
					&& movementBaseSymbol.getIswaSymbol().getVariation() == symbol.getVariation()) {
				result = movementBaseSymbol;
				break;
			}
		}

		return result;
	}

	@Override
	public List<Integer> getValidFills() {
		return validFills;
	}

	@Override
	public List<SymbolRotation> getValidRotations() {
		return validRotations;
	}

	@Override
	public List<Integer> getValidRotationValues() {
		List<Integer> result = new ArrayList<Integer>();

		for (SymbolRotation rotation : validRotations) {
			result.add(rotation.getRotationValue());
		}
		return result;
	}

	@Override
	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	@Override
	public boolean canBeMirrored() {
		boolean result = false;

		for (SymbolRotation mirroredSymbolEnum : MIRRORED_ROTATIONS) {
			if (validRotations.contains(mirroredSymbolEnum)) {
				result = true;
				break;
			}
		}

		// Finger circles can be mirrored but have rotations 1-8 (5-8 are
		// mirrored)
		if (!result && (getIswaSymbol().getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()))) {
			result = true;
		}
		return result;
	}

}
