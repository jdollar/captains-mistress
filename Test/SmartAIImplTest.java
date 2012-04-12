
import static org.junit.Assert.*;

import org.junit.Test;


public class SmartAIImplTest {
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	SmartAIImpl tester;
	
	@Test
	public void testAStar() {	
		testBoard.EmptyGameBoard();
		tester = new SmartAIImpl(testBoard);
		assertEquals("Result", 0, tester.AStar());
	}

	@Test
	public void testScoreDetermine(){
		testBoard.EmptyGameBoard();
		testBoard.ColumnNTokens(3, 1, 0);
		testBoard.displayBoard();
		tester = new SmartAIImpl(testBoard);
		assertEquals("Result", 3, tester.ScoreDetermine(1));
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
