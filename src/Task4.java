/*
Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
Текст и слово вводится вручную.
*/

import java.util.Scanner;

public class Task4 {
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите предложение (разделитель - пробел): ");
        String inputText = scanner.nextLine();
        if (inputText.length() < 1){
            System.out.println("В предложении должна быть как минимум 1 буква");
            return;
        }
        System.out.print("Введите слово: ");
        String inputWord = scanner.nextLine();
        if (inputWord.length() < 1){
            System.out.println("В слове должна быть как минимум 1 буква");
            return;
        }
        int counter =0;
        String[] words = inputText.split(" ");
        for (String word : words){
            if (word.toUpperCase().equals(inputWord.toUpperCase())){
                counter++;
            }
        }
        System.out.println("Без учета регистра слово \"" + inputWord + "\" встречается " + counter + " раз(а)");
    }
}
