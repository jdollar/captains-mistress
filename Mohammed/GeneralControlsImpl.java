package Mohammed;

import mainPack.*;

public abstract class GeneralControlsImpl implements GeneralControls {

    protected DummyGameBoardImpl gameBoard;

    //constructor. Adds values from gameboard object to general control's copy
    protected GeneralControlsImpl(DummyGameBoardImpl dummyGameBoardImpl) {
        gameBoard = dummyGameBoardImpl;
    }

    /**
     * 
     * @return DummyGameBoardImpl
     */
    public DummyGameBoardImpl getGameBoard() {
        return gameBoard;
    }

    /**
     *
     * @return int[][]
     */
    public int[][] getGameBoardArray() {
        return gameBoard.getGameBoard();
    }

    /**
     * We have a gameboard with 6 X 7.
     * i.e. 6 rows and 7 columns.
     *
     * Hence the user must enter column number between 1 to 7.
     *
     * @param columnNumber
     * @return false if columnNumber is invalid.
     *          i.e. if columnNumber < 1 or columnNumber > 7.
     *          true if columnNumber is valid.
     */
    public boolean CheckValid(int columnNumber) {
        boolean isValid = true;
        if (columnNumber < 1 || columnNumber > 7) {
            isValid = false;
        }
        return isValid;
    }

    /**
     *
     * @param columnNumber
     * @return int between 0 and 6.
     *            -1 if the column is full.
     */
    public int getLowestGridValue(int columnNumber) {
        int lowestValue = -1; //Dummy value, that indicates no position is available in the column.
        for (int row = 0; row < gameBoard.getNumRows(); row++) {
            if (gameBoard.getValue(row, columnNumber) == PLAYER.EMPTY.getId()) {
                lowestValue = row;
                break;
            }
        }
        return lowestValue;
    }

    /**
     * Places the token on the board.
     * @return false if columnNumber is full. true otherwise
     */
    public boolean inputToken(PLAYER playersToken, int columnNumber) {
        boolean isTokenPlacedSuccessfully = false;

        int lowestPosition = getLowestGridValue(columnNumber);
        if (lowestPosition != -1 //if the column is not full
                && lowestPosition < gameBoard.getNumRows()
                && columnNumber >= 0
                && columnNumber < gameBoard.getNumColumns()) {
            gameBoard.setValue(lowestPosition, columnNumber, playersToken.getId());
            isTokenPlacedSuccessfully = true;
        }

         if(!isTokenPlacedSuccessfully){
                P.p("Full");
            }
        return isTokenPlacedSuccessfully;
    }

    /**
     *
     * @param columnNumber
     * @return true if all positions in columnNumber are occupied.
     * false otherwise
     */
    private boolean isColumnFull(int columnNumber) {
        boolean isColumnFull = false;
        int lowestGridValue = getLowestGridValue(columnNumber);
        if (lowestGridValue == -1) {
            isColumnFull = true;
        }
        return isColumnFull;
    }
}
