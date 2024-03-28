import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();

        String[] infos;

        for (int i = 0; i < count; i++) {
            infos = br.readLine().split(" ");

            if (map.containsKey(infos[0])) {
                map.remove(infos[0]);
            } else {
                map.put(infos[0], infos[1]);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>(map.keySet());

        Collections.sort(arrayList, Collections.reverseOrder());

        for (String li:arrayList) {
            System.out.println(li);
        }
    }
}