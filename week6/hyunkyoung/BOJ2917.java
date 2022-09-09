package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2917 { // 늑대 사냥꾼
	static int N, M;
	static char[][] map;
	static int[][] dist;
	static boolean[][] visit;
	static int startX, startY, endX, endY;
	static Queue<Node> tree;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new char[N][M];
		dist = new int[N][M];
		visit = new boolean[N][M];
		tree = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				dist[i][j] = Integer.MAX_VALUE;
				
				if(map[i][j] == 'V') {
					startX = i; startY = j;
				}
				
				if(map[i][j] == 'J') {
					endX = i; endY = j;
				}
				
				if(map[i][j] == '+') {
					dist[i][j] = 0;
					tree.add(new Node(i, j));
				}
			}
		}
		
		bfs();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startX, startY));
		visit[startX][startY] = true;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
				
			if(n.x == endX && n.y == endY) {
				max = dist[n.x][n.y];
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
					
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(dist[nx][ny] > dist[n.x][n.y]) {
						dist[nx][ny] = dist[n.x][n.y];
					}
					
					if(!visit[nx][ny]) {
						visit[nx][ny] = true;
						pq.add(new Node(nx, ny));
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs() {
		while(!tree.isEmpty()) {
			Node n = tree.poll();
				
			for(int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
					
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(map[nx][ny] != '+') {
						if(dist[nx][ny] > dist[n.x][n.y] + 1) {
							dist[nx][ny] = dist[n.x][n.y] + 1;
							tree.add(new Node(nx, ny));
						}
					}
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int x, y, w;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.w = dist[x][y];
		}

		@Override
		public int compareTo(Node o) {
			return o.w - this.w;
		}
	}
}
