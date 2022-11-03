package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj21610 { // 마법사 상어와 비바라기 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dy = {0,-1,-1,-1,0,1,1,1};
		int[] dx = {-1,-1,0,1,1,1,0,-1};
		ArrayList<int[]> clouds = new ArrayList<>();
		clouds.add(new int[]{N-1,0});
		clouds.add(new int[]{N-1,1});
		clouds.add(new int[]{N-2,0});
		clouds.add(new int[]{N-2,1});
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			boolean[][] visitedCloud = new boolean[N][N];
			
			// 구름 이동
			for (int[] cloud : clouds) {
				int y = cloud[0];
				int x = cloud[1];
				y += dy[d]*s;
				x += dx[d]*s;
				while (y<0) y+=N;
				while (y>=N) y-=N;
				while (x<0) x+=N;
				while (x>=N) x-=N;
				
				// 비 내리기 (1 증가)
				map[y][x]++;
				visitedCloud[y][x] = true;
				cloud[0] = y;
				cloud[1] = x;
			}
			// 구름 사라짐
			// 대각선 4방향 물 체크 후 복사 
			for (int[] cloud : clouds) {
				int y = cloud[0];
				int x = cloud[1];
				int cnt=0;
				for (int dd=1; dd<=7; dd+=2) {
					int ny = y+dy[dd];
					int nx = x+dx[dd];
					
					if (0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] >= 1) cnt++;
				}
				map[y][x] += cnt;
			}
			// 물의 양이 2 이상인 칸에 구름 생성 
			clouds = new ArrayList<>();
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (!visitedCloud[r][c] && map[r][c] >=2) {
						clouds.add(new int[] {r,c});
						map[r][c] -=2;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j]>=1) ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

}
