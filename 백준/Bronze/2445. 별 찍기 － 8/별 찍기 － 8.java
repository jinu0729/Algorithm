import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }

            for (int k = 0; k < 2 * (N - i); k++) {
                bw.write(" ");
            }

            for (int l = 0; l < i; l++) {
                bw.write("*");
            }

            bw.newLine();
        }

        for (int m = 1; m < N; m++) {
            for (int n = 0; n < N - m; n++) {
                bw.write("*");
            }

            for (int o = 0; o < 2 * m; o++) {
                bw.write(" ");
            }

            for (int p =0; p < N - m; p++) {
                bw.write("*");
            }

            bw.newLine();
        }

        bw.flush();
    }
}