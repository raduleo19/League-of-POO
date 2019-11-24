/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package heroes;

import abilities.Ability;
import abilities.Fireblast;
import abilities.Ignite;
import common.Constants;

public class Pyromancer extends Hero {

    Pyromancer(int line, int column) {
        super(line, column, Constants.INITIAL_PYROMANCER_HP, Constants.BONUS_PYROMANCER_HP);
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.PYROMANCER + " " + Constants.DEAD;
        }
        return Constants.PYROMANCER + " " + level + " " + experiencePoints + " " + healthPoints + " " + line + " " + column;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }
}
