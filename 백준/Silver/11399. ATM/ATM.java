import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * --------------------------------------------------------------
 * ATM
 * <p>
 * 문제 풀이
 * ATM앞에 N명의 사람들이 줄을 서있고 i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분
 * 사람의 수 N(1 ≤ N ≤ 1,000)
 * 각 사람이 돈을 인출하는데 걸리는 시간 (1 ≤ Pi ≤ 1,000)
 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하여라
 * <p>
 * 접근 방법
 * 배열로 사람당 걸리는 시간을 입력받고 오름차순으로 정렬
 * 반복문을 수행하면서 첫번째 사람부터 N번째 사람까지의 소요시간을 구함
 * 사람별 걸린시간을 모두 더해서 결과를 출력
 * --------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수
        int K = Integer.parseInt(br.readLine());
        // 사람 별 인출 소요시간
        int[] arr = new int[K];
        // i - 1 의 사람 소요시간
        int before = 0;
        // 총 소요시간
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // arr에 소요시간 추가
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 총 소요시간 계산
        for (int i = 0; i < K; i++) {
            total += before + arr[i];
            before += arr[i];
        }

        System.out.println(total);
    }
}