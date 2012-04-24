package Joel;
import mainPack.*;

public interface NTree{
	Node buildTree(GameBoardImpl board, int player, int column);
	public boolean transversal(NodeImpl currentNode);
}