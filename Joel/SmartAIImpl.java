
public class SmartAIImpl extends AI implements SmartAI{
	private final int STEPS = 4;
	SmartAIImpl(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTreeImpl alphaTree = new NTreeImpl(STEPS);
		return alphaTree.transversal(alphaTree.buildTree(GameBoard, 0, -1));
	}
	
	public int ScoreDetermine(int token){
		int lowestGridValue = 0;
		int maxValue = 0;
		int temp = 0;

		for(int x = 0; x < GameBoard.getNumColumns(); x++){
			lowestGridValue = GameBoard.GetLowestGridValue(x) - 1;
			System.out.println(lowestGridValue);
			//vertical
			if(lowestGridValue > 0){
				//maxValue += TokenCount(x, lowestGridValue, x, lowestGridValue + 1, token); //won't need
				temp += TokenCount(x, lowestGridValue, x, lowestGridValue - 1, token);
			}
			
			compare(maxValue, temp);
			temp = 0;

			//horizontal
			if(x > 0){
				maxValue += TokenCount(x, lowestGridValue, x - 1, lowestGridValue, token);
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue, token);
			}
			else{
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue, token);
			}

			//left up down right diagonal
			if(x > 0 && lowestGridValue > 0){ //both larger than 0
				maxValue += TokenCount(x, lowestGridValue - 1, x - 1, lowestGridValue + 1, token);
				maxValue += TokenCount(x, lowestGridValue - 1, x + 1, lowestGridValue - 1, token);
			}
			else if(x > 0 && lowestGridValue == 0){  //x larger than 0 and on bottom row
				maxValue += TokenCount(x, lowestGridValue, x - 1, lowestGridValue + 1, token);
			}
			else if(x == 0 && lowestGridValue > 0){  //x is on left side and 0 or more row
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue - 1, token);
			}

			//right up down left diagonal
			if(x > 0 && lowestGridValue > 0){ //both larger than 0
				maxValue += TokenCount(x, lowestGridValue, x - 1, lowestGridValue - 1, token);
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue + 1, token);
			}
			else if(x > 0 && lowestGridValue == 0){  //x larger than 0 and on bottom row
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue + 1, token);
			}
			else if(x == 0 && lowestGridValue >= 0){  //x is on left side and 0 or more row
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue + 1, token);
			}	
		}
		
		return maxValue;
	}
	
	private int compare(int x, int y){
		if(x < y){
			x = y;
		}
		return x;
	}
	public int TokenCount(int xValue, int yValue, int x2Value, int y2Value, int player){
		int tempScore = 0;
//		System.out.println("x2: " + x2Value);
//		System.out.println("x: " + xValue);
//		System.out.println("y2: " + y2Value);
//		System.out.println("y" + yValue);
//		System.out.println("COL:" + GameBoard.getNumColumns());
//		System.out.println("ROW: " + GameBoard.getNumRows());
		if(x2Value <= GameBoard.getNumRows() && y2Value <= GameBoard.getNumColumns() && x2Value >= 0 && y2Value >= 0){
			if(GameBoard.getValue(xValue, yValue) == player){
				if(yValue < y2Value && xValue  > x2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value - 1, y2Value + 1, player); //left up diagonal
				}
				if(yValue > y2Value && xValue < x2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value + 1, y2Value - 1, player); //right down diagonal
				}
				if(xValue < x2Value && yValue < y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value + 1, y2Value + 1, player);  //right up diagonal
				}
				if(xValue > x2Value && yValue > y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value - 1, y2Value - 1, player);  //left down diagonal
				}
				if(xValue == x2Value && yValue > y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value, y2Value + 1, player);  //up
				}
				if(xValue == x2Value && yValue < y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value, y2Value - 1, player);  //down
				}
				if(xValue < x2Value && yValue == y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value + 1, y2Value, player); //right
				}
				if(xValue > x2Value && yValue == y2Value){
					tempScore++;
					TokenCount(x2Value, y2Value, x2Value - 1, y2Value, player); //left
				}

			}
		}
		return tempScore;
	}
	
	
}