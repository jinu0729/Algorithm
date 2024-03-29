import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] sticks = new int[count];

        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = sc.nextInt();
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