package game.resources.abilities;

import game.resources.common.Constants;
import game.resources.heroes.*;

public class Paralysis extends Ability {
    private static final int DOT_BASE_DAMAGE = 40;
    private static final int DOT_LEVEL_MULTIPLIER = 10;

    private static final float ROGUE_MODIFIER = 0.9f;
    private static final float KNIGHT_MODIFIER = 0.8f;
    private static final float PYROMANCER_MODIFIER = 1.2f;
    private static final float WIZARD_MODIFIER = 1.25f;

    public Paralysis(Hero hero) {
        super(hero);
    }

    @Override
    public void setOvertime(Hero other) {
        float damage = DOT_BASE_DAMAGE + this.level * DOT_LEVEL_MULTIPLIER;
        damage *= this.hero.getLandModifier();
        damage *= other.requestRaceModifier(this);
        int time = 3;
        if (this.hero.getLandType() == Constants.ROGUE_PREFERED_LAND) {
            time = 6;
        }
        other.setOvertime(time, true, Math.round(damage));
    }

    @Override
    public float getDeflectionDamage(Hero other, int receivedRawDamage) {
        return 0;
    }

    @Override
    public float getDamage(Hero hero) {
        setOvertime(hero);
        return DOT_BASE_DAMAGE + this.level * DOT_LEVEL_MULTIPLIER;
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
