import java.util.*;

class Solution {
    
    /*
        BFS로 1번 노드에서부터 탐색하면서 최단 거리를 기록한다.
    */
    
    ArrayList[] edges; // 인접 리스트
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 인접 리스트 초기화
        edges = new ArrayList[n+1];
        for (int i=0; i<n+1; edges[i++] = new ArrayList<Integer>());
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            edges[from].add(to);
            edges[to].add(from);
        }
        
        // BFS
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(1);
        int[] visited = new int[n+1];
        visited[1] = -1;
        int distance = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int s=0; s<size; s++) {
                int node = q.poll();
                
                for (int nextNode : (ArrayList<Integer>) edges[node]) {
                    if (visited[nextNode] == 0) {
                        q.add(nextNode);
                        visited[nextNode] = distance+1;
                    }
                }
            }
            distance++;
        }
        
        for (int i=2; i<n+1; i++) {
            if (visited[i] == distance-1) answer++;
        }
        
        return answer;
    }
}