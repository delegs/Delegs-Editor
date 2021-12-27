package de.signWritingEditor.client.model.material.positionedHandSymbols;

import de.signWritingEditor.shared.model.material.SymbolFactory;

public interface PositionedHandSymbolTestInterface {

	public void setUp(SymbolFactory symbolFactory);

	public void testIsRightHand();

	public void testIsLeftHand();

	public void testCanIncrease();

	public void testIncrease();

	public void testCanDecrease();

	public void testDecrease();

	public void testCanRotate();

	public void testRotateClockwise();

	public void testRotateCounterClockwise();

	public void testCanMirror();

	public void testMirror();

	public void testCanMirrorVertically();

	public void testMirrorVertically();

	public void testCanPitch();

	public void testPitch();

	public void testCanRoll();

	public void testRoll();

	public void testCanSwitchArrowHead();

	public void testSwitchArrowHead();

	public void testCanSwitchToNormalArrows();

	public void testSwitchToNormalArrows();

	public void testCanSwitchToAlternatingArrows();

	public void testSwitchToAlternatingArrows();

	public void testCanSwitchStartingPoint();

	public void testSwitchStartingPoint();

}
