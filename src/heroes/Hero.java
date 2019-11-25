/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package heroes;

import abilities.Ability;
import common.Constants;

import java.util.ArrayList;

public abstract class Hero {
    protected ArrayList<Ability> abilities;
    protected int experiencePoints;
    protected int healthPoints;
    protected int baseHealthPoints;
    protected int level;
    protected int bonusHealthPoints;
    protected int line;
    protected int column;
    protected int paralyzed;

    Hero(int line, int column, int baseHealthPoints, int bonusHealthPoints) {
        this.abilities = new ArrayList<>();
        this.experiencePoints = 0;
        this.baseHealthPoints = baseHealthPoints;
        this.healthPoints = baseHealthPoints;
        this.level = 0;
        this.bonusHealthPoints = bonusHealthPoints;
        this.line = line;
        this.column = column;
        this.paralyzed = 0;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxPossibleHealthPoints() {
        return baseHealthPoints + level * bonusHealthPoints;
    }

    public void setParalyzed(int paralyzed) {
        this.paralyzed = paralyzed;
    }

    public void getDamage(float damage) {
        healthPoints -= damage;
    }

    abstract void accept(Hero hero);

    public abstract String toString();

    public abstract float getLandModifier();

    public boolean collide(Hero other) {
        return this.line == other.line && this.column == other.column;
    }

    public void move(char direction) {
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

    public boolean isDead() {
        return healthPoints <= 0;
    }

    public void attack(Hero other) {
        other.accept(this);
    }

    public void giveDamage(Knight knight) {
    }

    public void giveDamage(Rogue hero) {
    }

    public void giveDamage(Pyromancer hero) {
    }

    public void giveDamage(Wizard hero) {
    }

}
