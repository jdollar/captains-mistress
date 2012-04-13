package Joel;

public interface SmartAI{
	public int AStar();
	public int ScoreDetermine(int token);
	public int TokenCount(int xValue, int yValue, int x2Value, int y2Value, int player);
}