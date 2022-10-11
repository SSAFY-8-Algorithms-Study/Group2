package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1189 { // 컴백홈 - 시작점 출발점 체크 !! 백트래킹 

	static int R;
	static int C;
	static int K;
	static char[][] map;
	static int ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void dfs(int y, int x, int move, boolean[][] visited) {
		if (move == K) {
			if (y == 0 && x == C-1) {
				ans++;
			}
			return;
		}
		
		for (int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (0 <= ny && ny < R && 0<= nx && nx < C && !visited[ny][nx] && map[ny][nx] != 'T') {
				visited[ny][nx] = true;
				dfs(ny,nx,move+1,visited);
				visited[ny][nx] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean[][] visited = new boolean[R][C];
		visited[R-1][0] = true;
		dfs(R-1,0,1,visited);
		System.out.println(ans);
	}
}