/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.pyromancer.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.IStrategy;

public class PyromancerStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero hero) {
        if (hero.getMaxHealthPoints() / 4 < hero.getHealthPoints()
                && hero.getHealthPoints() < hero.getMaxHealthPoints() / 3) {
            if (hero.getId() == 35) {
                System.out.println("ACTIVE");
            }
            hero.setHealthPoints(hero.getHealthPoints() - (hero.getHealthPoints() / 4));
            hero.getBuff().increaseBuff(0.7f);
        } else if (hero.getHealthPoints() < hero.getMaxHealthPoints() / 4) {
            if (hero.getId() == 35) {
                System.out.println("PASSIVE");
            }
            hero.setHealthPoints(hero.getHealthPoints() + (hero.getHealthPoints() / 3));
            hero.getBuff().decreaseBuff(0.3f);
        }
    }
}
