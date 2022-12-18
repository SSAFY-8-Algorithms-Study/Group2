import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PROG_스택큐_level2_올바른괄호 {
	public static void main(String[] args) throws IOException {
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		Solution(br.read());
	}
	
	static boolean Solution(Object d) {
		String s = (String)d;
		int L = 0; // ( 괄호 수
		int R = 0; // ) 괄호 수

		for (int i = 0; i < s.length(); i++) {
			char e = s.charAt(i);
			if(e == '(') {
				L++;
			} else {
				R++;
			}
			
			if(L < R) return false; // 닫히는 괄호가 더 많아지면
		}
		return L==R ? true : false; // 올바른 괄호인가
	}
}