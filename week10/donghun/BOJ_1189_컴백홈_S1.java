package week10.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈_S1 {
    static int R, C, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[] out;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        out = new int[R * C];
        ans = 0;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'T') {
                    map[i][j] = 1;
                    visited[i][j] = true;
                } else
                    map[i][j] = 0;
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 0);
        System.out.println(ans);


    }

    static void dfs(int nowi, int nowj, int cnt) {
        if (nowi == 0 && nowj == C - 1) {
            if (cnt == K - 1) {
                ans++;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if (inBoundary(nexti, nextj) && !visited[nexti][nextj] && map[nexti][nextj] != 1) {
                visited[nexti][nextj] = true;
                dfs(nexti, nextj, cnt + 1);
                visited[nexti][nextj] = false;
            }
        }
    }

    static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean inBoundary(int i, int j) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
