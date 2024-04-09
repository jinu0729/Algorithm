import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Integer[]{B, C});
            graph.get(B).add(new Integer[]{A, C});

            end = Math.max(end, C); // 그래프 최대 중량 구하기
        }

        st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        while (start <= end) {
            int mid = (start + end) / 2;

            ans = 0;
            visited = new boolean[N + 1];

            dfs(from, to, mid);

            if (ans != 0) { // 이동이 가능하면 중량 올리기
                start = mid + 1;
            } else { // 이동 불가능하면 중량 줄이기
                end = mid - 1;
            }
        }

        System.out.println(end);
    }

    static void dfs(int from, int to, int limit) {
        if (from == to) {
            ans = from;
            return;
        }

        visited[from] = true;

        for (Integer[] arr : graph.get(from)) {
            if (!visited[arr[0]] && limit <= arr[1]) {
                dfs(arr[0], to, limit);
            }
        }
    }
}