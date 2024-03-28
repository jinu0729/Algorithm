import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[] sArr = br.readLine().split(" ");

        int[] scoreArr = new int[count];

        double maxScore = 0;
        double sum = 0;

        for (int i = 0; i < scoreArr.length; i++) {
            scoreArr[i] = Integer.parseInt(sArr[i]);

            if (scoreArr[i] > maxScore) {
                maxScore = scoreArr[i];
            }
        }

        for (int i = 0; i < scoreArr.length; i++) {
            sum += (scoreArr[i] / maxScore) * 100;
        }

        System.out.println(sum / count);
    }
}