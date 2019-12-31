/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.wizard.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.Strategy;

public class WizardStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        if (hero.getMaxHealthPoints() / 4 < hero.getHealthPoints()
                && hero.getHealthPoints() < hero.getMaxHealthPoints() / 2) {
            hero.setHealthPoints(hero.getHealthPoints() - (hero.getHealthPoints() / 10));
            hero.getBuff().increaseBuff(0.6f);
        } else if (hero.getHealthPoints() < hero.getMaxHealthPoints() / 4) {
            hero.setHealthPoints(hero.getHealthPoints() + (hero.getHealthPoints() / 5));
            hero.getBuff().decreaseBuff(0.2f);
        }
    }
}
