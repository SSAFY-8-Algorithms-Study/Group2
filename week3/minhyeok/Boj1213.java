package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1213 {
	
	static int[] arr;
	static boolean[] visited;
	static char center='0';
	static StringBuilder sb = new StringBuilder();
	static boolean isPalindrome = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		arr = new int[26];
		for (int i=0;i<name.length();i++) {
			arr[(int)(name.charAt(i))-65]++; // Count Alphabets
		}
		for (int i=0;i<26;i++) {
			if (arr[i]==0) continue;
			if (arr[i]%2==1) {
				if (center == '0') {
					center = Character.toChars(i+65)[0]; // Set Center Alphabet
					arr[i] -= 1;
				} else {
					isPalindrome = false;
					break;
				}
			}
			while (arr[i]>1) {
				arr[i]-=2;
				sb.append(Character.toChars(i+65)[0]);
			}
		}
		if (isPalindrome) {
			StringBuilder ans = new StringBuilder();
			ans.append(sb);
			if (center!='0') {
				ans.append(center);
			}
			ans.append(sb.reverse());
			System.out.println(ans.toString());
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
	}

}
