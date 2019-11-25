package game.resources.abilities;

import game.resources.heroes.*;

public class Deflect extends Ability {
    private static final int DEFLECTION_BASE_DAMAGE = 35;
    private static final int DEFLECTION_LEVEL_MULTIPLIER = 2;

    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 1.4f;
    private static final float PYROMANCER_MODIFIER = 1.3f;
    private static final float WIZARD_MODIFIER = 0;

    public Deflect(Hero hero) {
        super(hero);
    }

    @Override
    public void setOvertime(Hero other) {

    }

    @Override
    public float getDeflectionDamage(Hero other, int receivedRawDamage) {
        int percent = DEFLECTION_BASE_DAMAGE + this.level * DEFLECTION_LEVEL_MULTIPLIER;
        percent = Math.min(70, percent);
        return percent * receivedRawDamage / 100;
    }

    @Override
    public float getDamage(Hero hero) {
        setOvertime(hero);
        return 0;
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
