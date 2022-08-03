package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {

    static int[][] iceberg;
    static boolean[][] icebergVisited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M, piece = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceberg = new int[N][M];
        icebergVisited = new boolean[N][M];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());

                if (iceberg[i][j] > 0) {
                    icebergVisited[i][j] = true;
                }
            }
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                if (piece == 2) {
                    break;
                }
                if (icebergVisited[i][j]) {
                    yearPass(i, j);
                    separate(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void yearPass(int y, int x) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newX < 0 || newX >= M || newY < 0 || newY >= N) continue;

            if (iceberg[newY][newX] == 0) {
                cnt++;
            }
        }
        iceberg[y][x] -= cnt;
        if (iceberg[y][x] < 0) {
            iceberg[y][x] = 0;
            icebergVisited[y][x] = false;
        }
    }

    public static void separate(int y, int x) {
        icebergVisited[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= N || !icebergVisited[newY][newX]) {
                continue;
            }

            if (icebergVisited[newY][newX]) {
                separate(newY, newX);
                piece++;
            }
        }
    }
}
