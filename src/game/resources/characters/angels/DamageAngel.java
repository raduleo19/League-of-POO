/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.common.Constants;

public class DamageAngel extends Angel {
    public DamageAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.DAMAGE_ANGEL + " was spawned at " + line + " " + column;
    }
}
