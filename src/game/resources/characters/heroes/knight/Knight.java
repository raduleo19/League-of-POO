/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.knight;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Ability;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.knight.abilities.Execute;
import game.resources.characters.heroes.knight.abilities.Slam;
import game.resources.characters.heroes.shared.strategies.AttackStrategy;
import game.resources.characters.heroes.shared.strategies.DefenseStrategy;
import game.resources.characters.heroes.shared.strategies.NormalStrategy;
import game.resources.common.Constants;
import game.resources.map.Map;

public final class Knight extends Hero {

    public Knight(final int line, final int column, final int id) {
        super(line, column, Constants.INITIAL_KNIGHT_HP, Constants.BONUS_KNIGHT_HP,
                id);
        abilities.add(new Execute(this));
        abilities.add(new Slam(this));
    }

    @Override
    public void selectStrategy() {
        if (this.getMaxHealthPoints() / Constants.KNIGHT_MIN_HP < this.getHealthPoints()
                && this.getHealthPoints() < this.getMaxHealthPoints() / Constants.KNIGHT_MAX_HP) {
            strategy = new AttackStrategy(Constants.KNIGHT_ATTACK_HP, Constants.KNIGHT_ATTACK_BUFF);
        } else if (this.getHealthPoints() < this.getMaxHealthPoints() / Constants.KNIGHT_MIN_HP) {
            strategy = new DefenseStrategy(Constants.KNIGHT_DEFENSE_HP,
                    Constants.KNIGHT_DEFENSE_BUFF);
        } else {
            strategy = new NormalStrategy();
        }
    }

    @Override
    public String toString() {
        return "Knight " + id;
    }

    public String getStats() {
        if (isDead()) {
            return Constants.KNIGHT + " " + Constants.DEAD;
        }
        return Constants.KNIGHT + " " + level + " " + experiencePoints + " " + healthPoints + " "
                + line + " " + column;
    }

    @Override
    public float getLandModifier() {
        if (Map.getInstance().getLandType(this.line, this.column)
                == Constants.KNIGHT_PREFERRED_LAND) {
            return Constants.KNIGHT_LAND_MODIFIER;
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
