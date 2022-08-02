package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {

    static int[][] rect;
    static boolean[][] rectVisited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int high = 0;
        int ans = 0;

        N = Integer.parseInt(br.readLine());
        rect = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rect[i][j] = Integer.parseInt(st.nextToken());
                high = Math.max(high, rect[i][j]);
            }
        }

        for (int i = high; i >= 0; i--) {
            rectVisited = new boolean[N][N];
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!rectVisited[j][k] && rect[j][k] > i) {
                        cnt += sink(i, j, k);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

    public static int sink(int high, int y, int x) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        rectVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= N || rectVisited[newY][newX]) {
                continue;
            }

            if (rect[newY][newX] > high) {
                sink(high, newY, newX);
            }
        }
        return 1;
    }
}
