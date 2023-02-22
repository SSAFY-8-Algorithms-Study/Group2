class Solution {
    /*
        DFS로 모든 노드 방문 체크하면서 탐색하기 !!
        노드 방문과 간선 방문을 따로 관리하여 최적화하기 !!
    */
    int[][] computers;
    boolean[] visited; // 노드 방문
    boolean[][] edgeVisited; // 간선 방문
    int N;
    
    void dfs(int node) {
        
        for (int i=0; i<N; i++) {
            if (i == node) continue; // 자기 자신 건너뛰기 
            if (computers[node][i] == 1 && !edgeVisited[node][i]) {
                edgeVisited[node][i] = true;
                edgeVisited[i][node] = true;
                visited[i] = true;
                dfs(i);
            }

        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        this.visited = new boolean[n];
        this.edgeVisited = new boolean[n][n];
        this.N = n;
        
        // 노드를 방문하지 않았다면 DFS
        // DFS의 횟수 == 네트워크 개수 
        for (int i=0; i<N; i++) {
            if (!this.visited[i]) {
                this.visited[i] = true;
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
}