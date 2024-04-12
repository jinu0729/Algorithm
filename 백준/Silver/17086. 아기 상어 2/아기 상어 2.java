import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] move = {{0, 1}, {1, 1}, {1, 0}, {-1, 1}, {0, -1}, {-1, -1}, {-1, 0}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) continue;

                cnt = Math.max(bfs(i, j), cnt);
            }
        }
        System.out.println(cnt);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});

        visited = new boolean[N][M];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + move[i][0];
                int ny = now[1] + move[i][1];
                int val = now[2];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                if (grid[nx][ny] == 1) return val + 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, val + 1});
            }
        }
        return 0;
    }
}