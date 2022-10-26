package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj1743 { // 음식물 피하기 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로 
		int K = Integer.parseInt(st.nextToken()); // 음식물 개수 
		
		boolean[][] food = new boolean[N][M]; // 음식물 맵, true => 음식물  
		boolean[][] visited = new boolean[N][M]; // 방문 체크 배열 
		int[][] pos = new int[K][2]; // 음식물 위치 저장 배열 
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			food[y][x] = true; // 음식물 체크 
			pos[i] = new int[] {y,x}; // 음식물 저장 
		}
		
		int maxSize = 1; // 최대 음식물 크기 
		int[] dy = {0,0,-1,1};
		int[] dx = {1,-1,0,0};
		
		for (int i=0; i<K; i++) { // 음식물 개수 만큼 너비우선탐색 
			// i번째 음식물 위치 
			int y = pos[i][0];
			int x = pos[i][1];
			
			int size = 1;
			if (!visited[y][x]) { // 주변 음식물 탐색 
				visited[y][x] = true;
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.add(new int[] {y,x});
				while (!q.isEmpty()) {
					
					int[] arr = q.poll();
					int cy = arr[0];
					int cx = arr[1];
					
					for (int d=0; d<4; d++) {
						int ny = cy + dy[d];
						int nx = cx + dx[d];
						if (0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx] && food[ny][nx]) {
							size++; 
							visited[ny][nx] = true;
							q.add(new int[] {ny,nx});
						}
					}
				} // end while
				maxSize = Math.max(maxSize, size); // 최대 음식물 크기 저장 
			}
		}
		
		System.out.println(maxSize);
	}

}
