package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 { // 벽 부수고 이동하기
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		visit = new boolean[2][N][M]; // 0: 벽 부순적 없음, 1: 벽 부순적 있음
		
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
		que.add(new int[] {0, 0, 1, 0}); // x 좌표, y 좌표, 이동 횟수, 공사 여부
		visit[0][0][0] = true;
		
		while(!que.isEmpty()) {
			int[] node = que.poll();
			int nx = node[0];
			int ny = node[1];
			int nr = node[2];
			int nc = node[3];
			
			if(nx == N - 1 && ny == M - 1) {
				return nr;
			}
			
			for(int d = 0; d < 4; d++) {
				int newX = nx + dx[d];
				int newY = ny + dy[d];
				
				if(0 <= newX && newX < N && 0 <= newY && newY < M) {
					// 벽이 아닌 경우
					if(map[newX][newY] == 0) {
						// 이전에 벽 부순 경우, 안부순 경우 맞춰서 방문 배열 체크
						if(visit[nc][newX][newY] == false) {
							que.add(new int[] {newX, newY, nr + 1, nc});
							visit[nc][newX][newY] = true;
						}
					}
					
					// 벽인 경우
					if(map[newX][newY] == 1) {
						// 벽 부술 횟수 남은 경우, 벽 부순 경우의 방문 배열 체크
						if(nc == 0 && visit[1][newX][newY] == false) {
							que.add(new int[] {newX, newY, nr + 1, 1});
							visit[1][newX][newY] = true;
						}
					}
				}
			}
		}
		
		return -1;
	}
}
