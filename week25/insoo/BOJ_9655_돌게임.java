package algo;
import java.util.Scanner;
class BOJ_9655_돌게임 {
	public static void main(String[] args) {
		/*
		 * 1개나 3개 가져갈 수 있음
		 * 고로 1,3은 이기고, 2,4는 진다.
		 */
		System.out.print(new Scanner(System.in).nextInt() % 2 == 1 ? "SK" : "CY");
	}
}