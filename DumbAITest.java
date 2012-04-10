import org.junit.*;
import static org.junit.Assert.*;

public class DumbAITest {
	DummyGameBoardImpl testBoardCase = new DummyGameBoardImpl();
	DumbAI testAI = new DumbAI(testBoardCase);
	
	@Test
	public void FirstMoveTest(){
		testBoardCase.EmptyGameBoard();
		int testNumber = testAI.ColumnFill(testBoardCase);
		assertTrue(testNumber >= 0 || testNumber <= 7);
	}
	
	@Test
	public void OneColumnFullTest(){
		
	}
	
	@Test
	public void NColumnFullTest(){
		
	}
	
	@Test
	public void GlassHalfFullTest(){
		
	}
	
	@Test
	public void NColumnGlassHalfFullTest(){
		
	}
	
	@Test
	public void FullBoardTest(){
		testBoardCase.EmptyGameBoard();
		testBoardCase.FullGameBoardAlternating();
		
		assertEquals("Result", -1, testAI.ColumnFill(testBoardCase));
	}
}
