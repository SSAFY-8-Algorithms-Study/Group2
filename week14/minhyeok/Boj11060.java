package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11060 { // 점프 점프 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 미로의 크기 
		int[] jump = new int[N]; // 점프 배열 
		
		// 점프 배열 받기 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			jump[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp 메모이제이션 초기화 
		int[] dp = new int[N];
		for (int i=0; i<N; dp[i++] = Integer.MAX_VALUE);
		dp[0] = 0;
		
		// 현재 칸에서 점프 가능한 모든 칸을 체크해보며 최소 점프 계산하기 
		for (int i=0; i<N; i++) {
			if (dp[i] == Integer.MAX_VALUE) break; // 더 이상 갈 수 없는 경우 종료 (이거 때문에 틀림 ㅠ)
			int maxStep = Math.min(i+jump[i], N-1);
			for (int nextStep=i+1; nextStep<=maxStep; nextStep++) {
				dp[nextStep] = Math.min(dp[i]+1, dp[nextStep]);
			}
			}
		if (dp[N-1] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}

}
