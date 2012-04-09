
public class SmartAITest extends AI{
	SmartAITest(int[][] GameBoardPass){
		super(GameBoardPass);
	}
	
	public int AStar(){
		NTree alphaTree = new NTree();
		alphaTree.createTree();
		return 0;
	}
	
	
}

class NTree{
	private int player = 0;
	private Node root = null;
	
	public int createTree(){
		NTree StateCheckTree = new NTree();
		StateCheckTree.setRoot(buildTree(new DummyGameBoardImpl(), 0, -1));
		
		return 0;
	}
	
	public Node buildTree(DummyGameBoardImpl board, int player, int column){
		int validMoves = 0;
		
		if(player != 0){
			board.setValue(board.GetLowestGridValue(column), column, player);
		}
		for(int x = 0; x < 6; x++){
			if(board.CheckValid(x)){
				validMoves++;
			}
		}
		Node n = new Node(board, validMoves);
		
		int count = 0;
		for(int i = 0; i < validMoves; i++){
			if(board.getValue(board.GetLowestGridValue(i), i) == 0){
				n.setChildAt(count++, buildTree(new DummyGameBoardImpl(board), changePlayer(player), i));
			}
		}
		return n;
	}
	
	public void setRoot(Node n){
		root = n;
	}
	private int changePlayer(int p){
		switch(p){
		case 0:
			player = 1;
			return 1;
		case 1:
			player = 2;
			return 2;
		case 2:
			player = 1;
			return 1;
		default:
			player = 0;
			return 0;
		}
	}
}

class Node{
	private DummyGameBoardImpl State;
	private int player;
	private int depth;
	private Node parent = null;
	private Node[] child;
	
	public Node(DummyGameBoardImpl gameState, int validMoves){
		this.State = new DummyGameBoardImpl(gameState);
		this.child = new Node[validMoves];
	}
	
	public int numChildren(){
		return child.length;
	}
	
	public void setChildAt(int i, Node n){
		this.child[i] = n;
	}
	
	public DummyGameBoardImpl getState(){
		return this.State;
	}
}