package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_게임_맵_최단거리 {
	public int solution(int[][] maps) {
        int answer = 0;
        boolean finished = false;
        
        // N, M
        int N = maps.length;
        int M = maps[0].length;
        
        // 델타
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};
        
        // 최단 거리 = BFS
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        // 처음 위치
        q.add(new int[]{0,0,0});
        visited[0][0] = true;
        
        // 0 = 벽, 1 = 갈 수 있음
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++){
                int[] now = q.poll();
                
                // 도착 체크
                if(now[0] == N-1 && now[1] == M-1){
                    answer = now[2]+1;
                    finished = true;
                    break;
                } 
                
                for(int d=0; d<4; d++){
                    int nexti = now[0] + di[d];
                    int nextj = now[1] + dj[d];
                    
                    if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
                    if(maps[nexti][nextj] == 0) continue;
                    if(visited[nexti][nextj]) continue;
                    
                    visited[nexti][nextj] = true;  //visited
                    q.add(new int[]{nexti,nextj, now[2]+1});
                }
            }
        }
        if(!finished) answer = -1;
        return answer;
    }
}
