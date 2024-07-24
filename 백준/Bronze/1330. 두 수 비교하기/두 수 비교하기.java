import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        switch (Integer.compare(a, b)) {
            case 1:
                System.out.println(">");
                break;
            case -1:
                System.out.println("<");
                break;
            case 0:
                System.out.println("==");
                break;
        }
    }
}