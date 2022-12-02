package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2688_줄어들지않아 {
	static int N;
	static int total;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[][] D = new long[64 + 1][10];	// n(자릿수), 앞
		Arrays.fill(D[1], 1);
		
		for(int n=2; n<=64; n++) {
			for(int i=0; i<10; i++) {	
				for(int j=i; j<=9; j++) {
					D[n][i] += D[n-1][j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			long sum = 0;
			for(int i=0; i<10; i++) {
				sum += D[n][i];
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}
}
