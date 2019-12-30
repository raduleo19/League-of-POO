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

public class GoodBoy extends Angel {
    public GoodBoy(int line, int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.increaseHealthPoints(Constants.GOOD_BOY_HP_BONUS_KNIGHT);
        knight.getBuff().increaseBuff(Constants.GOOD_BOY_DAMAGE_BONUS_KNIGHT);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.increaseHealthPoints(Constants.GOOD_BOY_HP_BONUS_PYROMANCER);
        pyromancer.getBuff().increaseBuff(Constants.GOOD_BOY_DAMAGE_BONUS_PYROMANCER);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.increaseHealthPoints(Constants.GOOD_BOY_HP_BONUS_ROGUE);
        rogue.getBuff().increaseBuff(Constants.GOOD_BOY_DAMAGE_BONUS_ROGUE);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.increaseHealthPoints(Constants.GOOD_BOY_HP_BONUS_WIZARD);
        wizard.getBuff().increaseBuff(Constants.GOOD_BOY_DAMAGE_BONUS_WIZARD);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.GOOD_BOY + " was spawned at " + line + " " + column;
    }
}