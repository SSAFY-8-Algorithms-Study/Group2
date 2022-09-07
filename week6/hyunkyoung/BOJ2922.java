package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2922 { // 즐거운 단어
	static String input;
	static String mo = "AEIOU";
	static long ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		perm(0, 0, 0, 1, false);
		System.out.println(ans);
	}
	
	static void perm(int cnt, int mCnt, int sCnt, long total, boolean L) {
		if(mCnt == 3 || sCnt == 3) {
			return;
		}
		
		if(cnt == input.length()) {
			if(L) {
				ans = ans + total;				
			}
			
			return;
		}
		
		if(input.charAt(cnt) != '_') {
			String str = String.valueOf(input.charAt(cnt));
			if(mo.contains(str)) {
				perm(cnt + 1, mCnt + 1, 0, total, L);
			} else {
				if(str.equals("L")) {
					perm(cnt + 1, 0, sCnt + 1, total, true);
				} else {
					perm(cnt + 1, 0, sCnt + 1, total, L);
				}
			}
			
			return;
		}
		
		perm(cnt + 1, mCnt + 1, 0, total * 5, L);
		perm(cnt + 1, 0, sCnt + 1, total * 1, true);
		perm(cnt + 1, 0, sCnt + 1, total * 20, L);
	}
}
