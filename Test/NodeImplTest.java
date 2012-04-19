package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Joel.*;

public class NodeImplTest {

	@Test
	public void testNodeImpl() {
		NodeImpl n = new NodeImpl(1, 1, 1);
		assertEquals("Result", 1, n.getState());
		assertEquals("Result", 1, n.getPlayer());
		assertEquals("Result", 1, n.numChildren());

		NodeImpl t = new NodeImpl(-1, 0, -1);
		assertEquals("Result", -1, t.getState());
		assertEquals("Result", -1, t.getPlayer());
		assertEquals("Result", 0, t.numChildren());

		NodeImpl q = new NodeImpl(0, 0, 0);
		assertEquals("Result", 0, q.getState());
		assertEquals("Result", 0, q.getPlayer());
		assertEquals("Result", 0, q.numChildren());
	}

	@Test
	public void testNumChildren() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetChildAt() {
		NodeImpl n = new NodeImpl(1, 1, 1);
		NodeImpl child = new NodeImpl(1, 2, 1);

		n.setChildAt(0, child);
		assertEquals("Result", child, n.getChild(0));
	}

	@Test
	public void testGetState() {
		NodeImpl t = new NodeImpl(1, 0, 0);
		assertEquals("Result", 1, t.getState());

		NodeImpl n = new NodeImpl(-1, 0, 0);
		assertEquals("Result", -1, n.getState());

		NodeImpl q = new NodeImpl(0, 0, 0);
		assertEquals("Result", 0, q.getState());
	}

	@Test
	public void testGetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChild() {
		fail("Not yet implemented");
	}

}
