import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = reverseInt(Integer.parseInt(arr[0]));
        int b = reverseInt(Integer.parseInt(arr[1]));

        int max = Math.max(a, b);

        System.out.println(max);
    }

    private static int reverseInt(int num) {
        int reversed = 0;
        
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        
        return reversed;
    }
}