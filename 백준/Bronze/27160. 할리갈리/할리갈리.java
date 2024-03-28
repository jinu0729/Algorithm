import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardQty = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cardQty; i++) {
            String[] sArr = br.readLine().split(" ");

            if (map.containsKey(sArr[0])) {
                map.put(sArr[0], map.get(sArr[0]) + Integer.parseInt(sArr[1]));
            } else {
                map.put(sArr[0], Integer.parseInt(sArr[1]));
            }
        }

        if (map.containsValue(5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}