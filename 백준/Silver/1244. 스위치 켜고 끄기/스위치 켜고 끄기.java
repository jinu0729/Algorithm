import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sNum = Integer.parseInt(br.readLine());
        int iArr[] = new int[sNum];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sNum; i++) {
            iArr[i] = Integer.parseInt(st.nextToken());
        }

        int sCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < sCount; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            changeSwitch(iArr, gender, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]); // 공백 제거
            if ((i + 1) % 20 == 0) sb.append("\n"); // 20개마다 줄 바꿈
            else sb.append(" "); // 스위치 상태 사이에 공백 추가
        }
        System.out.println(sb);
    }

    public static void changeSwitch(int iArr[], int gender, int num) {
        switch (gender) {
            case 1:
                for (int i = num - 1; i < iArr.length; i += num) {
                    iArr[i] = (iArr[i] == 0) ? 1 : 0;
                }
                break;
            case 2:
                num--; // 입력으로 받은 번호를 배열의 인덱스로 변환

                // 대칭 구간의 왼쪽과 오른쪽 인덱스 설정
                int left = num - 1;
                int right = num + 1;

                iArr[num] = (iArr[num] == 0) ? 1 : 0;

                // 가운데부터 시작하여 대칭 구간을 찾음
                while (left >= 0 && right < iArr.length && iArr[left] == iArr[right]) {
                    iArr[left] = (iArr[left] == 0) ? 1 : 0;
                    iArr[right] = (iArr[right] == 0) ? 1 : 0;
                    left--;
                    right++;
                }

                break;
        }
    }
}
