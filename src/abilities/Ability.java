package abilities;

import heroes.Hero;

public abstract class Ability {
    Ability() {
    }

    public abstract void giveDamage(Hero hero, int level, int round);

}
