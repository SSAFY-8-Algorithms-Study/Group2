import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * BOJ 1213 Silver 3
 * 팰린드롬 만들기
 * 1. 문자열 배열로 받아서 오름차순 정렬
 * 2. 2개이상의 문자는 받아서 문자가 끝나는 부분에서 처리
 * 3. 홀수이면 haveOdd로 기억하기
 * 	3.1 홀수이면 문자열 중앙에 홀수 문자 저장
 * 	3.1 홀수가 2개 이상이면 팰린드롬 불가능
 * 	3.3 홀수가 있는데 문자열 길이 짝수이면 불가능
 * 4. 반복문자길이/2 왼쪽과 오른쪽에 저장
 */
public class BOJ1213 {
	public static void main(String[] args) throws IOException {
		int idxInsert = 0; // 문자 추가 위치
		int sameCnt = 1; // 문자 반복 횟수
		boolean haveOdd = false; // 홀수 문자 입력 여부
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = br.readLine().split("");
		Arrays.sort(strs);

		int len = strs.length; // 문자열 길이 len
		String[] result = new String[len];
		
		for (int i = 0; i < len; i++) {
			if(i>0 && strs[i].equals(strs[i-1])) sameCnt++;
			else sameCnt = 1;
			
			// 연속되는 문자지만 끝나는 부분이 아닌 경우
			if(i<len-1 && strs[i].equals(strs[i+1])) continue;
			// 연속되는 문자가 끝나는 부분
			if((i!=len-1 && !strs[i].equals(strs[i+1]))
					|| i==len-1 || len==1) {
				// 개수가 홀수일 때
				if(sameCnt % 2 == 1) {
					// 이미 홀수 문자가 있어서 홀수 문자가 두개이면 팰린드롬 불가능
					// 홀수 문자가 있는데 문자열이 짝수라면 팰린드롬 불가능
					if(haveOdd == true || len % 2 == 0) {
						System.out.print("I'm Sorry Hansoo");
						return;
					} else {
						haveOdd = true;
						// 문자열 중간에 홀수 문자 저장
						result[len/2] = strs[i];
					}
				}
				// 앞뒤 부분 문자열 저장
				for (int j = 0; j < sameCnt/2; j++) {
					result[idxInsert+j] = strs[i];
					result[(len-1)-(idxInsert+j)] = strs[i];
				}
				idxInsert += (sameCnt/2-1)+1;
			}
		}
		for(String str : result) sb.append(str);
		System.out.print(sb);
	}
}