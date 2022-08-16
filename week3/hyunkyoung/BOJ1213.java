package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ1213 { // 팰린드롬 만들기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		char[] arr = new char[str.length()];
		HashMap<Character, Integer> map = new HashMap<>();
		int strLen = 0;
		
		for(char chr : str.toCharArray()) {
			arr[strLen++] = chr;
			map.put(chr, map.getOrDefault(chr, 0) + 1);			
		}
		
		Arrays.sort(arr);
		
		int idx = 0;
		char[] ans = new char[strLen]; // 정답 배열
		
		for(int i = 0; i < strLen; i++) {
			char chr = arr[i];
			int count = map.get(chr);
			
			// 들어갈 자리가 비어있지 않다면 팰린드롬 아니므로 종료
			if(count % 2 == 1 && ans[strLen / 2] != 0 || ans[idx] != 0 || ans[strLen - idx - 1] != 0) {
				System.out.println("I'm Sorry Hansoo");
				return;								
			}
			
			if(count % 2 == 1) { // 홀수면 가운데부터 위치
				for(int j = 0; j <= count / 2; j++) {
					if(j == 0) {
						ans[strLen / 2] = chr;
					} else {
						ans[idx] = chr;
						ans[strLen - idx - 1] = chr;							
						idx++;
					}
				}
			} else { // 짝수면 앞뒤부터 위치
				for(int j = 0; j < count / 2; j++) {
					ans[idx] = chr;
					ans[strLen - idx - 1] = chr;
					idx++;
				}
			}
			
			i += map.get(chr) - 1; // 다음 문자 탐색
		}
		
		for(char chr : ans) {
			sb.append(chr);
		}
		
		System.out.println(sb);
	}
}
