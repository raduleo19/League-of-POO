/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.common.Constants;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.LEVEL_UP_ANGEL + " was spawned at " + line + " " + column;
    }

}
