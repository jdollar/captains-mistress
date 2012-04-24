package Joel;

import mainPack.GameBoardImpl;
import mainPack.StateCheckImpl;

public class NTreeImpl implements NTree{
	private int alpha = -5;
	private int beta = -6;
	private int stepCount;
	private boolean alphaTrue = false;
	private boolean betaTrue = false;
	private int columnToMove = 0;
	private int columnToMoveAlpha = -1;
	private int columnToMoveBeta = -1;
	private int testDepthAlpha = 2147483647;
	private int testDepthBeta = 2147483647;
	private int depth = 0;
	private StateCheckImpl tests;

	public NTreeImpl(int step){
		stepCount = step;
	}

	public NodeImpl buildTree(GameBoardImpl board, int player, int column){
		//variable declaration
		int validMoves = 0;
		int[] validMoveArray = new int[7]; 

		/*creates a new instance of the board class to hold this node as a 
		 *parent gameBoard reference for the children so they should
		 *restart their states with the parent gameBoard then explore
		 *all possible choices*/
		//DummyGameBoardImpl tempBoard = new DummyGameBoardImpl(board.getGameBoard());

		//checks if move possible on column and if not root node
		if(board.checkValid(column)){
			if(player != -1){
				//if not the root node change the value of the current column
				board.setValue(board.getLowestGridValue(column), column, player);
			}
		}

		//creates an instance of the StateChecker for the score determination.
		tests = new StateCheckImpl(board);
		depth++;
		/*as long as max steps haven't been reached check to see how many children
		 *are possible and input moves possible into an array so when buildtree is
		 *called it knows which column to use.*/
		if(depth <= stepCount){
			for(int x = 0; x < board.getNumColumns(); x++){
				if(board.checkValid(x)){
					validMoveArray[validMoves] = x;
					validMoves++;
				}
			}
		}
		/*creates a node for the tree based on score of current position and how many different children
		 *it can make. Also stores the current player and depth of the node in the tree*/
		NodeImpl n = new NodeImpl(tests.scoreDetermine(player), validMoves, player, depth, column);

		if(depth <= stepCount){	

			for(int i = 0; i < validMoves; i++){
				//creates a child with new gameboard created here and places it in child of current node


				/*done for testing. Getting weird errors with array not populating right
				 *Placed board set value inside this loop so that board is explicitly
				 *(via assignment statement below) getting reinitialized as original
				 *board value then assigned one by one.*/
				//board =  new DummyGameBoardImpl(tempBoard.getGameBoard());


				/*should create a child with one of the valid moves recursively running this method
				 *again until depth has been reached then go out one layer and do the next child
				 *of that node until we get all children of root's first 7 children for stepCount
				 *layers*/
				n.setChildAt(i, buildTree(new GameBoardImpl(board), changePlayer(player), validMoveArray[i]));
				board.setValue(board.getLowestGridValue(validMoveArray[i]), validMoveArray[i], 0);

			}
		}
		//board.setValue(board.getLowestGridValue(column) + 1, column, 0);
		depth--;
		return n; //returns node once no more children can be derived or max steps reached
	}

	public int getAlpha(){
		return alpha;
	}

	public boolean transversal(NodeImpl currentNode){
		boolean choice = false;
		boolean betaChange = false;
		boolean alphaChange = false;
		boolean testForBiggestValue = false;
		for(int x = 0; x <= currentNode.numChildren(); x++){
			if(currentNode.numChildren() > 0 && x < currentNode.numChildren()){
				transversal(currentNode.getChild(x));
				if(currentNode.getPlayer() == 1 && alphaTrue ){
					columnToMoveAlpha = currentNode.getColumn();
				}
				else if(currentNode.getPlayer() == 2 && betaTrue){
					columnToMoveBeta = currentNode.getColumn();
				}
			}

			if((currentNode.getState() > alpha &&
					currentNode.getPlayer() == 1) || (currentNode.getState() == alpha &&
					alpha <= 4 && currentNode.getPlayer() == 1 && currentNode.getDepth() < testDepthAlpha)){
				testDepthAlpha = currentNode.getDepth();
				alpha = currentNode.getState();
				columnToMoveAlpha = currentNode.getColumn();
				alphaChange = true;
			}
			else if((currentNode.getState() > beta &&
					currentNode.getPlayer() == 2) || (currentNode.getState() == beta &&
					beta <= 4 && currentNode.getPlayer() == 2 && currentNode.getDepth() < testDepthBeta)){
				testDepthBeta = currentNode.getDepth();
				beta = currentNode.getState();
				columnToMoveBeta = currentNode.getColumn();
				betaChange = true;
			}
		}
		
		if ((beta > alpha && beta >= 3) && betaChange){
			columnToMove = columnToMoveBeta;
			betaTrue = true;
			alphaTrue = false;
		}
		else if (((beta < alpha || alpha == beta) && beta < 3) && alphaChange){
			columnToMove = columnToMoveAlpha;
			alphaTrue = true;
			betaTrue = false;
		}

		return choice;
	}

	private int changePlayer(int p){
		switch(p){
		case -1:
			return 1;
		case 1:
			return 2;
		case 2:
			return 1;
		default:
			return 0;
		}
	}

	public int getColumnToMove(){
		return this.columnToMove;
	}
}
