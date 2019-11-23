package heroes;

import common.Constants;

public class Pyromancer extends Hero {

    Pyromancer(int x, int y) {
        super(x, y, Constants.INITIAL_PYROMANCER_HP, Constants.BONUS_PYROMANCER_HP);
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "P" + " " + "dead";
        }
        return "P" + " " + level + " " + experiencePoints + " " + healthPoints + " " + x + " " + y;
    }
}
