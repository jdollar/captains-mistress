package Josh;

import Mohammed.AbstractGeneralControls;
import mainPack.*;

import java.util.*;

public class UserInput extends AbstractGeneralControls{
	private int playerMove;

	public UserInput(GameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int GetInput(boolean playerTurn){

		int moveCheck = 0;
		if(playerTurn){
			System.out.print("Player 1: ");
		}
		else{
			System.out.print("Player 2: ");
		}
		
		System.out.println ("Please make a move");
		playerMove = 0;
		Scanner in = new Scanner(System.in);
		playerMove = in.nextInt();
		playerMove--;
		if(gameBoard.checkValid(playerMove) == true)
		{
			if (playerMove >= 0 || playerMove < 7)
			{
				moveCheck = 1;
			}
		}

		while (moveCheck != 1)
		{
			System.out.println ("Not a valid move, please select a new move");
			playerMove = in.nextInt();
			playerMove--;
			if(gameBoard.checkValid(playerMove) == true)
			{
				if (playerMove >= 0 || playerMove <  7)
				{
					moveCheck = 1;
				}
			}
		}
		//in.close();

		return playerMove;
	}

	@Override
	public String[] getLog() {
		// TODO Auto-generated method stub
		return null;
	}
}