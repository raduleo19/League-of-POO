package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Backstab extends Ability {
    private static final int BASE_DAMAGE = 200;
    private static final int LEVEL_MULTIPLIER = 20;

    private static final float BONUS_MULTIPLIER = 1.5f;
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 0.9f;
    private static final float PYROMANCER_MODIFIER = 1.25f;
    private static final float WIZARD_MODIFIER = 1.25f;
    private static final int CRITICAL_ROUND = 3;

    private int numHits;

    public Backstab(final Hero hero) {
        super(hero);
        this.numHits = 0;
    }

    @Override
    public float getDamage(final Hero hero) {
        if (numHits % CRITICAL_ROUND == 0
                && this.hero.getLandType() == Constants.ROGUE_PREFERRED_LAND) {
            numHits++;
            return BONUS_MULTIPLIER * (BASE_DAMAGE + this.level * LEVEL_MULTIPLIER);
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
