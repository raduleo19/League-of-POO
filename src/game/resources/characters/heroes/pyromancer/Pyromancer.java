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
        if (this.getMaxHealthPoints() / Constants.PYROMANCER_MIN_HP < this.getHealthPoints()
                && this.getHealthPoints()
                < this.getMaxHealthPoints() / Constants.PYROMANCER_MAX_HP) {
            strategy = new AttackStrategy(Constants.PYROMANCER_ATTACK_HP,
                    Constants.PYROMANCER_ATTACK_BUFF);
        } else if (this.getHealthPoints()
                < this.getMaxHealthPoints() / Constants.PYROMANCER_MIN_HP) {
            strategy = new DefenseStrategy(Constants.PYROMANCER_DEFENSE_HP,
                    Constants.PYROMANCER_DEFENSE_BUFF);
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
    public void requestBuff(final Angel angel) {
        angel.applyBuff(this);
    }
}
