/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.abstracts;

import game.resources.characters.angels.Angel;
import game.resources.characters.heroes.interfaces.Strategy;
import game.resources.characters.heroes.shared.Overtime;
import game.resources.common.Constants;
import game.resources.map.Map;

import java.util.ArrayList;

public abstract class Hero {
    protected int level;
    protected int line;
    protected int column;
    protected int buff;
    protected int healthPoints;
    protected int baseHealthPoints;
    protected int bonusHealthPoints;
    protected int experiencePoints;
    protected ArrayList<Ability> abilities;
    protected Overtime overtime;
    protected Strategy strategy;

    protected Hero(final int line, final int column, final int baseHealthPoints,
                   final int bonusHealthPoints, Strategy strategy) {
        this.abilities = new ArrayList<>();
        this.experiencePoints = 0;
        this.baseHealthPoints = baseHealthPoints;
        this.healthPoints = baseHealthPoints;
        this.level = 0;
        this.bonusHealthPoints = bonusHealthPoints;
        this.line = line;
        this.column = column;
        this.overtime = new Overtime(0, 0, false);
        this.strategy = strategy;
        this.buff = 0;
    }

    public void applyStrategy() {
        strategy.applyStrategy(this);
    }

    public abstract String toString();

    public abstract float getLandModifier();

    public abstract float requestRaceModifier(Ability ability);

    public abstract void requestBuff(Angel angel);

    public final boolean collide(final Hero other) {
        return this.line == other.line && this.column == other.column;
    }

    public final boolean collide(final Angel other) {
        return this.line == other.getLine() && this.column == other.getColumn();
    }

    public final void move(final char direction) {
        if (direction == Constants.UP) {
            line--;
        } else if (direction == Constants.DOWN) {
            line++;
        } else if (direction == Constants.LEFT) {
            column--;
        } else if (direction == Constants.RIGHT) {
            column++;
        }
    }

    public final boolean isDead() {
        return healthPoints <= 0;
    }

    public final boolean isStunned() {
        return overtime.getStun() && overtime.getTime() > 0;
    }

    public final void attack(final Hero other) {
        int damage = 0;
        int rawDamage = 0;


//        System.out.print(other.healthPoints);
        for (Ability ability : abilities) {
            float abilityRawDamage = ability.getDamage(other) * this.getLandModifier();
            float abilityDamage = Math.round(abilityRawDamage) * (other.requestRaceModifier(ability)
                    + 1.0f * buff / 100);
//            System.out.print("Damage:" + Math.round(abilityDamage) + ' ');
            rawDamage += Math.round(abilityRawDamage);
            damage += Math.round(abilityDamage);
        }
        other.receiveDamage(damage);
//        System.out.println(" " + damage + ' ' + other.healthPoints);
        this.receiveDamage(other.getDeflectionDamage(this, rawDamage));
    }

    public final int getDeflectionDamage(final Hero other, final int receivedRawDamage) {
        int damage = 0;

        for (Ability ability : abilities) {
            damage += Math.round(ability.getDeflectionDamage(other, receivedRawDamage)
                    * (other.requestRaceModifier(ability) + 1.0f * buff / 100)
                    * this.getLandModifier());
        }

        return damage;
    }

    public final int getMaxHealthPoints() {
        return this.baseHealthPoints + this.level * this.bonusHealthPoints;
    }

    public final int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public final int getMaxExperiencePoints() {
        return Constants.BASE_EXPERIENCE + this.level * Constants.EXPERIENCE_MULTIPLIER;
    }

    public final void levelUp() {
        this.level++;
        for (Ability ability : abilities) {
            ability.levelUp();
        }
        if (!this.isDead()) {
            this.healthPoints = this.getMaxHealthPoints();
        }
    }

    public final int getLevel() {
        return level;
    }

    public final void receiveDamage(final int damage) {
        this.healthPoints -= damage;
    }

    public final void gainExperience(final int loserLevel) {
        experiencePoints += Math.max(0, Constants.BASE_GAIN_EXPERIENCE
                - (this.level - loserLevel) * Constants.GAIN_EXPERIENCE_MULTIPLIER);
        while (this.experiencePoints >= this.getMaxExperiencePoints()) {
            this.levelUp();
        }
    }

    public final void setOvertime(final int time, final boolean stun, final int damage) {
        this.overtime = new Overtime(time, damage, stun);
    }

    public final void applyOvertime() {
        if (overtime.getTime() > 0) {
            overtime.setTime(overtime.getTime() - 1);
            this.receiveDamage(overtime.getDamage());
        }
    }

    public final char getLandType() {
        return Map.getInstance().getLandType(this.line, this.column);
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public final void increaseHealthPoints(int value) {
        healthPoints += value;
    }
}
