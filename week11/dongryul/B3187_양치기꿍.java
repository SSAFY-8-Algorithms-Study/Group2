package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3187_양치기꿍 {
	static int N,M;
	static char[][] map;
	static boolean[][] visited;
	static int total_sheep;
	static int total_wolf;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		total_sheep = 0;
		total_wolf = 0;
		
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = arr[j];
			}
		}
		
		// 구역별 bfs
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) continue;
				if(map[i][j] == '#') continue;
				bfs(i,j);
			}
		}
		
		System.out.println(total_sheep + " " + total_wolf);
	}
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		visited[i][j] = true;
		
		int sheep = 0;
		int wolf = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(map[now.i][now.j] == 'v') wolf++;
			if(map[now.i][now.j] == 'k') sheep++;
			
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
				if(visited[nexti][nextj]) continue;
				if(map[nexti][nextj] == '#') continue;
				
				visited[nexti][nextj] = true;
				q.add(new Point(nexti, nextj));
			}
		}
		
		// 양 > 늑대
		if(sheep > wolf) {
			wolf = 0;
		}else {
			sheep = 0;
		}
		total_sheep += sheep;
		total_wolf += wolf;
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
