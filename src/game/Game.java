/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroFactory;
import map.Map;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    ArrayList<String> rounds;
    private String inputPath;
    private String outputPath;

    private int numRounds;
    private int numHeroes;
    private ArrayList<Hero> heroes;

    public Game(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public void load() throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        ArrayList<String> map = new ArrayList<>();
        heroes = new ArrayList<>();
        rounds = new ArrayList<>();

        int numLines = fileReader.nextInt();
        int numColumns = fileReader.nextInt();

        for (int i = 0; i < numLines; ++i) {
            map.add(fileReader.nextWord());
        }

        Map.getInstance().setMap(map);

        numHeroes = fileReader.nextInt();
        for (int i = 0; i < numHeroes; ++i) {
            heroes.add(HeroFactory.getInstance().getHero(fileReader.nextWord(), fileReader.nextInt(), fileReader.nextInt()));
        }

        numRounds = fileReader.nextInt();
        for (int i = 0; i < numRounds; ++i) {
            rounds.add(fileReader.nextWord());
        }
        fileReader.close();
    }

    public void run() {
        for (int round = 0; round < numRounds; ++round) {
            for (int heroId = 0; heroId < numHeroes; ++heroId) {
                heroes.get(heroId).move(rounds.get(round).charAt(heroId));
            }
//            for (Hero hero1 : heroes) {
//                for (Hero hero2 : heroes) {
//                    if (hero1 != hero2) {
//                        if (!hero1.isDead() && !hero2.isDead()) {
//                            if (hero1.collide(hero2)) {
//                                hero1.attack(hero2);
//                            }
//                        }
//                    }
//                }
//            }
        }
    }

    public GameOutput getGameOutput() {
        ArrayList<String> output = new ArrayList<>();
        for (Hero hero : heroes) {
            output.add(hero.toString());
        }
        return new GameOutput(output);
    }

}
