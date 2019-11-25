package game.resources.abilities;

import game.resources.heroes.*;

public abstract class Ability {
    protected int level;

    Ability() {
        this.level = 0;
    }

    public void levelUp() {
        this.level++;
    }

    public float getDamage(Hero hero) {
        return 1.0f;
    }

    public abstract float getModifier(Rogue rogue);

    public abstract float getModifier(Knight knight);

    public abstract float getModifier(Pyromancer pyromancer);

    public abstract float getModifier(Wizard wizard);

}
