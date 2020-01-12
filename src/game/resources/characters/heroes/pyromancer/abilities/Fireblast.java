/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.pyromancer.abilities;

import game.resources.characters.heroes.abstracts.Ability;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.common.Constants;

public final class Fireblast extends Ability {

    public Fireblast(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        return Constants.FIREBLAST_BASE_DAMAGE
                + this.hero.getLevel() * Constants.FIREBLAST_LEVEL_MULTIPLIER;
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
