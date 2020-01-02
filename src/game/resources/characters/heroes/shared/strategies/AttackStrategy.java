/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.shared.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.IStrategy;

public class AttackStrategy implements IStrategy {
    private int healthPointsPercent;
    private float buffPercent;

    public AttackStrategy(int healthPointsPercent, float buffPercent) {
        this.healthPointsPercent = healthPointsPercent;
        this.buffPercent = buffPercent;
    }

    @Override
    public void applyStrategy(Hero hero) {
        hero.setHealthPoints(
                hero.getHealthPoints() - (hero.getHealthPoints() / healthPointsPercent));
        hero.getBuff().increaseBuff(buffPercent);
    }
}
