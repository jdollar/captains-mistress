package Zach;

import mainPack.*;

public class  GameEngineImpl implements GameEngine{
  public void GameLoop(){
  	StateCheckImpl loopChecks = new StateCheckImpl();
	DummyGameBoardImpl checkBoard = new DummyGameBoardImpl();
	DummyControl player = new DummyControl(checkBoard);
  	while(!loopChecks.CheckVictory(checkBoard.getGameBoard())){
		player.getInput();
  	}
  }
}

