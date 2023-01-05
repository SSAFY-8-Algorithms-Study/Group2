import java.util.*;

class Solution {
    
    /*
        1. 노드를 모두 연결한다.
        2. 전선을 하나씩 잘라보며 두 개의 전력망의 개수 차의 최솟값을 구한다.
    */
    
    ArrayList[] nodes;
    boolean[] visited;
    int cnt;
    
    // 연결된 노드의 개수 구하기 
    public void dfs(int node) {
        
        ArrayList<Integer> connectedNodes = nodes[node];
        for (int n : connectedNodes) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
                cnt++;
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        this.nodes = new ArrayList[n+1];
        for (int i=0; i<=n; nodes[i++] = new ArrayList<Integer>());
        // 노드 연결하기 
        for (int[] wire : wires) { 
            int from = wire[0];
            int to = wire[1];
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        // 노드를 하나씩 자르고 두 개의 전력망의 개수 차의 최솟값 구하기
        for (int[] wire : wires) {
            visited = new boolean[n+1];
            visited[wire[0]] = true;
            cnt = 0;
            dfs(wire[1]);
            answer = Math.min(answer, Math.abs(n-cnt - cnt));
            
        }
        
        return answer;
    }
}