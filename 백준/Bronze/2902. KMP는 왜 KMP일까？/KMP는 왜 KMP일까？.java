import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 문자열을 - 기준으로 자름
        String[] arr = br.readLine().split("-");

        br.close();

        String answer = "";

        // 반복문을 수행하면서 arr[i]의 0번째 문자를 더해줌
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i].charAt(0);
        }

        System.out.println(answer);
    }
}