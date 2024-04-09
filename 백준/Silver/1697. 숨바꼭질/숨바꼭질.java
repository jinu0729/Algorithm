import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int visited[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int X = q.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;

                switch (i) {
                    case 0:
                        next = X - 1;
                        break;
                    case 1:
                        next = X + 1;
                        break;
                    case 2:
                        next = X * 2;
                        break;
                }

                if (next == K) {
                    System.out.println(visited[X]);
                    return;
                }

                if (next < 0 || next > 100000 || visited[next] != 0) continue;

                q.offer(next);

                visited[next] = visited[X] + 1;
            }
        }
    }
}
