import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 *----------------------------------------------------------------------------------
 * 첫 줄에 풍선의 수가 주어짐
 * 두번째 줄에 풍선에 써있는 정수들이 주어짐
 * 처음 1번 풍선을 터트리고 풍선 숫자가 양수면 오른쪽 음수면 왼쪽으로 숫자만큼 이동하여 터트림 (터진 풍선 제외)
 * 터진 풍선의 번호를 차례대로 출력
 * 양방향에서 데이터를 추가하고 제거하기 위해 Deque을 사용함
 * 양수일 경우 앞에서 제거하여 뒤로 추가하고 음수일경우 뒤에서 제거하여 앞으로 추가함
 *----------------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 명령의 수
        int N = Integer.parseInt(br.readLine());

        // 명령 stack
        Stack<Integer> stack = new Stack<>();

        // 명령 수행 반복문
        while (N-- > 0) {
            // 명령
            String str = br.readLine();

            switch (str.split(" ")[0]) {
                case "push":
                    stack.push(Integer.parseInt(str.split(" ")[1]));
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }
    }
}