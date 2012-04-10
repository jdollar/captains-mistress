import java.io.*;
public class DummyGameBoardImpl implements DummyGameBoard{
	private int[][] GameBoard;
	
	public DummyGameBoardImpl(DummyGameBoardImpl state){
		GameBoard = state.getGameBoard();
	}
	
	public DummyGameBoardImpl(){
		GameBoard = new int[6][7];
		EmptyGameBoard();
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
		for(int x = 5; x >= 0; x--){
			if(GameBoard[columnNumber][x] == 0){
				if(lowestValue > x){
					lowestValue = x;
				}
			}
		}
		return lowestValue;
	}
	
	public void EmptyGameBoard() {
		//creates an empty game board and sends it back
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 7; y++){
				GameBoard[x][y] = 0;
			}
		}
	}

	public void NColumnFilledGameBoard(int columnsToFill) {
		//fills up n columns based off parameters of alternative values
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
	}

	public void FullGameBoardAlternating() {
		//fills board up with alternating values of 1 and 2
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
	}

	public void FirstColumnHalfGameBoard() {
		//fills half the first column of the gameboard with alternating values
		int count = 0;
		
		for(int x = 0; x < 3; x++){
			if((count % 2) != 0){
				GameBoard[0][x] = 1;
			}
			else{
				GameBoard[0][x] = 2;
			}
		}
	}

	public void FullGameBoardToken(int token) {
		//fills the whole gameboard with ones 
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 7; y++){
				GameBoard[x][y] = token;
			}
		}
	}
	
	public void ColumnNTokens(int place, int token, int column){
		for(int y = 0; y < place; y++){
			GameBoard[column][y] = token;
		}
	}
}