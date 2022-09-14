package greedy;

import java.util.Scanner;

public class B20363_당근키우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int ans = 0;
		ans += X;
		ans += Y;
		if(X >= Y) {	// 앞에거가 더 큰 경우
			ans += Y / 10;
		}else {
			ans += X / 10;
		}
		
		System.out.println(ans);
	}
}
