/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package main;

import game.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInputReader gameInputReader = new GameInputReader(args[0]);
        GameInput gameInput = gameInputReader.getGameInput();

        // TO DO: Use gameInput
        Game game = new Game(args[0], args[1]);
        game.load();
        game.run();

        GameOutput gameOutput = game.getGameOutput();
        GameOutputWriter gameOutputWriter = new GameOutputWriter(gameOutput);
        gameOutputWriter.printToFile(args[1]);
        gameOutputWriter.printToConsole();
    }
}
