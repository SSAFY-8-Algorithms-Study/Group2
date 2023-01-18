package trying;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PROG_탐욕법_leve3_섬연결하기 {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.print(Solution(n, costs));
	}
	
	static int Solution(int n, int[][] costs) {
		ArrayList<Info>[] list = new ArrayList[n]; // 리스트 배열
		for (int i = 0; i < list.length; list[i++] = new ArrayList<>());
		
		for(int[] cost : costs) {
			list[cost[0]].add(new Info(cost[1], cost[2])); // 양방향
			list[cost[1]].add(new Info(cost[0], cost[2]));
		}
		
		boolean[] visit = new boolean[n];
		visit[0] = true;
		
		PriorityQueue<Info> pq = new PriorityQueue<>((a,b) -> a.w - b.w); // 건설비용 오름차순
		for(Info el : list[0])
			pq.add(new Info (el.to, el.w)); // 0부터 시작, 0과 연결된 다리 모두 넣어주기
		
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Info el = pq.poll(); // 현재 pq에 들어간 값 중 가장 적은 건설비용 요소 꺼내기
			
			if(visit[el.to]) continue; // 방문 검사
			visit[el.to] = true; // 방문 기록
			
			sum += el.w;
			
			for(Info next : list[el.to])
				if(!visit[next.to]) // 현재 방문한 섬의 다리 중 방문하지 않은 섬과 연결된다면 pq에 추가
					pq.add(new Info (next.to, next.w));
		}
		
		return sum;
	}
	
	static class Info {
		int to, w;
		Info(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
}