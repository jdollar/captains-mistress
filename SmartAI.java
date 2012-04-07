
public class SmartAI extends AI {
	//constant that determines how many steps ahead algorithm will check
	private final int STEPS = 4;
	
	SmartAI(int[][] GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		return 0;
	}
	
	private int ScoreDetermine(int xValue, int yValue, int checkCondition){
		int score = 0;
		int maxScore = 0;
		int count = 1;
		int check = checkCondition;
		
		while(check == checkCondition){
			if(GameBoard[xValue][yValue] == GameBoard[xValue][yValue + count]){
				score++;
			}
		}
		
		return score;
	}
	
	private int TokenCount(){
		
		return 0;
	}
}
