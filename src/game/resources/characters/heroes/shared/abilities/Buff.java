/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.heroes.shared.abilities;

public class Buff {
    private float buff;

    public Buff() {
        buff = 0;
    }

    public float getBuff() {
        return buff;
    }

    public void setBuff(float buff) {
        this.buff = buff;
    }

    public void increaseBuff(float buff) {
        this.buff += buff;
    }

    public void decreaseBuff(float buff) {
        this.buff -= buff;
    }
}
