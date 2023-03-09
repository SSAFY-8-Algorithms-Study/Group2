package week26.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ 12919 : A와 B 2 */
public class BOJ12919 {
	
	static String S, T;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		ABgame(T);
		System.out.println(flag ? 1 : 0);
	}
	
	public static void ABgame(String t) {
		if (t.equals(S)) {
			flag = true;
			return;
		}
		
		if (t.length() == 1) return;
		
		if (t.charAt(t.length() - 1) == 'A') {
			ABgame(t.substring(0, t.length() - 1));
		}
		
		if (t.charAt(0) == 'B') {
			ABgame(reverse(t.substring(1)));
		}
	}
	
	public static String reverse(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}
		return reverse;
	}
}