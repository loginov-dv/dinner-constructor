package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Класс, который содержит основную логику по хранению блюд и генерации комбинаций
public class DinnerConstructor {
    public HashMap<String, ArrayList<String>> dishes;
    private final Random random;

    DinnerConstructor() {
        dishes = new HashMap<>();
        random = new Random();
    }

    // Метод, проверяющий наличие типа блюда в хеш-таблице
    public boolean checkType(String type) {
        return dishes.containsKey(type);
    }

    // Метод, добавляющий новое блюдо в хеш-таблицу
    public void addNewDish(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            ArrayList<String> dishesByType = dishes.get(dishType);
            dishesByType.add(dishName);
        } else {
            ArrayList<String> dishesByType = new ArrayList<>();
            dishesByType.add(dishName);
            dishes.put(dishType, dishesByType);
        }
    }

    // Метод, возвращающий список возможных комбинаций обедов
    public ArrayList<ArrayList<String>> generateDishCombo(int numberOfCombos, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> dishCombos = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();

            for (String type : dishTypes) {
                // наличие ключа уже проверили в Main с помощью метода checkType, поэтому здесь не проверяем
                ArrayList<String> dishesByType = dishes.get(type);
                String randomDish = dishesByType.get(random.nextInt(dishesByType.size()));
                combo.add(randomDish);
            }

            dishCombos.add(combo);
        }

        return dishCombos;
    }
}
