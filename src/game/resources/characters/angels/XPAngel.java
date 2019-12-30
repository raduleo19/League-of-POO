/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.common.Constants;

public class XPAngel extends Angel {
    public XPAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(Knight knight) {

    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {

    }

    @Override
    public void applyBuff(Rogue rogue) {

    }

    @Override
    public void applyBuff(Wizard wizard) {

    }

    @Override
    public String toString() {
        return "Angel " + Constants.XP_ANGEL + " was spawned at " + line + " " + column;
    }
}
