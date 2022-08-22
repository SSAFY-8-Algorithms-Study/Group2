package boj;

import java.util.Scanner;

public class Boj2960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0; // 지우는 횟수 카운트
		boolean[] isErase = new boolean[N+1]; // 숫자들을 지우기 위한 배열 
		for (int i = 2; i <= N; i++) {
			for (int j = 1; i * j <= N; j++) { // j는 i의 배수 
				if (!isErase[i * j]) {
					cnt++; // 아직 안지웠으면 카운트 증가
					isErase[i * j] = true; // 지우기
					if (cnt == K) {
						System.out.println(i * j);
					}
				}
			}
		}
	}

}
