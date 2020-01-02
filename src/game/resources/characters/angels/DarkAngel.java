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
        if (!knight.isDead()) {
            sendHitNotification(knight);
            knight.decreaseHealthPoints(Constants.DARK_ANGEL_HP_LOSS_KNIGHT);
            if (knight.isDead()) {
                sendKilledNotification(knight);
            }
        }
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            sendHitNotification(pyromancer);
            pyromancer.decreaseHealthPoints(Constants.DARK_ANGEL_HP_LOSS_PYROMANCER);
            if (pyromancer.isDead()) {
                sendKilledNotification(pyromancer);
            }
        }
    }

    @Override
    public void applyBuff(Rogue rogue) {
        if (!rogue.isDead()) {
            sendHitNotification(rogue);
            rogue.decreaseHealthPoints(Constants.DARK_ANGEL_HP_LOSS_ROGUE);
            if (rogue.isDead()) {
                sendKilledNotification(rogue);
            }
        }
    }

    @Override
    public void applyBuff(Wizard wizard) {
        if (!wizard.isDead()) {
            sendHitNotification(wizard);
            wizard.decreaseHealthPoints(Constants.DARK_ANGEL_HP_LOSS_WIZARD);
            if (wizard.isDead()) {
                sendKilledNotification(wizard);
            }
        }
    }

    public String getType() {
        return Constants.DARK_ANGEL;
    }
}
