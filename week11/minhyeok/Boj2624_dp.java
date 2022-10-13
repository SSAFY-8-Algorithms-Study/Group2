package boj;

import java.io.*;
import java.util.*;

public class Boj2624_dp { // 동전 바꿔주기 
	
	
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[][] coin = new int[k+1][2]; // 금액과 개수 
		for (int i=1; i<=k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coin[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		
		int[][] dp = new int[k+1][T+1]; // 동전 금액과 목표 금액 
		dp[0][0] = 1;
		for (int i=1; i<=k; i++) {
			int value = coin[i][0]; // i번째 동전 금액
			int size = coin[i][1]; // i번째 동전 개수
			for (int j=0; j<=size; j++) { // 0개부터 가진 동전만큼 시도 
				int v = value*j;
				if (v > T) break;
				for (int t=v; t<=T; t++) {
					dp[i][t] += dp[i-1][t-v];
				}
			}
		}
		System.out.println(dp[k][T]);
	}


}
