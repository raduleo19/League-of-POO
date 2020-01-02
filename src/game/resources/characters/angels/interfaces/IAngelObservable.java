/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.angels.interfaces;

import game.resources.characters.heroes.abstracts.Hero;

public interface IAngelObservable {
    void sendSpawnedNotification();

    void sendHelpedNotification(Hero hero);

    void sendHitNotification(Hero hero);

    void sendKilledNotification(Hero hero);

    void sendResurrectedNotification(Hero hero);
}
