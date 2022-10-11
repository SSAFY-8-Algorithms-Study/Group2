package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 { // 컴백홈
	static int R, C, K;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 거리
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(R - 1, 0, 1);
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int cnt) {
		if(cnt == K) {
			if(x == 0 && y == C - 1) {
				result++;				
			}
			
			return;
		}
		
		visit[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < R && 0 <= ny && ny < C) {
				if(map[nx][ny] != 'T' && !visit[nx][ny]) {
					dfs(nx, ny, cnt + 1);
					visit[nx][ny] = false;
				}
			}
		}
	}
}
