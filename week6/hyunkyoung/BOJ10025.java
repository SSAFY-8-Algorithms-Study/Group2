package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10025 { // 게으른 백곰
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 얼음 양동이 개수
		int K = Integer.parseInt(st.nextToken()); // 백곰 이동 거리
		int[] cage = new int[1000001]; // 우리 배열
		int end = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			end = Math.max(end, x);
			cage[x] = g;
		}
		
		int max = 0; // 백곰이 K 좌표에 있을 때 얼음의 합
		for(int i = 0; i <= K + K; i++) {
			if(i <= 1000000) max += cage[i];
		}
		
		// 얼음의 합 최댓값 탐색
		int sum = max;
		for(int i = 0; i < end - K - K; i++) {
			sum = sum - cage[i] + cage[i + K + K + 1];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
