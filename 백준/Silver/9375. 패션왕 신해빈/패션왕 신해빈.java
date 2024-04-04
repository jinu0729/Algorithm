import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * ------------------------------------------------------------------------------------------
 * 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
 * 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 * 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
 * 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
 *
 * 옷의 타입이 2개 이상일 경우 겹치지 않은 상태에서 하나의 타입만 착용하는 경우도 있어 미착용 +1 해줌
 * 예) 모자가 1개일 경우 모자를 안쓰고 선글라스를 착용하는 경우
 *
 * 알몸이 아닌 상태를 구하기 때문에 모두 안입고 있는 경우는 제외
 * ------------------------------------------------------------------------------------------
 */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 횟수
        int K = Integer.parseInt(br.readLine());

        // 테스트 케이스 반복
        while (K-- > 0) {
            // 옷 저장 HashMap
            HashMap<String, Integer> hashMap = new HashMap<>();

            // 옷 갯수
            int N = Integer.parseInt(br.readLine());

            // 옷 갯수만큼 반복
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                // 옷의 이름은 필요없으므로 저장 X
                st.nextToken();
                // 옷 타입
                String type = st.nextToken();

                // HashMap에 옷이 존재하면 그 값을 가져오고 없으면 0으로하여 더해줌
                hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            }

            // 모든 경우의 수를 곱해야 하여 1로 초기화
            int answer = 1;

            // HashMap 만큼 반복
            for (int val : hashMap.values()) {
                // 착용 안하는 경우의 수 추가
                answer *= val + 1;
            }

            // 알몸인 경우는 제외하여 -1
            sb.append(answer - 1).append('\n');
        }

        System.out.println(sb);
    }
}