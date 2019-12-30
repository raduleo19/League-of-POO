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

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.LEVEL_UP_ANGEL + " was spawned at " + line + " " + column;
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_KNIGHT);
        knight.setExperiencePoints(knight.getMaxExperiencePoints());
        knight.levelUp();
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_PYROMANCER);
        pyromancer.setExperiencePoints(pyromancer.getMaxExperiencePoints());
        pyromancer.levelUp();
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_ROGUE);
        rogue.setExperiencePoints(rogue.getMaxExperiencePoints());
        rogue.levelUp();
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_WIZARD);
        wizard.setExperiencePoints(wizard.getMaxExperiencePoints());
        wizard.levelUp();
    }
}
