import java.util.Collections;
import java.util.PriorityQueue;

public class PROG_스택큐_level2_프린터 {
	public static void main(String[] args) {
//		int[] priorities = new int[] {2, 1, 3, 2};
//		int location = 2;
		
		Solution();
	}
	
	static void Solution() {
		int[] priorities = new int[] {1,1,9,1,1,1};
		int location = 0;
		
		int len = priorities.length; // 길이
		boolean[] visit = new boolean[len]; // 프린트 여부
		int idx = 0; // 프린트 탐색 인덱스
		int cnt = 0; // 인쇄 순서
		
		// 큰 우선순위가 앞에
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int e : priorities) pq.add(e);
		
		while(true) {
			if(idx == len) idx = 0; // 순환하도록
			
			if(visit[idx]) idx++; // 이미 프린트한 거라면 스킵
			else {
				if(priorities[idx] == pq.peek()) { // 현재 가장 큰 우선순위라면
					cnt++;
					
					if(idx == location) break; // 요청한 문서인가
					
					visit[idx] = true; // 프린트했다 표시
					idx++;
					pq.poll(); // 프린트하기
				}
				else idx++; // 다음 인덱스 거 보기
			}
		}
		System.out.print(cnt);
	}
}