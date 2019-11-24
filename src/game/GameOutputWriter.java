/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import fileio.implementations.FileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class GameOutputWriter {
    ArrayList<String> gameOutput;

    public GameOutputWriter(GameOutput gameOutput) {
        this.gameOutput = gameOutput.getOutput();
    }

    public void printToFile(String outputFileName) throws IOException {
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
