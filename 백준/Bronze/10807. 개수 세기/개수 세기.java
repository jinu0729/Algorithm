import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int answer = countNum(n, st, v);

        System.out.println(answer);
    }

    private static int countNum(int n, StringTokenizer st, int v) {
        int answer = 0;

        while (st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) == v) answer++;
        }

        return answer;
    }
}