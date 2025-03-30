package ru.practicum.dinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    public HashMap<String, ArrayList<String>> dinners;

    DinnerConstructor() {
        dinners = new HashMap<>();
    }

    public boolean checkType(String type) {
        return dinners.containsKey(type);
    }

    public void addNewDish(String type, String name) {
        if (dinners.containsKey(type)) {
            ArrayList<String> dinnersByType = dinners.get(type);
            dinnersByType.add(name);
        } else {
            ArrayList<String> names = new ArrayList<>();
            names.add(name);
            dinners.put(type, names);
        }
    }
}
