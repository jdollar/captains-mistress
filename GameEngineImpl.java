public class  GameEngineImpl implements GameEngine{
  public void GameLoop(){
  	StateCheckImpl loopChecks = new StateCheckImpl();
  	DummyGameBoardImpl checkBoard = new DummyGameBoardImpl();
  	while(!loopChecks.CheckVictory(checkBoard.getGameBoard())){
  		
  	}
  }
}

interface GameEngine{
  void GameLoop();
}
