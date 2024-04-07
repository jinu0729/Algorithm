import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * -----------------------------------------------------------------------------------
 * 센티와 마법의 뿅망치
 *
 * 문제 풀이
 * 뿅망치에 맞으면 키가 ⌊ 뿅망치에 맞은 사람의 키 / 2 ⌋로 변함
 * 단, 키가 1인 경우 더 줄어들 수가 없어 뿅망치의 영향을 받지 않음
 * 뿅망치는 횟수 제한이 있어 매번 가장 키가 큰 거인 가운데 하나를 때려 모든 거인의 키를 작게 하여라
 *
 * 인구수 N (1 ≤ N ≤ 105), 센티의 키 Hcenti (1 ≤ Hcenti ≤ 2 × 109), 횟수 제한 T (1 ≤ T ≤ 105)
 * 두 번째 줄부터 N개의 줄에 각 거인의 키를 나타내는 정수 H (1 ≤ H ≤ 2 × 109)가 주어진다.
 *
 * 뿅망치를 센티의 전략대로 이용하여 거인의 나라의 모든 거인이 센티보다 키가 작도록 할 수 있는 경우
 * 첫 번째 줄에 YES를 출력, 두 번째 줄에 마법의 뿅망치를 최소로 사용한 횟수를 출력
 *
 * 뿅망치를 센티의 전략대로 남은 횟수 전부 이용하고도 거인의 나라에서 센티보다 키가 크거나 같은 거인이 있는 경우
 * 첫 번째 줄에 NO를 출력, 두 번째 줄에 마법의 뿅망치 사용 이후 거인의 나라에서 키가 가장 큰 거인의 키를 출력
 *
 * 접근 방법
 * 거인의 키를 우선순위 큐(맥스 힙)를 사용하여 초기화
 * 뿅망치를 쓴 후 키를 비교하여 조건에 맞게 출력
 * -----------------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인구수
        int N = Integer.parseInt(st.nextToken());
        // 센티의 키
        int H = Integer.parseInt(st.nextToken());
        // 뿅망치 횟수
        int T = Integer.parseInt(st.nextToken());
        // 거인의 키
        PriorityQueue<Integer> giants = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 거인의 키 초기화
        while (N-- > 0) {
            giants.offer(Integer.parseInt(br.readLine()));
        }

        // 뿅망치 사용 횟수
        int count = 0;

        // 뿅망치 사용 반복문
        while (T-- > 0) {
            // 센티와 거인의 키 비교
            if (giants.peek() < H || giants.peek() <= 1) break;

            // 뿅망치 사용 후 카운트 증가
            giants.offer(giants.poll() / 2);
            count++;
        }

        System.out.print((giants.peek() < H) ? "YES\n" + count : "NO\n" + giants.peek());
    }
}