package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2917 { // 늑대 사냥꾼 
	
	static int N; // 행 
	static int M; // 열 
	static int[][] map;
	static int ey; // 오두막 y 
	static int ex; // 오두막 x
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; // 나무로부터 거리맵 
		// 거리맵 최댓값으로 채우기
		for (int i=0; i<N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);  
		}

		ArrayDeque<int[]> dq = new ArrayDeque<int[]>(); // dijkstra queue
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->{return map[o2[0]][o2[1]] - map[o1[0]][o1[1]];}); // bfs queue

		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<M; j++) {
				char c = str.charAt(j);
				// 오두막 위치 저장 
				if (c=='J') { 
					ey = i;
					ex = j;
				}
				
				// 출발지 BFS 큐에 추가 
				if (c=='V') { 
					pq.add(new int[] {i,j});
				}
				
				// 나무 다익스트라 큐에 추가
				if (c=='+') { // 나무 
					map[i][j] = 0; // 거리 0
					dq.add(new int[] {i,j});
				}
			}
		}
		
		// 다익스트라 - 다음 좌표까지 거리를 체크하고 최단 거리로 갱신 
		while (!dq.isEmpty()) { 
			int[] arr = dq.poll(); // 현재 좌표 
			int y = arr[0]; // 나무의 y좌표 
			int x = arr[1]; // 나무의 x좌표 
			
			// 주변에 최단 거리로 갱신이 가능한지 사방으로 탐색 
			for (int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (0<= ny && ny < N && 0 <= nx && nx <M) {
					if (map[y][x] + 1 < map[ny][nx]) { // 최단 거리 갱신 가능한지 체크 
						map[ny][nx] = map[y][x] + 1; // 최단 거리 갱신 
						dq.offer(new int[] {ny,nx}); // 해당 좌표 최단거리가 갱신되면 주변 거리까지 다시 갱신해야 됨 
					}
				}
			}
		}
		
		// 오두막 찾아가기 - 위에서 구한 나무까지 거리랑 최대한 멀리인 좌표 찾아가기 
		int ans = Integer.MAX_VALUE; // 경로 중 나무로부터 최솟값 
		while (!pq.isEmpty()) { 
			int[] arr = pq.poll(); // 현재 위치 
			int y = arr[0];
			int x = arr[1];
			if(map[y][x] == Integer.MAX_VALUE) continue; // 이미 방문했으면 넘어감 
			ans = Math.min(ans, map[y][x]); // 경로 중 최솟값 체크 
			map[y][x] = Integer.MAX_VALUE; // 방문 체크 
			
			// 오두막 도착 
			if (y == ey && x == ex) { 
				System.out.println(ans);
				break;
			}

			for (int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (0<= ny && ny < N && 0 <= nx && nx <M && map[ny][nx] != Integer.MAX_VALUE) { // 아직 방문하지 않은 좌표 탐색 
					pq.offer(new int[] {ny,nx});
				}
			}
		}

		// 목적지에 도착할 수 없다면 무조건 나무를 지나야한다. 
		if (ans == Integer.MAX_VALUE) { 
			System.out.println(0);
		}
	}

}
