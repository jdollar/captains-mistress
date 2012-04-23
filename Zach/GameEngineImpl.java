package Zach;

import mainPack.*;
import James.*;
import Joel.*;
import Josh.*;
import Mohammed.*;

public class  GameEngineImpl implements GameEngine{
	int playerToken;
	public void GameLoop(){

		boolean loopcondition = true;
		int numberPlayers = 0;
		int aiChoice = 0;

  		StateCheckImpl loopChecks = new StateCheckImpl();     // Calls all the information needed for running the game
		DisplayImpl display = new DisplayImpl();
		GameBoardImpl gameBoard = new GameBoardImpl();
		SmartAIImpl smart = new SmartAIImpl();
		DumbAI dumb = new DumbAI();
		UserInput player = new UserInput();
		
                numberPlayers = display.DrawMenu();
		aiChoice = display.AIChoice(); 

  		while (loopcondition){

			if (numberPlayers == 0) //User selects computer vs computer, which is 2 AI's
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
			else if (numberPlayers == 1) //User selects player vs computer, which is 1 AI and 1 user player
			{
                          if (aiChoice == 1) {            //Smart AI
							  playerOne = smart.Astar();
							  playerTwo = ; // user player?
                          }
                          else if (aiChoice == 2) {       //Dumb AI
							  playerOne = dumb.ColumnFill(); // user player
							  playerTwo = ; // user player
                          }
			}
			else if (numberPlayers == 2)//User selects player vs player, which is 2 user players
			{
				playerOne = ; // user player
				playerTwo = ; // user player
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

