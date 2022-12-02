package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj20437 { // 문자열 게임 2 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		StringBuilder sb = new StringBuilder(); // 정답 
		
		for (int tc=0; tc<T; tc++) { // 테스트 케이스 만큼 반복 
			ArrayList<Integer>[] alphabet = new ArrayList[26]; // 어떤 알파벳의 인덱스가 참조하는 배열에 그 알파벳이 나타난 인덱스를 담는다 
			for (int i=0; i<26; alphabet[i++] = new ArrayList<Integer>()); // 배열 초기화 
			String word = br.readLine(); // 문자열 
			int K = Integer.parseInt(br.readLine()); // K  
			
			for (int i=0; i<word.length(); i++) {
				alphabet[word.charAt(i)-'a'].add(i); // 어떤 알파벳의 인덱스가 참조하는 배열에 그 알파벳이 나타난 인덱스를 담는다
			}
			
			int min = Integer.MAX_VALUE; // 최소 길이 
			int max = 0; // 최대 길이 
			
			for (int i=0; i<26; i++) {
				ArrayList<Integer> indexList = alphabet[i];
				if (indexList.size() >= K) {
					for (int j=0; j<= indexList.size()-K; j++) { 
						int len = indexList.get(j+K-1) - indexList.get(j)+1; // 가장 짧은 문자열의 길이 = 알파벳의 인덱스 j와 K-1개 떨어진 인덱스와 차 + 1 
						min = Math.min(min, len); // 최소 길이 저장 
						max = Math.max(max, len); // 최대 길이 저장 
					}
				}
			}
			
			if (min == Integer.MAX_VALUE || max == 0) sb.append("-1");
			else sb.append(min+" "+max);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
