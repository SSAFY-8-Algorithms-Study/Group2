package pending;

import java.util.Scanner;
/*
 * BOJ 1459 Silver 4
 * 걷기
 */
public class BOJ_1459_걷기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); // x 좌표
		int Y = sc.nextInt(); // y 좌표
		int W = sc.nextInt(); // 한 블록 이동 시간
		int S = sc.nextInt(); // 대각선 이동 시간

		int better = Math.min(W*2, S); // 두 블록 이동과 대각선 이동 중 빠른 거
		long answer = 0;
		
		if(better == S) { // 대각선이 더 빠르다면
			if(S < W) { // 한 블록보다도 대각선이 더 빠르다면
				if(Math.abs(X - Y) % 2 == 1) { // 차가 홀수로 한 블록 이동을 해야 하는 경우
					answer += W - S;
				}
				W = S;
			}
			answer += (long) Math.min(X, Y) * S;
			answer += (long) Math.abs(X - Y) * W;
		} else { // 두 블록이 더 빠르다면
			answer += (long) (X + Y) * W;
		}
		
		System.out.print(answer);
	}
}