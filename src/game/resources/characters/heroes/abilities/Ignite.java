/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.abilities;

import game.resources.characters.heroes.Hero;
import game.resources.characters.heroes.Knight;
import game.resources.characters.heroes.Pyromancer;
import game.resources.characters.heroes.Rogue;
import game.resources.characters.heroes.Wizard;
import game.resources.common.Constants;

public final class Ignite extends Ability {

    public Ignite(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero other) {
        float damage = Constants.IGNITE_DOT_BASE_DAMAGE
                + this.level * Constants.IGNITE_DOT_LEVEL_MULTIPLIER;
        damage *= this.hero.getLandModifier();
        damage *= other.requestRaceModifier(this);
        other.setOvertime(2, false, Math.round(damage));
        return Constants.IGNITE_BASE_DAMAGE + this.level * Constants.IGNITE_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return Constants.IGNITE_ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return Constants.IGNITE_KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return Constants.IGNITE_PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return Constants.IGNITE_WIZARD_MODIFIER;
    }
}
