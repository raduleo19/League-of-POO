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

public class DarkAngel extends Angel {
    public DarkAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.decreaseHealthPoints(Constants.DARK_ANGEL_HP_BONUS_KNIGHT);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.decreaseHealthPoints(Constants.DARK_ANGEL_HP_BONUS_PYROMANCER);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.decreaseHealthPoints(Constants.DARK_ANGEL_HP_BONUS_ROGUE);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.decreaseHealthPoints(Constants.DARK_ANGEL_HP_BONUS_WIZARD);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.DARK_ANGEL + " was spawned at " + line + " " + column;
    }
}
