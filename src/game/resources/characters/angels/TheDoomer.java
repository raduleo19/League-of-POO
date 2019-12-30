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

public class TheDoomer extends Angel {
    public TheDoomer(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.THE_DOOMER + " was spawned at " + line + " " + column;
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.setHealthPoints(0);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.setHealthPoints(0);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.setHealthPoints(0);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.setHealthPoints(0);
    }
}
