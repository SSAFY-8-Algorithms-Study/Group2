package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1670 { // 정상 회담 2 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람의 수 
		long[] dp = new long[N+1]; // 메모이제이션 배열, N명의 사람이 안겹치게 악수할 수 있는 경우의 수 
		dp[0] = 1; // N =2일때, 2명이 서로 악수하고 남은 인원이 악수하는 경우의 수 1 
		for (int i=2; i<=N; i+=2) { // i명일 때 (짝수로 증가)
			for (int j=2; j<=i; j+=2) { // j번째 사람과 악수할 수 있다. 악수가 안겹치기 위해 짝수로 증가 
				dp[i] = ((dp[i] + dp[j-1-1]*dp[i-j]) % 987654321); // 1번과 j번째 사람과 악수할 때, (1~j 사이 남은 인원이 악수하는 경우) X (j~N 인원끼리 악수하는 경우)
			}
		}
		System.out.println(dp[N]);
	}

}
