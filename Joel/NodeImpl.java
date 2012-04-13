package Joel;
public class NodeImpl implements Node{
	private int state;
	private int player;
	private Node[] child;
	
	public NodeImpl(int alphaBetaValue, int validMoves, int playerNumber){
		this.state = alphaBetaValue;
		this.child = new Node[validMoves];
		this.player = playerNumber;
	}
	
	public int numChildren(){
		return child.length;
	}
	
	public void setChildAt(int i, Node n){
		this.child[i] = n;
	}
	
	public int getState(){
		return this.state;
	}
	
	public int getPlayer(){
		return this.player;
	}
	
	public Node getChild(int i){
		return this.child[i];
	}
}
