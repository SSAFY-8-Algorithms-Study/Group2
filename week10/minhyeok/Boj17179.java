package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17179 { // 케이크 자르기 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 자르는 횟수 
		int M = Integer.parseInt(st.nextToken()); // 자를 수 있는 지점의 개수  
		int L = Integer.parseInt(st.nextToken()); // 케이크의 길이 
		
		int[] slice = new int[M];
		for (int i=0; i<M; i++) {
			slice[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int l=0;
			int r=L;
			int ans = 0;
			while (l<=r) {
				
				int m = l + (r-l) / 2; // m 길이 만큼 자르기 
				
				int count = 0;
				int lenCake = 0; // 현재 자른 케이크 길이 
				for (int j=0; j<M; j++) {
					if (slice[j] + m > L) break;
					if (lenCake + m <= slice[j]) {
						lenCake = slice[j];
						count++;
					}
				}
				if (count < n) { // 케이크를 더 작게 잘라야 함 
					r = m-1;
				} else {
					ans = m;
					l = m+1; 
				}
			}
			System.out.println(ans);
		}
		
	}

}
