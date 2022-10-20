package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 { // 불
	static int w, h;
	static char[][] map;
	static int[][] time;
	static Queue<int[]> fQueue;
	static Queue<int[]> tQueue;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean flag;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			
			map = new char[h][w];
			time = new int[h][w];
			
			fQueue = new ArrayDeque<>();
			tQueue = new ArrayDeque<>();
			
			for(int i = 0; i < h; i++) {
				String str = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') fQueue.add(new int[] {i, j});
					
					if(map[i][j] == '@') {
						map[i][j] = '.';
						tQueue.add(new int[] {i, j});
						time[i][j] = 1;
					}					
				}
			} // end input
			
			flag = false;
			result = Integer.MAX_VALUE;
			
			while(true) {
				fire();
				move();
				
				if(flag) break;
				if(tQueue.isEmpty()) break;
			}
			
			System.out.println(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result);
		}
	}
	
	static void move() {
		int size = tQueue.size();
		for(int s = 0; s < size; s++) {
			int[] node = tQueue.poll();
			int x = node[0];
			int y = node[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0 > nx || nx >= h || 0 > ny || ny >= w) {
					result = Math.min(result, time[x][y]);
					flag = true;
					return;
				}
				
				if(map[nx][ny] == '.' && time[nx][ny] == 0) {
					tQueue.add(new int[] {nx, ny});
					time[nx][ny] = time[x][y] + 1;
				}
			}
		}
	}
	
	static void fire() {
		int size = fQueue.size();
		for(int s = 0; s < size; s++) {
			int[] node = fQueue.poll();
			int x = node[0];
			int y = node[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0 <= nx && nx < h && 0 <= ny && ny < w) {
					if(map[nx][ny] == '.') {
						fQueue.add(new int[] {nx, ny});
						map[nx][ny] = '*';
					}
				}
			}
		}
	}
}
