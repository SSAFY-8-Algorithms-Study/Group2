package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427_불 {
	static int M,N;
	static char[][] map;
	static Point people;
	static Queue<Point> fire;
	static boolean[][] visited_F;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new char[N][];
			visited_F = new boolean[N][M];
			fire = new LinkedList<>();
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(map[i][j] == '@') {
						people = new Point(i,j);
					}else if(map[i][j] == '*') {
						fire.add(new Point(i,j));
					
					}
	
				}
			}// end input
			bfs();
		}
	}
	static int[] di = {1, -1, 0 , 0};
	static int[] dj = {0, 0, -1, 1};
	static void bfs() {

		boolean[][] visited_P = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		
		q.add(people);							// 사람
		visited_P[people.i][people.j] = true;
		int time = 0;
		try {

			//불 먼저
			
			while(!q.isEmpty()) {
				int size = q.size();
				fire();
				for(int s=0; s<size; s++) {
					Point now = q.poll();

					for(int d=0; d<4; d++) {
						int nexti = now.i + di[d];
						int nextj = now.j + dj[d];
						
						if(visited_P[nexti][nextj]) continue;
						
						// 땅만 갈 수 있음.
						if(map[nexti][nextj] == '.') {
							visited_P[nexti][nextj] = true;
							q.add(new Point(nexti, nextj));
						}
					}
				}
				time++;
		
			}
		}catch(Exception e) {
			System.out.println(time+1);
			return;
		}
		System.out.println("IMPOSSIBLE");
	}
	static void fire() {
		int size = fire.size();
		for(int s=0; s<size; s++) {
			Point now = fire.poll();
			
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
				if(visited_F[nexti][nextj]) continue;
				if(map[nexti][nextj] != '#') {	//벽아닌곳 다갈 수 있음
					visited_F[nexti][nextj] = true;
					fire.add(new Point(nexti, nextj));
					map[nexti][nextj] = '*';
				}
			}	
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
