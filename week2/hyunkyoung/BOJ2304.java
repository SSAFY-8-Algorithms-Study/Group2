package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2304 { // 창고 다각형
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int max = 0;
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[index] = value;
			max = Math.max(max, arr[index]);
		}
		
		int result = 0;
		int min = 0, idx = 0;
		for (int i = 1; i < 1001; i++) {
			if(arr[i] == max) {
				idx = i;
				result += max;
				break;
			}
			
			if(arr[i] > min) {
				min = arr[i];
			}
			
			result += min;
		}
		
		min = 0;
		for (int i = 1000; i > idx; i--) {
			if(arr[i] > min) {
				min = arr[i];
			}
			
			result += min;
		}
		
		System.out.println(result);
	}
}
