import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String output = "";
        StringBuilder stringBuilder = new StringBuilder();
        int length = input.length();
        ArrayList<Character> list = toCharList(input);
        if (length % 2 == 1) {
            list.remove(length / 2);
            list.forEach(stringBuilder::append);
            output = stringBuilder.toString();
        } else {
            list.remove(list.size() / 2);
            list.remove(list.size() / 2);
            list.forEach(stringBuilder::append);
            output = stringBuilder.toString();
        }
        System.out.println(output);
    }


    private static ArrayList<Character> toCharList(String input) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        return list;
    }
}