/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.map;

import java.util.ArrayList;

public final class Map {
    private static Map instance = new Map();
    private ArrayList<String> map;

    private Map() {
        map = new ArrayList<>();
    }

    public static Map getInstance() {
        return instance;
    }

    public void setMap(final ArrayList<String> map) {
        this.map = map;
    }

    public char getLandType(final int line, final int column) {
        return map.get(line).charAt(column);
    }

}
