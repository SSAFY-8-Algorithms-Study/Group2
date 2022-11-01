package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14267 { // 회사 문화1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 회사 직원 수
		int m = Integer.parseInt(st.nextToken()); // 최초 칭찬 횟수
		
		int[] boss = new int[n + 1];
		int[] dp = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == -1) continue;
			boss[i] = num;
		}
		
		for(int x = 0; x < m; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dp[i] += w;
		}
		
		for(int i = 1; i <= n; i++) {
			dp[i] += dp[boss[i]];
		}
		
		for(int i = 1; i <= n; i++) {
			sb.append(dp[i] + " ");
		}
		
		System.out.println(sb);
	}
}
