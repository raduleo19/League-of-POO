/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.abstracts;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.interfaces.IHeroObservable;
import game.resources.characters.heroes.interfaces.IStrategy;
import game.resources.characters.heroes.shared.abilities.Buff;
import game.resources.characters.heroes.shared.abilities.Overtime;
import game.resources.characters.heroes.shared.strategies.NormalStrategy;
import game.resources.characters.observers.interfaces.IObserver;
import game.resources.common.Constants;
import game.resources.map.Map;

import java.util.ArrayList;

public abstract class Hero implements IHeroObservable {
    protected int id;
    protected int line;
    protected int column;
    protected int level;
    protected int healthPoints;
    protected int baseHealthPoints;
    protected int bonusHealthPoints;
    protected int experiencePoints;
    protected ArrayList<Ability> abilities;
    protected Buff buff;
    protected Overtime overtime;
    protected IStrategy strategy;
    protected IObserver observer;

    protected Hero(final int line, final int column, final int baseHealthPoints,
                   final int bonusHealthPoints, final int id) {
        this.abilities = new ArrayList<>();
        this.experiencePoints = 0;
        this.baseHealthPoints = baseHealthPoints;
        this.healthPoints = baseHealthPoints;
        this.level = 0;
        this.bonusHealthPoints = bonusHealthPoints;
        this.line = line;
        this.column = column;
        this.overtime = new Overtime(0, 0, false);
        this.strategy = new NormalStrategy();
        this.buff = new Buff();
        this.id = id;
    }

    public final void setObserver(final IObserver observer) {
        this.observer = observer;
    }

    public abstract void selectStrategy();

    public final void applyStrategy() {
        selectStrategy();
        strategy.applyStrategy(this);
    }

    @Override
    public abstract String toString();

    public abstract String getStats();

    public abstract float getLandModifier();

    public abstract float requestRaceModifier(Ability ability);

    public abstract void requestBuff(Angel angel);

    public final boolean collide(final Hero other) {
        return this.line == other.line && this.column == other.column;
    }

    public final boolean collide(final Angel other) {
        return this.line == other.getLine() && this.column == other.getColumn();
    }

    public final void move(final char direction) {
        if (direction == Constants.UP) {
            line--;
        } else if (direction == Constants.DOWN) {
            line++;
        } else if (direction == Constants.LEFT) {
            column--;
        } else if (direction == Constants.RIGHT) {
            column++;
        }
    }

    public final boolean isDead() {
        return healthPoints <= 0;
    }

    public final boolean isStunned() {
        return overtime.getStun() && overtime.getTime() > 0;
    }

    public void attack(final Hero other) {
        int damage = 0;
        int rawDamage = 0;

        for (Ability ability : abilities) {
            float abilityRawDamage = ability.getDamage(other);

            float newModifier = 1.0f;
            if (other.requestRaceModifier(ability) != 1.0f) {
                newModifier = other.requestRaceModifier(ability)
                        + buff.getBuff();
            }

            float abilityDamage = Math.round(Math.round(abilityRawDamage) * this
                    .getLandModifier()) * newModifier;

            rawDamage += Math.round(abilityRawDamage * this.getLandModifier());
            damage += Math.round(abilityDamage);
        }

        other.receiveDamage(damage);

        int deflectionDamage = other.getDeflectionDamage(this, rawDamage);
        this.receiveDamage(deflectionDamage);
    }

    public final int getDeflectionDamage(final Hero other, final int receivedRawDamage) {
        int damage = 0;

        for (Ability ability : abilities) {
            if (other.requestRaceModifier(ability) != 0.0f) {
                damage += Math.round(
                        ability.getDeflectionDamage(other, receivedRawDamage)
                                * this.getLandModifier() * (other.requestRaceModifier(ability)
                                + buff.getBuff()));
            }
        }

        return damage;
    }

    public final int getMaxHealthPoints() {
        return this.baseHealthPoints + this.level * this.bonusHealthPoints;
    }

    public final int getHealthPoints() {
        return healthPoints;
    }

    public final void setHealthPoints(final int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public final int getMaxExperiencePoints() {
        return Constants.BASE_EXPERIENCE + this.level * Constants.EXPERIENCE_MULTIPLIER;
    }

    public final void receiveLevelBonus() {
        this.level++;
        sendLevelUpNotification();
        if (!this.isDead()) {
            this.healthPoints = this.getMaxHealthPoints();
        }

    }

    public final void sendLevelUpNotification() {
        observer.receiveNotification(
                String.format("%s reached level %d", this.toString(), this.getLevel()));
    }

    public final void sendKilledNotification(final Hero other) {
        observer.receiveNotification(String.format("Player %s was killed by %s", other.toString(),
                this.toString()));
    }

    public final void levelUp() {
        setExperiencePoints(getMaxExperiencePoints());
        receiveLevelBonus();
    }

    public final void setExperiencePoints(final int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public final int getLevel() {
        return level;
    }

    public final void receiveDamage(final int damage) {
        this.healthPoints -= damage;
    }

    public final void gainExperience(final int value) {
        experiencePoints += value;
        while (this.experiencePoints >= this.getMaxExperiencePoints()) {
            this.receiveLevelBonus();
        }
    }

    public final void setOvertime(final int time, final boolean stun, final int damage) {
        this.overtime = new Overtime(time, damage, stun);
    }

    public final void applyOvertime() {
        if (overtime.getTime() > 0) {
            overtime.setTime(overtime.getTime() - 1);
            this.receiveDamage(overtime.getDamage());
        }
    }

    public final char getLandType() {
        return Map.getInstance().getLandType(this.line, this.column);
    }

    public final Buff getBuff() {
        return buff;
    }

    public final void increaseHealthPoints(final int value) {
        healthPoints = Math.min(getMaxHealthPoints(), healthPoints + value);
    }

    public final void decreaseHealthPoints(final int value) {
        healthPoints -= value;
    }
}
