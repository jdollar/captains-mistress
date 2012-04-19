package Mohammed;

import junit.framework.TestCase;
import mainPack.DummyGameBoardImpl;

/**
 *
 * @author Mohammed
 */
public class JUnitTestForGeneralControlsImpl extends TestCase {

    GeneralControlsTestImpl gc1;
    GeneralControlsTestImpl gc2;
    DummyGameBoardImpl dbg1;
    DummyGameBoardImpl dbg2;

    public JUnitTestForGeneralControlsImpl(String str) {
        super(str);
    }

    @Override
    protected void setUp() {
        dbg1 = new DummyGameBoardImpl();
        dbg2 = new DummyGameBoardImpl();
        gc1 = new GeneralControlsTestImpl(dbg1);
        gc2 = new GeneralControlsTestImpl(dbg2);
    }

    public void testEquals(){
        boolean invalidCol_1 = gc1.CheckValid(-1);
        boolean invalidCol_2 = gc1.CheckValid(655436);
        boolean invalidCol_3 = gc1.CheckValid(8);
        boolean invalidCol_4 = gc1.CheckValid(9);
        boolean invalidCol_5 = gc1.CheckValid(655499999);

        assertTrue(!invalidCol_1);
        assertTrue(!invalidCol_2);
        assertTrue(!invalidCol_3);
        assertTrue(!invalidCol_4);
        assertTrue(!invalidCol_5);

        
    }

}
