import java.text.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        SimpleDateFormat oldSDF = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat newSDF = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = oldSDF.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(newSDF.format(date));
    }
}