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
    public void applyBuff(Knight knight) {
        knight.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_KNIGHT);
        knight.levelUp();
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_PYROMANCER);
        pyromancer.levelUp();
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_ROGUE);
        rogue.levelUp();
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_WIZARD);
        wizard.levelUp();
    }

    public String getType() {
        return Constants.LEVEL_UP_ANGEL;
    }
}
