public abstract class  GeneralControlsImpl{
	protected DummyGameBoardImpl GameBoard;
	
	//constructor. Adds values from gameboard object to general control's copy
	GeneralControlsImpl(DummyGameBoardImpl GameBoardPass){
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
		for(int x = 5; x >= 0; x--){
			if(GameBoard.getValue(x, columnNumber) == 0){
				if(lowestValue > x){
					lowestValue = x;
				}
			}
		}
		return lowestValue;
	}
}
