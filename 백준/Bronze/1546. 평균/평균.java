import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int m = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());

            if (score > m) m = score;

            sum += score;
        }

        bw.write(String.valueOf(sum / (m * n) * 100));
        bw.close();
    }
}