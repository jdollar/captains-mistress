import java.util.*;

public class UserInput extends GeneralControlsImpl {
	private int PlayerMove;

	UserInput(DummyGameBoardImpl GameBoardPass) {
		super(GameBoardPass);
	}

	public int GetInput() {
		System.out.println("Please make a move");
		Scanner in = new Scanner(System.in);
		PlayerMove = in.nextInt();
		in.close();

		return PlayerMove;
	}
}