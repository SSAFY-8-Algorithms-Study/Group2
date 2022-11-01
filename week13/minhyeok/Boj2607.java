package boj;

import java.io.*;

public class Boj2607 { // 비슷한 단어 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String target = br.readLine(); // 맞춰야 하는 목표 단어 
		boolean[] visited = new boolean[26]; // 알파벳이 있는지 체크 
		int[] count = new int[26]; // 등장한 알파벳의 개수 카운드 
		int totalLength = target.length(); // 목표 단어의 전체 길이 
		
		// 초기 세팅 
		for (int i=0; i<totalLength; i++) { 
			char c = target.charAt(i);
			visited[c-'A'] = true;
			count[c-'A'] += 1;
		}
		
		int ans=0; // 정답 
		// 단어를 입력받으며 알파벳 하나씩 검사 
		for (int i=0; i<N-1; i++) {
			String word = br.readLine();
			int diff = 1; // 목표 단어와 차이 체크 -> 0 이상이어야 함 ( 최대 한 문자 차이가 나야함 )
			int copyLen = totalLength; // 목표 단어의 길이 복사 
			int[] copyCount = new int[26]; // 목표 단어의 알파벳 카운드 배열 복사 
			for (int a=0; a<26; copyCount[a] = count[a++]); // 깊은 복사 
			
			for (int j=0; j<word.length(); j++) {
				char c = word.charAt(j);
				if (!visited[c-'A']) { // 현재 문자가 목표 단어에 없다 
					diff--; // 차이 체크 
				} else {
					if (copyCount[c-'A'] == 0) diff--; // 현재 문자가 목표 단어에 있지만 개수를 넘어섰다 -> 차이 체크 
					else {
						copyCount[c-'A'] -= 1; // 목표 단어의 문자 세주기 
						copyLen--; // 남은 목표 단어의 개수 
					}
				}
			}
			if (diff < 0) continue; // 차이가 두 개 이상 난다 
			if (copyLen <= 1) ans++; // 소거하고 남은 목표 문자의 개수가 0개 또는 1개 
		}
		System.out.println(ans);
	}

}
