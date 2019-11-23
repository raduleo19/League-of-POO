package heroes;

public abstract class Hero {
    protected int experiencePoints;
    protected int healthPoints;
    protected int level;
    protected int bonusHealthPoints;
    protected int x;
    protected int y;

    Hero(int x, int y, int healthPoints, int bonusHealthPoints) {
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

    public void attack(Hero other) {

    }

}
