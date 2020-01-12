/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.wizard;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Ability;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.shared.strategies.AttackStrategy;
import game.resources.characters.heroes.shared.strategies.DefenseStrategy;
import game.resources.characters.heroes.shared.strategies.NormalStrategy;
import game.resources.characters.heroes.wizard.abilities.Deflect;
import game.resources.characters.heroes.wizard.abilities.Drain;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Wizard extends Hero {
    public Wizard(final int line, final int column, final int id) {
        super(line, column, Constants.INITIAL_WIZARD_HP, Constants.BONUS_WIZARD_HP,
                id);
        abilities.add(new Drain(this));
        abilities.add(new Deflect(this));
    }

    @Override
    public void selectStrategy() {
        if (this.getMaxHealthPoints() / Constants.WIZARD_MIN_HP < this.getHealthPoints()
                && this.getHealthPoints() < this.getMaxHealthPoints() / Constants.WIZARD_MAX_HP) {
            strategy = new AttackStrategy(Constants.WIZARD_ATTACK_HP, Constants.WIZARD_ATTACK_BUFF);
        } else if (this.getHealthPoints() < this.getMaxHealthPoints() / Constants.WIZARD_MIN_HP) {
            strategy = new DefenseStrategy(Constants.WIZARD_DEFENSE_HP,
                    Constants.WIZARD_DEFENSE_BUFF);
        } else {
            strategy = new NormalStrategy();
        }
    }

    @Override
    public String toString() {
        return "Wizard " + id;
    }

    public String getStats() {
        if (isDead()) {
            return Constants.WIZARD + " " + Constants.DEAD;
        }
        return Constants.WIZARD + " " + level + " " + experiencePoints + " " + healthPoints + " "
                + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.WIZARD_PREFERRED_LAND) {
            return Constants.WIZARD_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(final Ability ability) {
        return ability.getModifier(this);
    }

    @Override
    public void requestBuff(final Angel angel) {
        angel.applyBuff(this);
    }

    @Override
    public void attack(final Hero other) {
        int damage = 0;

        for (Ability ability : abilities) {

            float newModifier = 1.0f;
            if (other.requestRaceModifier(ability) != 1.0f) {
                newModifier = other.requestRaceModifier(ability)
                        + buff.getBuff();
            }
            float abilityDamage = Math.round(ability.getDamage(other) * newModifier * this
                    .getLandModifier());
            damage += Math.round(abilityDamage);
        }
        other.receiveDamage(damage);
    }
}
