package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj5427 { // 불 
		
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			ArrayDeque<Integer> fq = new ArrayDeque<>(); // 불 큐 
			ArrayDeque<Integer> q = new ArrayDeque<>(); // 위치 큐 
			
			char[][] map = new char[h][w];
			for (int i=0; i<h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j=0; j<w; j++) {
					if(map[i][j] == '*') fq.add(w*i + j); 
					if(map[i][j] == '@') q.add(w*i + j);
				}
			}
			
			int[] dy = {-1,1,0,0};
			int[] dx = {0,0,-1,1};
			
			int t=0;
			boolean isPos = false;
			while (true) {
				int fSize = fq.size(); // 불 먼저 이동 
				for (int i=0; i<fSize; i++) {
					int a = fq.poll();
					int y = a / w;
					int x = a % w;
					
					for (int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						
						if (0<= ny && ny <h && 0<=nx && nx <w && map[ny][nx] != '#' && map[ny][nx] != '*') {
							map[ny][nx] = '*';
							fq.add(w*ny + nx);
						}
					}
				}
				
				int size = q.size(); // 위치 이동 
				for (int i=0; i<size; i++) {
					int a = q.poll();
					int y = a / w;
					int x = a % w;
					if (y == h-1 || y == 0 || x == w-1 || x == 0) { // 탈출 가능 !!
						isPos = true;
						break;
					}
						
					for (int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						
						if (0<= ny && ny <h && 0<=nx && nx <w && map[ny][nx] == '.') {
							map[ny][nx] = '@';
							q.add(w*ny + nx);
						}
					}
				}
				if (isPos) break;
				t++;
				if (size == 0) break;
			}
			if(isPos) sb.append(t+1);
			else sb.append("IMPOSSIBLE");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
