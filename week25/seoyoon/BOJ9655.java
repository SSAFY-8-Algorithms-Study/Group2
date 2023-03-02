package week25.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ 9655 : 돌 게임 */
public class BOJ9655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		System.out.println(n % 2 == 1 ? "SK" : "CY");
	}
}