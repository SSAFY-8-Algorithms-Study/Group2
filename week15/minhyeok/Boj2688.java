package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2688 { // 줄어들지 않아 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		int[] tc = new int[T]; // n을 담을 배열 
		int maxn = 0; // n 들의 최댓값을 구한다  
		for (int i=0; i<T; i++) { // 테스트케이스 개수만큼 n을 저장하고 최댓값을 구하기 
			tc[i] = Integer.parseInt(br.readLine());
			maxn = Math.max(maxn, tc[i]);
		}
		
		long[][] dp = new long[maxn+1][11]; // 행: 1 ~ n, 열: 0 ~ 9, 10에는 총합 저장 
		for (int i=0; i<10; i++) { // n자리 일 경우, n-1자리에서 맨 앞의 수에 i를 놓아보고 줄어들지 않는 수의 개수를 저장한다. 
			dp[1][i] = 1; // 1자리일 경우, 0자리 수에 0~9 모두 넣을 수 있다. 
		}
		dp[1][10] = 10; // 총합 10 
		
		for (int n=2; n<=maxn; n++) { // n은 2부터 maxn까지 
			dp[n][0] = dp[n-1][10]; // n-1자리의 모든 수의 앞에 0을 놓으면 모두 줄어들지 않는 수 이다. 
			long sum=dp[n][0]; // n자리수의 줄어들지 않는 수의 개수 총합 저장 
			for (int i=1; i<10; i++) { // 1 ~ 9까지 n-1자리수 앞에 놓아본다.
				dp[n][i] = dp[n][i-1] - dp[n-1][i-1]; // n자리수의 i로 시작하는 줄어드는 수의 개수 = (n자리수의 i-1로 시작하는 줄어드는 수의 개수) - (n-1자리수의 i-1로 시작하는 줄어드는 수의 개수)
				sum += dp[n][i]; // n자리수의 줄어들지 않는 수 총합 구하기 
			}
			dp[n][10] = sum; // n자리수의 줄어들지 않는 수 총합 저장 
		}
		
		StringBuilder sb = new StringBuilder();
		for (int n : tc) {
			sb.append(dp[n][10]+"\n");
		}
		System.out.println(sb);
	}

}
