import java.util.ArrayDeque;
class PROG_그래프_level3_가장먼노드 {
    public int solution(int n, int[][] edge) {
        ArrayDeque<Integer>[] qList = new ArrayDeque[n+1];
		for (int i = 0; i <= n; i++) {
			qList[i] = new ArrayDeque<Integer>();
		}
		
		for (int i = 0; i < edge.length; i++) {
			int A = edge[i][0];
			int B = edge[i][1];
			
			qList[A].add(B); // 양방향 연결
			qList[B].add(A);
		}
		
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(1,0));
		
		boolean[] visit = new boolean[n+1];
		visit[1] = true;
		
		int maxEdge = 0; // 최대 거리
		int maxEdgeCnt = 0; // 최대 거리의 노드 수
		
		while(!q.isEmpty()) { // BFS
			Info el = q.poll();
			
			if(maxEdge <= el.cnt) {
				if(maxEdge < el.cnt) { // 최대 거리 갱신
					maxEdge = el.cnt;
					maxEdgeCnt = 0;
				}
				maxEdgeCnt++;
			}
			
			for(int e : qList[el.n]) {
				if(!visit[e]) { // 노드 방문 기록
					visit[e] = true;
					q.add(new Info(e, el.cnt+1));
				}
			}
		}
		
		return maxEdgeCnt;
	}
	
	static class Info {
		int n, cnt; // 노드, 거리
		Info(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
}