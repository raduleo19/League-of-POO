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
        if (this.getMaxHealthPoints() / 7 < this.getHealthPoints()
                && this.getHealthPoints() < this.getMaxHealthPoints() / 5) {
            strategy = new AttackStrategy(7, 0.4f);
        } else if (this.getHealthPoints() < this.getMaxHealthPoints() / 7) {
            strategy = new DefenseStrategy(2, 0.1f);
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
    public void requestBuff(Angel angel) {
        angel.applyBuff(this);
    }

    public void attack(final Hero other) {
        int damage = 0;
        int rawDamage = 0;


//        System.out.print(other.healthPoints);
        for (Ability ability : abilities) {
            float abilityRawDamage = ability.getDamage(other);
//            System.out.println(abilityRawDamage * (other.requestRaceModifier(ability)
//                    + buff.getBuff()));


            float newModifier = 1.0f;
            if (other.requestRaceModifier(ability) != 1.0f) {
                newModifier = other.requestRaceModifier(ability)
                        + buff.getBuff() - 0.000001f;
            }

//            System.out.println(ability.getClass().getSimpleName() + ' ' + newModifier);;
            float abilityDamage = Math.round(Math.round(abilityRawDamage) * this
                    .getLandModifier()) * newModifier;
//
            rawDamage += Math.round(abilityRawDamage * this.getLandModifier());
            damage += Math.round(abilityDamage);
////            System.out.println(abilityDamage);
////            System.out.print("Damage:" + Math.round(abilityDamage) + ' ');
//
//
//            System.out.println(
//                    this.toString() + " give " + abilityDamage + " to " + other.toString());
        }
        other.receiveDamage(damage);
//        System.out.println(" " + damage + ' ' + other.healthPoints);
        int deflectionDamage = other.getDeflectionDamage(this, rawDamage);
        this.receiveDamage(deflectionDamage);
//        if (this.getId() == 44 || other.getId() == 44 || this.getId() == 35 || hero2.getId() ==
//        35) {
//            if (deflectionDamage != 0) {
//                System.out.println("DEFLECTION:" + deflectionDamage);
//                System.out.println("RAW DMG:" + rawDamage);
//            }
//        }
    }
}
