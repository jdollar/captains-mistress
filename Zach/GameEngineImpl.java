package Zach;

import mainPack.*;
import James.*;
import Joel.*;
import Josh.*;
import Mohammed.*;

public class  GameEngineImpl implements GameEngine{
	int playerToken;
	
	public GameEngineImpl(){
		playerToken = 1;
	}
	
	public void GameLoop(){

		boolean draw = false;
		boolean victory = false;
		int numberPlayers = 0;
		int aiChoice = 0;
		int input = 0;

		StateCheckImpl loopChecks = new StateCheckImpl();     // Calls all the information needed for running the game
		DisplayImpl display = new DisplayImpl();
		GameBoardImpl gameBoardObject = new GameBoardImpl();

		numberPlayers = display.DrawMenu();
		if(numberPlayers != 2){
			aiChoice = display.AIChoice();
		}


		ControlsImpl inputObject = new ControlsImpl(numberPlayers, aiChoice, gameBoardObject); 

		while(!draw && !victory){
			display.ReDrawGameBoard(gameBoardObject.getGameBoard()); //Redraws game board
			input = inputObject.getInput(gameBoardObject);           //Gets user input
			gameBoardObject.setValue(gameBoardObject.getLowestGridValue(input), input, playerToken);
			if (loopChecks.checkVictory(gameBoardObject, playerToken))
			{
				victory = true;
				display.ReDrawGameBoard(gameBoardObject.getGameBoard());
				System.out.println("WIN FOO");
				// Calls displays output for victory
				break;
			}
			else if (loopChecks.checkDraw(gameBoardObject))
			{
				draw = true;
				// Calls displays output for draw
				break;
			}
			changePlayer(playerToken);
		}
	}
	
	private void changePlayer(int currentToken){
		switch(currentToken){
		case 1:
			playerToken = 2;
			break;
		case 2:
			playerToken = 1;
		}
	}
}



