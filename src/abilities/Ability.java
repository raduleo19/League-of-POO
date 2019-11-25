package abilities;

import heroes.*;

public abstract class Ability {
    protected int level;

    Ability() {
        this.level = 0;
    }

    public int getDamage(Hero hero) {
    }

    public void giveDamage(Hero hero) {
    }

    public void deflect(Hero hero, float damage) {
    }

    public float getModifier(Rogue rogue) {
    }

    public float getModifier(Knight knight) {
    }

    public float getModifier(Pyromancer pyromancer) {
    }

    public float getModifier(Wizard wizard) {
    }

}
