import java.util.Queue;
import java.util.ArrayDeque;

class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            queue.add(i); // 인쇄 대기목록 문서 넣기
        }
        
        while(true) {
            int doc = queue.poll(); // 인쇄 대기목록 가장 앞 문서 꺼내기
            boolean print = true;
            
            Queue<Integer> queue_copy = new ArrayDeque<>(queue); // 남은 문서 복사
            int size = queue.size();
            
            // 남은 문서 중 가장 중요도가 높은 문서인지 탐색
            for(int i = 0; i < size; i++) {
                int next_doc = queue.poll();
                
                // 가장 앞 문서보다 중요도가 높은 문서가 남아있는 경우
                if(priorities[doc] < priorities[next_doc]) {
                    queue_copy.add(doc); // 가장 앞 문서를 대기목록의 가장 마지막에 넣기
                    print = false; // 인쇄 불가능
                    break;
                }
            }
            
            queue = queue_copy;
            
            if(print) { // 가장 앞 문서가 인쇄된 경우
                answer++; // 인쇄 순서 1 증가
                if(location == doc) break; // 인쇄된 문서가 인쇄를 요청한 문서라면 break
            }
        }
        
        return answer;
    }
}
