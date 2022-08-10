package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 2630 silver 2
 * 색종이 만들기
 * 1. 색종이 길이/2의 값을 길이로 가지는 각 정사각형 4개로 나눈다.
 * 2. 각 색종이의 좌상단을 시작점으로 for문 돌며 모든 좌표가 같은 색으로 채워져있는지 검사한다.
 * 3. 같은 색으로 채워져 있지 않으면 '1'부터 다시 반복한다.
 */
public class BOJ2630 {
	static int[][] arr;
	static int white, blue;
	
	static void cutAvailable(int dividedL, int x, int y) {
		if(dividedL == 0) return;

		boolean same = true;
		// 2. 각 색종이의 좌상단을 시작점으로 for문 돌며 모든 좌표가 같은 색으로 채워져있는지 검사한다.
		for (int i = 0; i < dividedL; i++) {
			for (int j = 0; j < dividedL; j++) {
				if(x+i >= arr.length || x+j >= arr.length) continue;
				if(x+dividedL+i >= arr.length || x+dividedL+j >= arr.length) continue;
				if(y+i >= arr.length || y+j >= arr.length) continue;
				if(y+dividedL+i >= arr.length || y+dividedL+j >= arr.length) continue;
				
				int topLeft = arr[x+i][y+j];
				int topRight = arr[x+i][y+dividedL+j];
				int bottomLeft = arr[x+dividedL+i][y+j];
				int bottomRight = arr[x+dividedL+i][y+dividedL+j];

				if(!(arr[x][y] == topLeft && topLeft == topRight && bottomLeft == bottomRight && topLeft == bottomLeft)) {
					same = false;
				}
			}
		}
		if(same) {
			if(arr[x][y] == 1) blue++;
			else white++;
		}
		else {
			// 3. 같은 색으로 채워져 있지 않으면 '1'부터 다시 반복한다.
			cutAvailable(dividedL/2, x, y);
			cutAvailable(dividedL/2, x, y+dividedL);
			cutAvailable(dividedL/2, x+dividedL, y);
			cutAvailable(dividedL/2, x+dividedL, y+dividedL);
			if(dividedL == 1) {
				if(arr[x][y] == 1)blue++;
				else white++;
				if(arr[x+dividedL][y] == 1)blue++;
				else white++;
				if(arr[x][y+dividedL] == 1)blue++;
				else white++;
				if(arr[x+dividedL][y+dividedL] == 1)blue++;
				else white++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 색종이 길이/2의 값을 길이로 가지는 각 정사각형 4개로 나눈다.
		cutAvailable(n/2, 0, 0);
		
		System.out.printf("%d%n%d",white,blue);
	}
}