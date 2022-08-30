package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2596 { // 비밀편지
	static String[] alpha = {"000000", "001111", "010011", "011100", 
			"100110", "101001", "110101", "111010"}; // A, B, C, D, E, F, G, H
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		for(int n = 0, idx = 0; n < N; n++) {
			String str = input.substring(idx, idx + 6);
			int num = -1;
			
			for(int i = 0; i < 8; i++) {
				int diff = 0;
				for(int j = 0; j < 6; j++) {
					if(str.charAt(j) != alpha[i].charAt(j)) diff++;
				}
				
				if(diff <= 1) num = i;
			}
			
			if(num != -1) sb.append((char) (num + 65));
			else {
				System.out.println(n + 1);
				return;
			}
			
			idx += 6;
		}
		
		System.out.println(sb);
	}
}
