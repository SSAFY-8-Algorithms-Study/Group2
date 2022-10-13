package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3187 { // 양치기 꿍
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int wolf, sheep;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		} // end input
		
		int wolfAns = 0, sheepAns = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'v' || map[i][j] == 'k') {
					if(!visit[i][j]) {
						bfs(i, j);
						wolfAns += wolf;
						sheepAns += sheep;
					}
				}
			}
		}
		
		System.out.println(sheepAns + " " + wolfAns);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visit[x][y] = true;
		wolf = 0; sheep= 0;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			
			if(map[node[0]][node[1]] == 'v') wolf++;
			else if(map[node[0]][node[1]] == 'k') sheep++;
			
			for(int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				
				if(0 <= nx && nx < R && 0 <= ny && ny < C) {
					if(map[nx][ny] == '#') continue;
					
					if(!visit[nx][ny]) {						
						queue.add(new int[] {nx, ny});
						visit[nx][ny] = true;
					}
				}
			}
		}
		
		if(sheep > wolf) wolf = 0;
		else sheep = 0;
	}
}
