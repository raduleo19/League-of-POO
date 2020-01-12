/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.shared.abilities;

public final class Buff {
    private float buff;

    public Buff() {
        buff = 0;
    }

    public float getBuff() {
        return buff;
    }

    public void increaseBuff(final float buff) {
        this.buff += buff;
    }

    public void decreaseBuff(final float buff) {
        this.buff -= buff;
    }
}
