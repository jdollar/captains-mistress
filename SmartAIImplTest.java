import static org.junit.Assert.*;

import org.junit.Test;


public class SmartAIImplTest {

	@Test
	public void testAStar() {
		DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
		testBoard.EmptyGameBoard();
		SmartAIImpl tester = new SmartAIImpl(testBoard);
		assertEquals("Result", 0, tester.AStar());
	}

//	@Test
//	public void testScoreDetermine() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTokenCount() {
//		fail("Not yet implemented");
//	}

}
