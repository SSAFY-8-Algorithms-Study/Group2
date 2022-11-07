package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 { // 수들의 합 2

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열의 개수 
		int M = Integer.parseInt(st.nextToken()); // 목표 합 
		int[] arr = new int[N]; // 배열 생성 
		
		// 수열 입력 받기 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 좌, 우 포인터, 정답, 수들의 합 초기화 
		int l = 0;
		int r = 0;
		int ans = 0;
		int sum = arr[l];
		while (l < N) {

			if (sum == M) { // 수들의 합이 목표 합과 같다 
				ans++;
				sum -= arr[l++];
				if (r == N-1) break; // 좌 ~ 끝까지 수들의 합의 최댓값이 M이다. => break 
				sum += arr[++r];
				
			} else if (sum > M) { // 수들의 합이 목표 합보다 크다. 
				sum -= arr[l++];
				
			} else { // 수들의 합이 목표 합보다 작다.
				if (r == N-1) break; // 좌 ~ 끝까지 수들의 합의 최댓값이 M보다 작다. => break
				sum += arr[++r];
			} 
			
		}
		System.out.println(ans);

	}

}
