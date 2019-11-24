package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Fireblast extends Ability {
    @Override
    public void giveDamage(Rogue rogue, int level, float landModifier, int round) {
        float damage = Constants.FIREBLAST_BASE_DAMAGE + level * Constants.FIREBLAST_LEVEL_MULTIPLIER;
        damage *= Constants.FIREBLAST_ROGUE_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        rogue.getDamage(damage);
    }

    @Override
    public void giveDamage(Knight knight, int level, float landModifier, int round) {
        float damage = Constants.FIREBLAST_BASE_DAMAGE + level * Constants.FIREBLAST_LEVEL_MULTIPLIER;
        damage *= Constants.FIREBLAST_KNIGHT_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        knight.getDamage(damage);
    }

    @Override
    public void giveDamage(Wizard wizard, int level, float landModifier, int round) {
        float damage = Constants.FIREBLAST_BASE_DAMAGE + level * Constants.FIREBLAST_LEVEL_MULTIPLIER;
        damage *= Constants.FIREBLAST_WIZARD_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        wizard.getDamage(damage);
    }

    @Override
    public void giveDamage(Pyromancer pyromancer, int level, float landModifier, int round) {
        float damage = Constants.FIREBLAST_BASE_DAMAGE + level * Constants.FIREBLAST_LEVEL_MULTIPLIER;
        damage *= Constants.FIREBLAST_PYROMANCER_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        pyromancer.getDamage(damage);
    }
}
