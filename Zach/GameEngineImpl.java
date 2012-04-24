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
		int[][] gameBoard;

  		StateCheckImpl loopChecks = new StateCheckImpl();     // Calls all the information needed for running the game
		DisplayImpl display = new DisplayImpl();
		GameBoardImpl gameBoardObject = new GameBoardImpl();

                numberPlayers = display.DrawMenu();
		aiChoice = display.AIChoice();
		gameBoardObject.emptyGameBoard();
		gameBoard = gameBoardObject.getGameBoard();
		display.ReDrawGameBoard(gameBoard);

                if (numberPlayers == 0){ //User selects computer vs computer, which is 2 AI's
                  if (aiChoice == 1) {             //Smart AI
                    //SmartAIImpl playerOne = new SmartAIImpl();
                    //SmartAIImpl playerTwo = new SmartAIImpl();
                  }
                  else if (aiChoice == 2) {        //Dumb AI
                    //DumbAI playerOne = new DumbAI();
                    //DumbAI playerTwo = new DumbAI();
                  }
                }
                else if (numberPlayers == 1){ //User selects player vs computer, which is 1 AI and 1 user player
                  if (aiChoice == 1) {            //Smart AI
                    //UserInput playerOne = new UserInput();
                    //SmartAIImpl playerTwo = new SmartAIImpl();
                  }
                  else if (aiChoice == 2) {       //Dumb AI
                    //UserInput playerOne = new UserInput();
                    //DumbAI playerTwo = new DumbAI();
                  }
                }
                else if (numberPlayers == 2){//User selects player vs player, which is 2 user players
                  //UserInput playerOne = new UserInput();
                  //UserInput playerTwo = new UserInput();
                }
        }
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

