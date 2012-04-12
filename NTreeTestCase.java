import static org.junit.Assert.*;

import org.junit.Test;


public class NTreeTestCase extends NTreeImpl{

	NTreeTestCase(int numberOfSteps){
		super(numberOfSteps);
	}
	
	@Test
	public void testBuildTreeEmpty() {
		DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
		testBoard.EmptyGameBoard();
		
	}

	@Test
	public void testTransversal() {
		fail("Not yet implemented");
	}
	
	public void displayTree(){
		
	}

}

/*private DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
private NTreeImpl testTree = new NTreeImpl(4);

@Test
public void emptyTest(){
	testBoard.EmptyGameBoard();
	SmartAIImpl testAI = new SmartAIImpl(testBoard);
	assertEquals("Result", 0, testAI.AStar());
}

@Test
public void FullTest(){
	testBoard.EmptyGameBoard();
	testBoard.FullGameBoardAlternating();
	
	assertEquals("Result", -1, testTree.Transversal((testTree.buildTree(testBoard, 1, 0))));
}

@Test
public void DefendTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(3, 2, 0);

	assertEquals("Result", 0, testTree.Transversal(testTree.buildTree(testBoard, 0, -1)));
}

@Test
public void DefendVsWinOpponentFirstColumnTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(3, 1, 0);
	testBoard.ColumnNTokens(3, 2, 1);
	
	assertEquals("Result", 0, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));
}

@Test
public void DefendVsWinOpponentSecondColumnTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(3, 2, 0);
	testBoard.ColumnNTokens(3, 1, 1);
	
	assertEquals("Result", 1, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));
}

@Test
public void BestSpotChoosingFirstColumnBestTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(3, 1, 0);
	testBoard.ColumnNTokens(2, 1, 1);
	
	assertEquals("Result", 0, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));
}

@Test
public void BestSpotChoosingSecondColumnBestTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(2, 1, 0);
	testBoard.ColumnNTokens(3, 1, 1);
	
	assertEquals("Result", 1, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));	
}

@Test
public void LastColumnEmptyTest(){
	testBoard.EmptyGameBoard();
	testBoard.NColumnFilledGameBoard(6);
	
	assertEquals("Result", 7, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));
}

@Test
public void AIOffensiveFirstColumnTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(2, 1, 0);
	testBoard.ColumnNTokens(1, 2, 1);
	
	assertEquals("Result", 0, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));
}

@Test
public void AIOffensiveSecondColumnTest(){
	testBoard.EmptyGameBoard();
	testBoard.ColumnNTokens(1, 2, 0);
	testBoard.ColumnNTokens(2, 1, 1);
	
	assertEquals("Result", 0, testTree.Transversal(testTree.buildTree(testBoard,  0, -1)));
}*/