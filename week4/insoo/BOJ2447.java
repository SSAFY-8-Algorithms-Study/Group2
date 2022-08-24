import java.util.Scanner;
/*
 * BOJ 2447 Gold 5
 * 별 찍기 - 10
 * 1. 모든 좌표에 문자 *를 입력
 * 2. 가운데를 빈 공간으로 바꾸기
 * 3. size/3으로 둘러싸인 주변 좌표 빈 공간으로 바꾸기
 * 4. 입력받은 숫자를 3으로 나누고 반복
 */
public class BOJ2447 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = '*'; // 1. 모든 좌표에 문자 *를 입력
			}
		}

		int size = N;
		while(size>1) {
			// 2. 가운데를 빈 공간으로 바꾸기
			for (int i = size / 3; i < (size / 3) * 2; i++) {
				for (int j = size / 3; j < (size / 3) * 2; j++) {
					map[i][j] = ' ';
				}
			}
			
			// 3. size/3으로 둘러싸인 주변 좌표 빈 공간으로 바꾸기
			for (int l = 0; l < N; l+=size/3) {
				for (int k = 0; k < N; k+=size/3) {
					for (int i = 0; i < size/3/3; i++) {
						for (int j = 0; j < size/3/3; j++) {
							map[size/3/3+i+k][size/3/3+j+l] = ' ';
						}
					}
				}
			}
			size /= 3; // 4. 입력받은 숫자를 3으로 나누고 반복
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}