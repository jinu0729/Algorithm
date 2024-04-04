import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * -----------------------------------------------------------------------------------------------
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
 * <p>
 * 배열에 정수 x (x ≠ 0)를 넣는다.
 * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 * <p>
 * 첫 번째 줄에 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)과 카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15×n)이 주어진다.
 * 두 번째 줄에 맨 처음 카드의 상태를 나타내는 n개의 자연수 a1, a2, …, an이 공백으로 구분되어 주어진다. (1 ≤ ai ≤ 1,000,000)
 * <p>
 * 절대값이 적은 수 순으로 정렬해야 하기 때문에 PriorityQueue를 이용하여 풀이
 * -----------------------------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // PriorityQueue를 이용하여 입력받은 수를 저장
        // 람다식으로 비교하여 요구조건에 맞게 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            // 절대값이 같을 경우 음수를 앞으로 이동
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        }));

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            } else {
                pq.offer(x);
            }
        }
    }
}