package adj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B22116_창영이와퇴근 {
	static int N;
	static int[][] map;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}// input end
		
		bfs();
		System.out.println(max);
	}
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1 ,1};
	
	static void bfs() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			visited[now.i][now.j] = true;
			if(max < now.d) {
				max = now.d;
			}
			if(now.i == N-1 && now.j == N-1) {
				return;
			}
			for(int d=0; d<4; d++) {
				int nexti  = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) {
					continue;
				}
				if(visited[nexti][nextj]) {
					continue;
				}
				pq.add(new Point(nexti, nextj, Math.abs(map[now.i][now.j] - map[nexti][nextj])));
			}
			
		}
	
	}
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int d;
		public Point(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}
		@Override
		public int compareTo(Point o) {
			return this.d - o.d;
		}
	}
	
}
