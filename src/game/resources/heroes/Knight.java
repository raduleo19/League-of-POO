/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.heroes;

import game.resources.abilities.Ability;
import game.resources.abilities.Execute;
import game.resources.abilities.Slam;
import game.resources.common.Constants;
import game.resources.map.Map;

public class Knight extends Hero {

    Knight(int line, int column) {
        super(line, column, Constants.INITIAL_KNIGHT_HP, Constants.BONUS_KNIGHT_HP);
        abilities.add(new Execute(this));
        abilities.add(new Slam(this));
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.KNIGHT + " " + Constants.DEAD;
        }
        return Constants.KNIGHT + " " + level + " " + experiencePoints + " " + healthPoints + " " + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column) == Constants.KNIGHT_PREFERED_LAND) {
            return Constants.KNIGHT_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(Ability ability) {
        return ability.getModifier(this);
    }
}
