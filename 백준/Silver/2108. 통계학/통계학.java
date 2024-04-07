import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        // 정수를 담을 배열
        int[] arr1 = new int[N];

        // 산술평균을 위한 sum
        int sum = 0;

        // 최빈값을 위한 배열, -4000 ~ 4000까지 값 확인
        int[] arr2 = new int[8001];

        // 정수들을 담음
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
            sum += arr1[i];
            arr2[arr1[i] + 4000]++;
        }

        // 정렬
        Arrays.sort(arr1);

        // 산술평균, 소수점 이하 첫째 자리에서 반올림
        sb.append((int) Math.round((double) sum / arr1.length) + "\n");
        // 중앙값
        sb.append(arr1[(arr1.length - 1) / 2] + "\n");
        // 최빈값, 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값 출력
        sb.append(mode(arr2) + "\n");
        // 범위
        sb.append(arr1[(arr1.length - 1)] - arr1[0]);

        System.out.println(sb);
    }

    public static int mode(int[] arr2) {
        int maxCount = 0;

        for (int i = 0; i < 8001; i++) {
            if (arr2[i] > maxCount) {
                maxCount = arr2[i];
            }
        }

        //최빈값 확인
        ArrayList<Integer> mode = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (arr2[i] == maxCount) {
                mode.add(i - 4000);
            }
        }

        Collections.sort(mode);

        return (mode.size() > 1) ? mode.get(1) : mode.get(0);
    }
}