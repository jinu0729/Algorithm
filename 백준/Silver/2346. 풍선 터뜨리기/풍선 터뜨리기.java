import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayDeque;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 풍선갯수
        int N = sc.nextInt();

        // 풍선의 위치와 적혀있는 숫자를 저장히기 위한 Deque
        Deque<int[]> deque = new ArrayDeque<>();

        // 위치 순으로 풍선 저장
        for (int i = 0; i < N; i++) {
            int[] arr = {i + 1, sc.nextInt()};
            deque.add(arr);
        }

        // 마지막 남은 풍선은 계산할 필요가 없으므로 deque.size() > 1 조건
        while (deque.size() > 1) {
            // 처음으로 터질 풍선 가져오기
            int[] arr = deque.pollFirst();
            sb.append(arr[0]).append(" ");

            // 풍선에 적혀있는 숫자, 반복문을 수행할 횟수
            int n = arr[1];

            // 양수일 경우
            if (n > 0) {
                // 오른쪽으로 돌기 때문에 맨 앞 풍선을 맨 뒤로 보냄
                for (int j = 1; j < n; j++) {
                    deque.offerLast(deque.pollFirst());
                }
            // 음수일 경우
            } else if (n < 0) {
                // 왼쪽으로 돌기 때문에 맨 뒤 풍선을 맨 앞으로 보냄
                for (int j = n; j != 0; j++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        // 마자막 남은 풍선 추가
        sb.append(deque.poll()[0]);

        // 출력
        System.out.println(sb);
    }
}