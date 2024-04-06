import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * --------------------------------------------------------------
 * 통계학
 * <p>
 * 문제 풀이
 * 산술평균, 중앙값, 최빈값, 범위를 구하는 문제
 * 산술평균은 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * 최빈값이 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * <p>
 * 접근 방법
 * 정수들을 배열에 담아서 정렬한 후 계산한다.
 * 산술평균은 double형으로 평균을 구하고 Math.round로 반올림 한다.
 * 최빈값은 우선순위 큐를 사용하여 두 번째로 작은 값을 출력한다.
 * --------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 게임 횟수
        int N = Integer.parseInt(br.readLine());

        // 정수를 담을 arr
        int[] arr = new int[N];

        // 산술평균을 위한 sum
        int sum = 0;

        // 정수들을 담음
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 정렬
        Arrays.sort(arr);

        // 산술평균, 소수점 이하 첫째 자리에서 반올림
        sb.append((int) Math.round((double) sum / arr.length) + "\n");
        // 중간값
        sb.append(arr[(arr.length - 1) / 2] + "\n");
        // 최빈값, 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값 출력
        sb.append(mode(arr) + "\n");
        // 범위
        sb.append(arr[(arr.length - 1)] - arr[0]);

        System.out.println(sb);
    }

    public static int mode(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // {해당 정수, count}
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        // 두번째 작은값 출력을 위해 PriorityQueue 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // arr에서 맨 처음 값 입력
        pq.offer(arr[0]);
        int num = arr[0];
        int count = hashMap.get(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            // count가 높을 경우
            if (hashMap.get(arr[i]) > count) {
                pq.clear();
                pq.offer(arr[i]);
                num = arr[i];
                count = hashMap.get(arr[i]);
                // 중복 방지를 위해 count가 같지만 정수가 같지 않을때만 offer한다
            } else if (hashMap.get(arr[i]) == count && num != arr[i]) {
                pq.offer(arr[i]);
            }
        }

        // 최빈값이 같을 경우 두번쨰 작은수 return
        if (pq.size() > 1) {
            pq.poll();
            return pq.poll();
        }

        return pq.poll();
    }
}