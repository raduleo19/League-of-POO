/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.common.Constants;

public class TheDoomer extends Angel {
    public TheDoomer(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.THE_DOOMER + " was spawned at " + line + " " + column;
    }
}
