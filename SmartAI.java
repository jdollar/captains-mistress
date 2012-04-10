
public interface SmartAI{
	public int AStar();
}

interface NTree{
	Node buildTree(DummyGameBoardImpl board, int player, int column);
	public int Transveral(Node currentNode);
}
