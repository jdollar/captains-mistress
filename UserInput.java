import java.util.*;

public class UserInput extends GeneralControlsImpl {
	private int PlayerMove;
	public int GetInput(){
		System.out.println ("Please make a move");
		PlayerMove = System.in;

		return PlayerMove;
	}
}