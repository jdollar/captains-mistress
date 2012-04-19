package Mohammed;

import mainPack.DummyGameBoardImpl;

/**
 * This class is going to be a unit tester for the GeneralCobtrolsimpl class.
 * @author Mohammed
 */
public class GeneralControlsTester extends AbstractGeneralControls{

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
        
        //Make dummy moves on behalf of Player 1.
        for (int x = 0; x < 3; x++) {
            tester.inputToken(PLAYER.PLAYER_1, 0);
        }

        //Make dummy moves on behalf of Player 2.
        for (int x = 0; x < 3; x++) {
            tester.inputToken(PLAYER.PLAYER_2, 0);
        }

        //Test if two players play alternatively on same colmn,
        //Their tokens should be placed alternately in the column from bottom.
        for (int x = 0; x < 6; x++) {
            if (x % 2 == 0) {
                tester.inputToken(PLAYER.PLAYER_1, 0);
            } else {
                tester.inputToken(PLAYER.PLAYER_2, 0);
            }
        }

        //Test if two players play alternatively on same colmn,
        //Their tokens should be placed alternately in the column from bottom.
        for (int x = 0; x < 6; x++) {
            if (x % 2 == 0) {
                tester.inputToken(PLAYER.PLAYER_1, 1);
            } else {
                tester.inputToken(PLAYER.PLAYER_2, 1);
            }
        }
        int[][] gameBoardArray = tester.getGameBoardArray();
        //Print the gameBoard to see how it looks.
        P.p(gameBoardArray);
    }


    public String[] getLog() {
        return (String[]) logOfMoves.toArray();
    }
}
