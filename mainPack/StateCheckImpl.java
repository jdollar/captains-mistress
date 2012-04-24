package mainPack;

public class StateCheckImpl implements StateCheck{
	GameBoardImpl gameBoard;
	public StateCheckImpl(){
	}

	//second constructor used only for testing purposes.
	public StateCheckImpl(GameBoardImpl gameState){
		gameBoard = gameState;
	}

	public boolean checkVictory(GameBoardImpl gameState, int player){
		gameBoard = gameState;

		if(scoreDetermine(player) > 3)
		{
			return true;
		}
		return false;
	}

	public boolean checkDraw(GameBoardImpl gameState){
		gameBoard = gameState;
		int numOfInvalidMoves = 0;
		for(int x = 0; x < gameBoard.getNumColumns(); x++){
			if(!gameBoard.checkValid(x)){
				numOfInvalidMoves += 1;
			}
		}
		
		if(numOfInvalidMoves == gameBoard.getNumColumns()){
			return true;
		}
		
		return false;
	}

	public int scoreDetermine(int token){
		int lowestGridValue = 0;
		int maxValue = 0;
		int temp = 0;

		for(int x = 0; x < gameBoard.getNumColumns(); x++){
			for(int y = 0; y < gameBoard.getNumRows(); y++){
			lowestGridValue = y;
			//vertical
			if(lowestGridValue < 5){
				//maxValue += TokenCount(x, lowestGridValue, x, lowestGridValue + 1, token); //won't need
				temp += downCheck(x, lowestGridValue, token);
			}

			maxValue = compare(maxValue, temp++);
			temp = 0;

			//horizontal
			if(x >= 0){
				temp += rightCheck(x, lowestGridValue, token);
			}
			else if(x <= 6){
				temp += leftCheck(x, lowestGridValue, token);
			}

			maxValue = compare(maxValue, temp++);
			temp = 0;

			//left down right up diagonal
			if(x > 0 && lowestGridValue >= 0){  //x larger than 0 and on bottom row
				temp += leftDownCheck(x, lowestGridValue, token);
			}
			else if(x == 0 && lowestGridValue > 0){  //x is on left side and 0 or more row
				temp += rightUpCheck(x, lowestGridValue, token);
			}

			maxValue = compare(maxValue, temp++);
			temp = 0;

			//right down left up diagonal
			if(x < gameBoard.getNumColumns() && lowestGridValue == 0){  //x larger than 0 and on bottom row
				temp += rightUpCheck(x, lowestGridValue, token);
			}
			else if(x == 0 && lowestGridValue >= 0){  //x is on left side and 0 or more row
				temp += rightDownCheck(x, lowestGridValue, token);
			}	

			maxValue = compare(maxValue, temp++);
			temp = 0;
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

	public int downCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return downCheck(xValue, yValue + 1, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}

	public int upCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return upCheck(xValue, yValue - 1, player) + 1;
			}
		}
		else
			return 0;
		return 0;
	}

	public int leftCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return leftCheck(xValue - 1, yValue, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}

	public int rightCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return rightCheck(xValue + 1, yValue, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}

	public int rightUpCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return rightUpCheck(xValue + 1, yValue - 1, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}

	public int rightDownCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return rightDownCheck(xValue + 1, yValue + 1, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}

	public int leftUpCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return leftUpCheck(xValue - 1, yValue - 1, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}

	public int leftDownCheck(int xValue, int yValue, int player){
		if(xValue < gameBoard.getNumColumns() && xValue >= 0 && yValue < gameBoard.getNumRows() && yValue >= 0){
			if(gameBoard.getValue(yValue, xValue) == player){
				return leftDownCheck(xValue - 1, yValue + 1, player) + 1;
			}
		}
		else
			return 0;

		return 0;
	}
}
