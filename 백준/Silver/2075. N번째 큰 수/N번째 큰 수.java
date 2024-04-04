import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *-----------------------------------------------------------------------------------------------
 * N×N의 표에 수 N2개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다.
 * N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.
 *
 * 최대힙을 만들어 모든 수를 넣은 후 poll하여 N번째의 수를 찾는 방법으로 해결
 *-----------------------------------------------------------------------------------------------
 */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // N * N 표 이므로 N * N 만큼 이중 반복문 수행
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                // 값 넣기
                maxHeap.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // N 번째가 될 때까지 poll
        for (int i = 0; i < N-1; i++) {
            maxHeap.poll();
        }

        System.out.println(maxHeap.poll());
    }
}