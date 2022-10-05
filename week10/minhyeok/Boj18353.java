package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj18353 { // 병사 배치하기 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N]; // 내림차순의 최고점 저장 
		int[] s = new int[N]; // 병사 전투력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 1; i < N; i++) {
			for (int j=i-1; j>=0; j--) {
				if (s[j] > s[i]) { // 앞의 병사가 무조건 전투력이 높다 
					dp[i] = Math.max(dp[i],dp[j]+1); // 자신보다 큰 녀석 +1 중 최고값 GET
				}
			}
			ans = Math.max(dp[i], ans);
		}
		System.out.println(N-ans);
	}

}
