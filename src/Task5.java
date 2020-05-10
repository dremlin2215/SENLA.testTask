/*
Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы (зеркальное значение равно оригинальному).
Длина последовательности N вводится вручную и не должна превышать 100.
*/

import java.util.Scanner;

public class Task5 {
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число (от 0 до 100): ");
        String input = scanner.nextLine();
        try {
            int number;
            number = Integer.parseInt(input);
            if (number >100 ){
                throw new NumberFormatException("Число больше 100"); // По условиям задачи. Работать будет с N <= Integer.MAXVALUE
            }
            StringBuilder builder = new StringBuilder();
            builder.append("Результат: ");
            for (int i =0; i<=number; i++){
                if (isPalindrome(i)){
                    builder.append(i).append(" ");
                }
            }
            System.out.println(builder.toString());
        } catch (NumberFormatException e) {
            System.out.print("Введенные данные не верны");
        }


    }

    private boolean isPalindrome(int input) {
        if (input < 10) {
            return true;
        }
        char[] array = String.valueOf(input).toCharArray();
        int leftSide = 0;
        int rightSide = array.length - 1;
        boolean result = true;
        while (rightSide - leftSide >= 1) {
            if (array[leftSide] != array[rightSide]) {
                result = false;
                break;
            }
            rightSide--;
            leftSide++;
        }
        return  result;
    }
}
