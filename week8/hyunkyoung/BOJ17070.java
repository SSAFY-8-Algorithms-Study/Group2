package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 { // 파이프 옮기기1
	static int N;
	static int[][] map;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 0, 1);
		System.out.println(result);
	}
	
	static void dfs(int p, int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return;
		
		if(map[x][y] == 1) return;
		if(p == 3 && (map[x - 1][y] == 1 || map[x][y - 1] == 1)) return;
		
		if(x == N - 1 && y == N - 1) {
			result += 1;
			return;
		}
		
		if(p == 1) {
			dfs(1, x, y + 1);
			dfs(3, x + 1, y + 1);
		} else if(p == 2) {
			dfs(2, x + 1, y);
			dfs(3, x + 1, y + 1);
		} else if(p == 3) {
			dfs(1, x, y + 1);
			dfs(2, x + 1, y);
			dfs(3, x + 1, y + 1);
		}
	}
}
