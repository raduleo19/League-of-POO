/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.common.Constants;

public class GoodBoy extends Angel {
    public GoodBoy(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.GOOD_BOY + " was spawned at " + line + " " + column;
    }
}
