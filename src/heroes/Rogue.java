/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package heroes;

import abilities.Ability;
import common.Constants;
import map.Map;

public class Rogue extends Hero {
    Rogue(int line, int column) {
        super(line, column, Constants.INITIAL_ROGUE_HP, Constants.BONUS_ROGUE_HP);
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.ROGUE + " " + Constants.DEAD;
        }
        return Constants.ROGUE + " " + level + " " + experiencePoints + " " + healthPoints + " " + line + " " + column;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column) == Constants.ROGUE_PREFERED_LAND) {
            return Constants.ROGUE_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }
}
