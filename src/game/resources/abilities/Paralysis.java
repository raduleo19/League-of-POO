package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Paralysis extends Ability {
    private static final int DOT_BASE_DAMAGE = 40;
    private static final int DOT_LEVEL_MULTIPLIER = 10;

    private static final float ROGUE_MODIFIER = 0.9f;
    private static final float KNIGHT_MODIFIER = 0.8f;
    private static final float PYROMANCER_MODIFIER = 1.2f;
    private static final float WIZARD_MODIFIER = 1.25f;

    private static final int STANDARD_DURATION = 3;
    private static final int CRITICAL_DURATION = 3;

    public Paralysis(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero hero) {
        float damage = DOT_BASE_DAMAGE + this.level * DOT_LEVEL_MULTIPLIER;
        damage *= this.hero.getLandModifier();
        damage *= hero.requestRaceModifier(this);
        int time = STANDARD_DURATION;
        if (this.hero.getLandType() == Constants.ROGUE_PREFERRED_LAND) {
            time = CRITICAL_DURATION;
        }
        hero.setOvertime(time, true, Math.round(damage));
        return DOT_BASE_DAMAGE + this.level * DOT_LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(final Rogue rogue) {
        return ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(final Knight knight) {
        return KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(final Pyromancer pyromancer) {
        return PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(final Wizard wizard) {
        return WIZARD_MODIFIER;
    }
}
