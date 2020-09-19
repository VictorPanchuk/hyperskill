import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int integer = 1;
        List<String> outs = new ArrayList<>();
        while (integer != 0) {
            try {
                input = scanner.next();
                integer = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                outs.add("Invalid user input: " + input);
                continue;
            }
            if (integer != 0) {
                outs.add(String.valueOf(integer * 10));
            }
        }
        outs.forEach(System.out::println);
    }
}