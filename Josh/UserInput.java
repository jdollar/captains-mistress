package Josh;

import Mohammed.AbstractGeneralControls;
import mainPack.*;

import java.util.*;

public class UserInput extends AbstractGeneralControls{
	private int playerMove;
	private int moveCheck = 0;

	public UserInput(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int GetInput(){
		System.out.println ("Please make a move");
		Scanner in = new Scanner(System.in);
		playerMove = in.nextInt();
		if(gameBoard.checkValid(playerMove) == true)
		{
			if (playerMove >= 1 || playerMove <=  7)
			{
				moveCheck = 1;
			}
		}

		while (moveCheck != 1)
		{
			System.out.println ("Not a valid move, please select a new move");
			playerMove = in.nextInt();
			if(gameBoard.checkValid(playerMove) == true)
			{
				if (playerMove >= 1 || playerMove <=  7)
				{
					moveCheck = 1;
				}
			}
		}
		in.close();

		return playerMove;
	}

	@Override
	public String[] getLog() {
		// TODO Auto-generated method stub
		return null;
	}
}