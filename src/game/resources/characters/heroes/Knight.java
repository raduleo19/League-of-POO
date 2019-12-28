/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes;

import game.resources.characters.heroes.abilities.Ability;
import game.resources.characters.heroes.abilities.Execute;
import game.resources.characters.heroes.abilities.Slam;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Knight extends Hero {

    Knight(final int line, final int column) {
        super(line, column, Constants.INITIAL_KNIGHT_HP, Constants.BONUS_KNIGHT_HP);
        abilities.add(new Execute(this));
        abilities.add(new Slam(this));
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.KNIGHT + " " + Constants.DEAD;
        }
        return Constants.KNIGHT + " " + level + " " + experiencePoints + " " + healthPoints + " "
                + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.KNIGHT_PREFERRED_LAND) {
            return Constants.KNIGHT_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(final Ability ability) {
        return ability.getModifier(this);
    }
}
