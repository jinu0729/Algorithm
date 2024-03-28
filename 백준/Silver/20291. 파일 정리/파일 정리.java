import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();

        String[] infos;

        for (int i = 0; i < count; i++) {
            infos = br.readLine().split("\\.");

            if (map.containsKey(infos[1])) {
                map.put(infos[1], map.get(infos[1]) + 1);
            } else {
                map.put(infos[1], 1);
            }
        }

        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}