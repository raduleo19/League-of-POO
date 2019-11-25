package game.resources.abilities;

import game.resources.heroes.*;

public class Execute extends Ability {
    private static final int BASE_DAMAGE = 200;
    private static final int LEVEL_MULTIPLIER = 30;

    private static final float ROGUE_MODIFIER = 1.15f;
    private static final float KNIGHT_MODIFIER = 1f;
    private static final float PYROMANCER_MODIFIER = 1.1f;
    private static final float WIZARD_MODIFIER = 0.8f;

    public Execute(Hero hero) {
        super(hero);
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