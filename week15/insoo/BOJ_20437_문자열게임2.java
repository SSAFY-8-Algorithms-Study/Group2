package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
/*
 * BOJ 20437 Gold 5
 * 문자열 게임 2
 */
public class BOJ_20437_문자열게임2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int ntc = 0; ntc < tc; ntc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			ArrayDeque<Integer>[] qList = new ArrayDeque[26];
			for (int i = 0; i < 26; qList[i++] = new ArrayDeque<>());
			
			for (int i = 0; i < W.length(); i++) {
				int c = W.charAt(i) - 'a';
				qList[c].add(i);
				
				if(qList[c].size() == K) {
					int start = qList[c].poll();
					int dist = (i - start) + 1;

					max = Math.max(max, dist);
					min = Math.min(min, dist);
				}
			}
			
			System.out.println(max == 0 ? -1 : min + " " + max);
		}
	}
}