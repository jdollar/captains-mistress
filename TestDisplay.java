import org.junit.*;
import static org.junit.Assert.*;

public class TestDisplay{
  @Test public void testdrawmenu(){
    Display display = new DisplayImpl();
    
    assertTrue(ReDrawGameBoard(log[], gameboard[][]), true);
    assertTrue(display.DrawMenu(), true);
    
    assertNotNull(ReDrawGameBoard(log[], gameboard[][]));
    assertNotNull(display.DrawMenu());
    
  }
}
