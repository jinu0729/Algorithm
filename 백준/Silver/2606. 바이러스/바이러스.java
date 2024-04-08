import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexSize = Integer.parseInt(br.readLine());
        int edgeSize = Integer.parseInt(br.readLine());

        int[][] graph = new int[vertexSize + 1][vertexSize + 1];
        boolean[] visited = new boolean[vertexSize + 1];

        for (int i = 0; i < edgeSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(graph, visited, 1);

        int answer = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                if (i == 1) {
                    continue;
                }
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int[][] graph, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            for (int i = 1; i < graph.length; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}