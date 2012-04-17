package Mohammed;

import mainPack.DummyGameBoardImpl;

/**
 * This class is going to be a unit tester for the GeneralCobtrolsimpl class.
 * @author Mohammed
 */
public class GeneralControlsTester extends GeneralControlsImpl {

    public GeneralControlsTester(DummyGameBoardImpl gb) {
        super(gb);
    }

    public static void main(String[] args) {
        P.p("test");
        test();
    }

    private static void test() {
        DummyGameBoardImpl testBoard = new DummyGameBoardImpl();
        GeneralControlsTester tester = new GeneralControlsTester(testBoard);
        for (int x = 0; x < 3; x++) {
            tester.inputToken(PLAYER.PLAYER_1, 0);
        }

        for (int x = 0; x < 3; x++) {
            tester.inputToken(PLAYER.PLAYER_2, 0);
        }
        for (int x = 0; x < 6; x++) {
            if (x % 2 == 0) {
                tester.inputToken(PLAYER.PLAYER_1, 0);
            } else {
                tester.inputToken(PLAYER.PLAYER_2, 0);
            }
        }

        for (int x = 0; x < 6; x++) {
            if (x % 2 == 0) {
                tester.inputToken(PLAYER.PLAYER_1, 1);
            } else {
                tester.inputToken(PLAYER.PLAYER_2, 1);
            }
        }
        int[][] gameBoardArray = tester.getGameBoardArray();
        P.p(gameBoardArray);
    }
}
