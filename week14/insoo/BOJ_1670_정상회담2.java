import java.util.Scanner;

public class BOJ_1670_정상회담2 {
	static int MOD = 987654321;
	
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		
		if(N == 0) N = 2;
		
		long[] dp = new long[N+1];
		dp[2] = 1;
		
		int num = 2;
		
		while(num <= N) {
			int fst = num-2;
			int sec = 0;
			
			while(fst >= 0) {
				long a = dp[fst] == 0 ? 1 : dp[fst];
				long b = dp[sec] == 0 ? 1 : dp[sec];
				if(dp[fst] != 0 || dp[sec] != 0) dp[num] += (a * b) % MOD;
				dp[num] %= MOD;
				
				fst -= 2;
				sec += 2;
			}
			num += 2;
		}
		System.out.print(dp[N] % MOD);
	}
}