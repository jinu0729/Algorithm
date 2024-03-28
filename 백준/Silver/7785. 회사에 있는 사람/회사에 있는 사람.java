import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String key = scanner.next();
            String value = scanner.next();

            if (map.containsKey(key)) {
                map.remove(key);
            } else {
                map.put(key, value);
            }
        }

        List<String> sortedKeys = new ArrayList<>(map.keySet());
        sortedKeys.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String key : sortedKeys) {
            sb.append(key).append("\n");
        }

        System.out.print(sb);
    }
}
