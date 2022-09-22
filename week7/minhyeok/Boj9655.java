package boj;

import java.util.Scanner;

public class Boj9655 { // 돌 게임 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N%2 == 1) System.out.println("SK"); // 홀수면 상근이가 이긴다. 
		else System.out.println("CY");
	}

}
