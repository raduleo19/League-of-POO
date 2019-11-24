package heroes;

import abilities.Ability;
import abilities.Execute;
import abilities.Slam;
import common.Constants;

public class Knight extends Hero {

    Knight(int x, int y) {
        super(x, y, Constants.INITIAL_KNIGHT_HP, Constants.BONUS_KNIGHT_HP);
        abilities.add(new Execute());
        abilities.add(new Slam());
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "K" + " " + "dead";
        }
        return "K" + " " + level + " " + experiencePoints + " " + healthPoints + " " + x + " " + y;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }
}
