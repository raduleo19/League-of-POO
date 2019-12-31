/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.characters.admin;

import java.util.ArrayList;

public class Admin {
    ArrayList<String> logs;

    public Admin() {
        logs = new ArrayList<>();
    }

    public void receiveNotification(String notification) {
        logs.add(notification);
    }

    public ArrayList<String> getLogs() {
        return logs;
    }
}
