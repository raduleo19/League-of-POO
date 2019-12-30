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

public class DamageAngel extends Angel {
    public DamageAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.getBuff().increaseBuff(Constants.DAMAGE_ANGEL_DAMAGE_BONUS_KNIGHT);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.getBuff().increaseBuff(Constants.DAMAGE_ANGEL_DAMAGE_BONUS_PYROMANCER);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.getBuff().increaseBuff(Constants.DAMAGE_ANGEL_DAMAGE_BONUS_ROGUE);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.getBuff().increaseBuff(Constants.DAMAGE_ANGEL_DAMAGE_BONUS_WIZARD);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.DAMAGE_ANGEL + " was spawned at " + line + " " + column;
    }
}
