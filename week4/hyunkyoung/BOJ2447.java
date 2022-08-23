package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 { // 별 찍기-10
	static int N;
	static char[][] star;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 패턴 크기
		star = new char[N][N]; // 결과 배열
		
		makeStar(0, 0, N, false);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void makeStar(int x, int y, int n, boolean blank) {
		if(blank == true) { // 공백 출력
			for(int i = x; i < x + n; i++) {
				for(int j = y; j < y + n; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) { // 별 출력
			star[x][y] = '*';
			return;
		}
		
		int count = 0;
		int size = n / 3;
		
		for(int i = x; i < x + n; i += size) {
			for(int j = y; j < y + n; j += size) {
				count++;
				if(count == 5) { // 5번째는 공백
					makeStar(i, j, size, true);
				} else {
					makeStar(i, j, size, false);
				}
			}
		}
	}
}
