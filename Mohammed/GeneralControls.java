package Mohammed;

/**
 * This is GeneralControls interface.
 * GeneralControlsImpl will implement this interface.
 * 
 * @author Mohammed
 */
public interface GeneralControls {

    /**
     * We have a gameboard with 6 X 7.
     * i.e. 6 rows and 7 columns.
     *
     * Hence the user must enter column number between 1 to 7.
     *
     * This method checks to see if the columnNumber is between 1 to 7.
     *
     * @param columnNumber
     * @return false if columnNumber is invalid.
     *          i.e. if columnNumber < 1 or columnNumber > 7.
     *          true if columnNumber is valid.
     */
    public boolean CheckValid(int columnNumber);

    /**
     * Places the token on the board.
     * @return false if columnNumber is full. true otherwise
     */
    public boolean inputToken(PLAYER playersToken, int columnNumber);

    /**
     * Returns log of the moves
     * @return
     */
    public String[] getLog();

    /**
     * Records the moves happening in the game.
     *
     * @param player
     * @param row
     * @param column
     * @return
     */
    public void logMove(PLAYER player, int row, int column);

    

}
