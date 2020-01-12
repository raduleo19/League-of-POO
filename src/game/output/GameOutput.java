/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.output;

import java.util.ArrayList;

public final class GameOutput {
    private ArrayList<String> output;

    public GameOutput() {
        this.output = new ArrayList<>();
    }

    public void addLine(final String message) {
        output.add(message);
    }

    public ArrayList<String> getOutput() {
        return output;
    }
}
