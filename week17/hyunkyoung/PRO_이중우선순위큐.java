import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 정렬 우선순위 큐
        
        for(String str : operations) {
            String op = str.split(" ")[0];
            int num = Integer.parseInt(str.split(" ")[1]);
            
            switch(op) {
                case "I": // 숫자 삽입
                    pq.add(num);
                    break;
                case "D":
                    if(!pq.isEmpty()) {
                        if(num == 1) { // 최댓값 삭제
                            PriorityQueue<Integer> temp_pq = new PriorityQueue<>();
                            while(pq.size() > 1) { // 최댓값만 남기고 temp_pq에 add
                                temp_pq.add(pq.poll());
                            }
                            pq = temp_pq; // pq를 temp_pq로 덮어 최댓값 삭제
                        } else if(num == -1) { // 최솟값 삭제
                            pq.poll();
                        }
                    }
                    break;
            }
        }
        
        if(pq.size() == 1) { // pq size가 1인 경우: 최댓값 = 최솟값
            answer[1] = pq.poll();
            answer[0] = answer[1];
        } else if(pq.size() > 1) { // pq size가 2 이상인 경우
            answer[1] = pq.poll(); // 최솟값
            while(pq.size() > 1) { // 최댓값만 남기고 poll
                pq.poll();
            }
            answer[0] = pq.poll(); // 최댓값
        }
        
        return answer;
    }
}