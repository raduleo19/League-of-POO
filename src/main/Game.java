package main;

import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    ArrayList<String> rounds;
    private String inputPath;
    private String outputPath;
    private int numLines;
    private int numColumns;
    private ArrayList<String> map;
    private int numRounds;
    private int numHeroes;
    private ArrayList<Hero> heroes;


    public Game(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public void load() throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        numLines = fileReader.nextInt();
        numColumns = fileReader.nextInt();
        map = new ArrayList<>();
        heroes = new ArrayList<>();
        rounds = new ArrayList<>();

        for (int i = 0; i < numLines; ++i) {
            map.add(fileReader.nextWord());
        }

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
        for (int i = 0; i < numRounds; ++i) {

        }
    }
}
