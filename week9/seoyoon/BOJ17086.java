package week9.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 17086 : 아기상어2 */
public class BOJ17086 {
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, max;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // End Input

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    int distance = bfs(i, j);
                    max = Math.max(max, distance);
                }
            }
        }
        System.out.println(max);
    }

    public static int bfs(int y, int x) {
        visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(y, x));
        visited[y][x] = true;

        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            dis++;

            for (int s = 0; s < size; s++) {
                Point p = q.poll();

                for (int d = 0; d < 8; d++) {
                    int newY = p.y + dy[d];
                    int newX = p.x + dx[d];

                    if (newY < 0 || newY >= N || newX < 0 || newX >= M || visited[newY][newX]) {
                        continue;
                    }

                    if (map[newY][newX] == 1) {
                        return dis;
                    }

                    q.add(new Point(newY, newX));
                    visited[newY][newX] = true;
                }
            }
        }
        return 0;
    }
}
