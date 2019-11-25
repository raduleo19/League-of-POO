package game.resources.abilities;

import game.resources.heroes.*;

public abstract class Ability {
    protected int level;
    protected Hero hero;

    public Ability(Hero hero) {
        this.level = 0;
        this.hero = hero;
    }

    public void levelUp() {
        this.level++;
    }

    public abstract void setOvertime(Hero other);

    public abstract float getDeflectionDamage(Hero other, int receivedRawDamage);

    public abstract float getDamage(Hero other);

    public abstract float getModifier(Rogue rogue);

    public abstract float getModifier(Knight knight);

    public abstract float getModifier(Pyromancer pyromancer);

    public abstract float getModifier(Wizard wizard);

}
