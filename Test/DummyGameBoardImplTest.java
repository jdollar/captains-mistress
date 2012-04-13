package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import mainPack.*;


public class DummyGameBoardImplTest {
	DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
	
	@Test
	public void getLowestGridValueTest() {
		testBoard.emptyGameBoard();
		for(int x = 0; x < testBoard.getNumRows(); x++){
			assertEquals("Result", testBoard.getNumRows() - 1, testBoard.getLowestGridValue(x));
		}
		
		testBoard.columnNTokens(3, 1, 0);
		assertEquals("Result", testBoard.getNumRows() - 4, testBoard.getLowestGridValue(0));
		
		testBoard.emptyGameBoard();
		testBoard.columnNTokens(4, 1, 3);
		assertEquals("Result", testBoard.getNumRows() - 5, testBoard.getLowestGridValue(3));
	}

}
