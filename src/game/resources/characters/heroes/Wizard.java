/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes;

import game.resources.characters.heroes.abilities.Ability;
import game.resources.characters.heroes.abilities.Deflect;
import game.resources.characters.heroes.abilities.Drain;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Wizard extends Hero {
    Wizard(final int line, final int column) {
        super(line, column, Constants.INITIAL_WIZARD_HP, Constants.BONUS_WIZARD_HP);
        abilities.add(new Drain(this));
        abilities.add(new Deflect(this));
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.WIZARD + " " + Constants.DEAD;
        }
        return Constants.WIZARD + " " + level + " " + experiencePoints + " " + healthPoints + " "
                + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.WIZARD_PREFERRED_LAND) {
            return Constants.WIZARD_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(final Ability ability) {
        return ability.getModifier(this);
    }
}
