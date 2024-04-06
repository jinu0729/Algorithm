import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * --------------------------------------------------------------
 * 게임
 * <p>
 * 문제 풀이
 * 무조건 이기는 게임을 했을 때 최소 몇번을 해야 승률이 변하는지 구한다
 * 1 ≤ X ≤ 1,000,000,000
 * 0 ≤ Y ≤ X
 * <p>
 * 접근 방법
 * 현재 승률(Z)을 구한 후 이진탐색을 통해 최소 몇번을 해야 승률이 오르는지 구한다
 * Z >= 99 일 경우 변하지 않으므로 -1을 출력한다
 *
 * 주의점
 * 승률 계산 시 입력이 10^9 이므로 실수형 타입에 유의한다.
 * --------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 게임 횟수
        long X = Long.parseLong(st.nextToken());
        // 이긴 게임
        long Y = Long.parseLong(st.nextToken());

        // 현재 승률
        int Z = (int) (Y * 100 / X);

        // 승률이 변하지 않으므로 -1 출력
        if (Z >= 99) {
            System.out.println(-1);
        } else {
            long start = 1, end = X, mid = 0;

            while (start < end) {
                mid = (start + end) / 2;

                int ZZ = (int) ((Y + mid) * 100 / (X + mid));

                if (Z >= ZZ) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            System.out.println(end);
        }
    }
}