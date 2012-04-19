package Joel;

import java.io.*;

import mainPack.DummyGameBoardImpl;

public class NTreeImpl implements NTree{
	private int alpha = -5;
	private int beta = -6;
	private int STEPS = 4;
	private int columnToMove = 0;
	private int playerTurnCount = 0;
	private SmartAIImpl tests;

	public NodeImpl buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		int stepTop = STEPS;
		if(player != -1){
			if(!board.checkValid(column)){
				return new NodeImpl(0, 0, -1);
			}
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

		if(playerTurnCount <= stepTop){
			int count = 0;
			for(int i = 0; i < validMoves; i++){
				if(board.getValue(board.getLowestGridValue(validMoveArray[i]), validMoveArray[i]) == 0){
					n.setChildAt(count++, buildTree(new DummyGameBoardImpl(board), changePlayer(player), validMoveArray[i]));
				}
			}
		}

		playerTurnCount--;
		return n;
	}

	public int transversal(NodeImpl currentNode){
		int checkValue = 0;
		//currentNode.displayNode();
		int player = currentNode.getPlayer();
		int columnEnd = -2;

		for(int x = 0; x < currentNode.numChildren(); x++){
			//currentNode.displayNode();
			currentNode.displayNode();
			if(currentNode.numChildren() > 0){
				checkValue = transversal(currentNode.getChild(x));
			}
			
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
}
