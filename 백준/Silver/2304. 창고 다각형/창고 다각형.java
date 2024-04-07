import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * --------------------------------------------------------------------------
 * 창고 다각형
 *
 * 문제 풀이
 * N 개의 막대기둥이 주어진다.
 * 막대 기둥은 (왼쪽 면의 위치 , 높이) 로 주어지는데 순서는 무작위다.
 * 기둥별 높은 부분을 연결하여 지붕을 만들되 물은 고이지 않는 조건.
 * 기둥의 갯수 N은 1 이상 1,000 이하
 * 왼쪽 면의 위치 L, 높이 H는 둘 다 1 이상 1,000 이하.
 *
 * 접근 방법
 * 막대를 왼쪽 면의 위치의 오름차순으로 정렬한다.
 * 하지만 막대를 담을 배열의 길이를 1001로 생성 후 arr[L] = H 식으로 초기화 하면 정렬이 필요 없다.
 * 물이 고이지 않는 조건이므로 가장 긴 막대는 가운데에 존재하게 된다.
 * 따라서 왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽 두 방향으로 높이를 비교하여 계산한다.
 * stack에 기둥을 담고 시작점의 높이보다 높은 기둥을 만나면 담았던 기둥들의 높이를 시작점의 높이로 바꾼다.
 * --------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기둥의 갯수
        int N = Integer.parseInt(br.readLine());

        // 기둥을 담을 배열
        int[] poles = new int[1001];

        // L의 시작점 및 끝점
        int start = 1000, end = 0;

        // 반복문을 수행하면서 기둥 배열을 초기화하고 시작점과 끝점을 구함
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            poles[L] = H;

            start = Math.min(L, start);
            end = Math.max(L, end);
        }

        // 기둥 높이를 담을 stack
        Stack<Integer> heightStack = new Stack<>();

        // 왼쪽 -> 오른쪽 비교
        int height = poles[start];

        for (int i = start + 1; i <= end; i++) {
            // 폴의 높이가 낮으면 stack에 담는다
            if (poles[i] < height) {
                heightStack.push(i);
            } else {
                while (!heightStack.isEmpty()) {
                    // 면적을 계산하기 위해 기둥의 높이를 변경
                    int x = heightStack.pop();
                    poles[x] = height;
                }
                // 기준 높이를 변경
                height = poles[i];
            }
        }

        heightStack.clear();

        // 오른쪽 -> 왼쪽 비교, 왼쪽 -> 오른쪽과 동일하게 비교
        height = poles[end];

        for (int i = end - 1; i >= start; i--) {
            if (poles[i] < height) {
                heightStack.push(i);
            }
            else {
                while (!heightStack.isEmpty()) {
                    int x = heightStack.pop();
                    poles[x] = height;
                }
                height = poles[i];
            }
        }

        int result = 0;

        // 모든 면적을 더하여 출력
        for (int i = start; i <= end; i++) {
            result += poles[i];
        }

        System.out.print(result);
    }
}