/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels.abstracts;

import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;

public abstract class Angel {
    protected int line;
    protected int column;

    public Angel(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public abstract void applyBuff(Knight knight);

    public abstract void applyBuff(Pyromancer pyromancer);

    public abstract void applyBuff(Rogue rogue);

    public abstract void applyBuff(Wizard wizard);

    public abstract String getType();
}
