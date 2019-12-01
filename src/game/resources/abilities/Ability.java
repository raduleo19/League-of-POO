/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.abilities;

import game.resources.heroes.Hero;
import game.resources.heroes.Knight;
import game.resources.heroes.Pyromancer;
import game.resources.heroes.Rogue;
import game.resources.heroes.Wizard;

public abstract class Ability {
    protected int level;
    protected Hero hero;

    public Ability(final Hero hero) {
        this.level = 0;
        this.hero = hero;
    }

    public final void levelUp() {
        this.level++;
    }

    /**
     * @param target
     * @param receivedRawDamage
     * @return deflection damage based on receivedRawDamage
     */
    public float getDeflectionDamage(final Hero target, final float receivedRawDamage) {
        return 0;
    }

    /**
     * @param other
     * @return damage without modifiers
     */
    public abstract float getDamage(Hero other);

    public abstract float getModifier(Rogue rogue);

    public abstract float getModifier(Knight knight);

    public abstract float getModifier(Pyromancer pyromancer);

    public abstract float getModifier(Wizard wizard);

}
