import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = sc.nextInt();
        int day = sc.nextInt();

        int n = 0;

        for (int i = 0; i < month - 1; i++) {
            n += months[i];
        }

        n += day;

        System.out.println(days[n % 7]);
    }
}