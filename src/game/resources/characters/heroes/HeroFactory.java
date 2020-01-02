/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.common.Constants;

public final class HeroFactory {
    private static HeroFactory instance = new HeroFactory();

    private HeroFactory() {

    }

    public static HeroFactory getInstance() {
        return instance;
    }

    public Hero getHero(final String type, final int line, final int column, int id) {
        if (type.equals(Constants.KNIGHT)) {
            return new Knight(line, column, id);
        } else if (type.equals(Constants.PYROMANCER)) {
            return new Pyromancer(line, column, id);
        } else if (type.equals(Constants.ROGUE)) {
            return new Rogue(line, column, id);
        } else if (type.equals(Constants.WIZARD)) {
            return new Wizard(line, column, id);
        }
        return null;
    }
}
