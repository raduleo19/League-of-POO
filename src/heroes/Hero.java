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
    protected int procentDeflected;

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
        this.procentDeflected = 0;
    }


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

}
