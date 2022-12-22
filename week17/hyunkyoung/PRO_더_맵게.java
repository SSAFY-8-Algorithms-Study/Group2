import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int new_scoville = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 정렬
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(true) {
            if(pq.size() == 1) { // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
                answer = -1;
                break;
            }
            
            new_scoville = pq.poll() + 2 * pq.poll();
            pq.add(new_scoville); // 새로운 음식의 스코빌 지수 add
            answer++; // 섞은 횟수 1 증가
            
            if(pq.peek() >= K) break; // 최소 스코빌 지수가 K 이상인 경우 while문 종료
        }
        
        return answer;
    }
}