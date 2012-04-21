package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import mainPack.*;
import Joel.*;


public class SmartAIImplTest {
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	SmartAIImpl tester;
	
	@Test
	public void testAStar() {	
		testBoard.emptyGameBoard();
		tester = new SmartAIImpl(testBoard);
		assertEquals("Result", 0, tester.AStar());
	}
}
