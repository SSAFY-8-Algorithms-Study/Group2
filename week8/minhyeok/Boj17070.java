package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17070 { // 파이프 옮기기 1
	
	static int N;
	static int[][] map;
	static char[][] dir;
	static boolean[][] visited;
	static int cnt;
	
	static void dfs(int y, int x) {
		if (y == N-1 && x == N-1) {
			cnt++;
			return;
		}
		
		if (dir[y][x] == 'r' ) { // 우 
			int[] dy = {0,1}; // 우, 대각 
			int[] dx = {1,1};
			for (int d=0; d<2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]) {
					if (d==0 && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'r';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					} else if (d==1 && map[ny][nx] != 1 && map[ny][x] != 1 && map[y][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'e';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					}
				}
			}
		} else if (dir[y][x] == 'd') { // 아래 
			int[] dy = {1,1}; // 아래, 대각 
			int[] dx = {0,1};
			for (int d=0; d<2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]) {
					if (d==0 && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'd';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					} else if (d==1 && map[ny][nx] != 1 && map[ny][x] != 1 && map[y][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'e';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					}
				}
			}

		} else if (dir[y][x] == 'e') {
			int[] dy = {1,1,0};
			int[] dx = {0,1,1};
			for (int d=0; d<3; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]) {
					if (d==0 && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'd';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					} else if (d==1 && map[ny][nx] != 1 && map[ny][x] != 1 && map[y][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'e';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					} else if (d==2 && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						dir[ny][nx] = 'r';
						dfs(ny,nx);
						visited[ny][nx] = false;
						dir[ny][nx] = ' ';
					}
				}
			}

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dir = new char[N][N];
		dir[0][0] = 'r';
		dir[0][1] = 'r';
		
		dfs(0,1);
		System.out.println(cnt);
	}

}
