package week7.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 22116 : 창영이와 퇴근 */
public class BOJ22116 {

    static int N;
    static int[][] map, D;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Point implements Comparable<Point>{
        int y, x;
        int slope;

        public Point(int y, int x, int slope) {
            this.y = y;
            this.x = x;
            this.slope = slope;
        }

        @Override
        public int compareTo(Point o) {
            return this.slope - o.slope;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dijkstra());
    }

    public static int dijkstra() {
        D = new int[N][N];      // 최소 경사 저장 배열
        for (int i = 0; i < N; i++) {
            Arrays.fill(D[i], Integer.MAX_VALUE);
        }
        D[0][0] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0,0));

        while(!pq.isEmpty()) {
            int size = pq.size();

            for (int s = 0; s < size; s++) {
                Point point = pq.poll();
                visited[point.y][point.x] = true;

                if (point.y == N - 1 && point.x == N - 1) {
                    return D[N - 1][N - 1];
                }

                int maxDiff = D[point.y][point.x];
                for (int d = 0; d < 4; d++) {
                    int newY = point.y + dy[d];
                    int newX = point.x + dx[d];

                    if (newY < 0 || newY >= N || newX < 0 || newX >= N || visited[newY][newX]) continue;

                    int slopeDiff = Math.abs(map[point.y][point.x] - map[newY][newX]);
                    if (slopeDiff < D[newY][newX]) {
                        if (slopeDiff >= maxDiff) {
                            D[newY][newX] = slopeDiff;
                        }
                        else {
                            D[newY][newX] = maxDiff;
                        }
                        pq.offer(new Point(newY, newX, D[newY][newX]));
                    }
                }
            }
        }
        return 0;
    }
}
