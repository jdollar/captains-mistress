package Zach;

import mainPack.*;

public class  GameEngineImpl implements GameEngine{
	int playerToken;
	public void GameLoop(){
		boolean loopcondition = true;
		int choice = 0;
  		StateCheckImpl loopChecks = new StateCheckImpl();
		DummyGameBoardImpl checkBoard = new DummyGameBoardImpl();
		DummyControl player = new DummyControl(checkBoard);
		DisplayImpl numPlayers = new DisplayImpl();
		GameboardImpl gameBoard = new GameBoardImpl();
		
		choice = numPlayers.DrawMenu();
    
  		while (loopcondition){


			if (choice == 0) //User selects computer vs computer
			{
			}
			else if (choice == 1) //User selects player vs computer
			{
			}
			else //User selects player vs player
			{
			}

		while(!loopChecks.CheckVictory(checkBoard.getGameBoard())){
			numPlayers.ReDrawGameBoard(checkBoard); //Redraws game board
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


	}

  } 

