import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class BOJ_5073_삼각형과세변 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String Equilateral = "Equilateral\n";
		String Isosceles = "Isosceles\n";
		String Scalene = "Scalene\n";
		String Invalid = "Invalid\n";
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[] list = {A, B, C};
			Arrays.sort(list);
			A = list[0];
			B = list[1];
			C = list[2];
			
			if(A == 0) break; // 종료 검사
			
			if(A + B <= C) { // 조건 분기
				sb.append(Invalid);
			}
			else if(A == B || B == C) {
				if(A == C) {
					sb.append(Equilateral);
				}
				else {
					sb.append(Isosceles);
				}
			}
			else {
				sb.append(Scalene);
			}
		}
		
		System.out.print(sb);
	}
}