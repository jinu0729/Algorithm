import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        br.close();

        int answer = 0;
        int digit = 1;

        for (int i = n.length() - 1; i >=0 ; i--) {
            char c = n.charAt(i);
            int value;

            if (Character.isAlphabetic(c)) {
                value = c - 'A' + 10;
            } else {
                value = c - '0';
            }

            // 자리수에 맞게 10진수로 변환하여 더함
            answer += value * digit;
            digit *= b; // 다음 자리수로 이동
        }

        System.out.println(answer);
    }
}
