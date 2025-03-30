package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DinnerConstructor {
    public HashMap<String, ArrayList<String>> dinners;

    DinnerConstructor() {
        dinners = new HashMap<>();

        ArrayList<String> arr1 = new ArrayList<>(List.of("Солянка", "Борщ", "Уха", "Харчо"));
        dinners.put("Первое", arr1);

        ArrayList<String> arr2 = new ArrayList<>(List.of("Куриная грудка", "Свинина", "Говядина"));
        dinners.put("Мясо", arr2);

        ArrayList<String> arr3 = new ArrayList<>(List.of("Треска", "Горбуша", "Минтай"));
        dinners.put("Рыба", arr3);

        ArrayList<String> arr4 = new ArrayList<>(List.of("Греча", "Макароны", "Рис", "Картофельное пюре"));
        dinners.put("Гарнир", arr4);

        ArrayList<String> arr5 = new ArrayList<>(List.of("Компот", "Морс", "Чай", "Кофе"));
        dinners.put("Напиток", arr5);

        ArrayList<String> arr6 = new ArrayList<>(List.of("Халва", "Шоколад", "Выпечка", "Пуддинг"));
        dinners.put("Десерт", arr6);
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
