package heroes;

public class Hero {
    protected int experiencePoints;
    protected int healthPoints;
    protected int x;
    protected int y;

    Hero(int x, int y) {
        experiencePoints = 0;
        this.x = x;
        this.y = y;
    }

    void attack() {
    }

    void accept() {
    }
}
