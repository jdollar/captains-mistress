
public class SmartAI extends AI {
	//constant that determines how many steps ahead algorithm will check
	private final int STEPS = 4;
	private int[][] countBoard = new int[6][7];
	private int checkToken = 0;
	private int AIToken = 0;
	private int tempScore = 0;
	private int alpha = 0;
	private int beta = 0;

	SmartAI(int[][] GameBoardPass, int token){
		super(GameBoardPass);
		AIToken = token;
		
	}

	public int AStar(){
		ScoreDetermine();

		for(int runs = 0; runs <= STEPS; runs++){
				
		}

		return 0;
	}

	private void ScoreDetermine(){
		for(int count = 0; count < 2; count++){
			if(checkToken == 0){
				checkToken = 1;
			}
			else{
				checkToken = 2;
			}
			for(int x = 0; x < 6; x++){
				for(int y = 0; y < 5; y++){
					TokenCount(x, y, x, y + 1);
					tempScore = 0;
					TokenCount(x, y, x, y - 1);
					tempScore = 0;
					TokenCount(x, y, x + 1, y);
					tempScore = 0;
					TokenCount(x, y, x - 1, y);
					tempScore = 0;
					TokenCount(x, y, x + 1, y + 1);
					tempScore = 0;
					TokenCount(x, y, x - 1, y - 1);
					tempScore = 0;
					TokenCount(x, y, x + 1, y - 1);
					tempScore = 0;
					TokenCount(x, y, x - 1, y + 1);
					tempScore = 0;
				}
			}
		}
		
		checkToken = 0;
	}

	private void TokenCount(int xValue, int yValue, int x2Value, int y2Value){
		if(GameBoard[xValue][yValue] == checkToken){
			if(GameBoard[xValue][yValue] == GameBoard[x2Value][y2Value]){
				if(yValue < y2Value && xValue  > x2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value - 1, y2Value + 1); //left up diagonal
				}
				if(yValue > y2Value && xValue < x2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value + 1, y2Value - 1); //right down diagonal
				}
				if(xValue < x2Value && yValue < y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value + 1, y2Value + 1);  //right up diagonal
				}
				if(xValue > x2Value && yValue > y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value - 1, y2Value - 1);  //left down diagonal
				}
				if(xValue == x2Value && yValue > y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value, y2Value + 1);  //up
				}
				if(xValue == x2Value && yValue < y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value, y2Value - 1);  //down
				}
				if(xValue < x2Value && yValue == y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value + 1, y2Value); //right
				}
				if(xValue > x2Value && yValue == y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value - 1, y2Value); //left
				}

				if(AIToken == checkToken){
					if(tempScore >= 4){
						countBoard[xValue][yValue] = -5;
					}
					else{
						countBoard[xValue][yValue] = -tempScore;
					}
				}
				else{
					if(tempScore >= 4){
						countBoard[xValue][yValue] = 5;
					}
					else{
						countBoard[xValue][yValue] = tempScore;
					}
				}
			}
		}
	}
}
