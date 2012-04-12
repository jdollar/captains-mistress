import java.util.*;

public class UserInput extends GeneralControlsImpl {
	private int playerMove;
	private int moveCheck = 0;

	UserInput(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int GetInput(){
		System.out.println ("Please make a move");
		Scanner in = new Scanner(System.in);
		playerMove = in.nextInt();
		if(GameBoard.CheckValid(playerMove) == true)
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
			if(GameBoard.CheckValid(playerMove) == true)
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
}