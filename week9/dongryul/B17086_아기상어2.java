package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17086_아기상어2 {
	static int N, M;
	static int[][] map;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					bfs(new Point(i,j));
				}
			}
		}
		System.out.println(max);
	}
	static int[] di = {1, -1, 0, 0,    -1, 1, 1, -1};
	static int[] dj = {0, 0, -1 ,1,     1, 1, -1, -1};
	static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(start);
		visited[start.i][start.j] = true;
		
		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point now = q.poll();
				if(map[now.i][now.j] == 1) {
					if(max < dist ) {
						max = dist;
					}
					return;
				}
				for(int d=0; d<8; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					
					if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) {
						continue;
					}
					if(visited[nexti][nextj]) {
						continue;
					}

					q.add(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
				
			}
			dist++;
		}
	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		
	}
}
