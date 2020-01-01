/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels.abstracts;

import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.characters.observers.interfaces.Observer;

public abstract class Angel {
    protected int line;
    protected int column;
    protected Observer observer;

    public Angel(int line, int column) {
        this.line = line;
        this.column = column;
        observer = null;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public abstract void applyBuff(Knight knight);

    public abstract void applyBuff(Pyromancer pyromancer);

    public abstract void applyBuff(Rogue rogue);

    public abstract void applyBuff(Wizard wizard);

    public abstract String getType();

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void sendSpawnedNotification() {
        observer.receiveNotification(
                String.format("Angel %s was spawned at %d %d", getType(), getLine(),
                        getColumn()));
    }

    public void sendHelpedNotification(Hero hero) {
        observer.receiveNotification(
                String.format("%s helped %s", getType(), hero.toString()));
    }

    public void sendHitNotification(Hero hero) {
        observer.receiveNotification(
                String.format("%s hit %s", getType(), hero.toString()));
    }

    public void sendKilledNotification(Hero hero) {
        observer.receiveNotification(
                String.format("Player %s was killed by an angel", hero.toString()));
    }

    public void sendResurrectedNotification(Hero hero) {
        observer.receiveNotification(
                String.format("Player %s was brought to life by an angel", hero.toString()));
    }
}
