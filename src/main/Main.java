/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package main;

import game.Game;
import game.input.GameInput;
import game.input.GameInputReader;
import game.output.GameOutput;
import game.output.GameOutputWriter;

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
