package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Drain extends Ability {
    private static final int BASE_DAMAGE = 20;
    private static final int LEVEL_MULTIPLIER = 5;

    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final float HP_LIMIT = 0.3f;


    public Drain(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero hero) {
        int percent = BASE_DAMAGE + this.level * LEVEL_MULTIPLIER;
        float baseHealthPoints = Math.min(HP_LIMIT * hero.getMaxHealthPoints(),
                hero.getHealthPoints());
        return percent * baseHealthPoints / Constants.PERCENT_BASE;
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
