package boj;

import java.io.*;
import java.util.*;

public class Boj17143 { // 낚시왕
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열 
		int M = Integer.parseInt(st.nextToken()); // 상어 개수
		
		// map - 상어의 위치 
		int[][][] map = new int[R][C][3]; // s, d, z (속력, 이동 방향, 크기)
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		int totalSize = 0; // 잡은 상어의 크기 
		for (int move=0; move<C; move++) {
			// 상어 잡기 
			for (int depth=0; depth<R; depth++) {
				if (map[depth][move][1] != 0) {
					totalSize += map[depth][move][2];
					map[depth][move] = new int[] {0,0,0}; // 상어 제거 
					break;
				}
			}
			
			// 상어 이동
			ArrayDeque<int[]> q = new ArrayDeque<>(); // 상어를 담는 큐 
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					if (map[i][j][1] != 0) { // 상어가 있으면 큐에 담기 
						int[] shark = map[i][j];
						q.add(new int[] {i,j,shark[0],shark[1],shark[2]});
					}
				}
			} // end 상어 이동 
			
			int[][][] newMap = new int[R][C][3]; // 이동 후 상어의 위치 
			while (!q.isEmpty()) {
				int[] shark = q.poll();
				int r = shark[0];
				int c = shark[1];
				int s = shark[2]; // 속도 
				int d = shark[3]; // 방향 
				int z = shark[4]; // 크기 
				
				int distance = s;
				while (distance > 0) {
					if (d == 1) { // 위로 이동
						int up = Math.min(r-0, distance); // 위로 이동할 수 있는 범위 제한 
						distance -= up;
						r -= up;
						if (distance > 0) d=2; // 아직 더 이동할 수 있으면 방향 전환 
					} else if (d == 2) { // 아래로 이동 
						int down = Math.min(R-1 - r, distance); // 밑으로 이동할 수 있는 범위 제한 
						distance -= down;
						r += down;
						if (distance > 0) d=1; // 더 이동할 수 있다면 방향 전환 
					} else if (d == 3) { // 오른쪽 이동 
						int right = Math.min(C-1 - c, distance); // 오른쪽으로 이동할 수 있는 범위 제한 
						distance -= right;
						c += right;
						if (distance > 0) d=4; // 더 이동할 수 있다면 방향 전환 
					} else {
						int left = Math.min(c-0, distance); // 왼쪽으로 이동할 수 있는 범위 제한 
						distance -= left;
						c -= left;
						if (distance > 0) d=3; // 더 이동할 수 있다면 방향 전환 
					}
				} // end while
				if (newMap[r][c][1] == 0) { // 해당 칸이 비어있으면 들어가기 
					newMap[r][c] = new int[] {s,d,z};
				} else {
					if (newMap[r][c][2] < z) { // 기존의 상어보다 내가 더 크면 먹는다.
						newMap[r][c] = new int[] {s,d,z};
					}
				}
			} // end q
			map = newMap;
		} // end 사람 이동 
		System.out.println(totalSize);
	}
}