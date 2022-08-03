package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		int result = 0;
		
		// 빙하가 다 녹을 때까지 반복
		while(water()) {
			year += 1;
			
			int area = 0;
			visit = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 0 && !visit[i][j]) {
						check(i, j);
						area += 1;
					}
				}
			}
			
			// 덩어리 2개 이상이면 종료
			if(area >= 2) {
				result = year;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	// 빙하 녹이는 함수
	static boolean water() {
		boolean ice = false;
		
		int[][] map_copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map_copy[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					for(int d = 0; d < 4; d++) {
						int ni = i + dx[d];
						int nj = j + dy[d];
						if(0 <= ni && ni < N && 0 <= nj && nj < M) {
							if(map_copy[ni][nj] == 0 && map[i][j] > 0) {
								map[i][j] -= 1;
							}
						}
					}
					
					if(map[i][j] != 0) {
						ice = true;
					}
				}
			}
		}
		
		return ice;
	}
	
	// 덩어리 체크하는 함수
	static void check(int x, int y) {
		visit[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if(map[nx][ny] != 0 && !visit[nx][ny]) {
					check(nx, ny);
				}
			}
		}
	}
	
}
