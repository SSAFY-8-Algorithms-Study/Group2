package week12.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ5427:불 */
public class BOJ5427 {
    static int h, w, time;
    static boolean flag;
    static char[][] map;
    static ArrayList<Point> fires;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fires = new ArrayList<Point>();

            Point sk = null;
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();

                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') {
                        fires.add(new Point(i, j, '*'));
                    }
                    else if (map[i][j] == '@') {
                        sk = new Point(i, j, '@');
                    }
                }
            }

            bfs(sk);
            System.out.println(flag ? time : "IMPOSSIBLE");
        }
    }

    public static void bfs(Point sk) {
        boolean[][] visit = new boolean[h][w];
        Queue<Point> q = new ArrayDeque<Point>();

        // Queue에 불 먼저 넣어놓기
        for (int i = 0; i < fires.size(); i++) {
            q.add(fires.get(i));
        }

        // 상근이 넣기
        q.add(sk);
        map[sk.i][sk.j] = '.';
        visit[sk.i][sk.j] = true;

        time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int s = 0; s < size; s++) {
                Point cur = q.poll();

                // 불 이동
                if (cur.type == '*') {
                    for (int d = 0; d < 4; d++) {
                        int newi = cur.i + di[d];
                        int newj = cur.j + dj[d];

                        if (newi < 0 || newi >= h || newj < 0 || newj >= w || map[newi][newj] == '*' || map[newi][newj] == '#') continue;
                        map[newi][newj] = '*';
                        q.add(new Point(newi, newj, '*'));
                    }
                }

                // 상근 이동
                else if (cur.type == '@') {
                    flag = false;

                    for (int d = 0; d < 4; d++) {
                        int newi = cur.i + di[d];
                        int newj = cur.j + dj[d];

                        if (newi < 0 || newi >= h || newj < 0 || newj >= w) {
                            flag = true;
                            return;
                        }
                        if (visit[newi][newj] || map[newi][newj] == '*' || map[newi][newj] == '#') continue;

                        visit[newi][newj] = true;
                        q.add(new Point(newi, newj, '@'));
                    }
                }
            }
        }
    }

    static class Point {
        int i, j;
        char type;

        public Point(int i, int j, char type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }
    }
}
