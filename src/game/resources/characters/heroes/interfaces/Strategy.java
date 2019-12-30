/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.interfaces;

import game.resources.characters.heroes.abstracts.Hero;

public interface Strategy {
    void applyStrategy(Hero hero);
}
