package trying;
import java.util.PriorityQueue;

public class PROG_힙_level2_더맵게 {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.print(Solution(scoville, K));
	}
	
	static int Solution(int[] scoville, int K) {
		int cnt = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e : scoville) // 모든 음식 스코빌 지수를 pq에 넣어 정렬
        	pq.add(e);
        
        while(pq.size() > 1 && pq.peek() < K) { // K보다 작은 요소가 있다면
            cnt++;
            int A = pq.poll(); // 가장 작은 수 두개 꺼내서
            int B = pq.poll();
            pq.add(A + (B * 2)); // 공식 대입 후 pq에 다시 추가
        }
        
        int answer = pq.peek() > K ? cnt : -1; // 가장 작은 지수가 K보다 큰가
        return answer;
	}
}