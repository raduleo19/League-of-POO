/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.abilities;

import game.resources.heroes.*;

public class Fireblast extends Ability {
    private static final int BASE_DAMAGE = 350;
    private static final int LEVEL_MULTIPLIER = 50;

    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    public Fireblast(Hero hero) {
        super(hero);
    }

    @Override
    public void setOvertime(Hero hero) {
    }

    @Override
    public float getDeflectionDamage(Hero other, int receivedRawDamage) {
        return 0;
    }

    @Override
    public float getDamage(Hero hero) {
        setOvertime(hero);
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
