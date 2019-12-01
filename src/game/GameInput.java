/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import game.resources.heroes.Hero;

import java.util.ArrayList;

public final class GameInput {
    private ArrayList<String> map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> rounds;

    public GameInput(final ArrayList<String> map, final ArrayList<Hero> heroes,
                     final ArrayList<String> rounds) {
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
