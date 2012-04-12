public class StateCheckImpl implements StateCheck{
    public boolean CheckVictory(int[][] gameboard){
    	return false;
    }
    public boolean CheckDraw(int[][] gameboard){
    	return false;
    }
}

interface StateCheck{
  boolean CheckVictory(int[][] gameboard);
  boolean CheckDraw(int[][] gameboard);
}
