package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1743_음식물피하기 {
	static int[][] map;
	static int N, M, K;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		max = Integer.MIN_VALUE;
		
		for(int k=0;k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			map[r][c] = -1;
		}//end input
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == -1) dfs(i,j);
			}
		}
		//print();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max);
	}
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int dfs(int i, int j) {
		int cnt = 1;
		for(int d=0; d<4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];
			
			if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
			
			if(map[nexti][nextj] == -1) {
				map[nexti][nextj] = 0;
				map[i][j] = 0;
				cnt += dfs(nexti, nextj);
			}
		}
		map[i][j] = cnt;
		return cnt;
	}
	static void print() {
		System.out.println();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
