/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import game.input.GameInput;
import game.output.GameOutput;
import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.characters.observers.Admin;
import game.resources.characters.observers.interfaces.Observer;
import game.resources.common.Constants;
import game.resources.map.Map;

import java.util.ArrayList;

public final class Game {
    private Observer observer;
    private GameOutput gameOutput;
    private ArrayList<String> rounds;
    private ArrayList<Hero> heroes;
    private ArrayList<ArrayList<Angel>> angels;

    public Game(final GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        rounds = gameInput.getRounds();
        angels = gameInput.getAngels();
        gameOutput = new GameOutput();
        observer = new Admin(gameOutput);
    }

    public void fight(final Hero hero1, final Hero hero2) {
        hero1.attack(hero2);
        hero2.attack(hero1);

        if (hero1.isDead() && !hero2.isDead()) {
            gameOutput.addLine(String.format("Player %s was killed by %s", hero1.toString(),
                    hero2.toString()));
            int experiencePointsGain = Math.max(0, Constants.BASE_GAIN_EXPERIENCE
                    - (hero1.getLevel() - hero2.getLevel()) * Constants.GAIN_EXPERIENCE_MULTIPLIER);
            hero2.gainExperience(experiencePointsGain);
        } else if (!hero1.isDead() && hero2.isDead()) {
            gameOutput.addLine(String.format("Player %s was killed by %s", hero2.toString(),
                    hero1.toString()));
            int experiencePointsGain = Math.max(0, Constants.BASE_GAIN_EXPERIENCE
                    - (hero2.getLevel() - hero1.getLevel()) * Constants.GAIN_EXPERIENCE_MULTIPLIER);
            hero1.gainExperience(experiencePointsGain);
        }

        if (hero1.isDead() && hero2.isDead()) {
            gameOutput.addLine(String.format("Player %s was killed by %s", hero2.toString(),
                    hero1.toString()));
            gameOutput.addLine(String.format("Player %s was killed by %s", hero1.toString(),
                    hero2.toString()));
        }
    }

    public void play() {
        for (Hero hero : heroes) {
            hero.setObserver(observer);
        }

        for (int i = 0; i < rounds.size(); ++i) {
            gameOutput.addLine(String.format("~~ Round %d ~~", i + 1));
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
                angel.setObserver(observer);
                angel.sendSpawnedNotification();
                for (Hero hero : heroes) {
                    if (hero.collide(angel)) {
                        hero.requestBuff(angel);
                    }
                }
            }
            gameOutput.addLine("");
        }

        gameOutput.addLine("~~ Results ~~");
        for (Hero hero : heroes) {
            gameOutput.addLine(hero.getStats());
        }
    }

    public GameOutput getGameOutput() {
        return gameOutput;
    }
}
