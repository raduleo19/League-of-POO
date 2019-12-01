/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.overtime;

public final class Overtime {
    private int time;
    private int damage;
    private boolean stun;

    public Overtime(final int time, final int damage, final boolean stun) {
        this.time = time;
        this.damage = damage;
        this.stun = stun;
    }

    public int getTime() {
        return time;
    }

    public void setTime(final int time) {
        this.time = time;
    }

    public int getDamage() {
        return damage;
    }

    public boolean getStun() {
        return stun;
    }
}
