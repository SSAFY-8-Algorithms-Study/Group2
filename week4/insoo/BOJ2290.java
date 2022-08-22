import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 2290 Silver 2
 * LCD Test
 * 1. 기댓값이 빈칸인 열 인덱스 전달
 * 2. s길이의 행 반복 수행
 * 3. 빈칸을 가지는 숫자인지 숫자별 검사
 * 4. 한 행씩 출력 문자열에 삽입
 */
public class BOJ2290 {
	static int s;
	static String n;
	static StringBuilder sb;

	static void method1(int[] arrA) {
		for (int ni = 0; ni < n.length(); ni++) {
			int num = n.charAt(ni) - '1' + 1;
			
			sb.append(" ");

			for (int i = 0; i < s; i++) { // 2. s길이의 행 반복 수행
				boolean isBlank = false;
				for (int j = 0; j < arrA.length; j++) {
					if(arrA[j] == num) isBlank = true; // 3. 빈칸을 가지는 숫자인지 숫자별 검사
				}
				if(isBlank) sb.append(" ");
				else sb.append("-");
			}
			
			sb.append(" ");
			sb.append(" ");
		} sb.append("\n"); // 4. 한 행씩 출력 문자열에 삽입
	}
	static void method2(int[] arrA, int[] arrB) {
		for (int si = 0; si < s; si++) {
			for (int ni = 0; ni < n.length(); ni++) {
				int num = n.charAt(ni) - '1' + 1;
				
				boolean isBlankA = false;
				for (int i = 0; i < arrA.length; i++) {
					if(arrA[i] == num) isBlankA = true;
				}
				if(isBlankA) sb.append(" ");
				else sb.append("|");

				for (int i = 0; i < s; i++) {
					sb.append(" ");
				}

				boolean isBlankB = false;
				for (int i = 0; i < arrB.length; i++) {
					if(arrB[i] == num) isBlankB = true;
				}
				if(isBlankB) sb.append(" ");
				else sb.append("|");
				
				sb.append(" ");
			} sb.append("\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		
		// 1. 기댓값이 빈칸인 열 인덱스 전달
		method1(new int[] {1,4});
		method2(new int[] {1,2,3,7},new int[] {5,6});
		method1(new int[] {0,1,7});
		method2(new int[] {1,3,4,5,7,9},new int[] {2});
		method1(new int[] {1,4,7});
		System.out.print(sb);
	}
}