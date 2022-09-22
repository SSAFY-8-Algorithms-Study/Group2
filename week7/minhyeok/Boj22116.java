package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj22116 { // 창영이와 퇴근 
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException { // 창영이와 퇴근 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N]; // 퇴근길의 높이 
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->{return o1[2]-o2[2];}); // 경사 기준 오름차순 정렬 
		
		int[][] minHeight = new int[N][N];
		for (int[] arr: minHeight) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		minHeight[0][0] = 0;
		
		int ans = 0;
		pq.add(new int[] {0,0,0});
		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			int y = arr[0];
			int x = arr[1];
			int h = arr[2]; // 경사 
			ans = Math.max(h, ans); // 최대 경사의 최솟값 
			if (y == N-1 && x == N-1) break;
			
			for (int d=0; d<4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if (0<=ny && ny<N && 0<=nx && nx<N && minHeight[ny][nx] > Math.abs(map[ny][nx] - map[y][x])) {
					int nh = Math.abs(map[ny][nx] - map[y][x]);
					minHeight[ny][nx] = nh;
					pq.add(new int[] {ny,nx,nh});
				}
			}
		}
		System.out.println(ans);
	}

}
