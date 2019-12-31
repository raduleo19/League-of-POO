/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game;

import game.input.GameInput;
import game.output.GameOutput;
import game.resources.characters.admin.Admin;
import game.resources.characters.angels.abstracts.Angel;
import game.resources.characters.heroes.abstracts.Hero;
import game.resources.common.Constants;
import game.resources.map.Map;

import java.util.ArrayList;

public final class Game {
    private Admin admin;
    private ArrayList<String> rounds;
    private ArrayList<Hero> heroes;
    private ArrayList<ArrayList<Angel>> angels;

    public Game(final GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        rounds = gameInput.getRounds();
        angels = gameInput.getAngels();
        admin = new Admin();
    }

    public void fight(final Hero hero1, final Hero hero2) {
        hero1.attack(hero2);
        hero2.attack(hero1);

        if (hero1.isDead() && !hero2.isDead()) {
            int experiencePointsGain = Math.max(0, Constants.BASE_GAIN_EXPERIENCE
                    - (hero1.getLevel() - hero2.getLevel()) * Constants.GAIN_EXPERIENCE_MULTIPLIER);
            hero2.gainExperience(experiencePointsGain);
        } else if (!hero1.isDead() && hero2.isDead()) {
            int experiencePointsGain = Math.max(0, Constants.BASE_GAIN_EXPERIENCE
                    - (hero2.getLevel() - hero1.getLevel()) * Constants.GAIN_EXPERIENCE_MULTIPLIER);
            hero1.gainExperience(experiencePointsGain);
        }
    }

    public void sendRoundStartedNotification(int round, Admin admin) {
        admin.receiveNotification(String.format("~~ Round %d ~~", round));
    }

    public void sendRoundEndedNotification(Admin admin) {
        admin.receiveNotification("");
    }

    public void sendSpawnedNotification(Angel angel, Admin admin) {
        admin.receiveNotification(
                String.format("Angel %s was spawned at %d %d", angel.getType(), angel.getLine(),
                        angel.getColumn()));
    }

    public void play() {
        for (int i = 0; i < rounds.size(); ++i) {
            sendRoundStartedNotification(i + 1, admin);
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
                sendSpawnedNotification(angel, admin);
                for (Hero hero : heroes) {
                    if (hero.collide(angel) && !hero.isDead()) {
                        hero.requestBuff(angel);
                    }
                }
            }
            sendRoundEndedNotification(admin);
        }
    }

    public ArrayList<String> getResult() {
        ArrayList<String> results = new ArrayList<>();
        results.add("~~ Results ~~");
        for (Hero hero : heroes) {
            results.add(hero.getStats());
        }
        return results;
    }

    public GameOutput getGameOutput() {
        ArrayList<String> output = new ArrayList<>(admin.getLogs());
        output.addAll(getResult());
        return new GameOutput(output);
    }
}
