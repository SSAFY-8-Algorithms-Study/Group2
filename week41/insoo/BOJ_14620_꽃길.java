package pending;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_14620_꽃길 {
	static int N, minCost = Integer.MAX_VALUE;
	static int[] rDir = {0, 0, 1, 0, -1};
	static int[] cDir = {0, 1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(1, 1, 0, 0);
		
		System.out.print(minCost);
	}
	
	static void find(int r, int c, int cnt, int cost) { // 백트래킹
		if(minCost < cost || (r==N-1 && cnt < 3)) return; // 처리
		
		if(cnt == 3) {
			minCost = cost;
			return;
		}
		
		int nr = c < N-2 ? r : r+1; // 다음 r
		int nc = c < N-2 ? c+1 : 1; // 다음 c
		
		if(check(r, c)) { // 검증
			int costPlus = draw(r, c, true); // 기록
			find(nr, nc, cnt+1, cost + costPlus); // 다음으로
			
			draw(r, c, false); // 기록 삭제
		}
		find(nr, nc, cnt, cost); // 다음으로
		
		return;
	}
	
	static boolean check(int r, int c) { // 꽃잎 필 수 있는지 확인
		for (int d = 0; d < 5; d++) {
			int nr = r + rDir[d];
			int nc = c + cDir[d];
			
			if(visit[nr][nc]) return false;
		}
		
		return true;
	}
	
	static int draw(int r, int c, boolean v) { // 꽃잎 기록 및 해당 비용 합 구하기
		int cost = 0;
		
		for (int d = 0; d < 5; d++) {
			int nr = r + rDir[d];
			int nc = c + cDir[d];
			
			visit[nr][nc] = v;
			cost += map[nr][nc];
		}
		
		return cost;
	}
}