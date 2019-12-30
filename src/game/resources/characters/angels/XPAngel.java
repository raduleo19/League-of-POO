/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.common.Constants;

public class XPAngel extends Angel {
    public XPAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.XP_ANGEL + " was spawned at " + line + " " + column;
    }
}
