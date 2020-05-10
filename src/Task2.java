/*
Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное) и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
*/

import java.util.Scanner;

public class Task2 {
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        String input1 = scanner.nextLine();
        System.out.print("Введите второе целое число: ");
        String input2 = scanner.nextLine();
        try {
            int number1, number2;
            number1 = Integer.parseInt(input1);
            number2 = Integer.parseInt(input2);
            int NOD = calculateNOD(number1, number2);
            int NOK = calculateNOK(number1, number2, NOD);
            System.out.println("Для чисел " + number1 + " и " + number2 + " НОД = " + NOD + ", а НОК = " + NOK);
        } catch (NumberFormatException e) {
            System.out.print("Введенные данные не верны");
        }
    }

    private int calculateNOD(int number1, int number2) {
        return number2 == 0 ? number1 : calculateNOD(number2, number1 % number2);
    }

    private int calculateNOK(int number1, int number2, int NOD) {
        return number1 / NOD * number2;
    }
}
