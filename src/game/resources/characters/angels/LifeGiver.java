/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels;

import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.common.Constants;

public class LifeGiver extends Angel {
    public LifeGiver(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.LIFE_GIVER + " was spawned at " + line + " " + column;
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_KNIGHT);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_PYROMANCER);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_ROGUE);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_WIZARD);
    }
}
