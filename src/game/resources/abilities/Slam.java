package game.resources.abilities;

import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Slam extends Ability {
    private static final int BASE_DAMAGE = 100;
    private static final int LEVEL_MULTIPLIER = 40;

    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    public Slam(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero hero) {
        hero.setOvertime(1, true, 0);
        return BASE_DAMAGE + this.level * LEVEL_MULTIPLIER;
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
