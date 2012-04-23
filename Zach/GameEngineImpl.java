package Zach;

import mainPack.*;
import James.*;

public class  GameEngineImpl implements GameEngine{
	int playerToken;
	public void GameLoop(){
		boolean loopcondition = true;
		int numberPlayers = 0;
		int aiChoice = 0;

  		StateCheckImpl loopChecks = new StateCheckImpl();     // Calls all the information needed for running the game
		DisplayImpl numPlayers = new DisplayImpl();
		GameBoardImpl gameBoard = new GameBoardImpl();
		SmartAIImpl smart = new SmartAIImpl();
		DumbAI dumb = new DumbAI();
  		while (loopcondition){
			numberPlayers = numPlayers.DrawMenu();
			aiChoice = numPlayers.AIChoice();

			if (aiChoice == 0) //User selects computer vs computer, which is 2 AI's
			{
                          if (aiChoice == 1) {             //Smart AI
							  playerOne = smart.Astar();
							  playerTwo = smart.Astar();
                          }
                          else if (aiChoice == 2) {        //Dumb AI
							  playerOne = dumb.ColumnFill();
							  playerTwo = dumb.ColumnFill();
                          }
			}
			else if (aiChoice == 1) //User selects player vs computer, which is 1 AI and 1 user player
			{
                          if (aiChoice == 1) {            //Smart AI
							  playerOne = smart.Astar();
							  playerTwo = ; // user player?
                          }
                          else if (aiChoice == 2) {       //Dumb AI
							  playerOne = ; // user player
							  playerTwo = ; // user player
                          }
			}
			else //User selects player vs player, which is 2 user players
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

