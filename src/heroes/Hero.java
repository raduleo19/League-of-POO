package heroes;

public class Hero {
    protected int experiencePoints;
    protected int healthPoints;
    protected int x;
    protected int y;

    Hero(int x, int y, int healthPoints) {
        this.experiencePoints = 0;
        this.healthPoints = healthPoints;
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

    void attack() {
    }

    void accept() {
    }
}
