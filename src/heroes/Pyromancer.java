/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package heroes;

import abilities.Fireblast;
import abilities.Ignite;
import common.Constants;
import map.Map;

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
    void accept(Hero hero) {
        hero.giveDamage(this);
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column) == Constants.PYROMANCER_PREFERED_LAND) {
            return Constants.PYROMANCER_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }
}
