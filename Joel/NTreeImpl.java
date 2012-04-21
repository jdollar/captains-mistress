package Joel;

import mainPack.DummyGameBoardImpl;
import mainPack.StateCheckImpl;

public class NTreeImpl implements NTree{
	private int alpha = -5;
	private int beta = -6;
	private int stepCount;
	private int columnToMoveAlpha = 0;
	private int columnToMoveBeta = 0;
	private int playerTurnCount = 0;
	private int depth = 0;
	private int testDepth = 2147483647;
	private StateCheckImpl tests;

	public NTreeImpl(int step){
		stepCount = step;
	}

	public NodeImpl buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		int[] validMoveArray = new int[7]; 
		DummyGameBoardImpl tempBoard = new DummyGameBoardImpl(board);

		//checks if move possible on column and if not root node


		//creates an instance of the SmartAI for the score determination.
		tests = new StateCheckImpl(board);

		//as long as max steps haven't been reached check to see how many children
		//are possible and input moves possible into an array so when buildtree is
		//called it knows which column to use.
		if(depth <= stepCount){
			for(int x = 0; x < board.getNumColumns(); x++){
				if(board.checkValid(x)){
					validMoveArray[validMoves] = x;
					validMoves++;
				}
			}
		}
		//creates a node for the tree based on score of current position and how many different children
		//it can make. Also stores the current player and depth of the node in the tree
		NodeImpl n = new NodeImpl(tests.scoreDetermine(player), validMoves, player, depth);

		if(depth <= stepCount){	

			for(int i = 0; i < validMoves; i++){
				//creates a child with new gameboard created here and places it in child of current node
				depth++;
				board.displayBoard();
				System.out.println();
				board = tempBoard;
				if(board.checkValid(column)){
					if(player != -1){
						//if not the root node change the value of the current column
						board.setValue(board.getLowestGridValue(validMoveArray[i]), validMoveArray[i], player);
					}
				}
				n.setChildAt(i, buildTree(new DummyGameBoardImpl(board), changePlayer(player), validMoveArray[i]));
				//tempBoard = board;
				depth--;
			}
		}

		return n; //returns node once no more children can be derived or max steps reached
	}

	public int transversal(NodeImpl currentNode){
		for(int x = 0; x < currentNode.numChildren(); x++){
			transversal(currentNode.getChild(x));
			if(currentNode.getChild(x).getState() >= alpha &&
					currentNode.getChild(x).getPlayer() == 1 && currentNode.getChild(x).getDepth() < testDepth){
				testDepth = currentNode.getChild(x).getDepth();
				alpha = currentNode.getChild(x).getState();
				columnToMoveAlpha = x;
			}
			/*if(currentNode.numChildren() > 0){
				if(currentNode.getChild(x) != null){
					if(currentNode.getChild(x).getPlayer() == 1){
						if(currentNode.getChild(x).getState() > alpha){
							alpha = currentNode.getChild(x).getState();
							System.out.println("ALPHA");
							columnToMove = x;
						}
					}
					else if(currentNode.getChild(x).getPlayer() == 2){
						if(currentNode.getChild(x).getState() > beta){
							beta = currentNode.getChild(x).getState();
							System.out.println("BETA");
							columnToMove = x;
						}
					}
				}*/
		}



		//			player = currentNode.getPlayer();
		//
		//			if(player == 1){
		//				if(checkValue > alpha){
		//					alpha = checkValue;
		//					columnToMove = x;
		//				}
		//			}
		//			else if(player == 2){
		//				if(checkValue > beta){
		//					beta = checkValue;
		//					columnToMove = x;
		//				}
		//			}		
		return 0;
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
		return this.columnToMoveAlpha;
	}
}
