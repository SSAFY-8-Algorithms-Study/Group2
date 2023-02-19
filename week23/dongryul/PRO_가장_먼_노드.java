package programmers.adj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_가장_먼_노드 {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] total = new int[n + 1];
        
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int[] e : edge){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        int depth = 0;  // 간선의 갯수, but 노드의 갯수라면 1
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++){
                int now = q.poll();
                total[now] = depth;
                for(int next : adjList[now]){
                    if(visited[next]) continue;
                    
                    visited[next] = true;
                    q.add(next);
                }
                
                
            }
            depth++;
        }
        depth--;
        
        
        for(int i=1; i<=n; i++){
            // System.out.print(total[i] + " ");
            if(total[i] == depth) answer++;
        }
        return answer;
    }
}
