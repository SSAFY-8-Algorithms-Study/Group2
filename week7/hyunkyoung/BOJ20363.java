package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20363 { // 당큰 키우기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken()); // 온기
		int Y = Integer.parseInt(st.nextToken()); // 수분
		
		int max, min;
		if(X > Y) {
			max = X; min = Y;
		} else {
			max = Y; min = X;
		}
		
		int result = max + min + (min / 10);
		System.out.println(result);
	}
}
