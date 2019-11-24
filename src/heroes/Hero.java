package heroes;

import abilities.Ability;

import java.util.ArrayList;

public abstract class Hero {
    protected ArrayList<Ability> abilities;
    protected int experiencePoints;
    protected int healthPoints;
    protected int level;
    protected int bonusHealthPoints;
    protected int x;
    protected int y;

    Hero(int x, int y, int healthPoints, int bonusHealthPoints) {
        this.abilities = new ArrayList<>();
        this.experiencePoints = 0;
        this.healthPoints = healthPoints;
        this.level = 0;
        this.bonusHealthPoints = bonusHealthPoints;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "H" + " " + "dead";
        }
        return "H" + " " + level + " " + experiencePoints + " " + healthPoints + " " + x + " " + y;
    }

    public void move(char direction) {
        if (direction == 'U') {
            x--;
        } else if (direction == 'D') {
            x++;
        } else if (direction == 'L') {
            y--;
        } else if (direction == 'R') {
            y++;
        }
    }

    public boolean isDead() {
        return healthPoints <= 0;
    }

    public boolean collide(Hero other) {
        return this.x == other.x && this.y == other.y;
    }

    public static void battle(Hero hero1, Hero hero2) {
        hero1.attack(hero2);
        hero2.attack(hero1);
    }

    abstract void accept(Ability ability);

    public void attack(Hero other) {
        for (Ability ability : abilities) {
            other.accept(ability);
        }

        if (other.isDead()) {
            this.experiencePoints += Math.max(0, 200 - (this.level - other.level) * 40);
        }
    }

}
