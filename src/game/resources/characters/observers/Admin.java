/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.observers;

import game.output.GameOutput;
import game.resources.characters.observers.interfaces.Observer;

public class Admin implements Observer {
    GameOutput gameOutput;

    public Admin(GameOutput gameOutput) {
        this.gameOutput = gameOutput;
    }

    public void receiveNotification(String message) {
        gameOutput.addLine(message);
    }
}
