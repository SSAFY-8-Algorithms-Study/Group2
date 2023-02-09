package week22.seoyoon;

import java.util.ArrayDeque;
import java.util.Queue;

public class PRO_게임맵_최단거리 {

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        int answer = 1;

        Queue<Point> queue = new ArrayDeque<Point>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();

                if (cur.y == n - 1 && cur.x == m - 1) {
                    return answer;
                }

                for (int d = 0; d < 4; d++) {
                    int newY = cur.y + di[d];
                    int newX = cur.x + dj[d];

                    if (newY < 0 || newY >= n || newX < 0 || newX >= m || visited[newY][newX] || maps[newY][newX] == 0) continue;

                    visited[newY][newX] = true;
                    queue.add(new Point(newY, newX));
                }
            }
            answer++;
        }

        answer = -1;
        return answer;
    }

    public static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
