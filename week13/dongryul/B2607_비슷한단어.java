package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2607_비슷한단어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String first = br.readLine();	//첫 단어
		int[] fCarr = new int[26];
		
		// 갯수 세고
		for(int i=0; i<first.length(); i++) {
			char c = first.charAt(i);
			fCarr[c - 'A']++;
		}
		
		String[] second = new String[N-1];	//두 번째 단어 부터
		int[][] sCarr = new int[N-1][26];
		
		for(int i=0; i<N-1; i++) {
			second[i] = br.readLine();
			char[] cArr = second[i].toCharArray();
			
			// 알파벳 갯수 세고
			for(char c : cArr) {
				sCarr[i][c - 'A']++;
			}
			
		}
		int ans = 0;
		for(int i=0; i<N-1; i++) {
			if(Math.abs(first.length() - second[i].length()) >= 2) continue;
			if(first.length() == second[i].length()) {	// 두 문자열의 길이가 같을 경우
				//한 문자만 다르거나 구성이 같거나.
				int cnt = 0;
				for(int j=0; j<26; j++) {
					cnt += Math.abs(fCarr[j] - sCarr[i][j]);
				}
				
				if(cnt <= 2) {
					ans++;
				}
			}
			else if(first.length() + 1 == second[i].length()) {	// 뒤 문자열의 길이가 1 클 경우
				//앞에서 하나 더해봐
				for(int j=0; j<26; j++) {
					char c = (char)('A' + j);
					
					fCarr[c - 'A'] += 1;
					//체크
					if(check(fCarr, sCarr[i])) {
						ans++;
					}
					
					fCarr[c - 'A'] -= 1;
				}
			}
			else if(first.length() == second[i].length() + 1) {	// 앞 문자열의 길이가 1 클 경우
				//앞에서 빼봐
				for(int j=0; j<26; j++) {
					char c = (char)('A' + j);
					
					fCarr[c - 'A'] -= 1;
					//체크
					if(check(fCarr, sCarr[i])) {
						ans++;
					}
					
					fCarr[c - 'A'] += 1;
				}
			}
		}
		System.out.println(ans);
	}
	static boolean check(int[] origin, int[] test) {

		for(int j=0; j<26; j++) {
			if(origin[j] != test[j]) return false;
		}

		return true;
	}
}