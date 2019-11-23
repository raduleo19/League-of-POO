package heroes;

import common.Constants;

public class Knight extends Hero {

    Knight(int x, int y) {
        super(x, y, Constants.INITIAL_KNIGHT_HP, Constants.BONUS_KNIGHT_HP);
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "K" + " " + "dead";
        }
        return "K" + " " + level + " " + experiencePoints + " " + healthPoints + " " + x + " " + y;
    }
}
