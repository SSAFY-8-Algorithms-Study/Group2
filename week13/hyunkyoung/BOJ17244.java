package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17244 { // 아맞다우산
	static int N, M;
	static char[][] map;
	static ArrayList<Node> list;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Node start, end;
	static int[] order;
	static boolean[] visit;
	static int total_dist;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 집 가로
		M = Integer.parseInt(st.nextToken()); // 집 세로
		
		map = new char[M][N];
		list = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'S') {
					start = new Node(i, j);
				} else if(map[i][j] == 'E') {
					end = new Node(i, j);
				} else if(map[i][j] == 'X') {
					list.add(new Node(i, j));
				}
			}
		} // end input
		
		order = new int[list.size()];
		visit = new boolean[list.size()];
		result = Integer.MAX_VALUE;
		
		pick(0);
		System.out.println(result);
	}
	
	// 챙길 순서 고르는 함수
	static void pick(int cnt) {
		if(cnt == list.size()) {
			// 걸음 수 계산
			result = Math.min(result, dist());
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(!visit[i]) {
				order[cnt] = i;
				visit[i] = true;
				pick(cnt + 1);
				visit[i] = false;
			}
		}
	}
	
	static int dist() {
		total_dist = 0;
		Node node1 = start;

		for(int i = 0; i < list.size(); i++) {
			int num = order[i];
			Node node2 = list.get(num);
			
			bfs(node1, node2);
			node1 = node2;
		}
		
		bfs(node1, end);
		return total_dist;
	}
	
	static void bfs(Node start, Node end) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[M][N];
		
		queue.add(start);
		visit[start.x][start.y] = true;
		int dist = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Node n = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
					
					if(0 <= nx && nx < M && 0 <= ny && ny < N && !visit[nx][ny]) {
						if(nx == end.x && ny == end.y) {
							total_dist += dist;
							return;
						}
						
						if(map[nx][ny] != '#') {
							queue.add(new Node(nx, ny));
							visit[nx][ny] = true;
						}
					}
				}
			}
			
			dist++;
		}
	}
	
	static class Node {
		int x, y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
