
public class SmartAI extends AI {
	//constant that determines how many steps ahead algorithm will check
	private final int STEPS = 4;
	private int[][] CountBoard = new int[6][7];
	private int maxScore = 0;
	private int minScore = 0;
	private int checkToken = 0;
	private int tempScore = 0;
	
	SmartAI(int[][] GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		return 0;
	}
	
	private int ScoreDetermine(){
		int xValue = 0;
		int yValue = 0;
		
		checkToken = 1;
		TokenCount(xValue, yValue, xValue, yValue + 1);
		if(maxScore < tempScore){
			maxScore = tempScore;
		}
		tempScore = 0;
		
		checkToken = 2;
		TokenCount(xValue, yValue, xValue, yValue + 1);
		if(minScore < tempScore){
			minScore = tempScore;
		}
		return 0;
	}
	
	private void TokenCount(int xValue, int yValue, int x2Value, int y2Value){
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && yValue < y2Value && xValue  > x2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value - 1, y2Value + 1);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && yValue > y2Value && xValue < x2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value + 1, y2Value - 1);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && xValue < x2Value && yValue < y2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value + 1, y2Value + 1);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && xValue > x2Value && yValue > y2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value - 1, y2Value - 1);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && xValue == x2Value && yValue > y2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value, y2Value + 1);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && xValue == x2Value && yValue < y2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value, y2Value - 1);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && xValue < x2Value && yValue == y2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value + 1, y2Value);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
		if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value] && xValue > x2Value && yValue == y2Value){
			if(GameBoard[xValue][yValue] == AIToken){
				TokenCount(x2Value, y2Value, x2Value - 1, y2Value);
				tempScore++;
			}
			else{
				tempScoreMin++;
			}
		}
	}
}
