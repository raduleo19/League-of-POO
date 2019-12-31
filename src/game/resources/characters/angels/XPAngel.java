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
        knight.gainExperience(Constants.XP_ANGEL_BONUS_XP_KNIGHT);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.gainExperience(Constants.XP_ANGEL_BONUS_XP_PYROMANCER);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.gainExperience(Constants.XP_ANGEL_BONUS_XP_ROGUE);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.gainExperience(Constants.XP_ANGEL_BONUS_XP_WIZARD);
    }

    public String getType() {
        return Constants.XP_ANGEL;
    }
}
