package Joel;
import mainPack.*;

public interface NTree{
	Node buildTree(DummyGameBoardImpl board, int player, int column);
	public int transversal(Node currentNode);
}