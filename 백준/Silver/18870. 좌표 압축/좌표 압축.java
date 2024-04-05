import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌표의 수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 원본 배열
        int[] arr1 = new int[N];
        // PriorityQueue로 정렬
        int[] arr2 = new int[N];
        // 좌표에 따른 순서를 저장할 HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr1[i];
        }

        Arrays.sort(arr2);

        // 좌표에 따른 순서
        int order = 0;
        // 중복없이 저장
        for (int i : arr2) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, order++);
            }
        }

        // 원본 위치에 맞게 순서를 만듬
        StringBuilder sb = new StringBuilder();
        for (int i:arr1) {
            sb.append(hashMap.get(i) + " ");
        }

        System.out.println(sb);
    }
}