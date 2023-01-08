package programmers.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_전력망을_둘로_나누기 {
	public int solution(int n, int[][] wires) {
        int answer = 100;
        
        // adjList 인접리스트 만들기
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int[] wire : wires){
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            
            //1방문
            int visit_count = 1;
            visited[1] = true;
            q.add(1);
            
            
            //BFS
            while(!q.isEmpty()){
                int now = q.poll();
                
                for(int next : adjList[now]){
                    // 절단되었습니다.
                    if(now == wire[0] && next == wire[1]) continue;
                    if(now == wire[1] && next == wire[0]) continue;
                    
                    if(visited[next]) continue; // 이미 방문
                    
                    visit_count++;  // 방문한 노드 갯수
                    visited[next] = true;
                    q.add(next);
                }
            }
            int other = n - visit_count;    // 다른 전력망
            answer = Math.min(answer, Math.abs(other - visit_count));
        }
        
        
        return answer;
    }
}
