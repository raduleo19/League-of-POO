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

    public void battle(Hero hero1, Hero hero2) {
        int totalDamage1 = hero1.getTotalDamage(hero2);
        int totalDamage2 = hero2.getTotalDamage(hero1);

        hero2.receiveDamage(totalDamage1);
        hero1.receiveDamage(totalDamage2);

        int rawDamage1 = hero1.getRawDamage(hero2);
        int rawDamage2 = hero2.getRawDamage(hero1);

        // DEFLECT

        if (hero1.isDead() && !hero2.isDead()) {
            hero2.gainExperience(hero1.getLevel());
        }
        if (!hero1.isDead() && hero2.isDead()) {
            hero1.gainExperience(hero2.getLevel());
        }
    }

    public void run() {
        for (int round = 0; round < rounds.size(); ++round) {
            for (int hero = 0; hero < heroes.size(); ++hero) {
                heroes.get(hero).move(rounds.get(round).charAt(hero));
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
