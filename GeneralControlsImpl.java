public abstract class  GeneralControlsImpl implements GeneralControls{
	protected int[][] GameBoard;
	
	//constructor. Adds values from gameboard object to general control's copy
	GeneralControlsImpl(int[][] GameBoardPass){
		GameBoard = GameBoardPass;
	}
	
	protected boolean CheckValid(int columnNumber){
		if(GetLowestGridValue(columnNumber) == -1){
			return false;
		}
		else
			return true;
	}
	protected int GetLowestGridValue(int columnNumber){
		int lowestValue = 0;
		for(int x = 5; x >= 0; x++){
			if(GameBoard[columnNumber][x] == 0){
				if(lowestValue > x){
					lowestValue = x;
				}
			}
		}
		return lowestValue;
	}
}

interface GeneralControls{
}