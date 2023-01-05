import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        boolean[][] connect = new boolean[n + 1][n + 1];
        
        // 전선 정보 입력
        for(int i = 0; i < n - 1; i++) {
            int[] info = wires[i];
            connect[info[0]][info[1]] = true;
            connect[info[1]][info[0]] = true;
        }
        
        // 모든 전선 하나씩 끊어보기
        for(int i = 0; i < n - 1; i++) {
            int[] info = wires[i];
            connect[info[0]][info[1]] = false;
            connect[info[1]][info[0]] = false;
            
            int left = bfs(n, connect);
            int right = n - left;
            answer = Math.min(Math.abs(left - right), answer);
            
            connect[info[0]][info[1]] = true;
            connect[info[1]][info[0]] = true;
        }
        
        return answer;
    }
    
    static int bfs(int n, boolean[][] connect) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        int cnt = 0;
        
        queue.add(1);
        visit[1] = true;
        
        while(!queue.isEmpty()) {
            int tower = queue.poll();
            cnt += 1;
            
            for(int i = 1; i < n + 1; i++) {
                if(!visit[i] && connect[tower][i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        
        return cnt;
    }
}