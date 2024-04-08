import java.io.*;
import java.util.*;

/*
 * ------------------
 * 알고리즘 수업 - 너비 우선 탐색 1
 *
 * 문제
 * N개의 정점과 M개의 간선으로 구성된 양방향 그래프(undirected graph)
 * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
 * 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력.
 *
 * 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
 *
 * 풀이
 * BFS를 이용하여 1부터 방문 가능한 정점을 순서대로 방문 후 순서를 저장하여 출력
 * 최대 정점의 수가 100,000개 이므로 이중 배열은 사용이 불가함
 */

public class Main {
    // 방문 순서
    static int visitOrder = 1;
    // 그래프를 표현할 리스트
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 정점 방문 여부
    static boolean[] visited;
    // 각 정점 방문 순서
    static int[] visitSequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수, 간선의 수, 시작 정점
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 정점 방문 여부 초기화
        visited = new boolean[N + 1];
        // 방문 순서 초기화
        visitSequence = new int[N + 1];

        // 그래프를 인접 리스트로 표현
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(R);

        // 방문 순서 출력
        for (int i = 1; i <= N; i++) bw.write(visitSequence[i] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int R) {
        // 큐를 생성하여 시작 정점을 추가하고 방문 처리
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = true;

        // 큐가 비어있지 않은 동안 반복
        while (!queue.isEmpty()) {
            // 큐에서 정점을 하나 꺼내어 현재 정점으로 설정
            int currentVertex = queue.poll();
            // 방문 순서를 저장하고 방문 순서를 증가
            visitSequence[currentVertex] = visitOrder++;

            // 현재 정점에 연결된 정점들을 오름차순으로 정렬
            Collections.sort(graph.get(currentVertex));

            // 현재 정점에 연결된 정점들에 대해 반복
            for (int adjacentVertex : graph.get(currentVertex)) {
                // 방문하지 않은 인접 정점이면 큐에 추가하고 방문 처리
                if (!visited[adjacentVertex]) {
                    queue.add(adjacentVertex);
                    visited[adjacentVertex] = true;
                }
            }
        }
    }
}
