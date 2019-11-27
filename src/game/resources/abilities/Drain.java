package game.resources.abilities;

import game.resources.heroes.*;

public class Drain extends Ability {
    private static final int BASE_DAMAGE = 20;
    private static final int LEVEL_MULTIPLIER = 5;

    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    public Drain(Hero hero) {
        super(hero);
    }

    @Override
    public void setOvertime(Hero other) {

    }

    @Override
    public float getDeflectionDamage(Hero other, float receivedRawDamage) {
        return 0;
    }

    @Override
    public float getDamage(Hero hero) {
        setOvertime(hero);
        int percent = BASE_DAMAGE + this.level * LEVEL_MULTIPLIER;
        float baseHealthPoints = Math.min(0.3f * hero.maxHealthPoints(), hero.getHealthPoints());
        return percent * baseHealthPoints / 100;
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