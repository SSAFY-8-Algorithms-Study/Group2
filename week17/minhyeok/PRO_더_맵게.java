import java.util.PriorityQueue;

class Solution {
    /** 
        1. 스코빌 지수들을 우선순위 큐(오름차순 정렬)에 집어 넣는다.
        2. 원소를 하나 꺼냈을 때,
            2-1. K 보다 작다면 
                2-1-1. 원소를 하나 더 꺼내 새로운 음식을 만든다.
                2-1-2, 원소가 하나 더 없다면 return -1
            2-2. K 이상이면 return 횟수
    **/
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> o1-o2);
        // 스코빌을 집어 넣기
        for (int s : scoville) pq.add(s);
        int cnt = 0;
        // 하나씩 꺼내 보기
        while(!pq.isEmpty()) {
            int scv = pq.poll();
            // 모든 스코빌이 K 이상이면 종료 
            if (scv >= K) return cnt;
            
            // 음식을 섞어 새로운 음식의 스코빌 만들기
            if (pq.isEmpty()) return -1;
            int scv2 = pq.poll();
            pq.add(scv+scv2*2);
            cnt++;
        }
        return -1;
    }
}