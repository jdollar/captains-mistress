package Mohammed;
//test
/**
 *
 * @author Mohammed
 */
public interface GeneralControls {

    enum PLAYER {

        EMPTY(0),
        PLAYER_1(1),
        PLAYER_2(2);
        final int id;

        PLAYER(int playerId) {
            id = playerId;
        }

        public int getId() {
            return id;
        }
    };
}
