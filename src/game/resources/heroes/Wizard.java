/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.heroes;

import game.resources.abilities.Ability;
import game.resources.abilities.Deflect;
import game.resources.abilities.Drain;
import game.resources.common.Constants;
import game.resources.map.Map;

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
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column) == Constants.WIZARD_PREFERED_LAND) {
            return Constants.WIZARD_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(Ability ability) {
        return ability.getModifier(this);
    }
}