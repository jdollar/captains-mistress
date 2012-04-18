package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import mainPack.*;
import Joel.*;


public class SmartAIImplTest {
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	SmartAIImpl tester;
	
//	@Test
//	public void testAStar() {	
//		testBoard.emptyGameBoard();
//		tester = new SmartAIImpl(testBoard);
//		assertEquals("Result", 0, tester.AStar());
//	}


	@Test
	public void testTokenCount(){
		testBoard.emptyGameBoard();
		testBoard.displayBoard();
		System.out.println("\n");
		testBoard.columnNTokens(3, 1, 0);
		testBoard.displayBoard();
		tester = new SmartAIImpl(testBoard);
		assertEquals("Result", 3, tester.TokenCount(0, 2, 0, 3, 1));
		
		testBoard.columnNTokens(4, 1, 1);
		testBoard.displayBoard();
		assertEquals("Result", 4, tester.TokenCount(1, 1, 1, 2, 1));
		assertEquals("Result", 2, tester.TokenCount(1, 1, 0, 3, 1));
	}
	
	@Test
	public void testScoreDetermine(){
		testBoard.emptyGameBoard();
		testBoard.displayBoard();
		System.out.println("\n");
		testBoard.columnNTokens(3, 1, 0);
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
