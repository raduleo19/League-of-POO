package abilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class Ability {
    Ability() {
    }

    public abstract void giveDamage(Knight knight);

    public abstract void giveDamage(Pyromancer pyromancer);

    public abstract void giveDamage(Rogue rogue);

    public abstract void giveDamage(Wizard wizard);

}
