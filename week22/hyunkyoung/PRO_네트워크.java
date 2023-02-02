import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int num, int total, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        visit[num] = true;
        
        while(!queue.isEmpty()) {
            int n = queue.poll();
            
            for(int i = 0; i < total; i++) {
                if(computers[n][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}