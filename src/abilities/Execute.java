package abilities;

import common.Constants;
import heroes.*;

public class Execute extends Ability {

    private boolean checkLimit(Hero hero, int level) {
        int healthPointsLimit = Math.min(Constants.EXECUTE_MAX_HP_LIMIT, Constants.EXECUTE_BASE_HP_LIMIT + level);
        return healthPointsLimit * hero.getMaxPossibleHealthPoints() > Constants.PERCENT_DENOMINATOR * hero.getHealthPoints();
    }

    @Override
    public void giveDamage(Rogue rogue, int level, float landModifier, int round) {
        if (checkLimit(rogue, level)) {
            rogue.setHealthPoints(0);
        } else {
            float damage = Constants.EXECUTE_BASE_DAMAGE + level * Constants.EXECUTE_LEVEL_MULTIPLIER;
            damage *= Constants.EXECUTE_ROGUE_MODIFIER;
            damage *= landModifier;
            damage = Math.round(damage);
            rogue.getDamage(damage);
        }
    }

    @Override
    public void giveDamage(Knight knight, int level, float landModifier, int round) {
        if (checkLimit(knight, level)) {
            knight.setHealthPoints(0);
        } else {
            float damage = Constants.EXECUTE_BASE_DAMAGE + level * Constants.EXECUTE_LEVEL_MULTIPLIER;
            damage *= Constants.EXECUTE_KNIGHT_MODIFIER;
            damage *= landModifier;
            damage = Math.round(damage);
            knight.getDamage(damage);
        }
    }

    @Override
    public void giveDamage(Wizard wizard, int level, float landModifier, int round) {
        if (checkLimit(wizard, level)) {
            wizard.setHealthPoints(0);
        } else {
            float damage = Constants.EXECUTE_BASE_DAMAGE + level * Constants.EXECUTE_LEVEL_MULTIPLIER;
            damage *= Constants.EXECUTE_WIZARD_MODIFIER;
            damage *= landModifier;
            damage = Math.round(damage);
            wizard.getDamage(damage);
        }
    }

    @Override
    public void giveDamage(Pyromancer pyromancer, int level, float landModifier, int round) {
        if (checkLimit(pyromancer, level)) {
            pyromancer.setHealthPoints(0);
        } else {
            float damage = Constants.EXECUTE_BASE_DAMAGE + level * Constants.EXECUTE_LEVEL_MULTIPLIER;
            damage *= Constants.EXECUTE_PYROMANCER_MODIFIER;
            damage *= landModifier;
            damage = Math.round(damage);
            pyromancer.getDamage(damage);
        }
    }
}