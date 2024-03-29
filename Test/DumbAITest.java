package Test;

import org.junit.*;
import static org.junit.Assert.*;
import mainPack.*;
import Joel.*;

public class DumbAITest {
	DummyGameBoardImpl testBoardCase = new DummyGameBoardImpl();
	DumbAI testAI = new DumbAI(testBoardCase);

	@Test
	public void FirstMoveTest() {
		testBoardCase.emptyGameBoard();
		int testNumber = testAI.ColumnFill();
		assertTrue(testNumber >= 0 || testNumber <= 7);
	}

	@Test
	public void OneColumnFullTest() {

	}

	@Test
	public void NColumnFullTest() {

	}

	@Test
	public void GlassHalfFullTest() {

	}

	@Test
	public void NColumnGlassHalfFullTest() {

	}

	@Test
	public void FullBoardTest() {
		testBoardCase.emptyGameBoard();
		testBoardCase.fullGameBoardAlternating();

		assertEquals("Result", -1, testAI.ColumnFill());
	}
}
