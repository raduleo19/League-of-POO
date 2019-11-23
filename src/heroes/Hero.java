package heroes;

public class Hero {
    protected int experiencePoints;
    protected int healthPoints;
    protected int bonusHealthPoints;
    protected int x;
    protected int y;

    Hero(int x, int y, int healthPoints, int bonusHealthPoints) {
        this.experiencePoints = 0;
        this.healthPoints = healthPoints;
        this.bonusHealthPoints = bonusHealthPoints;
        this.x = x;
        this.y = y;
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
        return healthPoints > 0;
    }

    public boolean collide(Hero other) {
        return this.x == other.x && this.y == other.y;
    }

    void computeAttack(Hero other) {
        // TO DO RACE BUFF
        // TO DO LAND BUFF
        // TO DO BATTLE
    }

    // Double Dispath
    public void attack(Hero other) {
        this.computeAttack(other);
        other.attackBack(this);
    }

    void attackBack(Hero other) {
        this.computeAttack(other);
    }
}
