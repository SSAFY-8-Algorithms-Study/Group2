package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9655 { // 돌 게임
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
