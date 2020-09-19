package converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        int sourceRadix = 0;
        String sourceNumber = "";
        int targetRadix = 0;
        String output;
        try {
            sourceRadix = scanner.nextInt();
            sourceNumber = scanner.next();
            targetRadix = scanner.nextInt();
        } catch (Exception e) {
            output = "error";
            System.out.println("Output:");
            System.out.println(output);
            return;
        }
        System.out.println("Output:");

        if (targetRadix  < 1 || targetRadix > 36) {
            System.out.println("error");
            return;
        }

        try {
            output = numeralConvertor(sourceRadix, sourceNumber, targetRadix);
        } catch (NumberFormatException e) {
            output = "error";
        }
        System.out.println(output);
    }

    private static String converter(int decimal) {
        List<Integer> binary = new ArrayList<>();
        int div;

        while (decimal > 0) {
            div = decimal / 2;
            if (div > 0) {
                binary.add(decimal % 2);
            } else {
                binary.add(decimal);
            }

            decimal = div;

        }
        Collections.reverse(binary);

        String strBinary = binary.stream().map(String::valueOf).collect(Collectors.joining());

        return "0b" + strBinary;

    }

    private static String toEight(int decimal) {
        return String.valueOf(decimal % 8);
    }

    private static String simpleConverter(int decimal, int radix) {
        String prefix;
        switch (radix) {
            case 2:
                prefix = "0b";
                break;
            case 8:
                prefix = "0";
                break;
            case 16:
                prefix = "0x";
                break;
            default:
                prefix = "";
                break;
        }
        return prefix + Integer.toString(decimal, radix);
    }

    public static String numeralConvertor(Integer sourceRadix, String sourceNumber, Integer targetRadix) {
        String[] strings = sourceNumber.split("\\.");
        if (strings.length == 2) {
            String integerPart = strings[0];
            String fractionalPart = strings[1];
            return universalIntegerConverter(sourceRadix, integerPart, targetRadix) + "."
                    + fractionalConverter(sourceRadix, fractionalPart, targetRadix);
        } else return universalIntegerConverter(sourceRadix, sourceNumber, targetRadix);
    }

    private static String fractionalConverter(Integer sourceRadix, String fractionalPart, Integer targetRadix) {
        StringBuilder result = new StringBuilder();
        double decimalValue = 0;
        char[] chars = fractionalPart.toCharArray();
        for (int i = 0; i < fractionalPart.length(); i++) {
            decimalValue += Integer.parseInt(String.valueOf(chars[i]), sourceRadix) /
                    Math.pow(sourceRadix, i + 1);
        }
        for (int i = 0; i < 5; i++) {
            String[] split = String.valueOf(decimalValue * targetRadix).split("\\.");
            result.append(Integer.toString(Integer.parseInt(split[0]), targetRadix));
            decimalValue = Double.parseDouble("0." + split[1]);
        }
        return result.toString();
    }

    private static String universalIntegerConverter(Integer sourceRadix, String sourceNumber, Integer targetRadix) {
        int decimalSwap;
        String result;
        if (sourceRadix == 1) {
            decimalSwap = sourceNumber.length();
        } else {
            decimalSwap = Integer.parseInt(sourceNumber, sourceRadix);
        }

        if (targetRadix == 1) {
            result = toOnes(decimalSwap);
        } else {
            result = Integer.toString(decimalSwap, targetRadix);
        }
        return result;
    }

    private static String toOnes(int times) {
        return "1".repeat(Math.max(0, times));
    }
}
