package abilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class Ability {
    Ability() {
    }

    public abstract void giveDamage(Knight knight, int level, float landModifier, int round);

    public abstract void giveDamage(Pyromancer pyromancer, int level, float landModifier, int round);

    public abstract void giveDamage(Rogue rogue, int level, float landModifier, int round);

    public abstract void giveDamage(Wizard wizard, int level, float landModifier, int round);

}
