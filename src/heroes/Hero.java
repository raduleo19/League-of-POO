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

    Hero(int line, int column, int baseHealthPoints, int bonusHealthPoints) {
        this.abilities = new ArrayList<>();
        this.experiencePoints = 0;
        this.baseHealthPoints = baseHealthPoints;
        this.healthPoints = baseHealthPoints;
        this.level = 0;
        this.bonusHealthPoints = bonusHealthPoints;
        this.line = line;
        this.column = column;
    }

    public abstract String toString();
    public abstract float getLandModifier();

    public abstract float requestRaceModifier(Ability ability);

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

    public int getTotalDamage(Hero other) {
        int damage = 0;

        for (Ability ability : abilities) {
            damage += Math.round(ability.getDamage(other)
                    * other.requestRaceModifier(ability)
                    * this.getLandModifier());
        }

        return damage;
    }

    public int getRawDamage(Hero other) {
        int damage = 0;

        for (Ability ability : abilities) {
            damage += Math.round(ability.getDamage(other)
                    * this.getLandModifier());
        }

        return damage;
    }

    public void getMaxHealthPoints() {
        this.healthPoints = this.baseHealthPoints + this.level * this.bonusHealthPoints;
    }

    public void levelUp() {
        this.level++;
        for (Ability ability : abilities) {
            ability.levelUp();
        }
        this.getMaxHealthPoints();
    }

    public void receiveDamage(int damage) {
        this.healthPoints -= damage;
    }


}
