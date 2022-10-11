package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1189_컴백홈 {
	static int R, C, K;
	static char[][] map;
	static boolean[][] visited;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited  = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j] = arr[j];
			}
		}
		map[R-1][0] = 'T';
		dfs(new Point(R-1, 0), 1);
		System.out.println(ans);
	}
	static void dfs(Point p, int cnt) {
		if(p.i == 0 && p.j == C-1) {
			if(cnt == K) ans++;
			return;
		}
		if(cnt > K) {
			return;
		}
		for(int d=0; d<4; d++) {
			int nexti = p.i + di[d];
			int nextj = p.j + dj[d];
			
			if(nexti < 0 || nexti >= R || nextj < 0 || nextj >= C) {
				continue;
			}
			if(map[nexti][nextj] == 'T') {
				continue;
			}
			map[nexti][nextj] = 'T';
			dfs(new Point(nexti, nextj), cnt+1);
			map[nexti][nextj] = '.';
		}
	}
	static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
