import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] sticks = new int[count];

        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sticks.length; i++) {
           while (!stack.isEmpty() && sticks[i] >= stack.peek()) {
               stack.pop();
           }

           stack.push(sticks[i]);
        }

        System.out.println(stack.size());
    }
}