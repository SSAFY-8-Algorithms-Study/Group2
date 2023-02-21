import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
class BOJ_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split("");
		
		int[] alphas = new int[26];
		
		for (int i = 0; i < strs.length; i++) {
			int idx = (strs[i]).toUpperCase().charAt(0) - 'A'; // 대문자로 통일
			alphas[idx]++; // 알파벳 카운트
		}
		
		ArrayDeque<Character> list = new ArrayDeque<>();
		int max = -1;
		
		for (int i = 0; i < alphas.length; i++) {
			if(max <= alphas[i]) { // 가장 많이 사용된 알파벳 대문자 검사
				if(max < alphas[i]) {
					max = alphas[i];
					list.clear();
				}
				list.add((char) ('A' + i));
			}
		}
		
		System.out.print(1 < list.size() ? "?" : list.poll()); // 여러개 존재 검사
	}
}