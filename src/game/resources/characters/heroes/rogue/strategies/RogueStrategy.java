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
            hero.setHealthPoints(Math.round(hero.getHealthPoints() * 6 / 7));
            hero.setBuff(hero.getBuff() + 40);
        } else if (hero.getHealthPoints() <= hero.getMaxHealthPoints() / 7) {
            hero.setHealthPoints(Math.round(hero.getHealthPoints() * 3 / 2));
            hero.setBuff(hero.getBuff() - 10);
        }
    }
}
