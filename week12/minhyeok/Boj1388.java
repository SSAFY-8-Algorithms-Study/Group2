package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1388 { // 바닥 장식 - DFS
	
	static int N;
	static int M;
	static boolean[][] visited;
	static int ans;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					dfs(i,j,map[i][j]); // 탐색하는 타일의 모양을 변수로 넘기기
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int y, int x, char target) {
		
		int ny = y;
		int nx = x;
		if (target == '-') {
			nx += 1; // 우로 
		} else {
			ny += 1; // 아래로 
		}
		
		if (ny <N && nx <M && !visited[ny][nx] && map[ny][nx] == target) {
			visited[ny][nx] = true;
			dfs(ny,nx,target);
		}
	}

}
