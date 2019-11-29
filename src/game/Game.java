/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import game.resources.heroes.Hero;
import game.resources.map.Map;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> rounds;
    private ArrayList<Hero> heroes;

    public Game(GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        rounds = gameInput.getRounds();
    }

    public void battle(Hero hero1, Hero hero2) {
        hero1.attack(hero2);
        hero2.attack(hero1);

        if (hero1.isDead()) {
            hero2.gainExperience(hero1.getLevel());
        }

        if (hero2.isDead()) {
            hero1.gainExperience(hero2.getLevel());
        }
    }

    public void run() {
        for (String round : rounds) {
            for (int hero = 0; hero < heroes.size(); ++hero) {
                if (!heroes.get(hero).isDead()) {
                    heroes.get(hero).move(round.charAt(hero));
                }
            }

            for (int hero1 = 0; hero1 < heroes.size(); ++hero1) {
                if (!heroes.get(hero1).isDead()) {
                    for (int hero2 = hero1 + 1; hero2 < heroes.size(); ++hero2) {
                        if (!heroes.get(hero2).isDead()) {
                            if (heroes.get(hero1).collide(heroes.get(hero2))) {
                                battle(heroes.get(hero1), heroes.get(hero2));
                            }
                        }
                    }
                }
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
