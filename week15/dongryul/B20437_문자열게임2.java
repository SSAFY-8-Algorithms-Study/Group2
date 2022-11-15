package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B20437_문자열게임2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String input = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			int[] charArr = new int[26];
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				
				//문자 갯수 카운팅
				charArr[c - 'a']++;
				if(charArr[c - 'a'] >= K) {
					//다시 되돌아가면서 카운팅
					int len = 0;
					int reIndex = i;
					int cnt = 0;
					while(cnt != K) {
						if(input.charAt(reIndex) == c) cnt++;
						reIndex--;
						len++;
					}
					
					min = Math.min(min, len);
					max = Math.max(max, len);
				}
				
			}
			if(max == Integer.MIN_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(min + " " + max);
			}

		}
	}
}
