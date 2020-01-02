/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.interfaces;

import game.resources.characters.heroes.abstracts.Hero;

public interface IHeroObservable {
    void sendLevelUpNotification();

    void sendKilledNotification(Hero other);
}
