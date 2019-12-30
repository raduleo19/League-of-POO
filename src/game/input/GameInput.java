/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.input;

import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Hero;

import java.util.ArrayList;

public final class GameInput {
    private ArrayList<String> map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> rounds;
    private ArrayList<ArrayList<Angel>> angels;

    public GameInput(final ArrayList<String> map, final ArrayList<Hero> heroes,
                     final ArrayList<String> rounds, final ArrayList<ArrayList<Angel>> angels) {
        this.map = map;
        this.heroes = heroes;
        this.rounds = rounds;
        this.angels = angels;
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

    public ArrayList<ArrayList<Angel>> getAngels() {
        return angels;
    }
}
