package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 { // 아기 상어2
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
	static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					result = Math.max(distance(i, j), result);
				}
			}
		}
		
		System.out.println(result);
	}

	static int distance(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		
		q.add(new int[] {x, y, 0});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			
			for(int d = 0; d < 8; d++) {
				int nx = n[0] + dx[d];
				int ny = n[1] + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(!visit[nx][ny] && map[nx][ny] == 0) {
						q.add(new int[] {nx, ny, n[2] + 1});
						visit[nx][ny] = true;
					}
					
					if(map[nx][ny] == 1) return n[2] + 1;
				}
			}
		}
		
		return 0;
	}
}
