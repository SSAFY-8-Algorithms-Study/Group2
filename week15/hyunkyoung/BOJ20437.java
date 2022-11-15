package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20437 { // 문자열 게임2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			int[] cnt = new int[26]; // 알파벳 등장 횟수
			int[] idx = new int[26]; // 알파벳 등장 위치
			Arrays.fill(idx, -1);
			
			int game_three = 10001;
			int game_four = 0;
			
			for(int i = 0; i < str.length(); i++) {
				int chr = str.charAt(i) - 'a';
				cnt[chr] += 1; // 알파벳 등장 횟수 증가
				
				if(idx[chr] == -1) idx[chr] = i; // 처음 등장한 알파벳이면 위치 등록

				if(cnt[chr] == K) { // 같은 알파벳이 K번 등장한 경우
					game_three = Math.min(game_three, i - idx[chr] + 1);
					game_four = Math.max(game_four, i - idx[chr] + 1);
					
					cnt[chr] -= 1;
					int index = idx[chr];
					
					while(true) { // 다음으로 같은 알파벳이 등장한 위치 탐색
						if(index == str.length() - 1) break;
						
						if(str.charAt(++index) - 'a' == chr) {
							idx[chr] = index; // 다음으로 같은 알파벳이 등장한 위치로 변경
							break;
						}
					}
				}
			}
			
			System.out.println(game_three == 10001 ? -1 : game_three + " " + game_four);
		}
	}
}
