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

public final class Dracula extends Angel {
    public Dracula(final int line, final int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(final Knight knight) {
        if (!knight.isDead()) {
            sendHitNotification(knight);
            knight.decreaseHealthPoints(Constants.DRACULA_HP_BONUS_KNIGHT);
            knight.getBuff().decreaseBuff(Constants.DRACULA_DAMAGE_BONUS_KNIGHT);
            if (knight.isDead()) {
                sendKilledNotification(knight);
            }
        }
    }

    @Override
    public void applyBuff(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            sendHitNotification(pyromancer);
            pyromancer.decreaseHealthPoints(Constants.DRACULA_HP_BONUS_PYROMANCER);
            pyromancer.getBuff().decreaseBuff(Constants.DRACULA_DAMAGE_BONUS_PYROMANCER);
            if (pyromancer.isDead()) {
                sendKilledNotification(pyromancer);
            }
        }
    }

    @Override
    public void applyBuff(final Rogue rogue) {
        if (!rogue.isDead()) {
            sendHitNotification(rogue);
            rogue.decreaseHealthPoints(Constants.DRACULA_HP_BONUS_ROGUE);
            rogue.getBuff().decreaseBuff(Constants.DRACULA_DAMAGE_BONUS_ROGUE);
            if (rogue.isDead()) {
                sendKilledNotification(rogue);
            }
        }
    }

    @Override
    public void applyBuff(final Wizard wizard) {
        if (!wizard.isDead()) {
            sendHitNotification(wizard);
            wizard.decreaseHealthPoints(Constants.DRACULA_HP_BONUS_WIZARD);
            wizard.getBuff().decreaseBuff(Constants.DRACULA_DAMAGE_BONUS_WIZARD);
            if (wizard.isDead()) {
                sendKilledNotification(wizard);
            }
        }
    }

    public String getType() {
        return Constants.DRACULA;
    }
}
