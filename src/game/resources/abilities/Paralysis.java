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

public final class Paralysis extends Ability {

    public Paralysis(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        float damage = Constants.PARALYSIS_DOT_BASE_DAMAGE
                + this.level * Constants.PARALYSIS_DOT_LEVEL_MULTIPLIER;
        damage *= this.hero.getLandModifier();
        damage *= other.requestRaceModifier(this);
        int time = Constants.PARALYSIS_STANDARD_DURATION;
        if (this.hero.getLandType() == Constants.ROGUE_PREFERRED_LAND) {
            time = Constants.PARALYSIS_CRITICAL_DURATION;
        }
        other.setOvertime(time, true, Math.round(damage));
        return Constants.PARALYSIS_DOT_BASE_DAMAGE
                + this.level * Constants.PARALYSIS_DOT_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.PARALYSIS_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.PARALYSIS_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.PARALYSIS_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.PARALYSIS_WIZARD_MODIFIER;
    }
}
