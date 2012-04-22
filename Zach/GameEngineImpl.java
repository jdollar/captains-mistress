package Zach;

import mainPack.*;
import James.*;

public class  GameEngineImpl implements GameEngine{
	int playerToken;
	public void GameLoop(){
		boolean loopcondition = true;
		int numberPlayers = 0;
		int aiChoice = 0;

  		StateCheckImpl loopChecks = new StateCheckImpl();     // Calls all the information needed// for running the game
		DisplayImpl numPlayers = new DisplayImpl();
		GameBoardImpl gameBoard = new GameBoardImpl();
		
    
  		while (loopcondition){
			numberPlayers = numPlayers.DrawMenu();
			aiChoice = numPlayers.AIChoice();

			if (aiChoice == 0) //User selects computer vs computer, which is 2 AI's
			{
                          if (aiChoice == 1) {             //Smart AI

                          }
                          else if (aiChoice == 2) {        //Dumb AI

                          }
			}
			else if (aiChoice == 1) //User selects player vs computer, which is 1 AI and 1 player
			{
                          if (aiChoice == 1) {            //Smart AI

                          }
                          else if (aiChoice == 2) {       //Dumb AI

                          }
			}
			else //User selects player vs player, which is 2 players
			{
			}

	/*	while(!loopChecks.CheckVictory(gameBoard)){
			numPlayers.ReDrawGameBoard(gameBoard.getGameBoard()); //Redraws game board
			int input = player.getInput();           //Gets user input
			gameBoard.setValue(gameBoard.getLowestGridValue(input), input, playerToken);
			if (loopChecks.CheckVictory(gameBoard))
				{
				// Calls displays output for victory
				break;
				}
			else if (loopChecks.CheckDraw(gameBoard))
			{
				// Calls displays output for draw
				break;
			}
  		}*/	
	    }


	}

  } 

