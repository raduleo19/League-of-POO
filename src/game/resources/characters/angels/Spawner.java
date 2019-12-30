/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.common.Constants;

public class Spawner extends Angel {
    public Spawner(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.SPAWNER + " was spawned at " + line + " " + column;
    }
}
