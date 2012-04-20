package Joel;

import mainPack.*;

public class NodeImpl implements Node{
	private int state;
	private int player;
	private int depth;
	private NodeImpl[] child;
	
	public NodeImpl(int alphaBetaValue, int validMoves, int playerNumber, int depth){
		this.state = alphaBetaValue;
		this.child = new NodeImpl[validMoves];
		this.player = playerNumber;
		this.depth = depth;
	}
	
	public int numChildren(){
		return this.child.length;
	}
	
	public int getDepth(){
		return this.depth;
	}
	public void setChildAt(int i, NodeImpl n){
		this.child[i] = n;
	}
	
	public int getState(){
		return this.state;
	}

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
