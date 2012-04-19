package Joel;

public interface Node{
	public int numChildren();
	public void setChildAt(int childPosition, NodeImpl currentNode);
	public int getState();
	public int getPlayer();
	public NodeImpl getChild(int childPosition);
}