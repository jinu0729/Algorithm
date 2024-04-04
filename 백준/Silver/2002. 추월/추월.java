import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * -----------------------------------------------------------------------------------------------
 * 소문난 명콤비 경찰 대근이와 영식이가 추월하는 차량을 잡는 문제
 * 
 * 입력은 총 2N+1개의 줄로 이루어져 있다. 첫 줄에는 차의 대수 N(1 ≤ N ≤ 1,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 대근이가 적은 차량 번호 목록이 주어지고, N+2째 줄부터 N개의 줄에는 영식이가 적은 차량 번호 목록이 주어진다.
 * 각 차량 번호는 6글자 이상 8글자 이하의 문자열로, 영어 대문자('A'-'Z')와 숫자('0'-'9')로만 이루어져 있다.
 * 
 * 같은 차량 번호가 두 번 이상 주어지는 경우는 없다.
 * 
 * HashMap을 만들어 들어간 차의 번호와 순서를 저장 후 정수형 배열에 나온차량의 들어간 순서를 넣어서 반복문으로 비교한다.
 * -----------------------------------------------------------------------------------------------
 */


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 차량 수
        N = Integer.parseInt(br.readLine());

        // 차량을 맵에 담기 {차 번호 = 들어간 순서}
        for (int i = 1; i <= N; i++) {
            hashMap.put(br.readLine(), i);
        }

        // 나온 차량의 입장 순서를 담을 배열
        int[] arr = new int[N];

        // 나온 차량의 들어간 순서 담기
        for (int i = 0; i < N; i++) {
            arr[i] = hashMap.get(br.readLine());
        }
        
        int answer = 0;

        // 반복문을 수행하면서 비교
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}