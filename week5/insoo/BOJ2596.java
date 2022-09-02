import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * BOJ 2596 Bronze 1
 * 비밀편지
 */
public class BOJ_2596_비밀편지 {
	public static void main(String[] args) throws IOException {
		final String[] strs = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		final String[] words = {"A","B","C","D","E","F","G","H"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();

		String output = "";
		for (int i = 0; i < N; i++) { // 문자별
			int[] matchCnt = new int[8]; // words 카운트 배열
			
			for (int j = 0; j < 6; j++) { // 글자별
				for (int k = 0; k < strs.length; k++) { // 약속 암호별 비교
					if(input.charAt((6*i)+j) == strs[k].charAt(j)) {
						
						matchCnt[k]++;
						if(matchCnt[k] == 5) { // 같은 글자 5개가 카운트 되면
							output += words[k]; // 문자열에 반영
							break;
						}
					}
				}
			}
			if(i+1 > output.length()) { // 문자열에 반영된 게 없다면
				System.out.print(i+1); // 해당 문자 인덱스 출력하고 종료
				return;
			}
		}
		System.out.print(output);
	}
}