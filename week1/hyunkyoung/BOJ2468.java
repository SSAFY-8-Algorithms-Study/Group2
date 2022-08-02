package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int result = 0;
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		for(int m = 0; m <= max; m++) {
			int area = 0;
			visit = new boolean[N][N]; // 방문 여부
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > m && !visit[i][j]) {
						check(m, i, j);
						area += 1;
					}
				}
			}
			
			result = Math.max(result, area);
		}
		
		System.out.println(result);
	}
	
	static void check(int h, int x, int y) {
		visit[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(map[nx][ny] > h && visit[nx][ny] == false) {
					check(h, nx, ny);
				}
			}
		}
	}
	
}
