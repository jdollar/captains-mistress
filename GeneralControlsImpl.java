public abstract class  GeneralControlsImpl{
	protected int[][] GameBoard;
	
	//constructor. Adds values from gameboard object to general control's copy
	GeneralControlsImpl(int[][] GameBoardPass){
		GameBoard = GameBoardPass;
	}
}

interface GeneralControls{
}