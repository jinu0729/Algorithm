import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = {1, 1, 2, 2, 2, 8};

        int num = 0, sub = 0;

        for (int i = 0; i < arr1.length; i++) {
            num = Integer.parseInt(st.nextToken());

            sub = arr1[i] - num;

            bw.write(sub + " ");
        }

        bw.flush();
    }
}