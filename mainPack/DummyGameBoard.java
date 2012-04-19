package mainPack;

public interface DummyGameBoard {
		public void emptyGameBoard();
		public void nColumnFilledGameBoard(int columnsToFill);
		public void fullGameBoardAlternating();
		public void fullGameBoardToken(int token);
		public void firstColumnHalfGameBoard();
		public void columnNTokens(int place, int token, int column);
}
