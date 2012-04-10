import java.io.*;
class NTreeImpl implements NTree{
	private int playerTurnCount = 0;
	private int stepTop = 0;
	private int alpha = -5;
	private int beta = -6;
	private SmartAIImpl tests;
	
	NTreeImpl(int numberOfSteps){
		stepTop = numberOfSteps;
	}
	
	public NodeImpl buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		tests = new SmartAIImpl(board);
		
		if(player != 0){
			if(!board.CheckValid(column)){
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
		
		NodeImpl n = new NodeImpl(tests.ScoreDetermine(player), validMoves, player);
		
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
