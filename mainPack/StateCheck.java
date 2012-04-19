package mainPack;
interface StateCheck{
  boolean CheckVictory(GameBoardImpl gameboard);
  boolean CheckDraw(int[][] gameboard);
}
