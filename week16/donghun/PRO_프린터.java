import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] pri, int loc) {
        int answer = 0;
        
        // 큰 수 가중치 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 배열 -> 우선순위 큐 입력
        for(int i = 0;i<pri.length;i++){
            pq.add(pri[i]);
        }
        
        // 큐 쭉
        while(!pq.isEmpty()){
            for(int i = 0;i<pri.length;i++){
                
                // ㅠㅠ 벌금낼게
                
            }
        }
      
        
        return answer;
    }
}
