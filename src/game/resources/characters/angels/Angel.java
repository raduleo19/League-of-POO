/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

public abstract class Angel {
    private int line;
    private int column;

    public Angel(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
