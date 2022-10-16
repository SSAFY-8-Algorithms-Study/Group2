package boj;

import java.io.*;
import java.util.*;

public class Boj3187 { // 양치기 꿍 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,1,-1};
		
		int sheep = 0;
		int wolf = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] != '#') { // 울타리 안쪽 탐색 !! 
					int v=0;
					int k=0;
					ArrayDeque<int[]> q = new ArrayDeque<>();
					q.add(new int[] {i,j});
					if (map[i][j] == 'v') v++; 
					if (map[i][j] == 'k') k++;
					map[i][j] = '#';
					while(!q.isEmpty()) {
						int[] arr = q.poll();
						int y = arr[0];
						int x = arr[1];
						
						
						for (int d=0; d<4; d++) {
							int ny = y + dy[d];
							int nx = x + dx[d];
							
							if (0<=ny && ny <R && 0<=nx && nx<C && map[ny][nx] != '#') {
								if (map[ny][nx] == 'v') v++; 
								if (map[ny][nx] == 'k') k++; 
								map[ny][nx] = '#';
								q.add(new int[] {ny,nx});
							}
						}
					}
					if (v >= k) wolf += v; // 늑대가 다 잡아 먹는다 
					else sheep += k;
				}
			}
		}
		System.out.println(sheep+" "+wolf);
	}

}
