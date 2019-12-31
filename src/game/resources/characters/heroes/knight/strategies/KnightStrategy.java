/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.knight.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.Strategy;

public class KnightStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        if (hero.getMaxHealthPoints() / 3 < hero.getHealthPoints()
                && hero.getHealthPoints() < hero.getMaxHealthPoints() / 2) {
            hero.setHealthPoints(hero.getHealthPoints() - (hero.getHealthPoints() / 5));
            hero.getBuff().increaseBuff(0.5f);
        } else if (hero.getHealthPoints() < hero.getMaxHealthPoints() / 3) {
            hero.setHealthPoints(hero.getHealthPoints() + (hero.getHealthPoints() / 4));
            hero.getBuff().decreaseBuff(0.2f);
        }
    }
}
