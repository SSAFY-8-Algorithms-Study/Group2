package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2688 { // 줄어들지 않아
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			long[] cnt = new long[10];
			Arrays.fill(cnt, 1);
			
			for(int i = 1; i < n; i++) {
				for(int j = 1; j < 10; j++) {
					cnt[j] += cnt[j - 1];
				}
			}
			
			long result = 0;
			for(int i = 0; i < 10; i++) {
				result += cnt[i];
			}
			
			sb.append(result).append('\n');
		}
		
		System.out.println(sb);
	}
}
