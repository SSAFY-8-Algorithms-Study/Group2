package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16918 { // 봄버맨
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()); // 격자판 행 크기
		int C = Integer.parseInt(st.nextToken()); // 격자판 열 크기
		int N = Integer.parseInt(st.nextToken()); // 실행 시간
		int[][] map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				if(str.charAt(j) == '.') map[i][j] = -1;
				else map[i][j] = 1;
			}
		}
		
		if(N >= 2) {
			int num = (N - 1) % 4;
			if(num == 0) num = 4;
		
			for(int n = 0; n < num; n++) {
				int[][] map_copy = new int[R][C];
	
				// 폭탄 설치
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						map[i][j] +=1;
						map_copy[i][j] = map[i][j];
					}
				}
				
				// 폭탄 폭발
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(map[i][j] == 3) {
							map_copy[i][j] = -1;
							
							for(int d = 0; d < 4; d++) {
								int ni = i + di[d];
								int nj = j + dj[d];
								
								if(0 <= ni && ni < R && 0 <= nj && nj < C) {
									map_copy[ni][nj] = -1;
								}
							}
						}
					}
				}
				
				map = map_copy;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] >= 0) System.out.print('O');
				else System.out.print('.');
			}
			System.out.println();
		}
	}
}
