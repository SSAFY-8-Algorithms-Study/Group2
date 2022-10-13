package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17143 { // 낚시왕
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		int M = Integer.parseInt(st.nextToken()); // 상어 수
		
		int[][] map = new int[R][C];
		ArrayList<Shark> list = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = i + 1;			
			
			if(dir == 1 || dir == 2) {
				list.add(new Shark(x - 1, y - 1, speed % (2 * R - 2), dir, size));
			} else if(dir == 3 || dir == 4) {
				list.add(new Shark(x - 1, y - 1, speed % (2 * C - 2), dir, size));
			}
		} // end input
		
		boolean[] sVisit = new boolean[list.size()];
		int res = 0;

		int col = -1;
		while(true) {
			// 낚시왕 오른쪽으로 한칸 이동
			if(++col >= C) break;
			
			// 땅에 제일 가까운 상어 잡음
			for(int i = 0; i < R; i++) {
				if(map[i][col] != 0 && !sVisit[map[i][col] - 1]) {
					res += list.get(map[i][col] - 1).size;
					sVisit[map[i][col] - 1] = true;
					map[i][col] = 0;
					break;
				}
			}
			
			map = new int[R][C];
			
			// 상어 이동
			for(int i = 0; i < list.size(); i++) {
				if(!sVisit[i]) {
					Shark s = list.get(i);
					
					for(int j = 0; j < s.speed; j++) {
						int nx = s.x + dx[s.dir - 1];
						int ny = s.y + dy[s.dir - 1];
						
						if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
							if(s.dir == 1) s.dir = 2;
							else if(s.dir == 2) s.dir = 1;
							else if(s.dir == 3) s.dir = 4;
							else if(s.dir == 4) s.dir = 3;
						}
						
						s.x += dx[s.dir - 1];
						s.y += dy[s.dir - 1];
					}
					
					if(map[s.x][s.y] != 0) {
						Shark vs = list.get(map[s.x][s.y] - 1);
						
						if(vs.size < s.size) {
							sVisit[map[s.x][s.y] - 1] = true;
							map[s.x][s.y] = i + 1;
						} else {
							sVisit[i] = true;
						}
					} else {
						map[s.x][s.y] = i + 1; 
					}
				}
			}
		}
		
		System.out.println(res);
	}
	
	static class Shark {
		int x, y, speed, dir, size;
		
		Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
}
