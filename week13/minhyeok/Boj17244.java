package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj17244 { // 아맞다우산

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());  // 가로 
		int R = Integer.parseInt(st.nextToken()); // 세로
		int[][] map = new int[R][C]; // 맵 
		boolean[][][] visited = new boolean[R][C][1<<6]; // 방문 체크 비트마스킹 
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int kCnt = 1; // 증가하는 키 번호 
		int masterKey = 0; // 모든 키를 가지고 있을 경우 
		// R X C 입력 받기 
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				char c = str.charAt(j);
				if (c == 'S') {
					q.add(new int[] {i,j,0,0}); // y, x, 키의 개수 ,move
					visited[i][j][0] = true; // 그냥 이동 체크 
				} else if (c == 'X') { // 키 
					map[i][j] = kCnt; // 맵에 키 찍기 
					masterKey |= 1<<kCnt;  // 마스터키에 포함 시키기 
					kCnt++; // 키 번호 증가 
				} else if (c == 'E') { // 탈출 
					map[i][j] = -1;
				} else if (c == '#') { // 벽 
					map[i][j] = 9;
				}
			}
		}
		int[] dy = {0,0,-1,1};
		int[] dx = {1,-1,0,0};
		
		boolean isFin = false;
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int y = arr[0];
			int x = arr[1];
			int key = arr[2];
			int move = arr[3];
			
			for (int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (map[ny][nx] == -1 && key == masterKey) { // 탈출구 + 마스터 키면 종료 
					System.out.println(move+1);
					isFin = true;
					break;
				}
				int k = key; // 다음 큐로 넘어갈 키 
				if (0<ny && ny<R-1 && 0<nx && nx<C-1 && map[ny][nx] != 9) { // 범위 안 + 벽이 아님 
					if (map[ny][nx] > 0 && (key & 1<<map[ny][nx]) == 0) { // 다음 이동 칸이 키가 있다. 
						k |= 1<<map[ny][nx]; // 현재 키에 포함시키고 큐로 넘기기 
					}
					if (!visited[ny][nx][key]) { // 아직 현재 가지고 있는 키로 방문하지 않았으면 
						visited[ny][nx][key] = true; // 방문 
						q.add(new int[] {ny,nx,k,move+1});
					}
				}
			}
			if (isFin) break;
		}
	}
}
