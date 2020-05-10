/*
Создать программу, которая будет сообщать, является ли целое число, введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.
*/

import java.util.Scanner;

public class Task1 {
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        String input = scanner.nextLine();
        try {
            int number;
            number = Integer.parseInt(input);
            String isOdd = isOddString(number);
            String isComplex = isComplexString(number);
            System.out.println("Число " + number + " " + isOdd + " и " + isComplex);
        } catch (NumberFormatException e) {
            System.out.print("Введенные данные не верны");
        }
    }

    private String isComplexString(int number) {
        for (int i = 2; i< number; i++){
            if (number%i ==0){
                return "сложное";
            }
        }
        return "простое";
    }

    private String isOddString(int number) {
        String result;
        if (number % 2 == 0) {
            result = "четное";
        } else {
            result = "нечетное";
        }
        return result;
    }

}
