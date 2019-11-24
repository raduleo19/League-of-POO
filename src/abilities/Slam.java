package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Slam extends Ability {

    @Override
    public void giveDamage(Rogue rogue, int level, float landModifier, int round) {
        float damage = Constants.SLAM_BASE_DAMAGE + level * Constants.SLAM_LEVEL_MULTIPLIER;
        damage *= Constants.SLAM_ROGUE_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        rogue.getDamage(damage);
        rogue.setParalyzed(1);
    }

    @Override
    public void giveDamage(Knight knight, int level, float landModifier, int round) {
        float damage = Constants.SLAM_BASE_DAMAGE + level * Constants.SLAM_LEVEL_MULTIPLIER;
        damage *= Constants.SLAM_KNIGHT_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        knight.getDamage(damage);
        knight.setParalyzed(1);
    }

    @Override
    public void giveDamage(Wizard wizard, int level, float landModifier, int round) {
        float damage = Constants.SLAM_BASE_DAMAGE + level * Constants.SLAM_LEVEL_MULTIPLIER;
        damage *= Constants.SLAM_WIZARD_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        wizard.getDamage(damage);
        wizard.setParalyzed(1);
    }

    @Override
    public void giveDamage(Pyromancer pyromancer, int level, float landModifier, int round) {
        float damage = Constants.SLAM_BASE_DAMAGE + level * Constants.SLAM_LEVEL_MULTIPLIER;
        damage *= Constants.SLAM_PYROMANCER_MODIFIER;
        damage *= landModifier;
        damage = Math.round(damage);
        pyromancer.getDamage(damage);
        pyromancer.setParalyzed(1);
    }
}
