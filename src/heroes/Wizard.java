/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package heroes;

import abilities.Ability;
import abilities.Deflect;
import abilities.Drain;
import common.Constants;

public class Wizard extends Hero {
    Wizard(int line, int column) {
        super(line, column, Constants.INITIAL_WIZARD_HP, Constants.BONUS_WIZARD_HP);
        abilities.add(new Drain());
        abilities.add(new Deflect());
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.WIZARD + " " + Constants.DEAD;
        }
        return Constants.WIZARD + " " + level + " " + experiencePoints + " " + healthPoints + " " + line + " " + column;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }
}
