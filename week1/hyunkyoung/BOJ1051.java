package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int max = Math.min(N, M);
		
		for(int l = max - 1; l > 0; l--) {
			for(int i = 0; i < N - l; i++) {
				for(int j = 0; j < M - l; j++) {
					char value = arr[i][j];
					if((value == arr[i][j + l]) && (value == arr[i + l][j]) && (value == arr[i + l][j + l])) {
						System.out.println((l + 1) * (l + 1));
						return;
					}
				}
			}
		}
		
		System.out.println(1);
	}
}
