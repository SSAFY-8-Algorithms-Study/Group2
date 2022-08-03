package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1059 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 집합 S의 크기
		int[] arr = new int[L];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		Arrays.sort(arr); // 배열 정렬
		
		int result = 0;
		int small = 0, big = 0;
		
		for(int i = 0; i < L; i++) {
			if(arr[i] < n) {
				small = arr[i];
			} else if(arr[i] == n) {
				break;
			} else if(arr[i] > n) {
				big = arr[i];
				result = (big - n) * (n - small) - 1;
				break;
			}
		}
		
		System.out.println(result);
	}
}
