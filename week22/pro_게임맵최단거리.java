import java.util.*;
 
class Solution {
    
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, M;
    
    public int solution(int[][] map) {
        N = map.length;
        M = map[0].length;
        visited = new boolean[N][M];
        return bfs(map, 0, 0);
    }
    
    public int bfs(int[][] map, int starti, int startj) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(starti, startj, 1));
        visited[starti][startj] = true;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.i == N - 1 && now.j == M - 1) return now.cost;
            
            for(int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];
                if(nexti >= 0 && nextj >= 0 && nexti < N && nextj < M) {
                    if(map[nexti][nextj] == 1 && !visited[nexti][nextj]) {
                        visited[nexti][nextj] = true;
                        q.add(new Point(nexti, nextj, now.cost + 1));
                    }
                }
            }
        }
        return -1;
    }
    
    public class Point {
        int i;
        int j;
        int cost;
        
        public Point(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
}
