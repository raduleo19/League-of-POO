/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package main;

import game.Game;
import game.GameInput;
import game.GameInputReader;
import game.GameOutput;
import game.GameOutputWriter;

import java.io.IOException;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) throws IOException {
        GameInputReader gameInputReader = new GameInputReader(args[0]);
        GameInput gameInput = gameInputReader.getGameInput();
        Game game = new Game(gameInput);
        game.play();
        GameOutput gameOutput = game.getGameOutput();
        GameOutputWriter gameOutputWriter = new GameOutputWriter(gameOutput);
        gameOutputWriter.printToFile(args[1]);
        gameOutputWriter.printToConsole();
    }
}
