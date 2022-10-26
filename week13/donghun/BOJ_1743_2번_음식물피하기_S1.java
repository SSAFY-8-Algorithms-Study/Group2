package group.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_2번_음식물피하기_S1 {
    static Queue<Point> q;
    static int N, M, K, count;
    static boolean[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        q = new ArrayDeque<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            map[r][c] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) {
                    q.add(new Point(i, j));
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs(int starti, int startj) {

        int big = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            int nowi = now.i;
            int nowj = now.j;
            for (int d = 0; d < 4; d++) {
                int nexti = nowi + di[d];
                int nextj = nowj + dj[d];
                if (inBoundary(nexti, nextj) && map[nexti][nextj]) {
                    big++;
                    q.add(new Point(nexti, nextj));
                    map[nexti][nextj] = false;
                }
            }
        }
        count = Math.max(count, big);
    }

    private static boolean inBoundary(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }

    private static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
