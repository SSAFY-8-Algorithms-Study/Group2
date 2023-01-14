package programmers.greedy;

import java.util.PriorityQueue;

public class PRO_섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] adjMatrix = new int[n][n];
        boolean[] visited = new boolean[n];
        
        for(int[] cost : costs){
            adjMatrix[cost[0]][cost[1]] = cost[2];
            adjMatrix[cost[1]][cost[0]] = cost[2];
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2)-> a1[1] - a2[1]);
        
        // 더미 넣기
        pq.add(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int[] nowArr = pq.poll(); 
            int now = nowArr[0];
            int cost = nowArr[1];
            
            if(visited[now]) continue;

            visited[now] = true;
            answer += cost;
            
            for(int i=0; i<n; i++){
                if(adjMatrix[now][i] == 0) continue;
                //만약 방문했다면 con
                if(visited[i]) continue;
                
                pq.add(new int[]{i, adjMatrix[now][i]});
            }
        }
        return answer;
    }
}