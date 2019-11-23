package main;

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

        Map.getInstance().load(map);

        numHeroes = fileReader.nextInt();
        for (int i = 0; i < numHeroes; ++i) {
            heroes.add(HeroFactory.getInstance().getHero(fileReader.nextWord(), fileReader.nextInt(), fileReader.nextInt()));
        }

        numRounds = fileReader.nextInt();
        for (int i = 0; i < numRounds; ++i) {
            rounds.add(fileReader.nextWord());
        }
    }

    public void run() {
        for (int round = 0; round < numRounds; ++round) {
            for (int heroId = 0; heroId < numHeroes; ++heroId) {
                heroes.get(heroId).move(rounds.get(round).charAt(heroId));
            }
            for (Hero hero : heroes) {
                for (Hero hero2 : heroes) {
                    if (hero != hero2) {
                        if (!hero.isDead() && !hero2.isDead()) {
                            if (hero.collide(hero2)) {
                                hero.attack(hero2);
                            }
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (Hero hero : heroes) {
            System.out.println(hero.toString());
        }
    }

}
