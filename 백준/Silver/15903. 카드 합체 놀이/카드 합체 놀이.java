import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * -----------------------------------------------------------------------------------------------
 * 석환이의 카드 놀이 문제
 * <p>
 * x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
 * 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
 * 이 카드 합체를 총 m번 하면 놀이가 끝난다. m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다.
 * 이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
 * <p>
 * 첫 번째 줄에 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)과 카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15×n)이 주어진다.
 * 두 번째 줄에 맨 처음 카드의 상태를 나타내는 n개의 자연수 a1, a2, …, an이 공백으로 구분되어 주어진다. (1 ≤ ai ≤ 1,000,000)
 * <p>
 * 가장 적은 수를 만들어야 하므로 PriorityQueue를 이용하여 가장 작은 두 카드를 뽑은 후 풀이
 * -----------------------------------------------------------------------------------------------
 */


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        // 카드 수
        N = Integer.parseInt(st.nextToken());

        // 더할 횟수
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 카드를 PriorityQueue에 담기
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        while (M-- > 0) {
            // 가장 낮은 두 값 더하기
            long sum = pq.poll() + pq.poll();

            pq.offer(sum);
            pq.offer(sum);
        }

        long answer = 0;

        for (long i : pq) {
            answer += i;
        }

        System.out.println(answer);
    }
}