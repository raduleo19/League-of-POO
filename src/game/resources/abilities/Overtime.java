/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.abilities;

public class Overtime {
    private int time;
    private int damage;
    private boolean paralisys;

    public Overtime(int time, int damage, boolean paralisys) {
        this.time = time;
        this.damage = damage;
        this.paralisys = paralisys;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isParalisys() {
        return paralisys;
    }

    public void setParalisys(boolean paralisys) {
        this.paralisys = paralisys;
    }
}
