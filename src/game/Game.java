/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import heroes.Hero;
import map.Map;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> rounds;
    private ArrayList<Hero> heroes;

    public Game(GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        rounds = gameInput.getRounds();
    }

    public void run() {
        for (int round = 0; round < rounds.size(); ++round) {
            for (int hero = 0; hero < heroes.size(); ++hero) {
                heroes.get(hero).move(rounds.get(round).charAt(hero));
            }
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
