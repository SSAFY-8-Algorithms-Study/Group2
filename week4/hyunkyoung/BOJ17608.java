package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17608 { // 막대기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 막대기 개수
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 1;
		int max = arr[N - 1];
		
		for(int i = N - 2; i >= 0; i--) { // 오른쪽부터 탐색
			if(arr[i] > max) {
				max = arr[i];
				result += 1;
			}
		}
		
		System.out.println(result);
	}
}
