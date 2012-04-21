package mainPack;
abstract interface StateCheck{
	public boolean checkVictory(GameBoardImpl gameState, int player);
	public int scoreDetermine(int player);
	public boolean checkDraw(GameBoardImpl gameState);
	public int downCheck(int xValue, int yValue, int player);
	public int upCheck(int xValue, int yValue, int player);
	public int rightCheck(int xValue, int yValue, int player);
	public int leftCheck(int xValue, int yValue, int player);
	public int rightDownCheck(int xValue, int yValue, int player);
	public int leftDownCheck(int xValue, int yValue, int player);
	public int rightUpCheck(int xValue, int yValue, int player);
	public int leftUpCheck(int xValue, int yValue, int player);
}
