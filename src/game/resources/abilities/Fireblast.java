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

public final class Fireblast extends Ability {

    public Fireblast(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        return Constants.FIREBLAST_BASE_DAMAGE + this.level * Constants.FIREBLAST_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.FIREBLAST_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.FIREBLAST_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.FIREBLAST_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.FIREBLAST_WIZARD_MODIFIER;
    }
}
