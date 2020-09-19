import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array  = input.split(" ");
        long firstNumber = Long.parseLong(array[0]);
        String operation = array[1];
        long secondNumber = Long.parseLong(array[2]);
        switch (operation) {
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "/":
                if (secondNumber == 0) {
                    System.out.println("Division by 0!");
                } else System.out.println(firstNumber / secondNumber);
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}