package Joel;

import mainPack.DummyGameBoardImpl;

public class NTreeImpl implements NTree{
	private int alpha = -5;
	private int beta = -6;
	private int stepCount;
	private int columnToMove = 0;
	private int playerTurnCount = 0;
	private SmartAIImpl tests;

	public NTreeImpl(int STEP){
		stepCount = STEP;
	}
	
	public NodeImpl buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		if(player != -1){
			board.setValue(board.getLowestGridValue(column), column, player);
			playerTurnCount++;
		}

		tests = new SmartAIImpl(board);
		int[] validMoveArray = new int[7];
		int arrayIter = 0;
		for(int x = 0; x < board.getNumColumns(); x++){
			if(board.checkValid(x)){
				validMoves++;
				validMoveArray[arrayIter] = x;
				arrayIter++;
			}
		}

		NodeImpl n = new NodeImpl(tests.ScoreDetermine(player), validMoves, player);
		System.out.println(tests.ScoreDetermine(player));
		for(int i = 0; i < arrayIter; i++){
			if(playerTurnCount <= stepCount){
				n.setChildAt(i, buildTree(new DummyGameBoardImpl(board), changePlayer(player), validMoveArray[i]));
			}
		}

		playerTurnCount--;
		return n;
	}

	public int transversal(NodeImpl currentNode){
		int testValue = 0;

		for(int x = 0; x < currentNode.numChildren(); x++){
			transversal(currentNode.getChild(x));
			if(currentNode.getState() > alpha){
				columnToMove = x;
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
		return this.columnToMove;
	}
}
