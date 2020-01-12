/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.knight.abilities;

import game.resources.characters.heroes.abstracts.Ability;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.common.Constants;

public final class Slam extends Ability {

    public Slam(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        other.setOvertime(1, true, 0);
        return Constants.SLAM_BASE_DAMAGE + this.hero.getLevel() * Constants.SLAM_LEVEL_MULTIPLIER;
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
