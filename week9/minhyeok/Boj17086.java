package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj17086 { // 아기 상어 2 

	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[N][M];
		ArrayDeque<int[]> aq = new ArrayDeque<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				if (st.nextToken().equals("1")) { // 아기 상어 위치에서 탐색 시작 
					aq.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		int[] dy = {1,-1,0,0,1,1,-1,-1};
		int[] dx = {0,0,1,-1,-1,1,1,-1};
		
		int cnt = 0;
		while (!aq.isEmpty()) {
			int size = aq.size();
			cnt++;
			for (int s=0; s<size; s++) {
				int[] ps = aq.poll();
				int y = ps[0];
				int x = ps[1];
				
				for (int d=0; d<8; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (0 <= ny && ny < N && 0 <= nx && nx < M) {
						if (!visited[ny][nx]) {
							visited[ny][nx] = true;
							aq.add(new int[] {ny,nx});
						}
					}
				}
			}
		}
		
		System.out.println(cnt-1);
		
	}

}
