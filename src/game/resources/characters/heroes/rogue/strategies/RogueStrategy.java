/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.rogue.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.Strategy;

public class RogueStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        if (hero.getMaxHealthPoints() / 7 < hero.getHealthPoints()
                && hero.getHealthPoints() < hero.getMaxHealthPoints() / 5) {
            hero.setHealthPoints(hero.getHealthPoints() - (hero.getHealthPoints() / 7));
            hero.getBuff().increaseBuff(0.4f);
        } else if (hero.getHealthPoints() < hero.getMaxHealthPoints() / 7) {
            hero.setHealthPoints(hero.getHealthPoints() + (hero.getHealthPoints() / 2));
            hero.getBuff().decreaseBuff(0.1f);
        }
    }
}
