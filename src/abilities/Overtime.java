/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package abilities;

public class Overtime {
    int time;
    int damage;
    int paralisys;

    public Overtime(int time, int damage, int paralisys) {
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

    public int getParalisys() {
        return paralisys;
    }

    public void setParalisys(int paralisys) {
        this.paralisys = paralisys;
    }
}
