/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.output;

import fileio.implementations.FileWriter;

import java.io.IOException;
import java.util.ArrayList;

public final class GameOutputWriter {
    private ArrayList<String> gameOutput;

    public GameOutputWriter(final GameOutput gameOutput) {
        this.gameOutput = gameOutput.getOutput();
    }

    public void printToFile(final String outputFileName) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFileName);
        for (String line : gameOutput) {
            fileWriter.writeWord(line);
            fileWriter.writeNewLine();
        }
        fileWriter.close();
    }

    public void printToConsole() {
        for (String line : gameOutput) {
            System.out.println(line);
        }
    }
}
