import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 액수 부를 횟수
        int K = Integer.parseInt(br.readLine());

        // 돈 stack
        Stack<Integer> stack = new Stack<>();

        // 총액
        int answer = 0;

        // 액수 부르는 수행 반복문
        while (K-- > 0) {
            // 액수
            int money = Integer.parseInt(br.readLine());

            if (money == 0) {
                stack.pop();
                continue;
            }

            stack.push(money);
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}