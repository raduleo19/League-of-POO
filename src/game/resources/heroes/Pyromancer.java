/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.heroes;

import game.resources.abilities.Ability;
import game.resources.abilities.Fireblast;
import game.resources.abilities.Ignite;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Pyromancer extends Hero {

    Pyromancer(final int line, final int column) {
        super(line, column, Constants.INITIAL_PYROMANCER_HP, Constants.BONUS_PYROMANCER_HP);
        abilities.add(new Fireblast(this));
        abilities.add(new Ignite(this));
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.PYROMANCER + " " + Constants.DEAD;
        }
        return Constants.PYROMANCER + " " + level + " " + experiencePoints + " " + healthPoints
                + " " + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.PYROMANCER_PREFERRED_LAND) {
            return Constants.PYROMANCER_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(final Ability ability) {
        return ability.getModifier(this);
    }
}
