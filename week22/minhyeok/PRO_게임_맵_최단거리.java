import java.util.*;

class Solution {
    /*
        BFS 사용해 최단 거리 구하기
    */
    
    class MyPos { // 나의 위치 
        
        int x,y,cnt;
        
        public MyPos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
    }
    
    public int solution(int[][] maps) {
        // 기본값 초기화 
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        ArrayDeque<MyPos> q = new ArrayDeque<MyPos>();
        q.add(new MyPos(0,0,1));
        
        // BFS
        while(!q.isEmpty()) {
            MyPos pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            int cnt = pos.cnt;
            
            if (x == m-1 && y == n-1) return cnt;
            
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                
                if (maps[ny][nx] == 1) { // 한 번 방문한 칸은 벽으로 만들어 재방문 불가
                    maps[ny][nx] = 0;
                    q.add(new MyPos(nx,ny,cnt+1));
                }
            }
        }
        return answer;
    }
}