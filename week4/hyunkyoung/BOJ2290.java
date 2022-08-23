package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2290 { // LCD Test
	static int row, col;
	static char[][] arr;
	static int[][] exist = { // 위, 중앙, 아래, 왼위, 오위, 왼아, 오아
							{1, 0, 1, 1, 1, 1, 1}, // 0
							{0, 0, 0, 0, 1, 0, 1}, // 1
							{1, 1, 1, 0, 1, 1, 0}, // 2
							{1, 1, 1, 0, 1, 0, 1}, // 3
							{0, 1, 0, 1, 1, 0, 1}, // 4
							{1, 1, 1, 1, 0, 0, 1}, // 5
							{1, 1, 1, 1, 0, 1, 1}, // 6
							{1, 0, 0, 0, 1, 0, 1}, // 7
							{1, 1, 1, 1, 1, 1, 1}, // 8
							{1, 1, 1, 1, 1, 0, 1}}; // 9
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int s = Integer.parseInt(st.nextToken()); // 크기
		String n = st.nextToken(); // LCD 표시 숫자
		
		row = 2 * s + 3; // 세로
		col = s + 2; // 가로
		arr = new char[row][(s + 2) * n.length() + n.length()];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = ' ';
			}
		}
		
		for(int i = 0, x = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			makeNum(0, x, exist[num]);
			x += s + 3;
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void makeNum(int x, int y, int[] exist) {
		// 가로
		for(int i = x; i < x + row; i++) {
			for(int j = y + 1; j < y + col - 1; j++) {
				if(i == x && exist[0] == 1) arr[i][j] = '-';
				if(i == x + row / 2 && exist[1] == 1) arr[i][j] = '-';
				if(i == x + row - 1 && exist[2] == 1) arr[i][j] = '-';
			}
		}
		
		// 세로 위
		for(int i = x + 1; i < x + row / 2; i++) {
			if(exist[3] == 1) arr[i][y] = '|';
			if(exist[4] == 1) arr[i][y + col - 1] = '|';
		}
		
		// 세로 아래
		for(int i = x + row / 2 + 1; i < x + row - 1; i++) {
			if(exist[5] == 1) arr[i][y] = '|';
			if(exist[6] == 1) arr[i][y + col - 1] = '|';
		}
	}
}
