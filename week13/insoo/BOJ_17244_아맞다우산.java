package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 17244 Gold 2
 * 아맞다우산
 */
public class BOJ_17244_아맞다우산 {
	static int[] rDir = {0, 1, 0, -1};
	static int[] cDir = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cntStuff = 0;
		Info start = new Info(0, 0);
		Info target = new Info(0, 0);
		
		int[][] map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				char v = strs[j].charAt(0);
				
				map[i][j] = v == '#' ? -1 : 0;
				if(v == 'X') map[i][j] = ++cntStuff;
				else if(v == 'S') start = new Info(i,j);
				else if(v == 'E') target = new Info(i,j);
			}
		}
		
		int maxPocket = (int) Math.pow(2, cntStuff); // 비트마스킹 최대치 + 1
		
		boolean[][][] visit = new boolean[M][N][maxPocket];
		visit[start.r][start.c][0] = true;
		
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(start.r, start.c, 0, 0, new boolean[cntStuff+1]));
		
		while(!q.isEmpty()) {
			Info e = q.poll();
			int r = e.r;
			int c = e.c;
			
			if(e.pocket == maxPocket-1 && r == target.r && c == target.c) {
				System.out.print(e.cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + rDir[i];
				int nc = c + cDir[i];
				
				if(nr>=0 && nr<M && nc>=0 && nc<N) {
					boolean[] list = e.list.clone();
					int pocket = e.pocket;
					int next = map[nr][nc];
					
					if(next > 0 && !list[next]) {
						list[next] = true;
						pocket = 0;
						
						for (int j = 1; j < list.length; j++) {
							pocket += list[j] ? Math.pow(2, j-1) : 0; // 비트마스킹
						}
					}
					
					if(!visit[nr][nc][pocket] && next >= 0) {
						visit[nr][nc][pocket] = true;
						q.add(new Info(nr, nc, e.cnt+1, pocket, list));
					}
				}
			}
		}
	}
	
	static class Info {
		int r, c, cnt, pocket;
		boolean[] list;
		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
		Info(int r, int c, int cnt, int pocket, boolean[] list) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.pocket = pocket;
			this.list = list;
		}
	}
}