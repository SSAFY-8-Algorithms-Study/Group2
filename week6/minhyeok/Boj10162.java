package boj;

import java.util.Scanner;

public class Boj10162 { // 전자레인지 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		sb.append(T/300+" "); // 300으로 나눈 몫 저장 
		T = T - (T/300) * 300; // 남은 초 = 초 - (초를 300으로 나눈 몫 * 300) -- 생각해보니 이게 나머지인가 ? ㄷ ㄷ 

		sb.append(T/60+" "); // 60으로 나눈 몫 저장 
		T = T - (T/60) * 60; // 남은 초 = 초 - (초를 60으로 나눈 몫 * 60)

		sb.append(T/10); // 10으로 나눈 몫 저장 
		T = T - (T/10) * 10; // 남은 초 = 초 - (초를 10으로 나눈 몫 * 10)

		if (T>0) System.out.println(-1); // 아직도 남은 수가 있다면 -1
		else System.out.println(sb); // 몫들 출
	}

}
