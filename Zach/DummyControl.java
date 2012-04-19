package Zach;

import Josh.UserInput;
import Mohammed.AbstractGeneralControls;
import Joel.DumbAI;
import mainPack.*;

public class DummyControl extends AbstractGeneralControls
{
	UserInput player = new UserInput(gameBoard);
	DumbAI dummy = new DumbAI(gameBoard);
	DummyControl(DummyGameBoardImpl gameBoardPass){
		super(gameBoardPass);
	}
	
	public int getInput()
	{
		return player.GetInput();
	}

	@Override
	public String[] getLog() {
		// TODO Auto-generated method stub
		return null;
	}
}