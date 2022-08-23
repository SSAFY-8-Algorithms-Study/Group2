package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960 { // 에라토스테네스의 체
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // N보다 작거나 같은 모든 소수
		int K = Integer.parseInt(st.nextToken()); // K번째 지워진 수
		int[] arr = new int[N + 1];
		
		// 1단계
		for(int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}
		
		// 2~4단계
		int min = 2; // 가장 작은 수
		int count = 0; // 지운 수 개수
		int result = 0;
		
		while(true) {
			// 가장 작은 수의 배수 지우기
			for(int i = 1; i * min < N + 1; i++) {
				result = arr[i * min];
				
				if(result != 0) {
					arr[i * min] = 0;
					count += 1;
				}
				
				if(count == K) {
					System.out.println(result);
					return;
				}
			}
			
			// 남은 수 중 가장 작은 수 찾기
			for(int i = 2; i < N + 1; i++) {
				if(arr[i] != 0) {
					min = i;
					break;
				}
			}
		}
	}
}
