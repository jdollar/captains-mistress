package Mohammed;
/**
 * did not implemented folowing methods:
 *GetInput():int[] 
 *Because: I did not understand what does this mean. If this has to return last move, we can get that from the getLog() method.
 *ReturnMove() : int[][]
 *Because: public int[][] getGameBoardArray() does the same thing. And this method name sounds more appropriate than ReturnMove().
 */
import mainPack.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeneralControls implements GeneralControls {

    /**
     * History of the logOfMoves happening in the game
     */
    protected List<String> logOfMoves = new ArrayList<String>();

    /**
     * Game board object.
     */
    protected DummyGameBoardImpl gameBoard;

    /**
     * Constructor.
     *
     * Please note that we do not have parameterless constructor with a purpose.
     * @param dummyGameBoardImpl
     */
    protected AbstractGeneralControls(DummyGameBoardImpl dummyGameBoardImpl) {
        gameBoard = dummyGameBoardImpl;
    }

    /**
     * Returns instance of DummyGameBoardImpl field.
     * @return DummyGameBoardImpl
     */
    public DummyGameBoardImpl getGameBoard() {
        return gameBoard;
    }

    /**
     * Returns instance of int[][] in DummyGameBoardImpl field.
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
        if (columnNumber < 1 || columnNumber > gameBoard.getNumColumns()) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * This function returns lowest possible (vacant) position in a column on the board.
     * Please note that if the column is full, this function returns -1.
     * WARNING: The calling method must watch out for -1 returned.
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

        //lowestPosition = -1 indicates that the column is full.
        if (lowestPosition != -1 //if the column is not full
                && lowestPosition < gameBoard.getNumRows() //double check lowesePosition to avoid ArrrayIndexOutofBoundsException
                && columnNumber >= 0 //double check lowesePosition to avoid ArrrayIndexOutofBoundsException
                && columnNumber < gameBoard.getNumColumns()) {//double check lowesePosition to avoid ArrrayIndexOutofBoundsException

            //Place the player's token on the board
            gameBoard.setValue(lowestPosition, columnNumber, playersToken.getId());

            //log the move
            logMove(playersToken, lowestPosition, columnNumber);
            
            //successfully placed the token on the board. so return true.
            isTokenPlacedSuccessfully = true;
        }

        if (!isTokenPlacedSuccessfully) {
            P.p("Full");
        }
        return isTokenPlacedSuccessfully;
    }

    /**
     * Currently this function is unused.
     * TODO: Can be deleted later.
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

    /**
     * Records the logOfMoves happening in the game.
     *
     * @param player
     * @param row
     * @param column
     * @return
     */
    public void logMove(PLAYER player, int row, int column) {
        String d = " | ";
        String playerString = "PLAYER " + player.getId();
        String rowString = "ROW = " + row;
        String colString = "COLUMN = " + column;
        String logMsg = playerString + d + rowString + d + colString;
        logOfMoves.add(logMsg);
    }

    /**
     * This is a utility method to print the history of the logOfMoves.
     * @return String Formatted string of "logOfMoves" that can be directly printed on the terminal.
     * It will print as shownn below
     *
     * PLAYER 1 | ROW 0 | COLUMN 0
     * PLAYER 2 | ROW 1 | COLUMN 0
     * ...
     */
    public String getLogStringToPrint(){
        StringBuilder sb = new StringBuilder();
        for(String move : logOfMoves){
            sb.append(move);
            sb.append("\n");
        }
        return sb.toString();
    }
}
