package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

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
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Такой команды нет");
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
    }

    // Метод для получения наборов обедов
    private static void generateDishCombo() {
        if (dc.dishes.isEmpty()) {
            System.out.println("В конструкторе обедов отсутствуют блюда. Необходимо добавить блюда в конструктор " +
                    "для возможности получения наборов обедов");
            return;
        }
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        if (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод, необходимо ввести число");
            // Очищаем буфер от некорректного ввода
            scanner.nextLine();
            return;
        }
        int numberOfCombos = scanner.nextInt();
        // Очищаем буфер от \n
        scanner.nextLine();

        if (numberOfCombos < 1) {
            System.out.println("Количество наборов должно быть больше нуля (было введено: " + numberOfCombos + ")");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку:");
        ArrayList<String> dishTypes = new ArrayList<>();

        while (true) {
            String nextDishType = scanner.nextLine();
            if (nextDishType.isEmpty()) {
                break;
            }

            if (dc.checkType(nextDishType)) {
                dishTypes.add(nextDishType);
            } else {
                System.out.println("Такого типа блюда нет. Попробуйте ввести другой тип:");
            }
        }

        if (dishTypes.isEmpty()) {
            System.out.println("Не было введено ни одного типа блюда. Для конструирования обеда нужно указать " +
                    "хотя бы один тип блюда");
            return;
        }

        ArrayList<ArrayList<String>> combos = dc.generateDishCombo(numberOfCombos, dishTypes);
        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combos.get(i));
        }
    }
}
