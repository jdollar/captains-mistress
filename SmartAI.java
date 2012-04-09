
public class SmartAI extends AI {
	//constant that determines how many steps ahead algorithm will check
	private final int STEPS = 4;
	private int[][] TestBoard = GameBoard;
	private int checkToken = 0;
	private int AIToken = 0;
	private int opponentToken = 0;
	private int tempScore = 0;
	private int alpha = 0;
	private int beta = 0;
	private TreeClass StateCheckTree = new TreeClass();


	SmartAI(int[][] GameBoardPass, int token){
		super(GameBoardPass);
		AIToken = token;
		if(AIToken == 2)
			opponentToken = 1;
		else
			opponentToken = 2;

		for(int x = 0; x < 6; x++){

		}

	}

	public int AStar(){
		//takes spot checks neighbor numbers adds it to "cost" for each space? or just one at a time?
		//after done check possible moves next to neighbors for player move
		//takes possible moves next to move for AI (etc
		//checks for winning possibilities goes for those
		//watches for player number getting to 3 or above
		//after so many steps stop return parent with highest value for alpha and beta
		
		//to do: highest values. Transveral back with the correct values for alpha and beta determining highest. (or lowest)
		int player = 0;
		for(int runs = 0; runs <= STEPS; runs++){
			
			if(runs % 2 == 0)
				player = 1;
			else
				player = 2;
			
			for(int columns = 0; columns < 6; columns++){
				
				if(CheckValid(columns)){
					if(columns == 0){
						TestBoard[columns][GetLowestGridValue(columns)] = player;
						StateCheckTree.insert(TestBoard, player, columns);
					}
					else{
						TestBoard[columns][GetLowestGridValue(columns)] = player;
						StateCheckTree.insert(TestBoard, player, columns);
					}
				}
			}
		}
		return 0;
	}

	private void ScoreDetermine(int token){
		int lowestGridValue = 0;
		int beginABValue = 0;

		if(token == AIToken)
			beginABValue = alpha;
		else
			beginABValue = beta;

		for(int x = 0; x < 7; x++){
			lowestGridValue = GetLowestGridValue(x);
			TokenCount(x, lowestGridValue, x, lowestGridValue + 1);
			TokenCount(x, lowestGridValue, x, lowestGridValue - 1);
			if(beginABValue < tempScore){
				beginABValue = tempScore;
			}
			tempScore = 0;

			//horizontal
			if(x > 0){
				TokenCount(x, lowestGridValue, x - 1, lowestGridValue);
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			else{
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			tempScore = 0;

			//left up down right diagonal
			if(x > 0 && lowestGridValue > 0){ //both larger than 0
				TokenCount(x, lowestGridValue, x - 1, lowestGridValue + 1);
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue - 1);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			else if(x > 0 && lowestGridValue == 0){  //x larger than 0 and on bottom row
				TokenCount(x, lowestGridValue, x - 1, lowestGridValue + 1);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			else if(x == 0 && lowestGridValue > 0){  //x is on left side and 0 or more row
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue - 1);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			tempScore = 0;

			//right up down left diagonal
			if(x > 0 && lowestGridValue > 0){ //both larger than 0
				TokenCount(x, lowestGridValue, x - 1, lowestGridValue - 1);
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue + 1);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			else if(x > 0 && lowestGridValue == 0){  //x larger than 0 and on bottom row
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue + 1);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			else if(x == 0 && lowestGridValue >= 0){  //x is on left side and 0 or more row
				TokenCount(x, lowestGridValue, x + 1, lowestGridValue + 1);
				if(beginABValue < tempScore){
					beginABValue = tempScore;
				}
			}
			tempScore = 0;

			if(token == AIToken){
				if(beginABValue > alpha){
					alpha = beginABValue;
				}
				ScoreDetermine(opponentToken);
			}
			else{
				if(beginABValue > beta){
					beta = beginABValue;
				}
			}
		}
		//		for(int count = 0; count < 2; count++){
		//			if(checkToken == 0){
		//				checkToken = 1;
		//			}
		//			else{
		//				checkToken = 2;
		//			}
		//			for(int x = 0; x < 6; x++){
		//				for(int y = 0; y < 5; y++){
		//					TokenCount(x, y, x, y + 1);
		//					tempScore = 0;
		//					TokenCount(x, y, x, y - 1);
		//					tempScore = 0;
		//					TokenCount(x, y, x + 1, y);
		//					tempScore = 0;
		//					TokenCount(x, y, x - 1, y);
		//					tempScore = 0;
		//					TokenCount(x, y, x + 1, y + 1);
		//					tempScore = 0;
		//					TokenCount(x, y, x - 1, y - 1);
		//					tempScore = 0;
		//					TokenCount(x, y, x + 1, y - 1);
		//					tempScore = 0;
		//					TokenCount(x, y, x - 1, y + 1);
		//					tempScore = 0;
		//				}
		//			}
		//		}
		//		
		//		checkToken = 0;
	}

	private void TokenCount(int xValue, int yValue, int x2Value, int y2Value){
		if(x2Value >= 0 && y2Value >= 0){
			if(GameBoard[xValue][yValue] == checkToken){
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

				//				if(AIToken == checkToken){
				//					if(tempScore >= 4){
				//						countBoard[xValue][yValue] = -5;
				//					}
				//					else{
				//						countBoard[xValue][yValue] = -tempScore;
				//					}
				//				}
				//				else{
				//					if(tempScore >= 4){
				//						countBoard[xValue][yValue] = 5;
				//					}
				//					else{
				//						countBoard[xValue][yValue] = tempScore;
				//					}
				//				}
			}
		}
	}
}

class TreeClass{
	TreeNode root = null;
	TreeNode currentNode = null;

	boolean isEmpty(){
		if(root == null){
			return true;
		}

		return false;
	}

	public TreeNode create(int[][] gameState, int player, int columnNumber){
		TreeNode node = new TreeNode();
		node.stateOfTest = gameState;
		node.player = player;
		node.parent = null;
		for(int x = 0; x < 7; x++){
			node.child[x] = null;
		}

		return node;
	}

	public TreeNode insert(int[][] gameState, int player, int columnNumber){
		root = insert(root, gameState, player, columnNumber);
		return root;
	}

	public TreeNode insert(TreeNode node, int[][] gameState, int player, int columnNumber){
		if(node == null){
			node = create(gameState, player, columnNumber);
		}
		else{
			node.child[columnNumber] = insert(node.child[columnNumber], gameState, player, columnNumber);
		}

		return node;
	}
}

class TreeNode{
	int[][] stateOfTest;
	int player;
	TreeNode parent;
	TreeNode[] child = new TreeNode[7];
}
