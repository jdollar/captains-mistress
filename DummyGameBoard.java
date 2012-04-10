
public interface DummyGameBoard {
		public void EmptyGameBoard();
		public void NColumnFilledGameBoard(int columnsToFill);
		public void FullGameBoardAlternating();
		public void FullGameBoardToken(int token);
		public void FirstColumnHalfGameBoard();
		public void ColumnNTokens(int place, int token, int column);
}
