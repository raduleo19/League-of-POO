package heroes;

import abilities.Ability;
import abilities.Fireblast;
import abilities.Ignite;
import common.Constants;

public class Pyromancer extends Hero {

    Pyromancer(int x, int y) {
        super(x, y, Constants.INITIAL_PYROMANCER_HP, Constants.BONUS_PYROMANCER_HP);
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "P" + " " + "dead";
        }
        return "P" + " " + level + " " + experiencePoints + " " + healthPoints + " " + x + " " + y;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }
}
