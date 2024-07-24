import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int pos1 = Integer.parseInt(st.nextToken()) - 1;
            int pos2 = Integer.parseInt(st.nextToken()) - 1;

            int ball1 = arr[pos1];
            int ball2 = arr[pos2];

            arr[pos1] = ball2;
            arr[pos2] = ball1;
        }

        for (int j : arr) {
            bw.write(j + " ");
        }

        bw.flush();
    }
}