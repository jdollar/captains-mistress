
public class SmartAITest extends AI{
	private final int STEPS = 4;
	SmartAITest(int[][] GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTree alphaTree = new NTree(STEPS);
		DummyGameBoardImpl board = new DummyGameBoardImpl();
		alphaTree.buildTree(board, 0, -1);
		return 0;
	}
	
	public int ScoreDetermine(int token){
		int lowestGridValue = 0;
		int maxValue = 0;

		for(int x = 0; x < 7; x++){
			lowestGridValue = GetLowestGridValue(x);
			if(lowestGridValue > 0){
				maxValue += TokenCount(x, lowestGridValue, x, lowestGridValue + 1, token);
				maxValue += TokenCount(x, lowestGridValue, x, lowestGridValue - 1, token);
			}

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
				maxValue += TokenCount(x, lowestGridValue, x - 1, lowestGridValue + 1, token);
				maxValue += TokenCount(x, lowestGridValue, x + 1, lowestGridValue - 1, token);
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
	
	public int TokenCount(int xValue, int yValue, int x2Value, int y2Value, int player){
		int tempScore = 0;
		
		if(x2Value >= 0 && y2Value >= 0){
			if(GameBoard[xValue][yValue] == player){
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

class NTree{
	private int player = 0;
	private Node root = null;
	private int stepTop = 0;
	private SmartAITest tests;
	
	NTree(int numberOfSteps){
		stepTop = numberOfSteps;
	}
	
	public Node buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		
		if(player != 0){
			board.setValue(board.GetLowestGridValue(column), column, player);
		}
		for(int x = 0; x < 6; x++){
			if(board.CheckValid(x)){
				validMoves++;
			}
		}
		Node n = new Node(tests.ScoreDetermine(player), validMoves);
		
		int count = 0;
		for(int i = 0; i < validMoves; i++){
			if(board.getValue(board.GetLowestGridValue(i), i) == 0){
				n.setChildAt(count++, buildTree(new DummyGameBoardImpl(board), changePlayer(player), i));
			}
		}
		return n;
	}
	
	public void setRoot(Node n){
		root = n;
	}
	private int changePlayer(int p){
		switch(p){
		case 0:
			player = 1;
			return 1;
		case 1:
			player = 2;
			return 2;
		case 2:
			player = 1;
			return 1;
		default:
			player = 0;
			return 0;
		}
	}
}

class Node{
	private int state;
	private int player;
	private int depth;
	private Node parent = null;
	private Node[] child;
	
	public Node(int alphaBetaValue, int validMoves){
		this.state = alphaBetaValue;
		this.child = new Node[validMoves];
		this.depth = parent.depth + 1;
	}
	
	public int getDepth(){
		return depth;
	}
	public int numChildren(){
		return child.length;
	}
	
	public void setChildAt(int i, Node n){
		this.child[i] = n;
	}
	
	public int getState(){
		return this.state;
	}
}