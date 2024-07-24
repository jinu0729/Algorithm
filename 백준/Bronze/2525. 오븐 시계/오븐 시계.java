import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        if (b + c >= 60) {
            a += (b + c) / 60;
            b = (b + c) % 60;

            if (a > 23) {
                a -= 24;
            }
        } else {
            b += c;
        }

        System.out.println(a + " " + b);
    }
}