package map;

import java.util.ArrayList;

public class Map {
    private static Map instance = new Map();
    private ArrayList<String> map;

    private Map() {

    }

    public static Map getInstance() {
        return instance;
    }

    public void load(ArrayList<String> map) {
        this.map = new ArrayList<>(map);
    }

    public char getCell(int x, int y) {
        return map.get(x).charAt(y);
    }

}
