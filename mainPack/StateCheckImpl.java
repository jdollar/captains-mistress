package mainPack;

public class StateCheckImpl implements StateCheck{
    public boolean CheckVictory(GameBoardImpl gameboard){
    	return false;
    }
    public boolean CheckDraw(int[][] gameboard){
    	return false;
    }
    
/*    private int downCheck(int xValue, int yValue, int player){
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
*/}
