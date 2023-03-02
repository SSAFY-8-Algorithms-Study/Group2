package algo;
import java.io.*;
import java.util.*;
class BOJ_4659_비밀번호발음하기 {
	static String[] vowels = {"a", "e", "i", "o", "u"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) break; // 종료 검사
			
			String result = "";
			result = check(str) ? "acceptable." : "not acceptable."; // check 메서드 결과에 따른 출력
			sb.append("<" + str + "> is " + result + "\n");
		}
		
		System.out.print(sb);
	}
	
	static boolean check(String str) {
		if(!containVowel(str)) return false; // 모음 포함 여부 검사
		if(!notContainSequenceType(str)) return false; // 모음이나 자음 연속 검사
		if(!notContainSequenceSpell(str)) return false; // 같은 글자 연속 검사
		
		return true;
	}
	
	static boolean containVowel(String str) {
		for (int i = 0; i < vowels.length; i++) {
			if(str.contains(vowels[i])) return true;
		}
		
		return false;
	}
	
	static boolean notContainSequenceType(String str) {
		for (int i = 1; i < str.length()-1; i++) {
			boolean L = containVowel(str.charAt(i-1) + "");
			boolean center = containVowel(str.charAt(i) + "");
			boolean R = containVowel(str.charAt(i+1) + "");
			
			if(L == center && center == R) return false;
		}
		
		return true;
	}
	
	static boolean notContainSequenceSpell(String str) {
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == 'e') continue;
			else if(str.charAt(i) == 'o') continue;
			
			if(str.charAt(i-1) == str.charAt(i)) return false;
		}
		
		return true;
	}
}