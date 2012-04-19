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

		for(int i = 0; i < arrayIter; i++){
			if(playerTurnCount <= stepCount){
				n.setChildAt(i, buildTree(new DummyGameBoardImpl(board), changePlayer(player), validMoveArray[i]));
			}
		}

		playerTurnCount--;
		return n;
	}

	public int transversal(NodeImpl currentNode){
		int checkValue = currentNode.getState();
		int player = 0;
		//currentNode.displayNode();

		for(int x = 0; x < currentNode.numChildren(); x++){
			//currentNode.displayNode();
			currentNode.displayNode();
			if(currentNode.numChildren() > 0){
				if(currentNode.getChild(x) != null){
					checkValue += transversal(currentNode.getChild(x));
				}
			}

			player = currentNode.getPlayer();

			if(player == 1){
				if(checkValue > alpha){
					alpha = checkValue;
					columnToMove = x;
				}
			}
			else if(player == 2){
				if(checkValue > beta){
					beta = checkValue;
					columnToMove = x;
				}
			}		
		}

		return checkValue;
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
