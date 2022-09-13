package boj;

import java.util.Scanner;

public class Boj20363 { // 당근 키우기 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); // 필요 온기 
		int Y = sc.nextInt(); // 필요 수분 
		
		// 햇빛과 물 중 값이 더 큰 것 먼저 주고 작은 것을 줘서 최솟값 만들기  
		long ans = X + Y; 
		
		// 두번째로 주면 10으로 나눈 몫만큼 감소하기 때문에 다시 더해준다. 
		if (X >= Y) ans += Y / 10; 
		else ans += X / 10;
		
		System.out.println(ans);
	}

}
