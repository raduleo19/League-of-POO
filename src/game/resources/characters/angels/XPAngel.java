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

public final class XPAngel extends Angel {
    public XPAngel(final int line, final int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(final Knight knight) {
        if (!knight.isDead()) {
            sendHelpedNotification(knight);
            knight.gainExperience(Constants.XP_ANGEL_BONUS_XP_KNIGHT);
        }
    }

    @Override
    public void applyBuff(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            sendHelpedNotification(pyromancer);
            pyromancer.gainExperience(Constants.XP_ANGEL_BONUS_XP_PYROMANCER);
        }
    }

    @Override
    public void applyBuff(final Rogue rogue) {
        if (!rogue.isDead()) {
            sendHelpedNotification(rogue);
            rogue.gainExperience(Constants.XP_ANGEL_BONUS_XP_ROGUE);
        }
    }

    @Override
    public void applyBuff(final Wizard wizard) {
        if (!wizard.isDead()) {
            sendHelpedNotification(wizard);
            wizard.gainExperience(Constants.XP_ANGEL_BONUS_XP_WIZARD);
        }
    }

    public String getType() {
        return Constants.XP_ANGEL;
    }
}
