/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.pyromancer;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Ability;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.pyromancer.abilities.Fireblast;
import game.resources.characters.heroes.pyromancer.abilities.Ignite;
import game.resources.characters.heroes.shared.strategies.AttackStrategy;
import game.resources.characters.heroes.shared.strategies.DefenseStrategy;
import game.resources.characters.heroes.shared.strategies.NormalStrategy;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Pyromancer extends Hero {

    public Pyromancer(final int line, final int column, final int id) {
        super(line, column, Constants.INITIAL_PYROMANCER_HP, Constants.BONUS_PYROMANCER_HP, id);
        abilities.add(new Fireblast(this));
        abilities.add(new Ignite(this));
    }

    @Override
    public void selectStrategy() {
        if (this.getMaxHealthPoints() / 4 < this.getHealthPoints()
                && this.getHealthPoints() < this.getMaxHealthPoints() / 3) {
            strategy = new AttackStrategy(4, 0.7f);
        } else if (this.getHealthPoints() < this.getMaxHealthPoints() / 4) {
            strategy = new DefenseStrategy(3, 0.3f);
        } else {
            strategy = new NormalStrategy();
        }
    }

    @Override
    public String toString() {
        return "Pyromancer " + id;
    }

    public String getStats() {
        if (isDead()) {
            return Constants.PYROMANCER + " " + Constants.DEAD;
        }
        return Constants.PYROMANCER + " " + level + " " + experiencePoints + " " + healthPoints
                + " " + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.PYROMANCER_PREFERRED_LAND) {
            return Constants.PYROMANCER_LAND_MODIFIER;
        }
        return Constants.DEFAULT_LAND_MODIFIER;
    }

    @Override
    public float requestRaceModifier(final Ability ability) {
        return ability.getModifier(this);
    }

    @Override
    public void requestBuff(Angel angel) {
        angel.applyBuff(this);
    }
}
