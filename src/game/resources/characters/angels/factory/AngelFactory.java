/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels.factory;

import game.resources.characters.angels.DamageAngel;
import game.resources.characters.angels.DarkAngel;
import game.resources.characters.angels.Dracula;
import game.resources.characters.angels.GoodBoy;
import game.resources.characters.angels.LevelUpAngel;
import game.resources.characters.angels.LifeGiver;
import game.resources.characters.angels.SmallAngel;
import game.resources.characters.angels.Spawner;
import game.resources.characters.angels.TheDoomer;
import game.resources.characters.angels.XPAngel;
import game.resources.characters.angels.abstracts.Angel;
import game.resources.common.Constants;

public final class AngelFactory {
    private static AngelFactory instance = new AngelFactory();

    private AngelFactory() {

    }

    public static AngelFactory getInstance() {
        return instance;
    }

    public Angel getAngel(final String type, final int line, final int column) {
        if (type.equals(Constants.DAMAGE_ANGEL)) {
            return new DamageAngel(line, column);
        } else if (type.equals(Constants.DARK_ANGEL)) {
            return new DarkAngel(line, column);
        } else if (type.equals(Constants.DRACULA)) {
            return new Dracula(line, column);
        } else if (type.equals(Constants.GOOD_BOY)) {
            return new GoodBoy(line, column);
        } else if (type.equals(Constants.LEVEL_UP_ANGEL)) {
            return new LevelUpAngel(line, column);
        } else if (type.equals(Constants.LIFE_GIVER)) {
            return new LifeGiver(line, column);
        } else if (type.equals(Constants.SMALL_ANGEL)) {
            return new SmallAngel(line, column);
        } else if (type.equals(Constants.SPAWNER)) {
            return new Spawner(line, column);
        } else if (type.equals(Constants.THE_DOOMER)) {
            return new TheDoomer(line, column);
        } else if (type.equals(Constants.XP_ANGEL)) {
            return new XPAngel(line, column);
        }
        return null;
    }
}
