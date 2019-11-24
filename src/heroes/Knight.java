/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package heroes;

import abilities.Ability;
import abilities.Execute;
import abilities.Slam;
import common.Constants;

public class Knight extends Hero {

    Knight(int line, int column) {
        super(line, column, Constants.INITIAL_KNIGHT_HP, Constants.BONUS_KNIGHT_HP);
        abilities.add(new Execute());
        abilities.add(new Slam());
    }

    @Override
    public String toString() {
        if (isDead()) {
            return Constants.KNIGHT + " " + Constants.DEAD;
        }
        return Constants.KNIGHT + " " + level + " " + experiencePoints + " " + healthPoints + " " + line + " " + column;
    }

    @Override
    void accept(Ability ability) {
        ability.giveDamage(this);
    }
}
