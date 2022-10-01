package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
	static class El {
		int x, y, d;
		El(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d; // 거리
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		ArrayDeque<El> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().equals("1") ? true : false;
				if(map[i][j]) q.add(new El(i, j, 0));
			}
		}

		int[] dir = {-1, 0, 1};
		int max = 0;
		
		while(!q.isEmpty()) {
			El el = q.poll();

			if(el.d > max) max = el.d;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					
					if(i==1 && j==1) continue;
					
					int xx = el.x + dir[i];
					int yy = el.y + dir[j];

					if(xx>=0 && xx<N && yy>=0 && yy<M && !map[xx][yy]) {
						map[xx][yy] = true;
						q.add(new El(xx, yy, el.d+1));
					}
				}
			}
		}
		
		System.out.print(max);
	}
}