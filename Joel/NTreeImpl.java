package Joel;

import java.io.*;

import mainPack.DummyGameBoardImpl;

public class NTreeImpl implements NTree{
	private int playerTurnCount = 0;
	private int stepTop = 0;
	private int alpha = -5;
	private int beta = -6;
	private SmartAIImpl tests;

	public NTreeImpl(int numberOfSteps){
		stepTop = numberOfSteps;
	}

	public NodeImpl buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		
		if(player != 0){
			if(!board.checkValid(column)){
				return new NodeImpl(0, 0, -1);
			}
			board.setValue(board.getLowestGridValue(column), column, player);
			playerTurnCount++;
		}
		
		tests = new SmartAIImpl(board);

		for(int x = 0; x < 6; x++){
			if(board.checkValid(x)){
				validMoves++;
			}
		}

		NodeImpl n = new NodeImpl(tests.ScoreDetermine(player), validMoves, player);

		if(playerTurnCount <= stepTop){
			int count = 0;
			for(int i = 0; i < validMoves; i++){
				if(board.getValue(board.getLowestGridValue(i), i) == 0){
					n.setChildAt(count++, buildTree(new DummyGameBoardImpl(board), changePlayer(player), i));
				}
			}
		}

		playerTurnCount--;
		return n;
	}

	public int transversal(Node currentNode){
		int checkValue = 0;
		int player = currentNode.getPlayer();
		int columnEnd = -2;

		for(int x = 0; x < currentNode.numChildren(); x++){
			//System.out.println(currentNode.getPlayer());
			if(currentNode.getChild(x) != null){
				checkValue = transversal(currentNode.getChild(x));
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