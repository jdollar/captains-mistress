package mainPack;

import Joel.DumbAI;
import Joel.SmartAIImpl;
import Josh.UserInput;

public class ControlsImpl implements Controls{
	private SmartAIImpl smartyAi;
	private DumbAI dummyAi;
	private UserInput player;
	private int playerTypes;
	private int numberPlayersChoice;
	private boolean player1Turn = true;

	public ControlsImpl(int numberPlayers, int aiChoice, GameBoardImpl gameBoard){
		numberPlayersChoice = numberPlayers;
		playerTypes = aiChoice;
		smartyAi = new SmartAIImpl(gameBoard);
		dummyAi = new DumbAI(gameBoard);
		player = new UserInput(gameBoard);
	}
	
	public int getInput(GameBoardImpl gameBoard){
		int columnToMove = 0;
		if (numberPlayersChoice == 0){ //User selects computer vs computer, which is 2 AI's
			if (playerTypes == 1) {             //Smart AI
				columnToMove = smartyAi.AStar();
			}
			else if (playerTypes == 2) {        //Dumb AI
				columnToMove = dummyAi.ColumnFill();
				//dummyAi.FPSControl();
			}
		}
		else if (numberPlayersChoice == 1){ //User selects player vs computer, which is 1 AI and 1 user player
			if (playerTypes == 1) {            //Smart AI
				if(player1Turn){
					columnToMove = player.GetInput(player1Turn);
					player1Turn = false;
				}
				else{
					columnToMove = smartyAi.AStar();
					player1Turn = true;
				}
			}
			else if (playerTypes == 2) {       //Dumb AI
				if(player1Turn){
					columnToMove = player.GetInput(player1Turn);
					player1Turn = false;
				}
				else{
					columnToMove = dummyAi.ColumnFill();
					//dummyAi.FPSControl();
					player1Turn = true;
				}
			}
		}
		else if (numberPlayersChoice == 2){//User selects player vs player, which is 2 user players
				columnToMove = player.GetInput(player1Turn);
				player1Turn = !player1Turn;
		}
		return columnToMove;
	}

}
