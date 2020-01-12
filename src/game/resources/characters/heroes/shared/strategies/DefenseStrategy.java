/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.shared.strategies;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.interfaces.IStrategy;

public final class DefenseStrategy implements IStrategy {
    private int healthPointsPercent;
    private float buffPercent;

    public DefenseStrategy(final int healthPointsPercent, final float buffPercent) {
        this.healthPointsPercent = healthPointsPercent;
        this.buffPercent = buffPercent;
    }

    @Override
    public void applyStrategy(final Hero hero) {
        hero.setHealthPoints(
                hero.getHealthPoints() + (hero.getHealthPoints() / healthPointsPercent));
        hero.getBuff().decreaseBuff(buffPercent);
    }
}
