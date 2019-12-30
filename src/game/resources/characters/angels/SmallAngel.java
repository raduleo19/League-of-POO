/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.common.Constants;

public class SmallAngel extends Angel {
    public SmallAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.SMALL_ANGEL + " was spawned at " + line + " " + column;
    }
}
