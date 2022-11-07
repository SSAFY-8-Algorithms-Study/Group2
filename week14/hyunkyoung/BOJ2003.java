package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 { // 수들의 합2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int start = 0;
		int result = 0;
		
		for(int end = 0; end < N; end++) {
			sum += arr[end]; // 제일 오른쪽 수 더하기
			
			while(sum > M) { // sum이 M보다 큰 경우
				if(start == end) break; // 제일 왼쪽과 제일 오른쪽 칸이 같으면 break
				sum -= arr[start++]; // 제일 왼쪽 수부터 빼기
			}
			
			if(sum == M) { // sum이 M인 경우
				// System.out.println(start + " " + end);
				result++;
			}
		}
		
		System.out.println(result);
	}
}
