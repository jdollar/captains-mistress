public class  GameEngineImpl implements GameEngine{
  public void GameLoop(){
  	StateCheckImpl loopChecks = new StateCheckImpl();
  	while(!loopChecks.CheckVictory()){
  		
  	}
  }
}

interface GameEngine{
  void GameLoop();
}
