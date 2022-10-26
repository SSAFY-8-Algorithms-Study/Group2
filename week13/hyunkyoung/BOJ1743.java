package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1743 { // 음식물 피하기
	static int N, M, K;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int sum, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 통로 세로 길이
		M = Integer.parseInt(st.nextToken()); // 통로 가로 길이
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수
		
		map = new int[N + 1][M + 1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		} // end input
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 1) {
					bfs(i, j);
					result = Math.max(result, sum);
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		
		map[x][y] = 0;
		sum = 1;

		while(!queue.isEmpty()) {
			int node[] = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				
				if(0 <= nx && nx <= N && 0 <= ny && ny <= M) {
					if(map[nx][ny] == 1) {
						queue.add(new int[] {nx, ny});
						map[nx][ny] = 0;
						sum += 1;
					}
				}
			}
		}
	}
}
