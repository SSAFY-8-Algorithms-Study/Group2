package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 { // 색종이 만들기
	static int N;
	static int[][] map;
	static int white, blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0, 0, N);
		System.out.println(white + "\n" + blue);
	}
	
	static void check(int x, int y, int n) {
		int color = map[x][y];
		boolean rect = true;
		
		for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(map[i][j] != color) {
					rect = false;
				}
			}
		}
		
		if(rect) {
			if(color == 0) white += 1; else blue += 1;
			return;
		}
		
		// 왼쪽 위
		check(x, y, n / 2);
		
		// 오른쪽 위
		check(x, y + n / 2, n / 2);
		
		// 왼쪽 아래
		check(x + n / 2, y, n / 2);
		
		// 오른쪽 아래
		check(x + n / 2, y + n / 2, n / 2);
	}
}
