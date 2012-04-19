package mainPack;     
public interface GameBoard {
		public void emptyGameBoard();
		public void GameBoardImpl(GameBoardImpl state);
		public void GameBoardImpl();
		public int[][] getGameBoard();
		public int getNumRows();
		public int getNumColumns();
		public void setValue(int row, int column, int player);
		public boolean checkValid(int columnNumber);
		public int getValue(int row, int column);
		public int getLowestGridValue(int columnNumber);
		public void displayBoard();
}
