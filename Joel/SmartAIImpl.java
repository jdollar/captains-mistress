package Joel;

import mainPack.*;

public class SmartAIImpl extends AI implements SmartAI{
	private final int STEPS = 4;
	
	public SmartAIImpl(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTreeImpl alphaTree = new NTreeImpl(STEPS);
		alphaTree.transversal(alphaTree.buildTree(gameBoard, 0, -1));
		return alphaTree.getColumnToMove();
	}
}