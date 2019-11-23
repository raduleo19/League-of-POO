package heroes;

import common.Constants;

public class Rogue extends Hero {
    Rogue(int x, int y) {
        super(x, y, Constants.INITIAL_ROGUE_HP, Constants.BONUS_ROGUE_HP);
    }
}
