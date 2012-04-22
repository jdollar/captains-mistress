package Joel;
import mainPack.*;

public interface NTree{
	Node buildTree(DummyGameBoardImpl board, int player, int column);
	public boolean transversal(NodeImpl currentNode);
}