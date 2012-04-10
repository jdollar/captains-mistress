
public class main {
	public static void main(String[] args){
		//GameEngineImpl Heart = new GameEngineImpl();
		DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
		testBoard.EmptyGameBoard();
		SmartAIImpl AI = new SmartAIImpl(testBoard);
		
		AI.AStar();
		
		//Heart.GameLoop();
	}
}
