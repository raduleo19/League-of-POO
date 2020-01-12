/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.rogue;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Ability;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.rogue.abilities.Backstab;
import game.resources.characters.heroes.rogue.abilities.Paralysis;
import game.resources.characters.heroes.shared.strategies.AttackStrategy;
import game.resources.characters.heroes.shared.strategies.DefenseStrategy;
import game.resources.characters.heroes.shared.strategies.NormalStrategy;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Rogue extends Hero {
    public Rogue(final int line, final int column, final int id) {
        super(line, column, Constants.INITIAL_ROGUE_HP, Constants.BONUS_ROGUE_HP,
                id);
        abilities.add(new Backstab(this));
        abilities.add(new Paralysis(this));
    }

    @Override
    public void selectStrategy() {
        if (this.getMaxHealthPoints() / Constants.ROGUE_MIN_HP < this.getHealthPoints()
                && this.getHealthPoints() < this.getMaxHealthPoints() / Constants.ROGUE_MAX_HP) {
            strategy = new AttackStrategy(Constants.ROGUE_ATTACK_HP, Constants.ROGUE_ATTACK_BUFF);
        } else if (this.getHealthPoints() < this.getMaxHealthPoints() / Constants.ROGUE_MIN_HP) {
            strategy = new DefenseStrategy(Constants.ROGUE_DEFENSE_HP,
                    Constants.ROGUE_DEFENSE_BUFF);
        } else {
            strategy = new NormalStrategy();
        }
    }

    @Override
    public String toString() {
        return "Rogue " + id;
    }

    public String getStats() {
        if (isDead()) {
            return Constants.ROGUE + " " + Constants.DEAD;
        }
        return Constants.ROGUE + " " + level + " " + experiencePoints + " " + healthPoints + " "
                + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.ROGUE_PREFERRED_LAND) {
            return Constants.ROGUE_LAND_MODIFIER;
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

    public void attack(final Hero other) {
        int damage = 0;
        int rawDamage = 0;

        for (Ability ability : abilities) {
            float abilityRawDamage = ability.getDamage(other);

            float newModifier = 1.0f;
            if (other.requestRaceModifier(ability) != 1.0f) {
                newModifier = other.requestRaceModifier(ability)
                        + buff.getBuff() - Constants.EPS;
            }

            float abilityDamage = Math.round(Math.round(abilityRawDamage) * this
                    .getLandModifier()) * newModifier;

            rawDamage += Math.round(abilityRawDamage * this.getLandModifier());
            damage += Math.round(abilityDamage);
        }

        other.receiveDamage(damage);

        int deflectionDamage = other.getDeflectionDamage(this, rawDamage);
        this.receiveDamage(deflectionDamage);
    }
}
