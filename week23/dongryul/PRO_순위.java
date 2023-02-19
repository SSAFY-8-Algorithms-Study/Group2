package programmers.adj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_순위 {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int[] front = new int[n+1];
        int[] back = new int[n+1];
        
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int[] result : results){
            //단 방향
            adjList[result[0]].add(result[1]);
        }
        
        
        for(int i=1; i<=n; i++){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            
            q.add(i);
            visited[i] = true;
            
            int depth=0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int s=0; s<size; s++){
                    int now = q.poll();
                    
                    for(int next : adjList[now]){
                        
                        
                        if(visited[next]) continue;
                        
                        visited[next] = true;
                        front[next]++;  // 나한테 오는 것
                        back[i]++;  // 내 뒤에 있는 것
                        q.add(next);
                        
                    }
                }
                depth++;
            }
            
        }
        for(int i=1; i<=n; i++){
            if(front[i] + back[i] == n-1) answer++;
        }
        return answer;
    }
}
