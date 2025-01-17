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

public final class LifeGiver extends Angel {
    public LifeGiver(final int line, final int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(final Knight knight) {
        if (!knight.isDead()) {
            sendHelpedNotification(knight);
            knight.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_KNIGHT);
        }
    }

    @Override
    public void applyBuff(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            sendHelpedNotification(pyromancer);
            pyromancer.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_PYROMANCER);
        }
    }

    @Override
    public void applyBuff(final Rogue rogue) {
        if (!rogue.isDead()) {
            sendHelpedNotification(rogue);
            rogue.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_ROGUE);
        }
    }

    @Override
    public void applyBuff(final Wizard wizard) {
        if (!wizard.isDead()) {
            sendHelpedNotification(wizard);
            wizard.increaseHealthPoints(Constants.LIFE_GIVER_HP_BONUS_WIZARD);
        }
    }

    public String getType() {
        return Constants.LIFE_GIVER;
    }
}
