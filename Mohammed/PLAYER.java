package Mohammed;

/**
 * This is an enumerated data type to represent the two players in the game.
 *
 * Instead of using the integer literals in the code, it is more readable to
 * use enumerated data type.
 * e.g
 * Instead of '1', it makes more sense to call it PLAYER.PLAYER_1.
 * Instead of '2', it makes more sense to call it PLAYER.PLAYER_2.
 *
 * @author Mohammed
 */
public enum PLAYER {

    EMPTY(0), //Indicates the position on the game board is empty
    PLAYER_1(1), //Indicates the position on the game board is occupied by Player 1,
    PLAYER_2(2);//Indicates the position on the game board is occupied by Player 2

    //Enumerated id of the player
    final int id;

    /**
     * Constructor
     * @param playerId
     */
    PLAYER(int playerId) {
        id = playerId;
    }

    /**
     * Returns the id of the player.
     * @return int
     */
    public int getId() {
        return id;
    }
}
