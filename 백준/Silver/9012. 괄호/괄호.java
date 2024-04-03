import java.util.Scanner;
import java.util.Stack;

/*
 *-----------------------------------------------------------------
 * 이 문제는 입력받은 T만큼 괄호 문자열이 주어진다.
 * 주어진 괄호 문자열이 올바른 괄호 문자열인지 판단하여 그 결과를 YES or NO로 나타낸다
 * Stack에 '('일 경우 push 하고 ')'일 경우 VPS가 완성되므로 pop을 하여 빼낸다
 *-----------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String str = sc.next();
            System.out.println(calculate(str) ? "YES" : "NO");
        }
    }

    private static Boolean calculate(String str) {
        Stack<Character> stack = new Stack<>();

        for (Character c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            // ')'일 경우
            } else {
                // VPS의 시작이 ')'가 될 수 없으므로 false를 return
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}