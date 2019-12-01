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

public final class Backstab extends Ability {
    private int numHits;

    public Backstab(final Hero hero) {
        super(hero);
        this.numHits = 0;
    }

    @Override
    public float getDamage(final Hero other) {
        if (numHits++ % Constants.BACKSTAB_BONUS_ROUNDS == 0
                && this.hero.getLandType() == Constants.ROGUE_PREFERRED_LAND) {
            return Constants.BACKSTAB_BONUS_MULTIPLIER * (Constants.BACKSTAB_BASE_DAMAGE
                    + this.level * Constants.BACKSTAB_LEVEL_MULTIPLIER);
        }
        return Constants.BACKSTAB_BASE_DAMAGE + this.level * Constants.BACKSTAB_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.BACKSTAB_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.BACKSTAB_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.BACKSTAB_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.BACKSTAB_WIZARD_MODIFIER;
    }
}
