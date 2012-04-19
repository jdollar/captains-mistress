package Joel;

import mainPack.*;

public class SmartAIImpl extends AI implements SmartAI{
	private final int STEPS = 4;
	enum Direction {
		UP, DOWN, LEFT, RIGHT, RIGHTUP, RIGHTDOWN, LEFTUP, LEFTDOWN, NONE
	}
	
	public SmartAIImpl(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTreeImpl alphaTree = new NTreeImpl();
		return alphaTree.transversal(alphaTree.buildTree(gameBoard, 0, -1));
	}
	
	public int ScoreDetermine(int token){
		int lowestGridValue = 0;
		int maxValue = 0;
		int temp = 0;

		for(int x = 0; x < gameBoard.getNumColumns(); x++){
			lowestGridValue = gameBoard.getLowestGridValue(x);
			//vertical
			if(lowestGridValue < 5){
				//maxValue += TokenCount(x, lowestGridValue, x, lowestGridValue + 1, token); //won't need
				temp += downCheck(x, lowestGridValue + 1, token);
			}
			
			maxValue = compare(maxValue, temp++);
			temp = 0;

			//horizontal
			if(x > 0){
				temp += leftCheck(x - 1, lowestGridValue, token);
				temp += rightCheck(x + 1, lowestGridValue, token);
			}
			else{
				temp += rightCheck(x + 1, lowestGridValue, token);
			}
			
			maxValue = compare(maxValue, temp++);
			temp = 0;
			
			//left down right up diagonal
			if(x > 0 && lowestGridValue < 5 && lowestGridValue > 0){ //both larger than 0
				temp += leftDownCheck(x - 1, lowestGridValue + 1, token);
				temp += rightUpCheck(x + 1, lowestGridValue - 1, token);
			}
			else if(x > 0 && lowestGridValue == 0){  //x larger than 0 and on bottom row
				maxValue += leftDownCheck(x - 1, lowestGridValue + 1, token);
			}
			else if(x == 0 && lowestGridValue > 0){  //x is on left side and 0 or more row
				maxValue += rightUpCheck(x + 1, lowestGridValue - 1, token);
			}
			
			maxValue = compare(maxValue, temp++);
			temp = 0;
			
			//right down left up diagonal
			if(x > 0 && lowestGridValue > 0 && lowestGridValue < 5){ //both larger than 0
				maxValue += leftUpCheck(x - 1, lowestGridValue - 1, token);
				maxValue += rightDownCheck(x + 1, lowestGridValue + 1, token);
			}
			else if(x < gameBoard.getNumColumns() && lowestGridValue == 0){  //x larger than 0 and on bottom row
				maxValue += rightUpCheck(x + 1, lowestGridValue + 1, token);
			}
			else if(x == 0 && lowestGridValue >= 0){  //x is on left side and 0 or more row
				maxValue += rightDownCheck(x + 1, lowestGridValue + 1, token);
			}	
			
			maxValue = compare(maxValue, temp++);
			temp = 0;
		}
		
		return maxValue;
	}
	
	private int compare(int x, int y){
		if(x < y){
			x = y;
		}
		return x;
	}
	
	private int downCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return downCheck(xValue, yValue + 1, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int upCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return upCheck(xValue, yValue - 1, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int leftCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return leftCheck(xValue - 1, yValue, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int rightCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return rightCheck(xValue + 1, yValue, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int rightUpCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return rightUpCheck(xValue + 1, yValue - 1, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int rightDownCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return rightDownCheck(xValue + 1, yValue + 1, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int leftUpCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return leftUpCheck(xValue - 1, yValue - 1, player) + 1;
			}
		}
	
		return 0;
	}
	
	private int leftDownCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return leftDownCheck(xValue - 1, yValue + 1, player) + 1;
			}
		}
	
		return 0;
	}
}