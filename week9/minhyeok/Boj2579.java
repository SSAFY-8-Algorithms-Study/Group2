package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2579 { // 계단 오르기 

	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i=1; i<N+1; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		if (N==1) {
			System.out.println(scores[1]);
		} else if (N==2) {
			System.out.println(scores[1] + scores[2]);
		} else {
			dp[1] = scores[1];
			dp[2] = scores[1] + scores[2];
			for (int i=3; i<N+1; i++) {
				dp[i] = Math.max(dp[i-2]+scores[i], dp[i-3]+scores[i-1]+scores[i]);
			}
			System.out.println(dp[N]);
		}
		
	}

}
