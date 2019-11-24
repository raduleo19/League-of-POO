package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Ignite extends Ability {
    private int baseDamage;
    private int periodicDamage;

    public Ignite() {
        super();
        baseDamage = Constants.IGNITE_BASE_DAMAGE;
        periodicDamage = Constants.IGNITE_OVERTIME_DAMAGE;
    }

    private float calculateDamage(int level, int round) {
        if (round % 3 == 0) {
            return baseDamage + level * Constants.IGNITE_LEVEL_MULTIPLIER;
        }
        return periodicDamage + level * Constants.IGNITE_OVERTIME_LEVEL_MULTIPLIER;
    }

    @Override
    public void giveDamage(Rogue rogue, int level, float landModifier, int round) {
        float damage = calculateDamage(level, round);
        damage *= Constants.IGNITE_ROGUE_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        rogue.getDamage(damage);
    }

    @Override
    public void giveDamage(Knight knight, int level, float landModifier, int round) {
        float damage = calculateDamage(level, round);
        damage *= Constants.IGNITE_KNIGHT_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        knight.getDamage(damage);
    }

    @Override
    public void giveDamage(Wizard wizard, int level, float landModifier, int round) {
        float damage = calculateDamage(level, round);
        damage *= Constants.IGNITE_WIZARD_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        wizard.getDamage(damage);
    }

    @Override
    public void giveDamage(Pyromancer pyromancer, int level, float landModifier, int round) {
        float damage = calculateDamage(level, round);
        damage *= Constants.IGNITE_PYROMANCER_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        pyromancer.getDamage(damage);
    }
}
