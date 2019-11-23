package heroes;

import common.Constants;

public class Wizard extends Hero {
    Wizard(int x, int y) {
        super(x, y, Constants.INITIAL_WIZARD_HP, Constants.BONUS_WIZARD_HP);
    }
}
