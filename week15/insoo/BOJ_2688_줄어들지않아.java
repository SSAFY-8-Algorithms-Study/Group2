package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2688_줄어들지않아 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[][] dp = new long[64][10];
		
		for (int j = 0; j < 10; dp[0][j] = j+++1);
		
		for (int i = 1; i < 64; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
				}
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		for (int ntc = 0; ntc < tc; ntc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n-1][9]);
		}
	}
}