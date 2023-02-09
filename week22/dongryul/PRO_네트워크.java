package programmers.adj;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_네트워크 {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        // 그룹의 갯수 => 방문 체크는 하되, 1~N 까지 돌기
        for(int i=0; i<n; i++){
            Queue<Integer> q = new LinkedList<>();
            
            if(visited[i]) continue;
            answer++;
            
            //처음 거 넣기
            visited[i] = true;
            q.add(i);
            
            while(!q.isEmpty()){
                int now = q.poll();
                
                for(int j=0; j<n; j++){
                    
                    if(now == j) continue;
                    if(computers[now][j] != 1) continue;
                    if(visited[j]) continue;
                    
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
        
        
        return answer;
    }
}
