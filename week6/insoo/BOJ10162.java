import java.util.Scanner;
/*
 * BOJ 10162 Bronze 3
 * 전자레인지
 */
public class BOJ_10162_전자레인지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int btnA = 60 * 5;
		int btnB = 60;
		int btnC = 10;
		
		int cntA, cntB, cntC;

		cntA = T / btnA;
		T %= btnA;
		cntB = T / btnB;
		T %= btnB;
		cntC = T / btnC;
		T %= btnC;
		
		if(T > 0) System.out.print(-1);
		else System.out.printf("%d %d %d", cntA, cntB, cntC);
	}
}