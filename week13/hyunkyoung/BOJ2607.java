package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2607 { // 비슷한 단어
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 단어 개수
		
		int[] alpha = new int[26];
		
		String word = br.readLine();
		for(int i = 0; i < word.length(); i++) {
			alpha[word.charAt(i) - 65] += 1;
		}	
		
		int result = 0;
		int length = word.length();

		for(int i = 1; i < n; i++) {
			int change = 0;
			int[] alpha_copy = alpha.clone();
			
			word = br.readLine();
			
			if(Math.abs(word.length() - length) > 1) continue;
			
			// 한 문자를 더한 경우
			// 같은 구성이거나 하나의 문자를 다른 문자로 바꾼 경우
			if(word.length() >= length) {
				for(int j = 0; j < word.length(); j++) {
					if(alpha_copy[word.charAt(j) - 65] > 0) {
						alpha_copy[word.charAt(j) - 65] -= 1;
					} else {
						change += 1;
					}
				}
			}

			if(word.length() < length) { // 한 문자를 뺀 경우
				for(int j = 0; j < word.length(); j++) {
					if(alpha_copy[word.charAt(j) - 65] > 0) {
						alpha_copy[word.charAt(j) - 65] -= 1;
					} else {
						change = 2;
						break;
					}
				}
			}
			
			if(change <= 1) result++;
		}
		
		System.out.println(result);
	}
}
