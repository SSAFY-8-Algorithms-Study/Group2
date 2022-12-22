package programmers.heap;

import java.util.PriorityQueue;

public class PRO_더_맵게 {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        
	        // 오름차순으로 넣기
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        
	        // 스코빌 지수가 K를 넘지 않는 음식의 갯수 세기
	        int count = 0;

	        // PQ에 넣기
	        for(int scov : scoville){
	            if(K > scov) count++;
	            pq.add(scov);
	        }
	        while(count > 0){
	            // 가장 맵지 않은 음식의 스코빌 지수 + (두 번째 맵지 않은 음식의 스코빌 지수 * 2)
	            int firstFood = pq.poll();
	            int secondFood = pq.poll();
	            count-=2;
	            
	            int newFood = firstFood + (secondFood * 2);
	            
	            //새로 만든 음식이 넘지 않는다면 count++;
	            if(newFood < K) count++;
	            
	            //마지막으로 만든 음식이 K를 넘지 않는다면 -1
	            if(pq.isEmpty()){
	                if(newFood < K){
	                    answer = -1;
	                    break;
	                }
	            }
	            // 새 음식 추가
	            pq.add(newFood);
	            
	            // 섞은 횟수 ++
	            answer++;
	        }

	        return answer;
	}
}
