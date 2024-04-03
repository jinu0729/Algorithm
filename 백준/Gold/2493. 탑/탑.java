import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

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
        StringBuilder sb = new StringBuilder();

        // 탑의 수
        int N = Integer.parseInt(br.readLine());

        // 탑들의 높이
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 탑 비교를 위한 스택
        Stack<int[]> stack = new Stack<>();

        // 반복문을 수행하면서 탑 정보 입력받기
        outLoop:
        for (int i = 0; i < N; i++) {
            // 탑의 정보 {위치, 높이}
            int[] newTop = new int[]{i + 1, Integer.parseInt(st.nextToken())};

            // 스텍에 탑이 있을경우
            while (!stack.isEmpty()) {
                // 스텍에 있는 탑 가져오기
                int[] stackTop = stack.peek();

                // 스텍에 있는 탑이 높을 경우
                if (newTop[1] < stackTop[1]) {
                    // 레이저를 받은 타워의 위치 추가
                    sb.append(stackTop[0] + " ");
                    // 비교를 위해 추가
                    stack.push(newTop);

                    // for문 수행
                    continue outLoop;
                } else {
                    // 스텍에 있는 타워가 낮으므로 제거
                    stack.pop();
                }
            }

            // 레이저 받는 타워가 없으므로 0
            sb.append(0 + " ");

            // 비교를 위해 추가
            stack.push(newTop);
        }

        // 출력
        System.out.println(sb);
    }
}