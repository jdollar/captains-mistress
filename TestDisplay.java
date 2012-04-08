import org.junit.*;
import static org.junit.Assert.*;

public class TestDisplay{
  @Test public void testdrawmenu(){
    Display display = new DisplayImpl();
    
    assertTrue(display.ReDrawGameBoard(log[], gameboard[][]), true);
    assertTrue(display.DrawMenu(), true);
    
    assertNotNull(display.ReDrawGameBoard(log[], gameboard[][]));
    assertNotNull(display.DrawMenu());
    
>>>>>>> 482728c1d9f165adc0e321a1cbf51c93186c63cc
  }
}
