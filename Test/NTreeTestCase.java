package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import Joel.*;
import mainPack.*;


public class NTreeTestCase{
	NTreeImpl testTree = new NTreeImpl();
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	
	@Test
	public void transveralTest(){
		NodeImpl testNode = new NodeImpl(2, 0, 1);
		assertEquals("Result", 0, testTree.transversal(testNode));
		//write some more tests to get the problem determined
	}
/*	@Test
	public void testBuildTreeEmpty() {
		testBoard.emptyGameBoard();
		assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard, 0, -1)));
	}*/

/*	@Test
	public void testBuildTreeFull(){
		testBoard.emptyGameBoard();
		testBoard.fullGameBoardAlternating();
		
		assertEquals("Result", -1, testTree.transversal((testTree.buildTree(testBoard, 1, 0))));
	}*/


/*	@Test
	public void DefendTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 2, 0);

		assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard, 0, -1)));
	}

	@Test
	public void DefendVsWinOpponentFirstColumnTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 1, 0);
		testBoard.columnNTokens(3, 2, 1);
		
		assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));
	}

	@Test
	public void DefendVsWinOpponentSecondColumnTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 2, 0);
		testBoard.columnNTokens(3, 1, 1);
		
		assertEquals("Result", 1, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));
	}

	@Test
	public void BestSpotChoosingFirstColumnBestTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 1, 0);
		testBoard.columnNTokens(2, 1, 1);
		
		assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));
	}

	@Test
	public void BestSpotChoosingSecondColumnBestTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(2, 1, 0);
		testBoard.columnNTokens(3, 1, 1);
		
		assertEquals("Result", 1, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));	
	}

	@Test
	public void LastColumnEmptyTest(){
		testBoard.emptyGameBoard();
		testBoard.nColumnFilledGameBoard(6);
		
		assertEquals("Result", 7, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));
	}

	@Test
	public void AIOffensiveFirstColumnTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(2, 1, 0);
		testBoard.columnNTokens(1, 2, 1);
		
		assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));
	}

	@Test
	public void AIOffensiveSecondColumnTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(1, 2, 0);
		testBoard.columnNTokens(2, 1, 1);
		
		assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard,  0, -1)));
	}
	
	@Test
	public void testtransversal() {
		fail("Not yet implemented");
	}
	
	public void displayTree(){
		
	}*/
}