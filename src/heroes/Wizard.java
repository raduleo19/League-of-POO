package heroes;

import abilities.Ability;
import abilities.Deflect;
import abilities.Drain;
import common.Constants;

public class Wizard extends Hero {
    Wizard(int x, int y) {
        super(x, y, Constants.INITIAL_WIZARD_HP, Constants.BONUS_WIZARD_HP);
        abilities.add(new Drain());
        abilities.add(new Deflect());
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "W" + " " + "dead";
        }
        return "W" + " " + level + " " + experiencePoints + " " + healthPoints + " " + x + " " + y;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }
}
