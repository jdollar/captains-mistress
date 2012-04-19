package Joel;
public class NodeImpl implements Node{
	private int state;
	private int player;
	private NodeImpl[] child;
	
	public NodeImpl(int alphaBetaValue, int validMoves, int playerNumber){
		this.state = alphaBetaValue;
		this.child = new NodeImpl[validMoves];
		this.player = playerNumber;
	}
	
	public int numChildren(){
		return child.length;
	}
	
	public void setChildAt(int i, NodeImpl n){
		this.child[i] = n;
	}
	
	public int getState(){
		return this.state;
	}
	//test
	public int getPlayer(){
		return this.player;
	}
	
	public NodeImpl getChild(int i){
		return this.child[i];
	}
	
	public void displayNode(){
		System.out.println("state: " + state);
		System.out.println("player: " + player);
	}
}
