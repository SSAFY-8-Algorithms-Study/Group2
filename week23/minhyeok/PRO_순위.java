import java.util.*;
class Solution {
    /*
        승자 -> 패자, 패자 -> 승자 두 개의 단방향 그래프 만들기
        내가 이긴 사람 + 내가 진 사람 == n-1 이면 순위를 매길 수 있다.
    */
    
    void dfs(int node, ArrayList[] graph) {
        
        for (int nextNode : (ArrayList<Integer>) graph[node]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                visitCount[nextNode] += 1;
                dfs(nextNode, graph);
            }
        }
    }
    
    ArrayList[] winToLose;
    ArrayList[] loseToWin;
    int[] visitCount;
    boolean[] visited;
    public int solution(int n, int[][] results) {
        int answer = 0;
        visitCount = new int[n+1];
        winToLose = new ArrayList[n+1];
        loseToWin = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) {
            winToLose[i] = new ArrayList<Integer>();
            loseToWin[i] = new ArrayList<Integer>();
        }
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            winToLose[winner].add(loser);
            loseToWin[loser].add(winner);
        }
        
        for (int i=1; i<n+1; i++) {
            visited = new boolean[n+1];
            dfs(i,winToLose);
            dfs(i,loseToWin);
        }
        
        for (int i=1; i<n+1; i++) {
            if (visitCount[i] == n-1) answer++;
        }
        
        return answer;
    }
}