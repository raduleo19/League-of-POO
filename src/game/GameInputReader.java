/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

public class GameInputReader {
    private String inputFileName;

    public GameInputReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public GameInput getGameInput() {
        return new GameInput();
    }
}
