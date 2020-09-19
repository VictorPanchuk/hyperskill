import java.util.Scanner;

public class Main {
    public static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        char[] toChars = input.toCharArray();
        int maxVowelsSequence = 0;
        int maxConsonantSequence = 0;

        int counter = 0;

        for (char toChar : toChars) {
            if (isVowel(toChar)) {
                maxVowelsSequence++;
                maxConsonantSequence = 0;
                if (maxVowelsSequence > 2) {
                    counter++;
                    maxVowelsSequence = 1;
                }
            } else {
                maxConsonantSequence++;
                maxVowelsSequence = 0;
                if (maxConsonantSequence > 2) {
                    counter++;
                    maxConsonantSequence = 1;
                }
            }
        }
        System.out.println(counter);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char letter) {
        char toLowerCase = Character.toLowerCase(letter);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char element : vowels) {  // ищем среди массива гласных
            if (toLowerCase == element) {
                return true;
            }
        }
        return false;
    }
}