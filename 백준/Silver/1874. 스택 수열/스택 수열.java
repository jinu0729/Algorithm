import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int start = 1;

        Stack<Integer> stack = new Stack<>();

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            while (start <= num) {
                stack.push(start);
                sb.append("+").append("\n");
                start++;
            }

            // top에 있는 원소가 입력받은 값과 같이 않은 경우
            if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}