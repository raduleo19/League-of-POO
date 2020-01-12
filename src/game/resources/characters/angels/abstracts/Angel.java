/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels.abstracts;

import game.resources.characters.angels.interfaces.IAngelObservable;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.knight.Knight;
import game.resources.characters.heroes.pyromancer.Pyromancer;
import game.resources.characters.heroes.rogue.Rogue;
import game.resources.characters.heroes.wizard.Wizard;
import game.resources.characters.observers.interfaces.IObserver;

public abstract class Angel implements IAngelObservable {
    protected int line;
    protected int column;
    protected IObserver observer;

    public Angel(final int line, final int column) {
        this.line = line;
        this.column = column;
        observer = null;
    }

    public final int getLine() {
        return line;
    }

    public final int getColumn() {
        return column;
    }

    public abstract void applyBuff(Knight knight);

    public abstract void applyBuff(Pyromancer pyromancer);

    public abstract void applyBuff(Rogue rogue);

    public abstract void applyBuff(Wizard wizard);

    public abstract String getType();

    public final void setObserver(final IObserver observer) {
        this.observer = observer;
    }

    public final void sendSpawnedNotification() {
        observer.receiveNotification(
                String.format("Angel %s was spawned at %d %d", getType(), getLine(),
                        getColumn()));
    }

    public final void sendHelpedNotification(final Hero hero) {
        observer.receiveNotification(
                String.format("%s helped %s", getType(), hero.toString()));
    }

    public final void sendHitNotification(final Hero hero) {
        observer.receiveNotification(
                String.format("%s hit %s", getType(), hero.toString()));
    }

    public final void sendKilledNotification(final Hero hero) {
        observer.receiveNotification(
                String.format("Player %s was killed by an angel", hero.toString()));
    }

    public final void sendResurrectedNotification(final Hero hero) {
        observer.receiveNotification(
                String.format("Player %s was brought to life by an angel", hero.toString()));
    }
}
