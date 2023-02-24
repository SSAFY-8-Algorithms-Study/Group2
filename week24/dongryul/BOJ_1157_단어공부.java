package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1157_단어공부 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int[] alpha = new int[52];
		
		// 갯수 세기
		for(char c : input) {
			alpha[c - 'a']++;
		}
		int max = 0;
		
		int max_index = 0;
		
		// 제일 갯수 많은 것 찾기
		for(int a=0; a<52; a++) {
			if(max < alpha[a]) {
				max_index = a;
			}
		}
		char answer = '?';
		for(int a=0; a<52; a++) {
			if(a != max_index && alpha[a] == max) {
				answer = '?';
			}
		}
		
	}
}
