package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * BOJ 2607 Silver 3
 * 비슷한 단어
 */
public class BOJ_2607_비슷한단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String standard = br.readLine(); // 기준이 되는 첫 번째 단어
		
		int answer = 0;
		
		for (int i = 0; i < N-1; i++) {	
			String word = br.readLine();
			String wordy = word;
			
			if(Math.abs(standard.length() - word.length()) > 1) {
				continue;
			}
			
			for (int j = 0; j < standard.length(); j++) {
				word = word.replaceFirst(standard.charAt(j) + "", ""); // 첫 번째 단어의 글자들과의 매칭으로 하나씩 지우기
			}
			
			if(word.length() <= 1) { // 길이가 1 이하라면, (바꾸거나 빼거나 추가한다면 남는 단어가 1 이하이므로)
				String standy = standard;
				for (int j = 0; j < wordy.length(); j++) { // 반대로도 검사
					standy = standy.replaceFirst(wordy.charAt(j) + "", "");
				}
				if(standy.length() <= 1) answer++;
			}
		}
		System.out.print(answer);
	}
}