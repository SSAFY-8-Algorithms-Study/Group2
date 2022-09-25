package week9.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2_S2 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};

    static ArrayDeque<Point> shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        shark = new ArrayDeque<Point>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int p = Integer.parseInt(st.nextToken());
                map[i][j] = p;
//                  if (p == 1) {
//                    shark.addLast(new Point(i, j));
//                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                visited = new boolean[N][M];
                int temp = bfs(i, j);
                max = Math.max(max, temp);
            }
        }

        System.out.println(max);
    }

    static int bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(i, j));

        int ans = 1;

        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point p = q.poll();
                for (int d = 0; d < 8; d++) {
                    int nexti = p.i + di[d];
                    int nextj = p.j + dj[d];
                    if (inBoundary(nexti, nextj) && !visited[nexti][nextj]) {
                        if (map[nexti][nextj] == 1) {
                            break outer;
                        }
                        visited[nexti][nextj] = true;
                        q.add(new Point(nexti, nextj));
//                        System.out.print(ans+" ");
                    }
                }
//                System.out.println();
            }
            ans++;
        }
        return ans;
    }

    static boolean inBoundary(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < M;
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
