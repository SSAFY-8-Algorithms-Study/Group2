package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187_양치기꿍 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int sheep;
    static int wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = arr[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(sheep + " " + wolf);

    }

    static void bfs(int i, int j) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(i, j));
        visited[i][j] = true;

        int s = 0;
        int w = 0;
        if (map[i][j] == 'v') {
            w=1;
        } else if (map[i][j] == 'k') {
            s=1;
        }

        while (!q.isEmpty()) {

            Point p = q.poll();
            int nowi = p.i;
            int nowj = p.j;
            for (int d = 0; d < 4; d++) {
                int nexti = nowi + di[d];
                int nextj = nowj + dj[d];
                if (inBoundary(nexti, nextj) && !visited[nexti][nextj]) {
                    if (map[nexti][nextj] == 'v') {
                        w++;
                    }
                    if (map[nexti][nextj] == 'k') {
                        s++;
                    }
                    q.add(new Point(nexti, nextj));
                    visited[nexti][nextj] = true;
                }
            }
        }

        if (w >= s) {
            wolf += w;
        } else {
            sheep += s;
        }
    }

    static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
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
