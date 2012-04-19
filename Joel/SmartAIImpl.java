package Joel;

import Mohammed.*;
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
		NTreeImpl alphaTree = new NTreeImpl(STEPS);
		return alphaTree.transversal(alphaTree.buildTree(gameBoard, 0, -1));
	}
	
	public int ScoreDetermine(int token){
		int lowestGridValue = 0;
		int maxValue = 0;
		int temp = 0;

		for(int x = 0; x < gameBoard.getNumColumns(); x++){
			lowestGridValue = gameBoard.getLowestGridValue(x) + 1;
			//vertical
			if(lowestGridValue > 5){
				//maxValue += TokenCount(x, lowestGridValue, x, lowestGridValue + 1, token); //won't need
				temp += TokenCount(x, lowestGridValue, x, lowestGridValue + 1, token);
			}
			
			maxValue = compare(maxValue, temp);
			temp = 0;

			//horizontal
			if(x > 0){
				maxValue += TokenCount(x, lowestGridValue, x - 1, lowestGridValue, token);
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue, token);
			}
			else{
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue, token);
			}
			
			maxValue = compare(maxValue, temp);
			temp = 0;
			
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
			
			maxValue = compare(maxValue, temp);
			temp = 0;
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
			
			maxValue = compare(maxValue, temp);
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
	public int TokenCount(int xValue, int yValue, int x2Value, int y2Value, int player){
		int tempScore = 0;
		boolean multipleTokens = false;
		Direction heading = Direction.NONE;

		if(x2Value < gameBoard.getNumColumns() && x2Value >= 0 && y2Value < gameBoard.getNumRows() && y2Value >= 0
				&& xValue < gameBoard.getNumColumns() && yValue < gameBoard.getNumRows()){
			
			if(gameBoard.getValue(y2Value, x2Value) == player){
				System.out.println("False");
				if(yValue < y2Value && xValue  > x2Value){
					heading = Direction.LEFTUP;
					tempScore += TokenCount(x2Value, y2Value, x2Value - 1, y2Value + 2, player); //left up diagonal
				}
				if(yValue > y2Value && xValue < x2Value){
					heading = Direction.RIGHTDOWN;
					tempScore += TokenCount(x2Value, y2Value, x2Value + 1, y2Value + 2, player); //right down diagonal
				}
				if(xValue < x2Value && yValue < y2Value){
					heading = Direction.RIGHTUP;
					tempScore += TokenCount(x2Value, y2Value, x2Value + 1, y2Value - 2, player);  //right up diagonal
				}
				if(xValue > x2Value && yValue > y2Value){
					heading = Direction.LEFTDOWN;
					tempScore += TokenCount(x2Value, y2Value, x2Value - 1, y2Value + 2, player);  //left down diagonal
				}
				if(xValue == x2Value && yValue > y2Value){
					heading = Direction.UP;
					tempScore += TokenCount(x2Value, y2Value, x2Value, y2Value - 1, player);  //up
				}
				if(xValue == x2Value && yValue < y2Value){
					heading = Direction.DOWN;
					tempScore += TokenCount(x2Value, y2Value, x2Value, y2Value + 1, player);  //down
				}
				if(xValue < x2Value && yValue == y2Value){
					heading = Direction.RIGHT;
					tempScore += TokenCount(x2Value, y2Value, x2Value + 1, y2Value, player); //right
				}
				if(xValue > x2Value && yValue == y2Value){
					heading = Direction.LEFT;
					tempScore += TokenCount(x2Value, y2Value, x2Value - 1, y2Value, player); //left
				}
				
				//return tempScore + 1;
			}
		}
		
		/*if(y2Value < gameBoard.getNumRows() - 1 && y2Value >= 0 &&
				x2Value < gameBoard.getNumColumns() && x2Value >= 0){
			switch(heading){
			case UP:
				if(gameBoard.getValue(yValue - 1, xValue) == player){
					multipleTokens = true;
				}
				break;
			case DOWN:
				if(gameBoard.getValue(yValue + 1, xValue) == player){
					multipleTokens = true;
				}
				break; 
			case LEFT:
				if(gameBoard.getValue(yValue, xValue - 1) == player){
					multipleTokens = true;
				}
				break;
			case RIGHT:
				if(gameBoard.getValue(yValue, xValue + 1) == player){
					multipleTokens = true;
				}
				break;
			case RIGHTUP:
				if(gameBoard.getValue(yValue - 2, xValue + 1) == player){
					multipleTokens = true;
				}
				break;
			case RIGHTDOWN:
				if(gameBoard.getValue(yValue + 2, x2Value - 1) == player){
					multipleTokens = true;
				}
				break;
			case LEFTUP:
				if(gameBoard.getValue(yValue - 2, xValue - 1) == player){
					multipleTokens = true;
				}
				break;
			case LEFTDOWN:
				if(gameBoard.getValue(yValue + 2, xValue - 1) == player){
					multipleTokens = true;
				}
				break;
			}
			
			System.out.println(multipleTokens);
			if(multipleTokens){
				return tempScore + 1;
			}
		}*/
		if(gameBoard.getValue(yValue, xValue) == player){
			return tempScore + 1;
		}
		return tempScore;
	}
}