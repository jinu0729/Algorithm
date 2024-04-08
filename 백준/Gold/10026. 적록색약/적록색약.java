import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 그리드 배열
    static char[][] grid;
    // 방문 여부 배열
    static boolean[][] visited;
    // 그리드 크기
    static int N;
    // 이동할 방향 배열 (오른쪽, 아래, 왼쪽, 위쪽)
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    // 선택된 색
    static char selectedColor;
    // 적녹색약 여부
    static boolean weakness;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그리드 및 방문 여부 배열 초기화
        grid = new char[N][N];
        visited = new boolean[N][N];

        // 색 입력 받기
        for (int i = 0; i < N; i++) {
            String colorStr = br.readLine();
            for (int j = 0; j < colorStr.length(); j++) {
                grid[i][j] = colorStr.charAt(j);
            }
        }

        // 영역 수 초기화
        int area = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        // 현재 위치와 색
                        selectedColor = grid[j][k];
                        dfs(j, k);
                        area++;
                    }
                }
            }
            // 영역 수 출력
            System.out.print(area + " ");

            // 영역 수 초기화
            area = 0;
            // 방문 여부 배열 초기화
            visited = new boolean[N][N];
            // 적녹색약 여부 초기화
            weakness = true;
        }
    }

    private static void dfs(int x, int y) {
        // 현재 위치 방문 표시
        visited[x][y] = true;

        // 상하좌우로 이동하면서 탐색
        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            // 그리드 범위를 벗어나지 않는 경우에만 탐색 진행
            if (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N) {
                // 적녹색약 여부에 따라 다르게 탐색
                if (!weakness) {
                    // 적색, 녹색, 청색에 대해서 탐색
                    if (selectedColor == grid[nowX][nowY] && !visited[nowX][nowY]) {
                        dfs(nowX, nowY);
                    } else if (selectedColor == grid[nowX][nowY] && !visited[nowX][nowY]) {
                        dfs(nowX, nowY);
                    } else if (selectedColor == grid[nowX][nowY]  && !visited[nowX][nowY]) {
                        dfs(nowX, nowY);
                    }
                } else {
                    // 적녹색약인 경우, 녹색과 적색을 같은 색으로 처리
                    if ((selectedColor == 'R' || selectedColor == 'G') && (grid[nowX][nowY] == 'R' || grid[nowX][nowY] == 'G') && !visited[nowX][nowY]) {
                        dfs(nowX, nowY);
                    } else if (selectedColor == grid[nowX][nowY] && !visited[nowX][nowY]) {
                        dfs(nowX, nowY);
                    }
                }
            }
        }
    }
}