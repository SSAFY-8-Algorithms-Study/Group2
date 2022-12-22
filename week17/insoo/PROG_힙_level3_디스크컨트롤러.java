package trying;
import java.util.PriorityQueue;

public class PROG_힙_level3_디스크컨트롤러 {
	public static void main(String[] args) {
		Solution();
	}
	
	static void Solution() {
		int[][] jobs = {{0,16}, {0,14}, {15,1}, {13,13}}; // expect 14 15 13 44 /44 = 21
		// 왜 안 되나요? expect 16 2 17 44 /44 = 19
		/////////////////////////////////////////
		
		
		PriorityQueue<int[]> idxPQ = new PriorityQueue<>( // 요청시점 기준 정렬
				(a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>( // 들어온 요청까지 작업소요시간 우선순위
				(a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		
		for(int[] e : jobs)
			idxPQ.add(new int[] {e[0], e[1]});
		
		int sum = 0; // 요청 처리시간 합
		int idx = 0; // 처리 후 현재 시간
		
		while(!idxPQ.isEmpty() || !pq.isEmpty()) { // 두 pq가 비어있지 않을 떄
			if(pq.isEmpty()) // pq 비어있다면 idxPQ에서 가장 앞에 거 꺼내기
				pq.add(idxPQ.poll());
			
			int initIdx = Math.max(idx, pq.peek()[0]); // 현재 시간과 pq에 담긴 요청 시간 중 큰 값
			
			while(!idxPQ.isEmpty() && initIdx >= idxPQ.peek()[0]) // initIdx 이하의 요청시간을 가지는 요소들은 idxPQ에서 꺼내기
				pq.add(idxPQ.poll());
			
			int[] e = pq.poll(); // pq 중 처리시간 가장 짧은 거
			
			if(idx <= e[0] ) { // 요청 시간이 현재 시간 이상이라면
				idx = e[0] + e[1];
				sum += e[1];
			}
			else { // 요청 시간이 현재 시간 전이라면
				idx += e[1];
				sum += idx - e[0];
			}
		}
		System.out.print(sum / jobs.length);
	}
}