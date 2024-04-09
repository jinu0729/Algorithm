import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, K;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            solution();
            pq.clear();
        }
    }

    private static void solution() {
        long sum = 0;

        while (pq.size() > 1) {
            long n1 = pq.poll();
            long n2 = pq.poll();

            sum += n1 + n2;

            pq.offer(n1 + n2);
        }

        System.out.println(sum);
    }
}