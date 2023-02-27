package week25.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ 4659 : 비밀번호 발음하기 */
public class BOJ4659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if (str.equals("end")) {
				System.out.println(sb);				
				return;
			}
			
			sb.append("<" + str + "> is ");
			sb.append(isAcceptable(str) ? "acceptable.\n" : "not acceptable.\n");
		}
	}
	
	public static boolean isAcceptable(String str) {
		boolean vFlag = false;
		int vSeqCnt = 0, cSeqCnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
				if (!vFlag)	vFlag = true;
				vSeqCnt++;
				cSeqCnt = 0;
			}
			else {
				vSeqCnt = 0;
				cSeqCnt++;
			}
			
			// 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
			if (vSeqCnt >= 3 || cSeqCnt >= 3) return false;
			
			
			// 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
			if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
				if (str.charAt(i) != 'e' && str.charAt(i) != 'o') return false;
			}
		}
		
		// 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
		if (!vFlag) return false;
		
		return true;
	}

}