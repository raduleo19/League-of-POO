package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.*;

public class Backstab extends Ability {
    private static final int BASE_DAMAGE = 200;
    private static final int LEVEL_MULTIPLIER = 20;

    private static final float BONUS_MULTIPLIER = 1.5f;
    
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 0.9f;
    private static final float PYROMANCER_MODIFIER = 1.25f;
    private static final float WIZARD_MODIFIER = 1.25f;

    private int numHits;

    public Backstab(Hero hero) {
        super(hero);
        this.numHits = 0;
    }

    @Override
    public void setOvertime(Hero other) {
    }

    @Override
    public float getDeflectionDamage(Hero other, int receivedRawDamage) {
        return 0;
    }

    @Override
    public float getDamage(Hero hero) {
        setOvertime(hero);
        if (numHits % 6 == 0 && this.hero.getLandType() == Constants.ROGUE_PREFERED_LAND) {
            return BONUS_MULTIPLIER * (BASE_DAMAGE + this.level * LEVEL_MULTIPLIER);
        }
        return BASE_DAMAGE + this.level * LEVEL_MULTIPLIER;
    }

    @Override
    public float getModifier(Rogue rogue) {
        return ROGUE_MODIFIER;
    }

    @Override
    public float getModifier(Knight knight) {
        return KNIGHT_MODIFIER;
    }

    @Override
    public float getModifier(Pyromancer pyromancer) {
        return PYROMANCER_MODIFIER;
    }

    @Override
    public float getModifier(Wizard wizard) {
        return WIZARD_MODIFIER;
    }
}
