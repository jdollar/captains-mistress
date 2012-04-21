package Joel;

import mainPack.*;

public class SmartAIImpl extends AI implements SmartAI{
	private final int STEPS = 4;
	enum Direction {
		UP, DOWN, LEFT, RIGHT, RIGHTUP, RIGHTDOWN, LEFTUP, LEFTDOWN, NONE
	}
	
	public SmartAIImpl(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTreeImpl alphaTree = new NTreeImpl(STEPS);
		return alphaTree.transversal(alphaTree.buildTree(gameBoard, 0, -1));
	}
}