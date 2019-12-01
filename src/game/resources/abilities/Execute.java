/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Execute extends Ability {

    public Execute(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        int healthPointsLimitPercent = Constants.EXECUTE_BASE_HP_LIMIT
                + this.level * Constants.EXECUTE_LEVEL_MULTIPLIER_HP_LIMIT;
        healthPointsLimitPercent = Math.min(healthPointsLimitPercent, Constants.EXECUTE_HP_LIMIT);
        if (other.getHealthPoints() / other.getMaxHealthPoints()
                < healthPointsLimitPercent / Constants.PERCENT_BASE) {
            int damage = other.getHealthPoints();
            other.receiveDamage(damage);
        }
        return Constants.EXECUTE_BASE_DAMAGE + this.level * Constants.EXECUTE_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.EXECUTE_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.EXECUTE_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.EXECUTE_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.EXECUTE_WIZARD_MODIFIER;
    }
}
