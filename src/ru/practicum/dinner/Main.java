package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        random = new Random();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }

            System.out.println("-".repeat(20));
        }
    }

    // Вывод доступных для пользователя команд в консоль
    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    // Метод для добавления нового блюда
    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);

        System.out.println("Добавлено новое блюдо (тип - " + dishType + ", название - " + dishName + ")");
        System.out.println("*".repeat(10));
        System.out.println(dc.dinners);
        System.out.println("*".repeat(10));
    }

    // Метод для получения наборов обедов
    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        if (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод, необходимо ввести число");
            // Считываем некорректный ввод
            scanner.nextLine();
            return;
        }
        int numberOfCombos = scanner.nextInt();
        // Считываем \n
        scanner.nextLine();

        if (numberOfCombos < 1) {
            System.out.println("Количество наборов должно быть больше нуля (было введено: " + numberOfCombos + ")");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        //String nextItem = scanner.nextLine();
        //реализуйте ввод типов блюд
        /*while (!nextItem.isEmpty()) {
            System.out.println(nextItem);
        }*/
        ArrayList<String> dishTypes = new ArrayList<>();
        while (true) {
            String nextItem = scanner.nextLine();

            if (nextItem.isEmpty()) {
                break;
            }

            if (dc.checkType(nextItem)) {
                dishTypes.add(nextItem);
            } else {
                System.out.println("Такого типа блюда нет. Попробуйте ввести другой тип");
            }
        }

        if (dishTypes.isEmpty()) {
            System.out.println("Не было введено ни одного типа блюда. Для конструирования обеда нужно указать " +
                    "хотя бы один тип блюда");
            return;
        }

        // сгенерируйте комбинации блюд и выведите на экран
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishes = new ArrayList<>();

            System.out.println("Комбо " + (i + 1));
            for(String type : dishTypes) {
                ArrayList<String> dishesNames = dc.dinners.get(type);
                String randomDish = dishesNames.get(random.nextInt(dishesNames.size()));
                dishes.add(randomDish);
            }

            System.out.println(dishes);
        }
    }
}
