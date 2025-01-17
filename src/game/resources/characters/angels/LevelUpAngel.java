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

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final int line, final int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(final Knight knight) {
        if (!knight.isDead()) {
            sendHelpedNotification(knight);
            knight.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_KNIGHT);
            knight.levelUp();
        }
    }

    @Override
    public void applyBuff(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            sendHelpedNotification(pyromancer);
            pyromancer.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_PYROMANCER);
            pyromancer.levelUp();
        }
    }

    @Override
    public void applyBuff(final Rogue rogue) {
        if (!rogue.isDead()) {
            sendHelpedNotification(rogue);
            rogue.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_ROGUE);
            rogue.levelUp();
        }
    }

    @Override
    public void applyBuff(final Wizard wizard) {
        if (!wizard.isDead()) {
            sendHelpedNotification(wizard);
            wizard.getBuff().increaseBuff(Constants.LEVEL_UP_ANGEL_DAMAGE_BONUS_WIZARD);
            wizard.levelUp();
        }
    }

    public String getType() {
        return Constants.LEVEL_UP_ANGEL;
    }
}
