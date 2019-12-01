package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public final class Deflect extends Ability {
    private static final int DEFLECTION_BASE_DAMAGE = 35;
    private static final int DEFLECTION_LEVEL_MULTIPLIER = 2;

    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 1.4f;
    private static final float PYROMANCER_MODIFIER = 1.3f;
    private static final float WIZARD_MODIFIER = 0;
    private static final float DEFLECTION_LIMIT = 70f;


    public Deflect(final Hero hero) {
        super(hero);
    }

    @Override
    public float getDeflectionDamage(final Hero other, final float receivedRawDamage) {
        float percent = DEFLECTION_BASE_DAMAGE + this.level * DEFLECTION_LEVEL_MULTIPLIER;
        percent = Math.min(DEFLECTION_LIMIT, percent);
        return percent / Constants.PERCENT_BASE * receivedRawDamage;
    }

    @Override
    public float getDamage(final Hero hero) {
        return 0;
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
