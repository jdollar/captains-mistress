import org.junit.Test;
import static org.junit.Assert.*;

public class smartAITest {
	@Test
	public void emptyTest(){
		DummyGameBoardImpl emptyBoard = new DummyGameBoardImpl();
		emptyBoard.EmptyGameBoard();
		SmartAIImpl testAI = new SmartAIImpl(emptyBoard);
		assertEquals("Result", 0, testAI.AStar());
	}
	
	@Test
	public void FullTest(){
		DummyGameBoardImpl fullBoard = new DummyGameBoardImpl();
		fullBoard.EmptyGameBoard();
		fullBoard.FullGameBoardAlternating();
		
		NTree testTree = new NTreeImpl(4);
		assertEquals("Result", -1, testTree.Transversal((testTree.buildTree(fullBoard, 1, 0))));
	}
	
	@Test
	public void DefendTest(){
		
	}
	
	@Test
	public void DefendVsWinTest(){
		
	}
	@Test
	public void BestSpotChoosingTest(){
		
	}
	
	@Test
	public void LastColumnEmptyTest(){
		
	}
	
	@Test
	public void AIOffensiveTest(){
		
	}
}
