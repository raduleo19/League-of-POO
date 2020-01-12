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

public final class Spawner extends Angel {
    public Spawner(final int line, final int column) {
        super(line, column);
    }

    @Override
    public void applyBuff(final Knight knight) {
        if (knight.isDead()) {
            knight.setHealthPoints(Constants.SPAWNER_HP_KNIGHT);
            sendHelpedNotification(knight);
            sendResurrectedNotification(knight);
        }
    }

    @Override
    public void applyBuff(final Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            pyromancer.setHealthPoints(Constants.SPAWNER_HP_PYROMANCER);
            sendHelpedNotification(pyromancer);
            sendResurrectedNotification(pyromancer);
        }
    }

    @Override
    public void applyBuff(final Rogue rogue) {
        if (rogue.isDead()) {
            rogue.setHealthPoints(Constants.SPAWNER_HP_ROGUE);
            sendHelpedNotification(rogue);
            sendResurrectedNotification(rogue);
        }
    }

    @Override
    public void applyBuff(final Wizard wizard) {
        if (wizard.isDead()) {
            wizard.setHealthPoints(Constants.SPAWNER_HP_WIZARD);
            sendHelpedNotification(wizard);
            sendResurrectedNotification(wizard);
        }
    }

    public String getType() {
        return Constants.SPAWNER;
    }
}
