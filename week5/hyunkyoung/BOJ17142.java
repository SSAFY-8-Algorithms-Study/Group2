package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142 { // 연구소3
	static int N, M;
	static int[][] map;
	static ArrayList<Virus> vList;
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int[] virusOn;
	static int empty;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 연구소 크기
		M = Integer.parseInt(st.nextToken()); // 활성 바이러스 개수
		
		map = new int[N][N]; // 연구소 배열 (0: 빈칸, 1: 벽, 2: 바이러스)
		vList = new ArrayList<>(); // 바이러스 위치
		virusOn = new int[M]; // 활성 바이러스 조합
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					vList.add(new Virus(i, j));
				}
				
				if(map[i][j] == 0) {
					empty++; // 빈 공간 개수
				}
			}
		} // end input
		
		if(empty == 0) {
			System.out.println(0);
		} else {
			comb(0, 0);
			if(ans == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(ans);			
		}
	}
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			int min = bfs(empty); // 바이러스 확산
			if(min != -1) ans = Math.min(ans, min);
			return;
		}
		
		for(int i = start; i < vList.size(); i++) {
			virusOn[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	static int bfs(int empty) {
		Queue<Virus> que = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][N];

		for(int i = 0; i < M; i++) {
			Virus v = vList.get(virusOn[i]);
			visit[v.x][v.y] = true;
			que.add(v);
		}
		
		int time = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int s = 0; s < size; s++) {
				Virus v = que.poll();
				
				for(int d = 0; d < 4; d++) {
					int ni = v.x + di[d];
					int nj = v.y + dj[d];
					
					if(0 <= ni && ni < N && 0 <= nj && nj < N) {
						if(map[ni][nj] != 1 && !visit[ni][nj]) {
							if(map[ni][nj] == 0) empty--;
							
							que.add(new Virus(ni, nj));
							visit[ni][nj] = true;
						}
					}
				}
			}
			
			time++;
			if(empty == 0) return time;
		}
		
		return -1;
	}
	
	static class Virus {
		int x, y;
		
		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
