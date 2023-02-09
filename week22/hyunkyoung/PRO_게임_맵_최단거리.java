import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[maps.length][maps[0].length];
        
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int nx = node[0];
            int ny = node[1];
            
            if(nx == maps.length - 1 && ny == maps[0].length - 1)
                return visit[nx][ny];
            
            for(int d = 0; d < 4; d++) {
                int x = nx + dx[d];
                int y = ny + dy[d];
                
                if(0 <= x && x < maps.length && 0 <= y && y < maps[0].length) {
                    if(maps[x][y] == 1 && visit[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        visit[x][y] = visit[nx][ny] + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}