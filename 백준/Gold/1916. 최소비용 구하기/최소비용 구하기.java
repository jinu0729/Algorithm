import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

/*
 * -----------------------------------------------------------------------------------
 * 최소비용 구하기
 *
 * 문제
 * N개의 도시, 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스
 * A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화
 * A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력 도시의 번호는 1부터 N까지
 * N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 100,000), 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수
 *
 * 풀이
 * 다익스트라 알고리즘을 활용
 * -----------------------------------------------------------------------------------
 */

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> nodes;
    static int[] distance; // 최단거리 행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();
        distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        Arrays.fill(distance, Integer.MAX_VALUE);


        // 단방향 인접 리스트
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // start -> end 가는 weight (가중치)
            nodes.get(from).add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(from, to));
    }

    private static int dijkstra(int from, int to) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.offer(new Node(from, 0));
        distance[from] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : nodes.get(cur)) {
                    if (!visited[node.to] && distance[node.to] > distance[cur] + node.weight) {
                        distance[node.to] = distance[cur] + node.weight;
                        pq.add(new Node(node.to, distance[node.to]));
                    }
                }
            }
        }
        return distance[to];
    }

    static class Node implements Comparable<Node> {
        public int to;
        public int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}