package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9372 { // 상근이의 여행
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가 수
			int M = Integer.parseInt(st.nextToken()); // 비행기 수
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
			} // end input
			
			System.out.println(N - 1);
		}
	}
}
