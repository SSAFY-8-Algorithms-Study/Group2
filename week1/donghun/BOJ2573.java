package week1.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {

    static int[][] inputMap, simpleMap;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    static int N, count, Max;

    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // start 입력
        N = Integer.parseInt(br.readLine());

        inputMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // end 입력

        // start 로직
        Max = 1;

        for (int i = 1; i < 101; i++) {
            simpleMap = new int[N][N];

            count = 0;
            visited = new boolean[N][N];

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (inputMap[a][b] <= i) {
                        simpleMap[a][b] = 0;
                    } else
                        simpleMap[a][b] = 1;
                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (simpleMap[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);
                        count++;
                    }

                }
            }
            Max = Math.max(Max, count);
        }
        // end 로직

        // 출력
        System.out.println(Max);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (simpleMap[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}