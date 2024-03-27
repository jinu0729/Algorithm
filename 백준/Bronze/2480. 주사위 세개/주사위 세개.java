import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = br.readLine().split(" ");
        br.close();

        int price = 0;

        int dice1 = Integer.parseInt(sArr[0]);
        int dice2 = Integer.parseInt(sArr[1]);
        int dice3 = Integer.parseInt(sArr[2]);


        // 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.

        if (dice1 == dice2 && dice2 == dice3) {
            price = 10000 + dice1 * 1000;
        } else if (dice1 == dice2 || dice2 == dice3 || dice1 == dice3) {
            int sameDice = (dice1 == dice2) ? dice1 : dice3;
            price = 1000 + sameDice * 100;
        } else {
            int maxDice = Math.max(Math.max(dice1, dice2), dice3);
            price = maxDice * 100;
        }

        System.out.println(price);
    }
}