import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int price = 0;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            price = 10000 + a * 1000;
        } else if (a == b || a == c || b == c) {
            int same = (a == b) ? a : c;
            price = 1000 + same * 100;
        } else {
            int max = Math.max(Math.max(a, b), c);
            price = max * 100;
        }

        System.out.println(price);
    }
}