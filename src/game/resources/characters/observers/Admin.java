/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.observers;

import game.output.GameOutput;
import game.resources.characters.observers.interfaces.IObserver;

public final class Admin implements IObserver {
    private GameOutput gameOutput;

    public Admin(final GameOutput gameOutput) {
        this.gameOutput = gameOutput;
    }

    public void receiveNotification(final String message) {
        gameOutput.addLine(message);
    }
}
