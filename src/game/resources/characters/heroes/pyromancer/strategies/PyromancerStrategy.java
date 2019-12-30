/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.pyromancer.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.Strategy;

public class PyromancerStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        if (hero.getMaxHealthPoints() / 4 < hero.getHealthPoints()
                && hero.getHealthPoints() < hero.getMaxHealthPoints() / 3) {
            hero.setHealthPoints(Math.round(hero.getHealthPoints() * 3 / 4));
            hero.getBuff().increaseBuff(0.7f);
        } else if (hero.getHealthPoints() <= hero.getMaxHealthPoints() / 4) {
            hero.setHealthPoints(Math.round(hero.getHealthPoints() * 4 / 3));
            hero.getBuff().decreaseBuff(0.3f);
        }
    }
}
