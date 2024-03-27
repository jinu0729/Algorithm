import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = 20;

        double creditSum = 0;
        double grade = 0;
        double gradeSum = 0;

        for (int i = 0; i < n; i++) {
            String[] subjects = sc.nextLine().split(" ");

            if (subjects[2].equals("P")) {
                continue;
            }

            creditSum += Double.parseDouble(subjects[1]);

            switch (subjects[2]) {
                case "A+":
                    grade = 4.5;
                    break;
                case "A0":
                    grade = 4.0;
                    break;
                case "B+":
                    grade = 3.5;
                    break;
                case "B0":
                    grade = 3.0;
                    break;
                case "C+":
                    grade = 2.5;
                    break;
                case "C0":
                    grade = 2.0;
                    break;
                case "D+":
                    grade = 1.5;
                    break;
                case "D0":
                    grade = 1.0;
                    break;
                case "F":
                    grade = 0.0;
                    break;

            }

            gradeSum += Double.parseDouble(subjects[1]) * grade;

        }

        System.out.println(gradeSum / creditSum);
    }
}