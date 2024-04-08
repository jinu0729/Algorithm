import java.util.*;
import java.io.*;

public class Main {
    static int count = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(R);
        for (int i = 1; i <= N; i++)
            bw.write(result[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        visited[cur] = true;
        result[cur] = count++;
        Collections.sort(graph.get(cur));
        for (Integer value : graph.get(cur)) {
            if (!visited[value]) {
                dfs(value);
            }
        }
        return;
    }
}
