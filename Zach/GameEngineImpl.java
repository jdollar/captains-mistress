package Zach;

import mainPack.*;

public class  GameEngineImpl implements GameEngine{
	int playerToken;
  public void GameLoop(){
    boolean loopcondition = true;
    int choice = 0;
  	StateCheckImpl loopChecks = new StateCheckImpl();
    DisplayImpl gameDisplay = new DisplayImpl();
	DummyGameBoardImpl checkBoard = new DummyGameBoardImpl();
	DummyControl player = new DummyControl(checkBoard);
  	while (loopcondition){
	if (choice == 1)
	{
	 while(!loopChecks.CheckVictory(checkBoard.getGameBoard())){
		gameDisplay.ReDrawGameBoard(checkBoard); //Redraws game board
		int input = player.getInput();           //Gets user input
		checkBoard.setValue(input, playerToken);
		if (loopChecks.CheckVictory(checkBoard))
		{
			// Calls displays output for victory
			break;
		}
		else if (loopChecks.CheckDraw(checkBoard))
		{
			// Calls displays output for draw
			break;
		}
		
  	}
	}
    else if (choice == 2){
		// call display instructions
	}
	else if (choice == 4){
		loopcondition =  false;
		}
	else {
		System.out.println("Invaild choice.");
	}
	}

  }
  
}

