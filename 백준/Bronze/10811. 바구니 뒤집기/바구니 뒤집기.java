import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[Integer.parseInt(st.nextToken()) + 1];
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());

            for (int j = firstNum; j <= secondNum ; j++) {
                int c = secondNum--;
                int temp = arr[j];
                arr[j] = arr[c];
                arr[c] = temp;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
    }
}