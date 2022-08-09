package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 { // 색종이
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] map = new int[100][100]; // 흰색 도화지
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()); // 왼쪽 거리
			int Y = Integer.parseInt(st.nextToken()); // 아래쪽 거리
			
			for (int x = X; x < X + 10; x++) {
				for (int y = Y; y < Y + 10; y++) {
					map[x][y] = 1; // 검은색 색종이 붙이기
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
}
