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

public final class Drain extends Ability {

    public Drain(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        int percent = Constants.DRAIN_BASE_DAMAGE + this.level * Constants.DRAIN_LEVEL_MULTIPLIER;
        float baseHealthPoints = Math.min(Constants.DRAIN_HP_LIMIT * other.getMaxHealthPoints(),
                other.getHealthPoints());
        return percent * baseHealthPoints / Constants.PERCENT_BASE;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.DRAIN_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.DRAIN_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.DRAIN_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.DRAIN_WIZARD_MODIFIER;
    }
}
