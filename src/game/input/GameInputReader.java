/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.input;

import fileio.implementations.FileReader;
import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.angels.factory.AngelFactory;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.heroes.factory.HeroFactory;

import java.io.IOException;
import java.util.ArrayList;

public final class GameInputReader {
    private String inputPath;

    public GameInputReader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public GameInput getGameInput() throws IOException {
        FileReader fileReader = new FileReader(inputPath);

        ArrayList<String> map = new ArrayList<>();
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<String> rounds = new ArrayList<>();

        int numLines = fileReader.nextInt();
        fileReader.nextInt();

        for (int i = 0; i < numLines; ++i) {
            map.add(fileReader.nextWord());
        }

        int numHeroes = fileReader.nextInt();
        for (int i = 0; i < numHeroes; ++i) {
            heroes.add(HeroFactory.getInstance().getHero(fileReader.nextWord(),
                    fileReader.nextInt(), fileReader.nextInt(), i));
        }

        int numRounds = fileReader.nextInt();
        for (int i = 0; i < numRounds; ++i) {
            rounds.add(fileReader.nextWord());
        }

        ArrayList<ArrayList<Angel>> angels = new ArrayList<>();
        for (int i = 0; i < numRounds; ++i) {
            int numAngels = fileReader.nextInt();
            ArrayList<Angel> roundAngels = new ArrayList<>();
            for (int j = 0; j < numAngels; ++j) {
                String angel = fileReader.nextWord();
                String[] tokens = angel.split(",");
                roundAngels.add(
                        AngelFactory.getInstance().getAngel(tokens[0], Integer.parseInt(tokens[1]),
                                Integer.parseInt(tokens[2])));
            }
            angels.add(roundAngels);
        }

        fileReader.close();

        return new GameInput(map, heroes, rounds, angels);
    }

}
