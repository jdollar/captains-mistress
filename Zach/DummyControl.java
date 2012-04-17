public class DummyControl extends GeneralControlsImpl
{
	UserInput player = new UserInput(gameBoard);
	DumbAI dummy = new DumbAI(gameBoard);
	DummyControl(DummyGameBoardImpl gameBoardPass){
		super(gameBoardPass);
	}
	
	public int getInput()
	{
		return player.getInput();
	}
}