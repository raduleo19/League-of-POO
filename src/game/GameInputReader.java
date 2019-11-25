/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroFactory;

import java.io.IOException;
import java.util.ArrayList;

public class GameInputReader {
    private String inputPath;

    public GameInputReader(String inputPath) {
        this.inputPath = inputPath;
    }

    public GameInput getGameInput() throws IOException {
        FileReader fileReader = new FileReader(inputPath);

        ArrayList<String> map = new ArrayList<>();
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<String> rounds = new ArrayList<>();

        int numLines = fileReader.nextInt();
        int numColumns = fileReader.nextInt();

        for (int i = 0; i < numLines; ++i) {
            map.add(fileReader.nextWord());
        }

        int numHeroes = fileReader.nextInt();
        for (int i = 0; i < numHeroes; ++i) {
            heroes.add(HeroFactory.getInstance().getHero(fileReader.nextWord(), fileReader.nextInt(), fileReader.nextInt()));
        }

        int numRounds = fileReader.nextInt();
        for (int i = 0; i < numRounds; ++i) {
            rounds.add(fileReader.nextWord());
        }
        fileReader.close();
        return new GameInput(map, heroes, rounds);
    }

}
