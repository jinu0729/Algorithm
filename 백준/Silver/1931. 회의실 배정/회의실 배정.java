import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
 * -----------------------------------------------------------------------------------
 * 회의실 배정
 *
 * 문제
 * 한 개의 회의실에 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의에 대한 시작시간과 끝나는 시간이 있고 회의가 겹치지 않게 회의실을 사용할 수 있는 최대 개수 찾기
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 회의의 수 N(1 ≤ N ≤ 100,000), 회의의 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0
 *
 * 풀이
 * 회의의 끝나는 시간으로 정렬하고 반복문을 수행하면서 회의 끝난시간을 갱신하면서 카운트를 새는 방식
 * -----------------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 종료시간 기준으로 정렬
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int result = 0;
        int beforeEndTime = 0;

        // 이전 회의 종료시간과 회의 시작시간을 비교하여 회의가 가능한 경우
        for (int i = 0; i < N; i++) {
            if (beforeEndTime <= time[i][0]) {
                beforeEndTime = time[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}