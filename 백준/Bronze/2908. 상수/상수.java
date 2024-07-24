import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = reverseInt(Integer.parseInt(st.nextToken()));
        int b = reverseInt(Integer.parseInt(st.nextToken()));

        int max = Math.max(a, b);

        bw.write(max + "");
        bw.flush();
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