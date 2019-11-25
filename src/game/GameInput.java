/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import heroes.Hero;

import java.util.ArrayList;

public class GameInput {
    private ArrayList<String> map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> rounds;

    public GameInput(ArrayList<String> map, ArrayList<Hero> heroes, ArrayList<String> rounds) {
        this.map = map;
        this.heroes = heroes;
        this.rounds = rounds;
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }
}
