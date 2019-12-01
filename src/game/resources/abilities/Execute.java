package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Execute extends Ability {
    private static final int BASE_DAMAGE = 200;
    private static final int LEVEL_MULTIPLIER = 30;

    private static final int BASE_HP_LIMIT = 20;
    private static final int LEVEL_MULTIPLIER_HP_LIMIT = 1;

    private static final float ROGUE_MODIFIER = 1.15f;
    private static final float KNIGHT_MODIFIER = 1f;
    private static final float PYROMANCER_MODIFIER = 1.1f;
    private static final float WIZARD_MODIFIER = 0.8f;

    private static final int HP_LIMIT = 40;

    public Execute(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDamage(final Hero hero) {
        int healthPointsLimitPercent = BASE_HP_LIMIT + this.level * LEVEL_MULTIPLIER_HP_LIMIT;
        healthPointsLimitPercent = Math.min(healthPointsLimitPercent, HP_LIMIT);
        if (hero.getHealthPoints() / hero.getMaxHealthPoints()
                < healthPointsLimitPercent / Constants.PERCENT_BASE) {
            int damage = hero.getHealthPoints();
            hero.receiveDamage(damage);
        }
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
