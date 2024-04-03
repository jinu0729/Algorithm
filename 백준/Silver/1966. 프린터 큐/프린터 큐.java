import java.util.LinkedList;
import java.util.Scanner;

/*
 *--------------------------------------------------------------------------
 * 첫 줄에 테스트케이스의 수가 주어짐
 * 테스트케이스 첫번째 줄 첫번째 수에 문서의 개수가 주어지고 두번째 수에 그 문서의 Index가 주어진다.
 * 테스트케이스 두번째 줄엔 문서의 중요도가 주어지는데 중요도는 내림차순이다.
 * Index에 있는 문서가 몇번째로 출력되는지 계산해서 리턴하는 문제이다.
 * LinkedList를 만들어 {초기위치, 중요도}로 offer 후 맨 첫번째를 가져오고
 * 반복문을 수행하면서 순서대로 Queue에 있는 값과 비교하여 중요도가 낮으면 offer 후 다시 비교한다.
 *--------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        while (T-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();

            // PrintQueue로 활용할 연결 리스트
            LinkedList<int[]> q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                q.offer(new int[]{i, in.nextInt()});
            }

            int count = 0;

            while (!q.isEmpty()) {
                // 맨 처음 문서
                int[] front = q.poll();
                // front 문서가 가장 높은 우선순위를 가지는가 판단하는 변수
                boolean isMax = true;

                // 큐에 남아있는 문서들과 중요도를 비교
                for (int i = 0; i < q.size(); i++) {
                    // 처음 뽑은 문서보다 큐에 있는 i번째 문서가 중요도가 클 경우
                    if (front[1] < q.get(i)[1]) {
                        // 뽑은 문서 및 i 이전의 문서들을 뒤로 보냄
                        q.offer(front);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        // front문서가 가장 큰 문서가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }
                // front 문서가 가장 큰 문서가 아니였으므로 다음 반복문으로 넘어감
                if (isMax == false) {
                    continue;
                }
                // front 문서가 가장 큰 문서였으므로 해당 문서는 출력해야하는 문서
                count++;
                // 찾고자 하는 문서라면 해당 테스트케이스 종료
                if (front[0] == M) {
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}