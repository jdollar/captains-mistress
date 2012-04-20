package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import Joel.*;
import mainPack.*;


public class NTreeTestCase{
	NTreeImpl testTree = new NTreeImpl(1);
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	
	/*@Test
	public void BuildTreeTest(){
		NodeImpl resultNode = new NodeImpl(1, 7, 1);
		assertEquals("Result", 1, testTree.buildTree(testBoard, -1, 0).getChild(0).getState());
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(1);
		assertEquals("Result", 0, testTree.buildTree(testBoard, -1, 0).getChild(0).numChildren());
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(2);
		assertEquals("Result", 1, testTree.buildTree(testBoard, -1, 0).getChild(0).getPlayer());
		testBoard.emptyGameBoard();
		assertEquals("Result", 2, testTree.buildTree(testBoard, -1, 0).getChild(0).
				getChild(0).getPlayer());
		
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(2);
		assertEquals("Result", 1, testTree.buildTree(testBoard, -1, 0).getChild(0).
				getChild(0).getState());
	
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(0);
		assertEquals("Result", 0, testTree.buildTree(testBoard, -1, 0).numChildren());
	
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(1);
		assertEquals("Result", 0, testTree.buildTree(testBoard, -1, 0).getChild(0).
				numChildren());
		
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(2);
		assertEquals("Result", 0, testTree.buildTree(testBoard, -1, 0).getChild(0).
				getChild(0).numChildren());
		
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(3);
		assertEquals("Result", 0, testTree.buildTree(testBoard, -1, 0).getChild(0).
				getChild(0).getChild(0).numChildren());
	}*/
	@Test
	public void transveralTest(){
		NodeImpl testNode = new NodeImpl(2, 0, 1, 0);
		testTree.transversal(testNode);
		assertEquals("Result", 0, testTree.getColumnToMove());
		//write some more tests to get the problem determined
	}
	
	@Test
	public void testEmptyGameBoardMove() {
		testBoard.emptyGameBoard();
		testTree = new NTreeImpl(1);
		testTree.transversal(testTree.buildTree(testBoard, -1, 0));
		assertEquals("Result", 0, testTree.getColumnToMove());
		//assertEquals("Result", 0, testTree.transversal(testTree.buildTree(testBoard, -1, 0)));
	}

/*	@Test
	public void testBuildTreeFull(){
		testBoard.emptyGameBoard();
		testBoard.fullGameBoardAlternating();
		
		assertEquals("Result", -1, testTree.transversal((testTree.buildTree(testBoard, 1, 0))));
	}*/


	@Test
	public void DefendTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 1, 2);
		testTree.transversal(testTree.buildTree(testBoard, -1, 0));
		assertEquals("Result", 2, testTree.getColumnToMove());
	}

	/*@Test
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
	}*/

/*	@Test
	public void BestSpotChoosingFirstColumnBestTest(){
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(3, 1, 0);
		testBoard.columnNTokens(2, 1, 1);
		testTree = new NTreeImpl(2);
		testTree.transversal(testTree.buildTree(testBoard,  -1, 0));
		assertEquals("Result", 0, testTree.getColumnToMove());
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(2, 1, 0);
		testBoard.columnNTokens(3, 1, 1);
		testTree.transversal(testTree.buildTree(testBoard, -1, 0));
		assertEquals("Result", 1, testTree.getColumnToMove());
	}
*/
/*	@Test
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