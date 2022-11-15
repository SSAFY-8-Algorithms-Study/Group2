package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1459 { // 걷기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken()); // 집 위치 (x, y)
		long w = Integer.parseInt(st.nextToken()); // 한 블록 가는데 걸리는 시간
		long s = Integer.parseInt(st.nextToken()); // 대각선으로 한 블록 가로지르는 시간

		// 대각선 이용 안하는 경우
		long min = x * w + y * w;
		
		// 대각선 이용하는 경우
		if(w < s) {
			min = Math.min(Math.min(x, y) * s + Math.abs(x - y) * w, min);
		} else {
			if((x + y) % 2 == 0) min = Math.min(Math.max(x, y) * s, min); // 대각선만으로 갈 수 있는 경우
			else min = Math.min((Math.max(x, y) - 1) * s + w, min); // 대각선만으로 갈 수 없는 경우
		}
		
		System.out.println(min);
	}
}
