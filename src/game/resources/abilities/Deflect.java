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

public final class Deflect extends Ability {

    public Deflect(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        return 0;
    }

    @Override
    public float getDeflectionDamage(final Hero other, final float receivedRawDamage) {
        float percent = Constants.DEFLECT_DEFLECTION_BASE_DAMAGE
                + this.level * Constants.DEFLECT_DEFLECTION_LEVEL_MULTIPLIER;
        percent = Math.min(Constants.DEFLECT_DEFLECTION_LIMIT, percent);
        return percent / Constants.PERCENT_BASE * receivedRawDamage;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.DEFLECT_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.DEFLECT_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.DEFLECT_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.DEFLECT_WIZARD_MODIFIER;
    }
}
