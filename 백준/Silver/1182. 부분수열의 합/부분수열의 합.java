import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * -----------------------------------------------------------------
 * 부분수열의 합
 *
 * 문제
 * N개의 정수로 이루어진 수열에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구함
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
 * 둘째 줄에 N개의 정수가 빈 칸을 사이에 주어지고 절댓값은 100,000을 넘지 않는다
 *
 * 풀이
 * dfs로 부분수열을 구하여 풀이
 * -----------------------------------------------------------------
 */

public class Main {
    static int N, S;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println((S == 0) ? answer - 1 : answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + arr[depth]);
    }
}