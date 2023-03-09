package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class BOJ_12919_A와B2 {
	static String S, T;
	static boolean answer;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		set = new HashSet<>(); // Set 함수 사용
		
		DFS(S);
		System.out.print(answer ? 1 : 0);
	}
	
	static void DFS(String str) {
		if(answer || str.length() > T.length() || !set.add(str)) return; // 길이 감안, set 추가 가능 여부
		if(str.equals(T)) { // 같으면 종료
			answer = true;
			return;
		}
		
		String reverse = new StringBuffer(str).reverse().toString(); // 뒤집은 거
		
		if(T.contains(str) || T.contains(reverse)) { // T가 포함하는 문자열인지 검사
			DFS(str + "A"); // 연산 1
			DFS("B" + reverse); // 연산 2
		}
	}
}