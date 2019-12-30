/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import game.input.GameInput;
import game.output.GameOutput;
import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.map.Map;

import java.util.ArrayList;

public final class Game {
    private ArrayList<String> rounds;
    private ArrayList<Hero> heroes;
    private ArrayList<ArrayList<Angel>> angels;
    private ArrayList<String> output;

    public Game(final GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        rounds = gameInput.getRounds();
        angels = gameInput.getAngels();
        output = new ArrayList<>();
    }

    public void fight(final Hero hero1, final Hero hero2) {
        hero1.attack(hero2);
        hero2.attack(hero1);

        if (hero1.isDead() && !hero2.isDead()) {
            hero2.gainExperience(hero1.getLevel());
        } else if (!hero1.isDead() && hero2.isDead()) {
            hero1.gainExperience(hero2.getLevel());
        }
    }

    public void play() {
        for (int i = 0; i < rounds.size(); ++i) {
            output.add("~~ Round " + (i + 1) + " ~~");
            String round = rounds.get(i);
            for (int j = 0; j < heroes.size(); ++j) {
                Hero hero = heroes.get(j);
                char move = round.charAt(j);
                if (!hero.isDead()) {
                    hero.applyOvertime();
                    hero.applyStrategy();
                    if (!hero.isStunned()) {
                        hero.move(move);
                    }
                }
            }

            for (int j = 0; j < heroes.size(); ++j) {
                if (!heroes.get(j).isDead()) {
                    for (int k = j + 1; k < heroes.size(); ++k) {
                        if (!heroes.get(k).isDead()) {
                            if (heroes.get(j).collide(heroes.get(k))) {
                                fight(heroes.get(j), heroes.get(k));
                            }
                        }
                    }
                }
            }

            for (Angel angel : angels.get(i)) {
                output.add(angel.toString());
                for (Hero hero : heroes) {
                    if (hero.collide(angel) && !hero.isDead()) {
                        hero.requestBuff(angel);
                    }
                }
            }
            output.add("");
        }

        output.add("~~ Results ~~");
        for (Hero hero : heroes) {
            output.add(hero.toString());
        }
    }

    public GameOutput getGameOutput() {
        return new GameOutput(output);
    }
}
