package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 1189 Silver 1
 * 컴백홈
 */
public class BOJ_1189_컴백홈 {
	static int R, C, K, cnt;
	static int[] xDir = {0, 1, 0, -1};
	static int[] yDir = {1, 0, -1, 0};
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[R][C];
		visited[R-1][0] = true;
		dfs(R-1, 0, 0);
		System.out.print(cnt);
	}
	
	static void dfs(int x, int y, int step) {
		if(step >= K) return;

		if(step == K-1 && x == 0 && y == C-1) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int xx = x + xDir[i];
			int yy = y + yDir[i];
			
			if(xx>=0 && xx<R && yy>=0 && yy<C && map[xx][yy] == '.' && !visited[xx][yy]) {
				visited[xx][yy] = true;
				dfs(xx, yy, step+1);
				visited[xx][yy] = false;
			}
		}
	}
}