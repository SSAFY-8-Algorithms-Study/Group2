package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2624 { // 동전 바꿔주기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 지폐 금액
		int k = Integer.parseInt(br.readLine()); // 동전 종류 수
		
		int[] p = new int[k];
		int[] n = new int[k];
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken()); // 동전 금액
			n[i] = Integer.parseInt(st.nextToken()); // 동전 개수
		} // end input
		
		int[] dp = new int[T + 1];
		dp[0] = 1;
		
		for(int i = 0; i < k; i++) { // 동전 종류 수만큼 반복
			int value = p[i];
			int count = n[i];
			
			for(int j = T; j >= 1; j--) {
				for(int c = 1; c <= count; c++) {
					if(j - c * value < 0) break;
					dp[j] += dp[j - c * value];
				}
			}
		}
		
		System.out.println(dp[T]);
	}
}
