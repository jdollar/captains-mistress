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

//tests for checking functions. Commented out because of access Change of functions
/*	@Test
	public void testTokenCount(){
		testBoard.emptyGameBoard();
		testBoard.displayBoard();
		System.out.println("\n");
		testBoard.columnNTokens(3, 1, 0);
		testBoard.displayBoard();
		tester = new SmartAIImpl(testBoard);
		assertEquals("Result", 3, tester.downCheck(0, 3, 1));
		assertEquals("Result", 0, tester.leftDownCheck(1, 2, 1));
		
		testBoard.columnNTokens(4, 1, 1);
		testBoard.displayBoard();
		assertEquals("Result", 4, tester.downCheck(1, 2, 1));
		assertEquals("Result", 2, tester.leftDownCheck(1, 2, 1));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(1, 1, 0);
		testBoard.columnNTokens(1, 1, 1);
		testBoard.columnNTokens(1, 1, 2);
		assertEquals("Result", 3, tester.leftCheck(2, 5, 1));
		
		testBoard.emptyGameBoard();
		testBoard.fullGameBoardToken(1);
		assertEquals("Result", 6, tester.downCheck(0, 0, 1));
		assertEquals("Result", 6, tester.rightDownCheck(0, 0, 1));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(4, 1, 0);
		testBoard.columnNTokens(3, 1, 1);
		assertEquals("Result", 2, tester.rightDownCheck(0, 2, 1));
	}
	*/
	@Test
	public void testScoreDetermine(){
		tester = new SmartAIImpl(testBoard);
		
		//test for vertical scoring
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 1, 0);
		assertEquals("Result", 3, tester.ScoreDetermine(1));
		
		//test if picks best choice (highest value)
		testBoard.columnNTokens(4, 1, 3);
		assertEquals("Result", 4, tester.ScoreDetermine(1));
		
		//test horizontal
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(1, 1, 0);
		testBoard.columnNTokens(1, 1, 1);
		testBoard.columnNTokens(1, 1, 2);
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
