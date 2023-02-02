import java.util.ArrayDeque;
class PROG_게임맵최단거리 {
    public int solution(int[][] maps) {
        int R = maps.length; // 맵의 가로줄 길이
		int C = maps[0].length; // 맵의 세로줄 길이
		
		int[] rDir = {0, 1, 0, -1}; // 우하좌상
		int[] cDir = {1, 0, -1, 0};
		
		boolean[][] visit = new boolean[R][C]; // 방문 기록
		visit[0][0] = true;
		
		ArrayDeque<Info> q = new ArrayDeque<>(); // BFS 큐
		q.add(new Info(0,0,1)); // 출발
		
		while(!q.isEmpty()) {
			Info el = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextR = el.r + rDir[i];
				int nextC = el.c + cDir[i];
				
				if(nextR == R-1 && nextC == C-1) return el.d+1; // 도착
				
				if(nextR>=0 && nextC>=0 && nextR<R && nextC<C &&
						maps[nextR][nextC] == 1 && !visit[nextR][nextC]) {
					visit[nextR][nextC] = true;
					q.add(new Info(nextR, nextC, el.d + 1)); // 다음 칸
				}
			}
		}
		
		return -1;
	}
	
	static class Info{ 
		int r, c, d; // 가로줄 세로줄 거리
		Info(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}