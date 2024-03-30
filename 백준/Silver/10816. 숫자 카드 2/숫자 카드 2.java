import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자와 해당 숫자의 개수를 저장할 HashMap 생성
        HashMap<Integer, Integer> cardMap = new HashMap<>();

        // 입력받은 숫자들을 HashMap에 저장
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // HashMap에 이미 해당 숫자가 존재한다면 개수를 증가시킴
            if (cardMap.containsKey(num)) {
                cardMap.put(num, cardMap.get(num) + 1);
            } else { // 존재하지 않는다면 새로운 숫자로 추가
                cardMap.put(num, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            // HashMap에서 해당 숫자의 개수를 찾아 출력, 없다면 0 출력
            bw.write(cardMap.getOrDefault(num, 0) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}