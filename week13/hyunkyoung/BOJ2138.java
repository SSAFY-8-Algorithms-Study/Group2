package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2138 { // 전구와 스위치
	static int N;
	static char[] before;
	static char[] after;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 전구 개수
		
		before = br.readLine().toCharArray();
		after = br.readLine().toCharArray();
		
		result = Integer.MAX_VALUE;
		char[] before_copy = before.clone();
		
		// 첫번째 전구 스위치 누르는 경우
		onoff(0);
		check(1, 1);
		
		// 첫번째 전구 스위치 누르지 않는 경우
		before = before_copy;
		check(1, 0);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void onoff(int num) {
		for(int i = num - 1; i <= num + 1; i++) {
			if(0 <= i && i < N) {
				before[i] = before[i] == '0' ? '1' : '0';
			}
		}
	}
	
	static void check(int num, int cnt) {
		if(num == N) {
			if(before[num - 1] == after[num - 1]) {
				result = Math.min(result, cnt);
			}
			
			return;
		}
		
		if(before[num - 1] != after[num - 1]) {
			onoff(num);
			check(num + 1, cnt + 1);
		} else {
			check(num + 1, cnt);
		}
	}
}
