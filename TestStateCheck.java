import org.junit.*;
import static org.junit.Assert.*;

public class TestStateCheck{
  @Test public void testdrawmenu(){
    StateCheck statecheck = new StateCheckImpl();
    
    assertTrue(ReDrawGameBoard(log[], gameboard[][]), true);
    assertTrue(display.DrawMenu(), true);
    
    assertNotNull(ReDrawGameBoard(log[], gameboard[][]));
    assertNotNull(display.DrawMenu());

  }
}