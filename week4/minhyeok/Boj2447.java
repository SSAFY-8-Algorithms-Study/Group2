package boj;

import java.util.Scanner;

public class Boj2447 {

	
	static int N;
	static char[][] arr;
	
	static void fillSpace(int y, int x, int n) { // 해당 영역을 공백으로 채웁니다.
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				arr[i][j] = ' ';
			}
		}
	}
	
	static void dfs(int y,int x, int n) { // 재귀로 별찍기를 수행합니다.
		if (n==1) { // 크기가 1이 되면 별을 찍고 종료합니다.
			arr[y][x] = '*';
			return;
		}
		
		int nn = n/3; // 다음 재귀를 수행할 크기는 n을 3등분 한 값입니다
		for (int i = y; i <= y + nn*2; i = i + nn) { // i는 3등분으로 나눈 각 지점의 첫번째 y값입니다
			for (int j = x; j <= x + nn*2; j = j + nn) { // j는 3등분으로 나눈 각 지점의 첫번째 x값입니다
				if (i == y + nn && j == x + nn) { // 중앙의 영역은 공백으로 채웁니다.
					fillSpace(i,j,nn);
				} else {
					dfs(i,j,nn); // 나머지 영역은 재귀를 수행합니다.
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		dfs(0,0,N);
		StringBuilder sb = new StringBuilder(); // 안쓰면 시간초과 나요 ,,
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
}
