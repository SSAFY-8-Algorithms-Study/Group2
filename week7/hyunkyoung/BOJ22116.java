package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22116 { // 창영이와 퇴근
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		System.out.println(dist[N - 1][N - 1]);
	}
	
	static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.x == N - 1 && n.y == N - 1) break;
				
			for(int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
					
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(dist[nx][ny] > Math.max(dist[n.x][n.y], Math.abs(map[nx][ny] - map[n.x][n.y]))) {
						dist[nx][ny] = Math.max(dist[n.x][n.y], Math.abs(map[nx][ny] - map[n.x][n.y]));					
						pq.add(new Node(nx, ny, Math.abs(map[nx][ny] - map[n.x][n.y])));
					}
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int x, y, h;
		
		Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public int compareTo(Node o) {
			return this.h - o.h;
		}
	}
}
