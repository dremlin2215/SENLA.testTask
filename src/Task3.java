/* Создать программу, которая будет:
        подсчитывать количество слов в предложении
        выводить их в отсортированном виде
        делать первую букву каждого слова заглавной.
        Предложение вводится вручную. (Разделитель пробел (“ ”)).

        Сортировка - естественная, то есть по индексу букв
*/
import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.util.*;

public class Task3 {
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите предложение (разделитель - пробел): ");
        String input = scanner.nextLine();
        if (input.length() < 1){
            System.out.println("В предложении должна быть как минимум 1 буква");
            return;
        }
        List<String> words = Arrays.asList(input.split(" "));
        words.removeIf(str -> str.equals(""));
        words.sort(Comparator.naturalOrder());
        for (int i =0; i< words.size(); i++){
            words.set(i, changeFirstLetter(words.get(i)));
        }
        System.out.println(words);
    }

    private String changeFirstLetter(String word) {
        char[] chars = word.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return String.valueOf(chars);
    }
}