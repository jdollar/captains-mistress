package Test;

import org.junit.*;
import mainPack.StateCheckImpl;
import mainPack.DummyGameBoardImpl;
import static org.junit.Assert.*;

public class TestStateCheck{
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	StateCheckImpl tester = new StateCheckImpl();
	
	@Test
	public void testCheckVictory(){
		testBoard.columnNTokens(4, 1, 0);
		assertTrue(tester.checkVictory(testBoard, 1));
		assertFalse(tester.checkVictory(testBoard, 2));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(4, 1, 2);
		assertTrue(tester.checkVictory(testBoard, 1));
		assertFalse(tester.checkVictory(testBoard, 2));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(4, 2, 0);
		assertTrue(tester.checkVictory(testBoard, 2));
		assertFalse(tester.checkVictory(testBoard, 1));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(4, 2, 2);
		assertTrue(tester.checkVictory(testBoard, 2));
		assertFalse(tester.checkVictory(testBoard, 1));

		testBoard.emptyGameBoard();
		assertFalse(tester.checkVictory(testBoard, 2));
		assertFalse(tester.checkVictory(testBoard, 1));

		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 2, 0);
		assertFalse(tester.checkVictory(testBoard, 2));
		assertFalse(tester.checkVictory(testBoard, 1));
	}
	
	@Test
	public void testCheckDraw(){
		testBoard.emptyGameBoard();
		assertFalse(tester.checkDraw(testBoard));
		
		testBoard.fullGameBoardAlternating();
		assertTrue(tester.checkDraw(testBoard));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(6, 1, 0);
		testBoard.columnNTokens(6, 1, 1);
		testBoard.columnNTokens(6, 1, 2);
		testBoard.columnNTokens(6, 1, 3);
		testBoard.columnNTokens(6, 1, 4);
		testBoard.columnNTokens(6, 1, 5);
		assertFalse(tester.checkDraw(testBoard));
	}
	
	@Test
	public void testScoreDetermine(){
		tester = new StateCheckImpl(testBoard);
		
		//test for vertical scoring
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 1, 0);
		assertEquals("Result", 3, tester.scoreDetermine(1));
		
		//test if picks best choice (highest value)
		testBoard.columnNTokens(4, 1, 3);
		assertEquals("Result", 4, tester.scoreDetermine(1));
		
		//test horizontal
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(1, 1, 0);
		testBoard.columnNTokens(1, 1, 1);
		testBoard.columnNTokens(1, 1, 2);
		assertEquals("Result", 3, tester.scoreDetermine(1));
	}
	
	@Test
	public void testTokenCount(){
		testBoard.emptyGameBoard();
		testBoard.displayBoard();
		System.out.println("\n");
		testBoard.columnNTokens(3, 1, 0);
		testBoard.displayBoard();
		tester = new StateCheckImpl(testBoard);
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
}
