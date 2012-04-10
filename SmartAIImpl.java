
public class SmartAIImpl extends AI implements SmartAI{
	private final int STEPS = 4;
	SmartAIImpl(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTreeImpl alphaTree = new NTreeImpl(STEPS);
		DummyGameBoardImpl board = new DummyGameBoardImpl();
		return alphaTree.Transversal(alphaTree.buildTree(board, 0, -1));
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

class NTreeImpl implements NTree{
	private int playerTurnCount = 0;
	private int stepTop = 0;
	private int alpha = -5;
	private int beta = -6;
	private SmartAIImpl tests;
	
	NTreeImpl(int numberOfSteps){
		stepTop = numberOfSteps;
	}
	
	public Node buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		
		if(player != 0){
			if(board.CheckValid(column)){
				return new NodeImpl(-1, -1, -1);
			}
			board.setValue(board.GetLowestGridValue(column), column, player);
			playerTurnCount++;
		}
		
		for(int x = 0; x < 6; x++){
			if(board.CheckValid(x)){
				validMoves++;
			}
		}
		
		Node n = new NodeImpl(tests.ScoreDetermine(player), validMoves, player);
		
		if(playerTurnCount >= stepTop){
			int count = 0;
			for(int i = 0; i < validMoves; i++){
				if(board.getValue(board.GetLowestGridValue(i), i) == 0){
					n.setChildAt(count++, buildTree(new DummyGameBoardImpl(board), changePlayer(player), i));
				}
			}
		}
		
		playerTurnCount--;
		return n;
	}
	
	public int Transversal(Node currentNode){
		int checkValue = 0;
		int player = currentNode.getPlayer();
		int columnEnd = -1;
		
		for(int x = 0; x < currentNode.numChildren(); x++){
			if(currentNode.getChild(x) != null){
				checkValue = Transversal(currentNode.getChild(x));
				if(player == 1){
					if(checkValue > alpha){
						alpha = checkValue;
						columnEnd = x;
					}
				}
				else if(player == 2){
					if(checkValue > beta){
						beta = checkValue;
						columnEnd = x;
					}
				}
			}
		}
		return columnEnd;
	}
	
	private int changePlayer(int p){
		switch(p){
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 1;
		default:
			return 0;
		}
	}
}

class NodeImpl implements Node{
	private int state;
	private int player;
	private Node[] child;
	
	public NodeImpl(int alphaBetaValue, int validMoves, int playerNumber){
		this.state = alphaBetaValue;
		this.child = new Node[validMoves];
		this.player = playerNumber;
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
	
	public int getPlayer(){
		return this.player;
	}
	
	public Node getChild(int i){
		return this.child[i];
	}
}

interface Node{
	public int numChildren();
	public void setChildAt(int childPosition, Node currentNode);
	public int getState();
	public int getPlayer();
	public Node getChild(int childPosition);
}

interface NTree{
	Node buildTree(DummyGameBoardImpl board, int player, int column);
	public int Transversal(Node currentNode);
}