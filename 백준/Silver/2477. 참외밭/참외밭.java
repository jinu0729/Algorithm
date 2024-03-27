import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int qty = Integer.parseInt(br.readLine());

        int[] arr = new int[6];

        int aWidth = 0, aWidthI = 0, aHeight = 0, aHeightI = 0, d;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if ((d == 1 || d == 2) && aWidth < arr[i]) {
                aWidth = arr[i];
                aWidthI = i;
            }

            else if ((d == 3 || d == 4) && aHeight < arr[i]) {
                aHeight = arr[i];
                aHeightI = i;
            }
        }

        int left, right, bWidth, bHeight;

        if (aWidthI - 1 == -1) left = 5;
        else left = aWidthI - 1;

        if (aWidthI + 1 == 6) right = 0;
        else right = aWidthI + 1;

        bHeight = Math.abs(arr[left] - arr[right]);

        if (aHeightI - 1 == -1) left = 5;
        else left = aHeightI - 1;

        if (aHeightI + 1 == 6) right = 0;
        else right = aHeightI + 1;

        bWidth = Math.abs(arr[left] - arr[right]);

        System.out.println(((aWidth * aHeight) - (bHeight * bWidth)) * qty);
    }
}