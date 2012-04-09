
public class DummyGameBoardImpl implements DummyGameBoard{
	private int[][] GameBoard;
	
	public DummyGameBoardImpl(DummyGameBoardImpl state){
		GameBoard = state.getGameBoard();
	}
	
	public DummyGameBoardImpl(){
		GameBoard = new int[6][7];
	}
	
	public int[][] getGameBoard(){
		return GameBoard;
	}
	
	public void setValue(int row, int column, int player){
		GameBoard[row][column] = player;
	}
	
	public boolean CheckValid(int columnNumber){
		if(GetLowestGridValue(columnNumber) == -1){
			return false;
		}
		else
			return true;
	}
	
	public int getValue(int row, int column){
		return GameBoard[row][column];
	}
	
	public int GetLowestGridValue(int columnNumber){
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
	
	public int[][] EmptyGameBoard() {
		//creates an empty game board and sends it back
		int[][] GameBoard = new int[6][7];
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 7; y++){
				GameBoard[x][y] = 0;
			}
		}
		return GameBoard;
	}

	public int[][] NColumnFilledGameBoard(int columnsToFill) {
		//fills up n columns based off parameters of alternative values
		int[][] GameBoard = new int[6][7];
		int count = 0;
		
		for(int x = 0; x < columnsToFill && x < 6; x++){
			count = x;
			for(int y = 0; y < 7; y++){
				if((count % 2) != 0){
					GameBoard[x][y] = 1;
				}
				else{
					GameBoard[x][y] = 2;
				}
			}
		}
		return GameBoard;
	}

	public int[][] FullGameBoardAlternating() {
		//fills board up with alternating values of 1 and 2
		int[][] GameBoard = new int[6][7];
		int count = 0;
		
		for(int x = 0; x < 6; x++){
			count = x;
			for(int y = 0; y < 7; y++){
				if((count % 2) != 0){
					GameBoard[x][y] = 1;
				}
				else{
					GameBoard[x][y] = 2;
				}
			}
		}
		return GameBoard;
	}

	public int[][] FirstColumnHalfGameBoard() {
		//fills half the first column of the gameboard with alternating values
		int[][] GameBoard = new int[6][7];
		int count = 0;
		
		for(int x = 0; x < 3; x++){
			if((count % 2) != 0){
				GameBoard[0][x] = 1;
			}
			else{
				GameBoard[0][x] = 2;
			}
		}
		return GameBoard;
	}

	public int[][] FullGameBoardOne() {
		//fills the whole gameboard with ones
		int[][] GameBoard = new int[6][7];
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 7; y++){
				GameBoard[x][y] = 1;
			}
		}
		return GameBoard;
	}

	public int[][] FullGameBoardTwo() {
		//fills the whole gameboard with twos
		int[][] GameBoard = new int[6][7];
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 7; y++){
				GameBoard[x][y] = 2;
			}
		}
		return GameBoard;
	}
}