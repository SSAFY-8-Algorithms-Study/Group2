import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static long[][] dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    public long solution(int m, int n, int[][] puddles) {
        dp = new long[n + 1][m + 1];
        
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        bfs(m, n);
        
        return dp[n][m];
    }
    
    static void bfs(int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 1});
        dp[1][1] = 1;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            
            for(int d = 0; d < 2; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                    if(dp[nx][ny] == -1) continue;
                    
                    if(dp[nx][ny] == 0) {
                        dp[nx][ny] = dp[x][y];
                        queue.add(new int[]{nx, ny});
                    } else {
                        dp[nx][ny] += dp[x][y];
                    }
                    
                    if(dp[nx][ny] >= 1000000007) {
                        dp[nx][ny] %= 1000000007;
                    }
                }
            }
        }
    }
}