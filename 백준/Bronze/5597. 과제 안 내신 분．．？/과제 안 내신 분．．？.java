import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[31];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 1; i < 29; i++) {
            arr[Integer.parseInt(br.readLine())] = 0;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) bw.write(i + "\n");
        }

        bw.flush();
    }
}