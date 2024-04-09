import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!s.isEmpty() && s.peek() > y) {
                answer++;
                s.pop();
            }

            if (!s.isEmpty() && s.peek() == y || y == 0 ) {
                continue;
            }

            s.push(y);
        }

        while (!s.isEmpty()) {
            s.pop();
            answer++;
        }

        System.out.println(answer);
    }
}