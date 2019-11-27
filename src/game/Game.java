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
        int totalDamage1 = hero1.getTotalDamage(hero2);
        int totalDamage2 = hero2.getTotalDamage(hero1);


//        System.out.println(totalDamage1);
//        System.out.println(totalDamage2);

        hero2.receiveDamage(totalDamage1);
        hero1.receiveDamage(totalDamage2);

        int rawDamage1 = hero1.getRawDamage(hero2);
        int rawDamage2 = hero2.getRawDamage(hero1);

        int deflectionDamage1 = hero1.getDeflectionDamage(hero2, rawDamage2);
        int deflectionDamage2 = hero2.getDeflectionDamage(hero1, rawDamage1);

//        System.out.println("========DEFLECTION==");
//        System.out.println(deflectionDamage1);
//        System.out.println(deflectionDamage2);
//        System.out.println("========END_DEF");
//        System.out.println("Total1:" + totalDamage1 + " Deflection1:" + deflectionDamage1);
//        System.out.println("Total2:" + totalDamage2 + " Deflection2:" + deflectionDamage2);


//        System.out.println(totalDamage1 + deflectionDamage1);
//        System.out.println(totalDamage2 + deflectionDamage2);

        hero2.receiveDamage(deflectionDamage1);
        hero1.receiveDamage(deflectionDamage2);

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
                if (!heroes.get(hero).isDead()) {
                    heroes.get(hero).move(rounds.get(round).charAt(hero));
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
