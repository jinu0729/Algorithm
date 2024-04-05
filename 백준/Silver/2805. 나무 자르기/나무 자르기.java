import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * --------------------------------------------------------------
 * 나무 자르기
 * <p>
 * 문제 풀이
 * 절단기 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간 후 나무를 모두 절단
 * 나무의 높이가 20, 15, 10, 17이고 높이를 15로 지정했다면
 * 자른 후 높이는 15, 15, 10, 15이고, 잘려진 5, 2 를 가지고 귀가
 * 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.
 * 나무의 수 N (1 ≤ N ≤ 1,000,000)
 * 상근이가 집으로 가져가려고 하는 나무의 길이 M (1 ≤ M ≤ 2,000,000,000)
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) {
                max = tree[i];
            }
        }
        
        while (min < max) {
            int mid = (min + max) / 2;
            
            long sum = 0;
            
            for (int treeHeight : tree) {
                if (treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }
            
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}