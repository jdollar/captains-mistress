package Joel;

public interface Node{
	public int numChildren();
	public void setChildAt(int childPosition, Node currentNode);
	public int getState();
	public int getPlayer();
	public Node getChild(int childPosition);
}