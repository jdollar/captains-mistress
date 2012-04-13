package mainPack;
import java.io.*;
public class DummyGameBoardImpl implements DummyGameBoard{
	private int[][] GameBoard;
	private int ROW = 6;
	private int COL = 7;
	
	public DummyGameBoardImpl(DummyGameBoardImpl state){
		GameBoard = state.getGameBoard();
	}
	
	public DummyGameBoardImpl(){
		GameBoard = new int[ROW][COL];
		EmptyGameBoard();
	}
	
	public int[][] getGameBoard(){
		return GameBoard;
	}
	
	public int getNumRows(){
		return ROW;
	}
	
	public int getNumColumns(){
		return COL;
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
		for(int x = ROW - 1; x >= 0; x--){
			if((x - 1) >= 0){
				if(GameBoard[x - 1][columnNumber] == 0){
					continue;
				}
				else{
					System.out.println("test: " + x);
					return x;
				}
			}
			
		}
		
		return lowestValue;
	}
	
	public void displayBoard(){
		for(int x = 0; x < ROW; x++){
			for(int y = 0; y < COL; y++){
				System.out.print(GameBoard[x][y]);
			}
			System.out.print("\n");
		}
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
			for(int y = 0; y < ROW; y++){
				if((count % 2) != 0){
					GameBoard[y][x] = 1;
				}
				else{
					GameBoard[y][x] = 2;
				}
			}
		}
	}

	public void FullGameBoardAlternating() {
		//fills board up with alternating values of 1 and 2
		int count = 0;
		
		for(int x = 0; x < COL; x++){
			count = x;
			for(int y = 0; y < ROW; y++){
				if((count % 2) != 0){
					GameBoard[y][x] = 1;
				}
				else{
					GameBoard[y][x] = 2;
				}
			}
		}
	}

	public void FirstColumnHalfGameBoard() {
		//fills half the first column of the gameboard with alternating values
		int count = 0;
		
		for(int x = 0; x < 3; x++){
			if((count % 2) != 0){
				GameBoard[x][0] = 1;
			}
			else{
				GameBoard[x][0] = 2;
			}
		}
	}

	public void FullGameBoardToken(int token) {
		//fills the whole gameboard with ones 
		for(int x = 0; x < COL; x++){
			for(int y = 0; y < ROW; y++){
				GameBoard[y][x] = token;
			}
		}
	}
	
	public void ColumnNTokens(int place, int token, int column){
		for(int y = 0; y < place; y++){
			GameBoard[GetLowestGridValue(column)][column] = token;
		}
	}
}