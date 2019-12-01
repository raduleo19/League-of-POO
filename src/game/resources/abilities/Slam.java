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

public final class Slam extends Ability {

    public Slam(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        other.setOvertime(1, true, 0);
        return Constants.SLAM_BASE_DAMAGE + this.level * Constants.SLAM_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.SLAM_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.SLAM_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.SLAM_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.SLAM_WIZARD_MODIFIER;
    }
}
