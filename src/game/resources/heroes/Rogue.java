/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.heroes;

import game.resources.abilities.Ability;
import game.resources.abilities.Backstab;
import game.resources.abilities.Paralysis;
import game.resources.common.Constants;
import game.resources.map.Map;

public class Rogue extends Hero {
    Rogue(int line, int column) {
        super(line, column, Constants.INITIAL_ROGUE_HP, Constants.BONUS_ROGUE_HP);
        abilities.add(new Backstab(this));
        abilities.add(new Paralysis(this));
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.ROGUE + " " + Constants.DEAD;
        }
        return Constants.ROGUE + " " + level + " " + experiencePoints + " " + healthPoints + " " + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column) == Constants.ROGUE_PREFERED_LAND) {
            return Constants.ROGUE_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(Ability ability) {
        return ability.getModifier(this);
    }
}
