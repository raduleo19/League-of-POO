/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package map;

import java.util.ArrayList;

public class Map {
    private static Map instance = new Map();
    private ArrayList<String> map;

    private Map() {
        map = new ArrayList<>();
    }

    public static Map getInstance() {
        return instance;
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public void setMap(ArrayList<String> map) {
        this.map = map;
    }

    public char getLandType(int line, int column) {
        return map.get(line).charAt(column);
    }

}
