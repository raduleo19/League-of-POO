/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import game.input.GameInput;
import game.output.GameOutput;
import game.resources.characters.angels.Angel;
import game.resources.characters.heroes.Hero;
import game.resources.map.Map;

import java.util.ArrayList;

public final class Game {
    private ArrayList<String> rounds;
    private ArrayList<Hero> heroes;
    private ArrayList<ArrayList<Angel>> angels;

    public Game(final GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        rounds = gameInput.getRounds();
        angels = gameInput.getAngels();
    }

    public void fight(final Hero hero1, final Hero hero2) {
        hero1.attack(hero2);
        hero2.attack(hero1);

        if (hero1.isDead()) {
            hero2.gainExperience(hero1.getLevel());
        }

        if (hero2.isDead()) {
            hero1.gainExperience(hero2.getLevel());
        }
    }

    public void play() {
        for (String round : rounds) {
            for (int i = 0; i < heroes.size(); ++i) {
                Hero hero = heroes.get(i);
                char move = round.charAt(i);
                if (!hero.isDead()) {
                    if (!hero.isStunned()) {
                        hero.move(move);
                    }
                    hero.applyOvertime();
                }
            }

            for (int i = 0; i < heroes.size(); ++i) {
                if (!heroes.get(i).isDead()) {
                    for (int j = i + 1; j < heroes.size(); ++j) {
                        if (!heroes.get(j).isDead()) {
                            if (heroes.get(i).collide(heroes.get(j))) {
                                fight(heroes.get(i), heroes.get(j));
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
