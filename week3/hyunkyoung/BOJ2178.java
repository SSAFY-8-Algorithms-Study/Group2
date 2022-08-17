package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 { // 미로 탐색
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {0, 0});
		map[0][0] = 2;
		
		while(!que.isEmpty()) {
			int[] node = que.poll();
			int nx = node[0];
			int ny = node[1];
			
			if(nx == N - 1 && ny == M - 1) {
				return map[nx][ny] - 1;
			}
			
			for(int d = 0; d < 4; d++) {
				int newX = nx + dx[d];
				int newY = ny + dy[d];
				
				if(0 <= newX && newX < N && 0 <= newY && newY < M) {
					if(map[newX][newY] == 1) {
						que.add(new int[] {newX, newY});
						map[newX][newY] = map[nx][ny] + 1;
					}
				}
			}
		}
		
		return 0;
	}
}
