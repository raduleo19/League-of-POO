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

public class Spawner extends Angel {
    public Spawner(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Angel " + Constants.SPAWNER + " was spawned at " + line + " " + column;
    }

    @Override
    public void applyBuff(Knight knight) {
        knight.setHealthPoints(Constants.SPAWNER_HP_KNIGHT);
    }

    @Override
    public void applyBuff(Pyromancer pyromancer) {
        pyromancer.setHealthPoints(Constants.SPAWNER_HP_PYROMANCER);
    }

    @Override
    public void applyBuff(Rogue rogue) {
        rogue.setHealthPoints(Constants.SPAWNER_HP_ROGUE);
    }

    @Override
    public void applyBuff(Wizard wizard) {
        wizard.setHealthPoints(Constants.SPAWNER_HP_WIZARD);
    }
}
